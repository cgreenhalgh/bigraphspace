package bigraph.biged.ui;

import java.util.Comparator;

public class BigraphLabelComparator implements Comparator<Object>
{
	public int compare(final Object o1, final Object o2)
	{
		return BigraphLabelProvider.text(o1).compareTo(BigraphLabelProvider.text(o2));
	}
}
