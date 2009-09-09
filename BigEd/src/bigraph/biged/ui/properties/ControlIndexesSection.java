package bigraph.biged.ui.properties;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import bigraph.biged.model.Place;
import bigraph.biged.model.PlaceEvent;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.IndexValue;

public class ControlIndexesSection extends AbstractPlacePropertySection
{
	private Text indexValue;
	private TableViewer viewer;
	private boolean modified;
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
																		Section.DESCRIPTION
																				| ExpandableComposite.TITLE_BAR
																				| ExpandableComposite.EXPANDED);
		final Composite indexesSectionClient = getWidgetFactory().createComposite(indexesSection);
		indexesSection.setLayoutData(data);
		indexesSection.setClient(indexesSectionClient);
		indexesSection.setText("Control Indexes");
		indexesSection.setDescription("Description");
		indexesSectionClient.setLayout(new FormLayout());

		data = new FormData();
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		final Composite buttonComposite = getWidgetFactory().createComposite(indexesSectionClient);
		buttonComposite.setLayout(new FillLayout(SWT.VERTICAL));
		buttonComposite.setLayoutData(data);

		final Button addButton = getWidgetFactory().createButton(buttonComposite, "Add", 0);
		removeButton = getWidgetFactory().createButton(buttonComposite, "Remove", 0);
		getWidgetFactory().createLabel(buttonComposite, " ");
		final Button upButton = getWidgetFactory().createButton(buttonComposite, "Up", 0);
		final Button downButton = getWidgetFactory().createButton(buttonComposite, "Down", 0);

		addButton.addSelectionListener(new SelectionListener()
		{
			public void widgetDefaultSelected(final SelectionEvent e)
			{
			}

			public void widgetSelected(final SelectionEvent e)
			{
				place.addControlIndex("\"\"");
			}
		});
		removeButton.addSelectionListener(new SelectionListener()
		{
			public void widgetDefaultSelected(final SelectionEvent e)
			{
			}

			public void widgetSelected(final SelectionEvent e)
			{
				final int index = viewer.getTable().getSelectionIndex();
				if(index != -1)
				{
					final IndexValue indexVal = (IndexValue)viewer.getElementAt(index);
					place.removeControlIndex(indexVal);
				}
			}
		});
		upButton.addSelectionListener(new SelectionListener()
		{
			public void widgetDefaultSelected(final SelectionEvent e)
			{
			}

			public void widgetSelected(final SelectionEvent e)
			{
				// TODO Auto-generated method stub
			}
		});
		downButton.addSelectionListener(new SelectionListener()
		{
			public void widgetDefaultSelected(final SelectionEvent e)
			{
			}

			public void widgetSelected(final SelectionEvent e)
			{
				// TODO Auto-generated method stub
			}
		});

		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(buttonComposite, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		data.bottom = new FormAttachment(buttonComposite, 0, SWT.BOTTOM);
		final Table indexList = getWidgetFactory().createTable(indexesSectionClient, SWT.SINGLE);
		indexList.setLayoutData(data);
		viewer = new TableViewer(indexList);
		viewer.setLabelProvider(new BigraphLabelProvider());
		viewer.setContentProvider(new IStructuredContentProvider()
		{
			public void dispose()
			{
			}

			public Object[] getElements(final Object inputElement)
			{
				if (inputElement instanceof Place) { return ((Place) inputElement).getControlIndexes().toArray(); }
				return null;
			}

			public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput)
			{
			}
		});
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
																		Section.DESCRIPTION
																				| ExpandableComposite.TITLE_BAR
																				| ExpandableComposite.EXPANDED);
		final Composite detailsSectionClient = getWidgetFactory().createComposite(detailsSection);
		detailsSection.setText("Index Details");
		detailsSection.setLayoutData(data);

		detailsSection.setClient(detailsSectionClient);
		detailsSection.setDescription("Description");
		detailsSectionClient.setLayout(new FormLayout());

		indexValue = getWidgetFactory().createText(detailsSectionClient, "");
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		indexValue.setLayoutData(data);
		indexValue.addModifyListener(new ModifyListener()
		{
			public void modifyText(ModifyEvent e)
			{
				modified = true;				
			}
		});
		indexValue.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetDefaultSelected(final SelectionEvent e)
			{
				setValue(indexValue.getText());
			}
		});
		indexValue.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusLost(final FocusEvent e)
			{
				setValue(indexValue.getText());
			}
		});		

		final Label valueLabel = getWidgetFactory().createLabel(detailsSectionClient, "Index Value:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(indexValue, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(indexValue, 0, SWT.TOP);
		valueLabel.setLayoutData(data);
	}

	private void setValue(final String value)
	{
		if(modified)
		{
			modified = false;
			IStructuredSelection selection = (IStructuredSelection)viewer.getSelection();
			if(selection.isEmpty())
			{
				indexValue.setText("");
			}
			else
			{
				final Object obj = selection.getFirstElement();
				if(obj instanceof IndexValue)
				{
					place.setControlIndex(value, viewer.getTable().getSelectionIndex());
				}
			}
		}		
	}
	
	public void onPlaceEvent(final PlaceEvent event)
	{
		refresh();
	}

	private void updateSelection()
	{
		final int index = viewer.getTable().getSelectionIndex();
		if(index == -1)
		{
			indexValue.setText("");
			indexValue.setEnabled(false);		
			removeButton.setEnabled(false);
		}
		else
		{
			indexValue.setEnabled(true);
			final IndexValue indexVal = (IndexValue)viewer.getElementAt(index);
			indexValue.setText(indexVal.getValue().toString());
			removeButton.setEnabled(true);			
		}
		modified = false;
	}
	
	@Override
	public void refresh()
	{
		Display.getDefault().asyncExec(new Runnable()
		{
			public void run()
			{
				int index = viewer.getTable().getSelectionIndex();
				viewer.setInput(place);
				if(index == -1 && viewer.getTable().getItemCount() > 0)
				{
					index = 0;
				}
				viewer.getTable().setSelection(index);
				updateSelection();
			}
		});
	}
}