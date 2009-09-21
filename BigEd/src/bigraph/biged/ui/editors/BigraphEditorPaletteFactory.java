/*******************************************************************************
 * Copyright (c) 2004, 2008 Elias Volanakis and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Elias Volanakis - initial API and implementation
 *******************************************************************************/
package bigraph.biged.ui.editors;

import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteToolbar;
import org.eclipse.gef.palette.PanningSelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;

import bigraph.biged.BigEdPlugin;
import bigraphspace.model.Place;
import bigraphspace.model.PlaceType;

/**
 * Utility class that can create a GEF Palette.
 * 
 * @see #createPalette()
 * @author Elias Volanakis
 */
final class BigraphEditorPaletteFactory
{
	/**
	 * Creates the PaletteRoot and adds all palette elements. Use this factory method to create a
	 * new palette for your graphical editor.
	 * 
	 * @return a new PaletteRoot
	 */
	static PaletteRoot createPalette(final BigraphEditor editor)
	{
		final PaletteRoot palette = new PaletteRoot();
		palette.add(createToolsGroup(palette));
		palette.add(createPlacesDrawer(editor));
		return palette;
	}

	/** Create the "Places" drawer. */
	private static PaletteContainer createPlacesDrawer(final BigraphEditor editor)
	{
		final PaletteDrawer componentsDrawer = new PaletteDrawer("Places");

		CombinedTemplateCreationEntry component = new CombinedTemplateCreationEntry("Root", "Create a Root",
				Place.class, new PlaceFactory(editor, PlaceType.root), null, null);
		componentsDrawer.add(component);

		component = new CombinedTemplateCreationEntry("Place", "Create a Place", Place.class, new PlaceFactory(editor,
				PlaceType.node), BigEdPlugin.getDescriptor("node"), null);
		componentsDrawer.add(component);

		component = new CombinedTemplateCreationEntry("Site", "Create a Site", Place.class, new PlaceFactory(editor,
				PlaceType.site), null, null);
		componentsDrawer.add(component);

		return componentsDrawer;
	}

	/** Create the "Tools" group. */
	private static PaletteContainer createToolsGroup(final PaletteRoot palette)
	{
		final PaletteToolbar toolbar = new PaletteToolbar("Tools");

		// Add a selection tool to the group
		final ToolEntry tool = new PanningSelectionToolEntry();
		toolbar.add(tool);
		palette.setDefaultEntry(tool);

		// Add a marquee tool to the group
		toolbar.add(new MarqueeToolEntry());

		return toolbar;
	}

	/** Utility class. */
	private BigraphEditorPaletteFactory()
	{
		// Utility class
	}
}