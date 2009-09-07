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

import java.util.List;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import bigraph.biged.model.Place;
import bigraph.biged.ui.properties.TypeMapper;
import bigraphspace.model.IndexValue;
import bigraphspace.model.PlaceType;

public class BigraphLabelProvider extends LabelProvider
{
	private static final BigraphLabelProvider LABEL_PROVIDER = new BigraphLabelProvider();

	public static Image image(final Object obj)
	{
		return LABEL_PROVIDER.getImage(obj);
	}

	public static String text(final Object obj)
	{
		return LABEL_PROVIDER.getText(obj);
	}

	@Override
	public Image getImage(final Object obj)
	{
		return null; // PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
	}

	@Override
	public String getText(final Object object)
	{
		final Object modelObject = TypeMapper.getModelObject(object);
		if (modelObject instanceof Place)
		{
			final Place place = (Place) modelObject;
			if (place.getType() == PlaceType.root)
			{
				return "root";
			}
			else if (place.getType() == PlaceType.site)
			{
				if (place.getSiteIndex() == null)
				{
					return "site";
				}
				else
				{
					return "site[" + place.getSiteIndex() + "]";
				}
			}
			else
			{
				String name = "";
				boolean comma = false;
				List<IndexValue> values = place.getControlIndexes();
				for(final IndexValue value: values)
				{
					if(comma)
					{
						name+= ", ";
					}
					else
					{
						comma = true;
					}
					name += value.getValue().toString();
				}
				
				if(comma)
				{
					name += ":";
				}
				
				name += place.getControlName();
				
				if(place.getSupport() != null && !place.getSupport().trim().equals(""))
				{
					name += "@" + place.getSupport();
				}
				return name;
			}
		}
		return modelObject.toString();
	}
}