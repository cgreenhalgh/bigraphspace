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
package bigraph.biged;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class BigEdPlugin extends AbstractUIPlugin
{
	// The shared instance.
	private static BigEdPlugin plugin;

	public static String createUniqueID()
	{
		return null;
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance.
	 */
	public static BigEdPlugin getDefault()
	{
		return plugin;
	}

	public static ImageDescriptor getDescriptor(final String key)
	{
		return getDefault().getImageRegistry().getDescriptor(key);
	}

	public static Image getImage(final String key)
	{
		return getDefault().getImageRegistry().get(key);
	}

	public static IPath getInstallDirectory()
	{
		final String path = Platform.getInstallLocation().getURL().getPath();
		if (path.endsWith("/eclipse/plugins/")) { return new Path("F:/artect/"); }
		return new Path(Platform.getInstallLocation().getURL().getPath());
	}

	private static ImageDescriptor getImageDescriptor(final String path)
	{
		return AbstractUIPlugin.imageDescriptorFromPlugin("bigraph.biged", path);
	}

	private final Collection<String> paths = new HashSet<String>();

	/**
	 * The constructor.
	 */
	public BigEdPlugin()
	{
		plugin = this;
	}

	public void addPath(final String path)
	{
		paths.add(path);
	}

	@Override
	public void start(final BundleContext context) throws Exception
	{
		super.start(context);
		final IPath installPath = BigEdPlugin.getInstallDirectory();
		System.setProperty("java.library.path", installPath.toOSString() + File.pathSeparator
				+ installPath.append("/common/").toOSString() + File.pathSeparator
				+ System.getProperty("java.library.path"));

		addPath("/");
		addPath(installPath.toOSString());
		addPath(installPath.append("/rdf/").toOSString());
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(final BundleContext context) throws Exception
	{
		super.stop(context);
		plugin = null;
	}

	@Override
	protected void initializeImageRegistry(final ImageRegistry reg)
	{
		super.initializeImageRegistry(reg);
		reg.put("node", getImageDescriptor("icons/node.png"));
		reg.put("port", getImageDescriptor("icons/port.gif"));
	}
}