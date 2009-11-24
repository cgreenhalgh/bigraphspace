package bigraph.biged.ui.sections;

import java.util.List;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.signaturexml.Control;
import bigraphspace.model.signaturexml.Definitions;
import bigraphspace.model.signaturexml.Sort;

public class SortingSection extends SignatureSection
{
	private TableViewer sortings;

	public SortingSection(final Definitions definitions, final CommandStack commandStack)
	{
		super(definitions, commandStack);
	}

	@Override
	public void createSection(final Composite parent, final FormToolkit toolkit, final boolean collapsable)
	{
		super.createSection(parent, toolkit, collapsable);
		final Composite client = (Composite) section.getClient();
		section.setText("Allowed Children");

		final FormLayout layout = new FormLayout();
		client.setLayout(layout);

		final Table table = toolkit.createTable(client, SWT.NULL);
		sortings = new TableViewer(table);
		sortings.setContentProvider(new IStructuredContentProvider()
		{
			private Sort sort;

			@Override
			public void dispose()
			{
				// TODO Auto-generated method stub

			}

			@Override
			public Object[] getElements(final Object inputElement)
			{
				if (sort != null) { return sort.getChildsorts().getSort().toArray(); }
				return new Object[] {};
			}

			@Override
			public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput)
			{
				if (newInput instanceof Sort)
				{
					sort = (Sort) newInput;
				}
				else
				{
					sort = null;
				}
			}
		});
		sortings.setLabelProvider(new BigraphLabelProvider());

		final Composite buttonPanel = toolkit.createComposite(client);
		final GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		buttonPanel.setLayout(gridLayout);

		final Button addButton = toolkit.createButton(buttonPanel, "Add...", SWT.PUSH);
		addButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		final Button removeButton = toolkit.createButton(buttonPanel, "Remove", SWT.PUSH);
		removeButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

		FormData data = new FormData();
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VMARGIN);
		data.bottom = new FormAttachment(100, -ITabbedPropertyConstants.VMARGIN);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HMARGIN);
		buttonPanel.setLayoutData(data);

		data = new FormData();
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HMARGIN);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VMARGIN);
		data.bottom = new FormAttachment(100, -ITabbedPropertyConstants.VMARGIN);
		data.right = new FormAttachment(buttonPanel, -ITabbedPropertyConstants.HMARGIN);
		table.setLayoutData(data);

	}

	@Override
	public void setInput(final Object input)
	{
		super.setInput(input);
		if (input instanceof Control)
		{
			section.setVisible(true);
			final Control control = (Control) input;
			sortings.setInput(getSort(control));
		}
		else
		{
			section.setVisible(false);
		}
	}

	private Sort getSort(final Control control)
	{
		final List<Sort> sorts = definitions.getSorts().getSort();
		for (final Sort sort : sorts)
		{
			if (sort.getName().equals(control.getName())) { return sort; }
		}
		return null;
	}
}