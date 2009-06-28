/**
 * 
 */
package bigraphspace.sorting;

import bigraphspace.model.Place;

/** Child Sort is not permitted by sorting.
 * 
 * @author cmg
 *
 */
public class ChildSortException extends SortingException {
	/** the node sort */
	protected Sort sort;
	/** the child node sort */
	protected Sort childSort;
	/** the node (optional) */
	protected Place place;
	/** the child node (optional) */
	protected Place child;

	/**
	 * 
	 */
	public ChildSortException(Sort sort, Sort childSort, Place place, Place child) {
		this.sort = sort;
		this.childSort = childSort;
		this.place = place;
		this.child = child;
	}

	/**
	 * @param arg0
	 */
	public ChildSortException(String arg0, Sort sort, Sort childSort, Place place, Place child) {
		super(arg0);
		this.sort = sort;
		this.childSort = childSort;
		this.place = place;
		this.child = child;
	}

	/**
	 * @param arg0
	 */
	public ChildSortException(Sort sort, Sort childSort, Place place, Place child, Throwable arg0) {
		super(arg0);
		this.sort = sort;
		this.childSort = childSort;
		this.place = place;
		this.child = child;
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public ChildSortException(String arg0, Sort sort, Sort childSort, Place place, Place child, Throwable arg1) {
		super(arg0, arg1);
		this.sort = sort;
		this.childSort = childSort;
		this.place = place;
		this.child = child;
	}

	/**
	 * @return the sort
	 */
	public Sort getSort() {
		return sort;
	}

	/**
	 * @return the childSort
	 */
	public Sort getChildSort() {
		return childSort;
	}

	/**
	 * @return the place
	 */
	public Place getPlace() {
		return place;
	}

	/**
	 * @return the child
	 */
	public Place getChild() {
		return child;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		return super.toString()+" (sort"+sort+", childSort="+childSort+", place="+place+", child="+child+")";
	}
	
}
