package bigraph.biged.ui.properties;

import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import bigraph.biged.model.BigraphEvent;
import bigraph.biged.ui.BigraphLabelProvider;

public abstract class AbstractListPropertySection extends AbstractPropertySection
{
	protected TableViewer viewer;
	private Button removeButton;

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage)
	{
		super.createControls(parent, aTabbedPropertySheetPage);

		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);

		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(50, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		final Section indexesSection = getWidgetFactory().createSection(
																		composite,
																		ExpandableComposite.TITLE_BAR
																				| ExpandableComposite.EXPANDED);
		final Composite indexesSectionClient = getWidgetFactory().createComposite(indexesSection);
		indexesSection.setLayoutData(data);
		indexesSection.setClient(indexesSectionClient);
		indexesSection.setText(getListTitle());
		// indexesSection.setDescription("Description");
		indexesSectionClient.setLayout(new FormLayout());

		data = new FormData();
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		final Composite buttonComposite = getWidgetFactory().createComposite(indexesSectionClient);
		buttonComposite.setLayout(new FillLayout(SWT.VERTICAL));
		buttonComposite.setLayoutData(data);

		final Button addButton = getWidgetFactory().createButton(buttonComposite, "Add", 0);
		removeButton = getWidgetFactory().createButton(buttonComposite, "Remove", 0);
		// getWidgetFactory().createLabel(buttonComposite, " ");
		// final Button upButton = getWidgetFactory().createButton(buttonComposite, "Up", 0);
		// final Button downButton = getWidgetFactory().createButton(buttonComposite, "Down", 0);

		addButton.addSelectionListener(new SelectionListener()
		{
			public void widgetDefaultSelected(final SelectionEvent e)
			{
			}

			public void widgetSelected(final SelectionEvent e)
			{
				final Command addCommand = getAddCommand();
				if (addCommand != null)
				{
					getCommandStack().execute(addCommand);
				}
			}
		});
		removeButton.addSelectionListener(new SelectionListener()
		{
			public void widgetDefaultSelected(final SelectionEvent e)
			{
			}

			public void widgetSelected(final SelectionEvent e)
			{
				final Command deleteCommand = getDeleteCommand(getSelectedObject());
				if (deleteCommand != null)
				{
					getCommandStack().execute(deleteCommand);
				}
			}
		});

		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(buttonComposite, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		data.bottom = new FormAttachment(buttonComposite, 0, SWT.BOTTOM);
		setViewerFormData(data);
		final Table indexList = getWidgetFactory().createTable(indexesSectionClient, SWT.SINGLE | SWT.FULL_SELECTION);
		indexList.setLayoutData(data);
		viewer = new TableViewer(indexList);
		viewer.setLabelProvider(new BigraphLabelProvider());
		viewer.setSorter(new ViewerSorter());
		viewer.setContentProvider(getContentProvider());
		viewer.addSelectionChangedListener(new ISelectionChangedListener()
		{
			public void selectionChanged(final SelectionChangedEvent event)
			{
				updateSelection();
			}
		});

		data = new FormData();
		data.left = new FormAttachment(indexesSection, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		final Section detailsSection = getWidgetFactory().createSection(
																		composite,
																		ExpandableComposite.TITLE_BAR
																				| ExpandableComposite.EXPANDED);
		final Composite detailsSectionClient = getWidgetFactory().createComposite(detailsSection);
		detailsSection.setText(getDetailsTitle());
		detailsSection.setLayoutData(data);

		detailsSection.setClient(detailsSectionClient);
		// detailsSection.setDescription("Description");
		detailsSectionClient.setLayout(new FormLayout());

		createDetailsPanel(detailsSectionClient, aTabbedPropertySheetPage);
	}

	public void onPlaceEvent(final BigraphEvent event)
	{
		refresh();
	}

	@Override
	public void refresh()
	{
		Display.getDefault().asyncExec(new Runnable()
		{
			public void run()
			{
				if(viewer.getControl().isDisposed()) { return; }
				int index = viewer.getTable().getSelectionIndex();
				viewer.setInput(getModel());
				if (index == -1 && viewer.getTable().getItemCount() > 0)
				{
					index = 0;
				}
				viewer.getTable().setSelection(index);
				updateSelection();
			}
		});
	}

	protected abstract void createDetailsPanel(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage);

	protected abstract Command getAddCommand();

	protected abstract IStructuredContentProvider getContentProvider();

	protected abstract Command getDeleteCommand(final Object item);

	protected abstract String getDetailsTitle();

	protected abstract String getListTitle();

	protected Object getSelectedObject()
	{
		final int selectionIndex = viewer.getTable().getSelectionIndex();
		if (selectionIndex == -1)
		{
			return null;
		}
		else
		{
			return viewer.getTable().getItem(selectionIndex).getData();
		}
	}

	protected void setViewerFormData(final FormData data)
	{
	}

	protected void updateSelection()
	{
		final Command deleteCommand = getDeleteCommand(getSelectedObject());
		removeButton.setEnabled(deleteCommand != null);
	}
}