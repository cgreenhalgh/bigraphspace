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
package bigraph.biged.splashHandlers;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.splash.AbstractSplashHandler;

/**
 * @since 3.3
 * 
 */
public class ExtensibleSplashHandler extends AbstractSplashHandler
{

	private final ArrayList<Image> fImageList;
	private final ArrayList<String> fTooltipList;
	private final static String F_SPLASH_EXTENSION_ID = "ect.equip.physconf.splashExtension"; // NON-NLS-1
	private final static String F_ELEMENT_ICON = "icon"; // NON-NLS-1
	private final static String F_ELEMENT_TOOLTIP = "tooltip"; // NON-NLS-1
	private final static String F_DEFAULT_TOOLTIP = "Image"; // NON-NLS-1
	private final static int F_IMAGE_WIDTH = 50;
	private final static int F_IMAGE_HEIGHT = 50;
	private final static int F_SPLASH_SCREEN_BEVEL = 5;
	private Composite fIconPanel;

	/**
	 * 
	 */
	public ExtensibleSplashHandler()
	{
		fImageList = new ArrayList<Image>();
		fTooltipList = new ArrayList<String>();
		fIconPanel = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.splash.AbstractSplashHandler#dispose()
	 */
	@Override
	public void dispose()
	{
		super.dispose();
		// Check to see if any images were defined
		if ((fImageList == null) || fImageList.isEmpty()) { return; }
		// Dispose of all the images
		for (final Image image : fImageList)
		{
			image.dispose();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.splash.AbstractSplashHandler#init(org.eclipse.swt.widgets .Shell)
	 */
	@Override
	public void init(final Shell splash)
	{
		// Store the shell
		super.init(splash);
		// Configure the shell layout
		configureUISplash();
		// Load all splash extensions
		loadSplashExtensions();
		// If no splash extensions were loaded abort the splash handler
		if (hasSplashExtensions() == false) { return; }
		// Create UI
		createUI();
		// Configure the image panel bounds
		configureUICompositeIconPanelBounds();
		// Enter event loop and prevent the RCP application from
		// loading until all work is done
		doEventLoop();
	}

	/**
	 * 
	 */
	private void configureUICompositeIconPanelBounds()
	{
		// Determine the size of the panel and position it at the bottom-right
		// of the splash screen.
		final Point panelSize = fIconPanel.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);

		final int x_coord = getSplash().getSize().x - F_SPLASH_SCREEN_BEVEL - panelSize.x;
		final int y_coord = getSplash().getSize().y - F_SPLASH_SCREEN_BEVEL - panelSize.y;
		final int x_width = panelSize.x;
		final int y_width = panelSize.y;

		fIconPanel.setBounds(x_coord, y_coord, x_width, y_width);
	}

	/**
	 * 
	 */
	private void configureUISplash()
	{
		// Configure layout
		final GridLayout layout = new GridLayout(1, true);
		getSplash().setLayout(layout);
		// Force shell to inherit the splash background
		getSplash().setBackgroundMode(SWT.INHERIT_DEFAULT);
	}

	/**
	 * 
	 */
	private void createUI()
	{
		// Create the icon panel
		createUICompositeIconPanel();
		// Create the images
		createUIImages();
	}

	/**
	 * 
	 */
	private void createUICompositeIconPanel()
	{
		final Shell splash = getSplash();
		// Create the composite
		fIconPanel = new Composite(splash, SWT.NONE);
		// Determine the maximum number of columns that can fit on the splash
		// screen. One 50x50 image per column.
		final int maxColumnCount = getUsableSplashScreenWidth() / F_IMAGE_WIDTH;
		// Limit size to the maximum number of columns if the number of images
		// exceed this amount; otherwise, use the exact number of columns
		// required.
		final int actualColumnCount = Math.min(fImageList.size(), maxColumnCount);
		// Configure the layout
		final GridLayout layout = new GridLayout(actualColumnCount, true);
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		fIconPanel.setLayout(layout);
	}

	/**
	 * 
	 */
	private void createUIImages()
	{
		final Iterator<Image> imageIterator = fImageList.iterator();
		final Iterator<String> tooltipIterator = fTooltipList.iterator();
		int i = 1;
		final int columnCount = ((GridLayout) fIconPanel.getLayout()).numColumns;
		// Create all the images
		// Abort if we run out of columns (left-over images will not fit within
		// the usable splash screen width)
		while (imageIterator.hasNext() && (i <= columnCount))
		{
			final Image image = imageIterator.next();
			final String tooltip = tooltipIterator.next();
			// Create the image using a label widget
			createUILabel(image, tooltip);
			i++;
		}
	}

	/**
	 * @param image
	 * @param tooltip
	 */
	private void createUILabel(final Image image, final String tooltip)
	{
		// Create the label (no text)
		final Label label = new Label(fIconPanel, SWT.NONE);
		label.setImage(image);
		label.setToolTipText(tooltip);
	}

	/**
	 * 
	 */
	private void doEventLoop()
	{
		final Shell splash = getSplash();
		if (splash.getDisplay().readAndDispatch() == false)
		{
			splash.getDisplay().sleep();
		}
	}

	/**
	 * @return
	 */
	private int getUsableSplashScreenWidth()
	{
		// Splash screen width minus two graphic border bevel widths
		return getSplash().getSize().x - (F_SPLASH_SCREEN_BEVEL * 2);
	}

	/**
	 * @return
	 */
	private boolean hasSplashExtensions()
	{
		if (fImageList.isEmpty())
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * 
	 */
	private void loadSplashExtensions()
	{
		// Get all splash handler extensions
		final IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint(F_SPLASH_EXTENSION_ID)
				.getExtensions();
		// Process all splash handler extensions
		for (final IExtension extension : extensions)
		{
			processSplashExtension(extension);
		}
	}

	/**
	 * @param configurationElement
	 */
	private void processSplashElementIcon(final IConfigurationElement configurationElement)
	{
		// Get attribute icon
		final String iconImageFilePath = configurationElement.getAttribute(F_ELEMENT_ICON);
		// Abort if an icon attribute was not specified
		if ((iconImageFilePath == null) || (iconImageFilePath.length() == 0)) { return; }
		// Create a corresponding image descriptor
		final ImageDescriptor descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(configurationElement
				.getNamespaceIdentifier(), iconImageFilePath);
		// Abort if no corresponding image was found
		if (descriptor == null) { return; }
		// Create the image
		final Image image = descriptor.createImage();
		// Abort if image creation failed
		if (image == null) { return; }
		// Abort if the image does not have dimensions of 50x50
		if ((image.getBounds().width != F_IMAGE_WIDTH) || (image.getBounds().height != F_IMAGE_HEIGHT))
		{
			// Dipose of the image
			image.dispose();
			return;
		}
		// Store the image and tooltip
		fImageList.add(image);
	}

	/**
	 * @param configurationElement
	 */
	private void processSplashElements(final IConfigurationElement configurationElement)
	{
		// Attribute: icon
		processSplashElementIcon(configurationElement);
		// Attribute: tooltip
		processSplashElementTooltip(configurationElement);
	}

	/**
	 * @param configurationElement
	 */
	private void processSplashElementTooltip(final IConfigurationElement configurationElement)
	{
		// Get attribute tooltip
		final String tooltip = configurationElement.getAttribute(F_ELEMENT_TOOLTIP);
		// If a tooltip is not defined, give it a default
		if ((tooltip == null) || (tooltip.length() == 0))
		{
			fTooltipList.add(F_DEFAULT_TOOLTIP);
		}
		else
		{
			fTooltipList.add(tooltip);
		}
	}

	/**
	 * @param extension
	 */
	private void processSplashExtension(final IExtension extension)
	{
		// Get all splash handler configuration elements
		final IConfigurationElement[] elements = extension.getConfigurationElements();
		// Process all splash handler configuration elements
		for (final IConfigurationElement element : elements)
		{
			processSplashElements(element);
		}
	}
}
