package bigraph.biged.ui.sections;

import org.eclipse.gef.commands.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;

import bigraph.biged.ui.commands.SetSignatureControlDescCommand;
import bigraph.biged.ui.commands.SetSignatureControlNameCommand;
import bigraph.biged.ui.widget.LabelledText;
import bigraphspace.model.signaturexml.Control;
import bigraphspace.model.signaturexml.Definitions;

public class ControlSection extends SignatureSection
{
	private LabelledText controlName;
	private LabelledText controlDesc;
	private LabelledText controlArity;
	private Button activeButton;
	private Button passiveButton;
	private Button atomicButton;

	public ControlSection(Definitions definitions)
	{
		super(definitions);
	}

	@Override
	public void createSection(final Composite parent, final FormToolkit toolkit, final boolean collapsable)
	{
		super.createSection(parent, toolkit, collapsable);
		final Composite client = (Composite) section.getClient();
		section.setText("Control Details");

		client.setLayout(new GridLayout(1, true));

		controlName = new LabelledText(client, toolkit)
		{
			@Override
			protected Command getCommand(final Object textValue)
			{
				if(input instanceof Control)
				{
					return new SetSignatureControlNameCommand(definitions, (Control)input, textValue.toString());
				}
				return null;
			}
		};
		controlName.setLabel("Name:");
		controlName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		controlDesc = new LabelledText(client, toolkit, SWT.MULTI)
		{
			@Override
			protected Command getCommand(final Object textValue)
			{
				if(input instanceof Control)
				{
					return new SetSignatureControlDescCommand(definitions, (Control)input, textValue.toString());
				}
				return null;
			}
		};
		controlDesc.setLabel("Description:");
		controlDesc.setHeight(4);
		controlDesc.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		controlArity = new LabelledText(client, toolkit)
		{

			@Override
			protected Command getCommand(final Object textValue)
			{
				// TODO Auto-generated method stub
				return null;
			}
		};
		controlArity.setLabel("Arity:");
		controlArity.addVerifyListener(new VerifyListener()
		{
			public void verifyText(final VerifyEvent e)
			{
				if (!"".equals(e.text))
				{
					try
					{
						Integer.parseInt(e.text);
					}
					catch (final NumberFormatException nfe)
					{
						e.doit = false;
						return;
					}
				}
			}
		});
		controlArity.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Composite radioComposite = toolkit.createComposite(client);
		final GridLayout layout = new GridLayout(4, false);
		layout.marginWidth = 0;
		radioComposite.setLayout(layout);

		final Label label = toolkit.createLabel(radioComposite, "Status:");
		final GridData data = new GridData(SWT.FILL, SWT.FILL, false, false);
		data.widthHint = org.eclipse.ui.views.properties.tabbed.AbstractPropertySection.STANDARD_LABEL_WIDTH;
		label.setLayoutData(data);

		activeButton = toolkit.createButton(radioComposite, "Active", SWT.RADIO);
		activeButton.setLayoutData(new GridData());
		passiveButton = toolkit.createButton(radioComposite, "Passive", SWT.RADIO);
		passiveButton.setLayoutData(new GridData());
		atomicButton = toolkit.createButton(radioComposite, "Atomic", SWT.RADIO);
		atomicButton.setLayoutData(new GridData());		
	}

	@Override
	public void setInput(Object input)
	{
		super.setInput(input);
		if(input instanceof Control)
		{
			section.setVisible(true);
			Control control = (Control)input;			
			controlName.setText(control.getName());
			controlDesc.setText(control.getDescription());
			if(control.getArity() != null)
			{
				controlArity.setText(control.getArity().toString());
			}
			else
			{
				controlArity.setText(null);
			}
			activeButton.setSelection(control.getStatus().toLowerCase().equals("active"));
			passiveButton.setSelection(control.getStatus().toLowerCase().equals("passive"));
			atomicButton.setSelection(control.getStatus().toLowerCase().equals("atomic"));			
		}
		else
		{
			section.setVisible(false);
		}
	}
}