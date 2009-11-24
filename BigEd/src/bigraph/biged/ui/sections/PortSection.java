package bigraph.biged.ui.sections;

import org.eclipse.gef.commands.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

import bigraph.biged.ui.widget.LabelledText;
import bigraphspace.model.signaturexml.Definitions;
import bigraphspace.model.signaturexml.Port;

public class PortSection extends SignatureSection
{
	private LabelledText portName;
	private LabelledText portDesc;

	public PortSection(Definitions definitions)
	{
		super(definitions);
	}

	@Override
	public void createSection(final Composite parent, final FormToolkit toolkit, final boolean collapsable)
	{
		super.createSection(parent, toolkit, collapsable);
		final Composite client = (Composite) section.getClient();
		section.setText("Port Details");
	
		client.setLayout(new GridLayout(1, true));

		portName = new LabelledText(client, toolkit)
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
		portName.setLabel("Name:");
		portName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		portDesc = new LabelledText(client, toolkit, SWT.MULTI)
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
		portDesc.setLabel("Description:");
		portDesc.setHeight(4);
		portDesc.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));		
	}

	@Override
	public void setInput(Object input)
	{
		super.setInput(input);
		if(input instanceof Port)
		{
			section.setVisible(true);
			Port port = (Port)input;			
			portName.setText(port.getName());
			portDesc.setText(port.getDescription());
		}
		else
		{
			section.setVisible(false);
		}
	}
}