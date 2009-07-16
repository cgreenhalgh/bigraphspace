/*
 <COPYRIGHT>

 Copyright (c) 2006-2009, University of Nottingham
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are met:

 - Redistributions of source code must retain the above copyright notice, this
 list of conditions and the following disclaimer.

 - Redistributions in binary form must reproduce the above copyright notice,
 this list of conditions and the following disclaimer in the documentation
 and/or other materials provided with the distribution.

 - Neither the name of the University of Nottingham
 nor the names of its contributors may be used to endorse or promote products
 derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

 </COPYRIGHT>

 Created by: Kevin Glover (University of Nottingham)
 */
package bigraph.biged.ui;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.EditDomain;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.Saveable;

public class PhysicalEditDomain extends EditDomain
{
	public static final PhysicalEditDomain INSTANCE = new PhysicalEditDomain();

	private String filename;

	private final Saveable saveable = new Saveable()
	{
		@Override
		public void doSave(final IProgressMonitor monitor) throws CoreException
		{
			final String filename = getFilename();
			if (filename == null) { return; }
			final File file = new File(filename);
			try
			{
				if (!file.exists())
				{
					file.createNewFile();
				}
				// final Model infModel = BigEdPlugin.getDefault().getModel();
				// final Model originalModel = ((InfModel) infModel).getRawModel();
				// final Model model = ModelFactory.createDefaultModel();
				// model.setNsPrefix("ect",
				// "http://www.ncess.ac.uk/nodes/digitalrecord/digitalrecord.owl#");
				// ResIterator resourceIterator = infModel.listSubjectsWithProperty(RDF.type,
				// Schema.PhysicalThing);
				// while (resourceIterator.hasNext())
				// {
				// final Resource resource = (Resource)
				// originalModel.asRDFNode(resourceIterator.nextResource().asNode());
				// addResource(model, resource);
				// }
				//
				// resourceIterator = originalModel.listSubjectsWithProperty(RDF.type, Schema.Link);
				// while (resourceIterator.hasNext())
				// {
				// addResource(model, resourceIterator.nextResource());
				// }

				// model.write(new FileWriter(file), "RDF/XML-ABBREV");
			}
			catch (final IOException e)
			{
				e.printStackTrace();
			}

			getCommandStack().markSaveLocation();
		}

		@Override
		public boolean equals(final Object object)
		{
			return this == object;
		}

		@Override
		public ImageDescriptor getImageDescriptor()
		{
			return null; // PhysConfPlugin.getDescriptor("");
		}

		@Override
		public String getName()
		{
			if (filename != null) { return filename; }
			return "Augmented Reality Configuration";
		}

		@Override
		public String getToolTipText()
		{
			return "Augmented Reality Configuration";
		}

		@Override
		public int hashCode()
		{
			return INSTANCE.hashCode();
		}

		@Override
		public boolean isDirty()
		{
			return getCommandStack().isDirty();
		}

		// private void addResource(final Model model, final Resource resource)
		// {
		// final Model originalModel = ((InfModel)
		// BigEdPlugin.getDefault().getModel()).getRawModel();
		// final StmtIterator iterator = originalModel.listStatements(resource, null, (RDFNode)
		// null);
		// while (iterator.hasNext())
		// {
		// final Statement statement = iterator.nextStatement();
		// if (!statement.getPredicate().equals(Schema.createdComponentRequest) &&
		// !model.contains(statement))
		// {
		// model.add(statement);
		// if (statement.getObject() instanceof Resource)
		// {
		// addResource(model, statement.getResource());
		// }
		// }
		// }
		// }

		private String getFilename()
		{
			if (filename != null) { return filename; }
			final FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SAVE);
			final String newFilename = dialog.open();
			if (newFilename != null)
			{
				filename = newFilename;
			}
			return filename;
		}
	};

	public void doSaveAs()
	{
		final FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SAVE);
		final String newFilename = dialog.open();
		if (newFilename != null)
		{
			setFilename(newFilename);
			try
			{
				getSaveable().doSave(null);
			}
			catch (final CoreException e)
			{
				e.printStackTrace();
			}
		}
	}

	public String getFilename()
	{
		return filename;
	}

	public Saveable getSaveable()
	{
		return saveable;
	}

	public Saveable[] getSaveables()
	{
		return new Saveable[] { saveable };
	}

	public void setFilename(final String filename)
	{
		this.filename = filename;
	}
}