package bigraph.biged.ui.sections;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

import bigraph.biged.model.Bigraph;
import bigraph.biged.ui.commands.SetSignatureRendererNameCommand;
import bigraph.biged.ui.graph.figures.HiddenPlaceFigure;
import bigraph.biged.ui.graph.figures.PlaceFigure;
import bigraph.biged.ui.graph.parts.BigraphEditPartFactory;
import bigraph.biged.ui.graph.parts.PlacePart;
import bigraph.biged.ui.widget.LabelledTextSelect;
import bigraphspace.model.BasicSignature;
import bigraphspace.model.Place;
import bigraphspace.model.signaturexml.Control;
import bigraphspace.model.signaturexml.Definitions;
import bigraphspace.model.signaturexml.Renderer;
import bigraphspace.model.xml.DomBigraph;

public class RendererSection extends SignatureSection
{
	private LabelledTextSelect rendererName;
	private LabelledTextSelect rendererColour;
	private LabelledTextSelect rendererImage;
	private PlacePart exampleNode;

	public RendererSection(final Definitions definitions, final CommandStack commandStack)
	{
		super(definitions, commandStack);
	}

	@Override
	public void createSection(final Composite parent, final FormToolkit toolkit, final boolean collapsable)
	{
		super.createSection(parent, toolkit, collapsable);
		final Composite client = (Composite) section.getClient();
		section.setText("Control Rendering");

		client.setLayout(new FormLayout());

		rendererName = new LabelledTextSelect(client, toolkit)
		{
			@Override
			protected Command getCommand(final Object textValue)
			{
				if (input instanceof Control) { return new SetSignatureRendererNameCommand(definitions,
						(Control) input, textValue.toString()); }
				return null;
			}

			@Override
			protected IStructuredContentProvider getContentProvider()
			{
				return new IStructuredContentProvider()
				{
					@Override
					public void dispose()
					{
					}

					@Override
					public Object[] getElements(final Object inputElement)
					{
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput)
					{
					}
				};
			}
		};
		rendererName.setLabel("Renderer:");
		rendererName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		rendererName.setCommandStack(commandStack);

		rendererColour = new LabelledTextSelect(client, toolkit)
		{
			@Override
			protected Command getCommand(final Object textValue)
			{
				// TODO Auto-generated method stub
				return null;
				// return new SetSignatureControlCommand();
			}

			@Override
			protected IStructuredContentProvider getContentProvider()
			{
				return new IStructuredContentProvider()
				{
					@Override
					public void dispose()
					{
					}

					@Override
					public Object[] getElements(final Object inputElement)
					{
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput)
					{
					}
				};
			}
		};
		rendererColour.setLabel("Colour:");
		rendererColour.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		rendererColour.setCommandStack(commandStack);

		rendererImage = new LabelledTextSelect(client, toolkit)
		{
			@Override
			protected Command getCommand(final Object textValue)
			{
				// TODO Auto-generated method stub
				return null;
				// return new SetSignatureControlCommand();
			}

			@Override
			protected IStructuredContentProvider getContentProvider()
			{
				return new IStructuredContentProvider()
				{
					@Override
					public void dispose()
					{
					}

					@Override
					public Object[] getElements(final Object inputElement)
					{
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput)
					{
					}
				};
			}
		};
		rendererImage.setLabel("Image:");
		rendererImage.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		rendererImage.setCommandStack(commandStack);

		final GraphicalViewer rendererExample = createGraphicalViewer(client);
		try
		{
			final Bigraph bigraph = new Bigraph(new DomBigraph(new BasicSignature()))
			{

				@Override
				public PlaceFigure getRenderer(final Place place)
				{
					if (place.isRoot()) { return new HiddenPlaceFigure(place); }
					return super.getRenderer(place);
				}

			};
			final Place root = bigraph.getBigraph().createRoot();
			bigraph.getBigraph().addRoot(root);
			final Place examplePlace = bigraph.getBigraph().createNode("Example");
			root.addChild(examplePlace);

			rendererExample.setContents(bigraph);

			exampleNode = (PlacePart) rendererExample.getEditPartRegistry().get(examplePlace);
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}

		FormData data = new FormData();
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		data.left = new FormAttachment(0, 0);
		data.width = 120;
		rendererExample.getControl().setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VMARGIN);
		data.left = new FormAttachment(rendererExample.getControl(), ITabbedPropertyConstants.HMARGIN);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		rendererName.setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(rendererName, 3);
		data.left = new FormAttachment(rendererExample.getControl(), ITabbedPropertyConstants.HMARGIN);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		rendererColour.setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(rendererColour, 3);
		data.left = new FormAttachment(rendererExample.getControl(), ITabbedPropertyConstants.HMARGIN);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		rendererImage.setLayoutData(data);

	}

	@Override
	public void setInput(final Object input)
	{
		super.setInput(input);
		if (input instanceof Control)
		{
			final Control control = (Control) input;
			section.setVisible(true);
			exampleNode.getPlace().setControlName(control.getName());

			final Renderer renderer = getRenderer(control);
			if (renderer != null)
			{
				rendererName.setText(renderer.getClazz());
			}
			else
			{
				rendererName.setText(null);
			}

			exampleNode.refresh();
			section.layout();
		}
		else
		{
			section.setVisible(false);
		}
	}

	private GraphicalViewer createGraphicalViewer(final Composite parent)
	{
		final GraphicalViewer graphicalViewer = new ScrollingGraphicalViewer();
		graphicalViewer.setEditPartFactory(new BigraphEditPartFactory());
		graphicalViewer.setRootEditPart(new ScalableRootEditPart());
		graphicalViewer.createControl(parent);
		graphicalViewer.getControl().setBackground(ColorConstants.listBackground);
		// getViewer().setEditDomain(getEditDomain());

		return graphicalViewer;
	}

	private Renderer getRenderer(final Control control)
	{
		if (definitions.getRenderers() == null) { return null; }
		final List<Renderer> renderers = definitions.getRenderers().getRenderer();
		for (final Renderer renderer : renderers)
		{
			if (renderer.getControl().equals(control.getName())) { return renderer; }
		}
		return null;
	}
}