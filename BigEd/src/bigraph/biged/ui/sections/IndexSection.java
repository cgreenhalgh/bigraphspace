package bigraph.biged.ui.sections;

import org.eclipse.gef.commands.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

import bigraph.biged.ui.widget.LabelledText;
import bigraphspace.model.signaturexml.ControlIndex;
import bigraphspace.model.signaturexml.Definitions;
import bigraphspace.model.signaturexml.Port;

public class IndexSection extends SignatureSection
{
	private LabelledText indexType;
	private LabelledText indexDesc;

	public IndexSection(Definitions definitions)
	{
		super(definitions);
	}

	@Override
	public void createSection(final Composite parent, final FormToolkit toolkit, final boolean collapsable)
	{
		super.createSection(parent, toolkit, collapsable);
		final Composite client = (Composite) section.getClient();
		section.setText("Index Details");
	
		client.setLayout(new GridLayout(1, true));

		indexType = new LabelledText(client, toolkit)
		{
			@Override
			protected Command getCommand(final Object textValue)
			{
				if(input instanceof Port)
				{
					// TODO return new SetSignatureControlNameCommand(definitions, (Port)input, textValue.toString());
				}
				return null;
			}
		};
		indexType.setLabel("Type:");
		indexType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		indexDesc = new LabelledText(client, toolkit, SWT.MULTI)
		{
			@Override
			protected Command getCommand(final Object textValue)
			{
				if(input instanceof Port)
				{
					// TODO return new SetSignatureControlDescCommand(definitions, (Port)input, textValue.toString());
				}
				return null;
			}
		};
		indexDesc.setLabel("Description:");
		indexDesc.setHeight(4);
		indexDesc.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));		
		
	}

	@Override
	public void setInput(Object input)
	{
		super.setInput(input);
		if(input instanceof ControlIndex)
		{
			section.setVisible(true);
			ControlIndex index = (ControlIndex)input;
			indexType.setText(index.getType());
			indexDesc.setText(index.getDescription());
		}
		else
		{
			section.setVisible(false);
		}
	}
}