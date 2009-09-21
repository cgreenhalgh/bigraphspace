package bigraph.biged.ui;

import java.util.Comparator;

public class BigraphLabelComparator implements Comparator<Object>
{
	@Override
	public int compare(Object o1, Object o2)
	{
		return BigraphLabelProvider.text(o1).compareTo(BigraphLabelProvider.text(o2));
	}
}
