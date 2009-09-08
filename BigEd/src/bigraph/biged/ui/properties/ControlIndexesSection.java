package bigraph.biged.ui.properties;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import bigraph.biged.model.PlaceEvent;

public class ControlIndexesSection extends AbstractPlacePropertySection
{
	private Text indexValue;
	private Table indexList;

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
		final Button removeButton = getWidgetFactory().createButton(buttonComposite, "Remove", 0);
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
				// TODO Auto-generated method stub

			}
		});
		removeButton.addSelectionListener(new SelectionListener()
		{
			public void widgetDefaultSelected(final SelectionEvent e)
			{
			}

			public void widgetSelected(final SelectionEvent e)
			{
				// TODO Auto-generated method stub

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
		indexList = getWidgetFactory().createTable(indexesSectionClient, SWT.SINGLE);
		indexList.setLayoutData(data);

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

		final Label valueLabel = getWidgetFactory().createLabel(detailsSectionClient, "Index Value:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(indexValue, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(indexValue, 0, SWT.TOP);
		valueLabel.setLayoutData(data);
	}

	public void onPlaceEvent(final PlaceEvent event)
	{
		// TODO Auto-generated method stub

	}
}