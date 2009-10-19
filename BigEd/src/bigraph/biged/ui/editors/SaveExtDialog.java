package bigraph.biged.ui.editors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SaveAsDialog;

public class SaveExtDialog extends SaveAsDialog
{
	private Combo combo;

	public SaveExtDialog(final Shell parentShell)
	{
		super(parentShell);
	}

	@Override
	protected Control createDialogArea(final Composite parent)
	{
		final Composite parentArea = (Composite) super.createDialogArea(parent);
		final Font font = parentArea.getFont();

		final Composite fileTypeArea = new Composite(parentArea, 0);

		final GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginWidth = 0;
		fileTypeArea.setLayout(layout);
		fileTypeArea.setFont(font);
		fileTypeArea.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));

		final Label label = new Label(fileTypeArea, 0);
		label.setText("Type:");

		combo = new Combo(fileTypeArea, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(final SelectionEvent e)
			{
				// TODO Auto-generated method stub
			}
		});

		return parentArea;
	}

}
