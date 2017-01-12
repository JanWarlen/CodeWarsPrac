package codewars;

import java.util.Arrays;
import java.util.List;

//TODO: complete this object/class

public class PaginationHelper<I> {

	private int itemsPerPage;
	private int len;
	
	/**
	* The constructor takes in an array of items and a integer indicating how many
	* items fit within a single page
	*/
	public PaginationHelper(List<I> collection, int itemsPerPage) {
		
		 this.itemsPerPage = itemsPerPage;
		 this.len = collection.size();
		
	}
	
	/**
	* returns the number of items within the entire collection
	*/
	public int itemCount() {
		return len;
	}
	
	/**
	* returns the number of pages
	*/
	public int pageCount() {
		return (int) Math.ceil((double)len/itemsPerPage);
	}
	
	/**
	* returns the number of items on the current page. page_index is zero based.
	* this method should return -1 for pageIndex values that are out of range
	*/
	public int pageItemCount(int pageIndex) {
		pageIndex+=1;
		return (pageIndex<pageCount() && pageIndex > -1)?itemsPerPage:pageIndex == pageCount()?len%itemsPerPage:-1;
	}
	
	/**
	* determines what page an item is on. Zero based indexes
	* this method should return -1 for itemIndex values that are out of range
	*/
	public int pageIndex(int itemIndex) {
		return (itemIndex>len||itemIndex<1||len<1)?-1:Math.round(itemIndex/itemsPerPage)-1;
	}
	
	public static void main(String[] args) {
		PaginationHelper<Character> helper = new PaginationHelper<Character>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f','a', 'b', 'c','a'), 4);
		System.out.println(helper.pageCount());
		System.out.println(helper.pageItemCount(-1));
		System.out.println(helper.pageItemCount(0));
		System.out.println(helper.pageItemCount(1));
		System.out.println(helper.pageItemCount(2));
		System.out.println(helper.pageItemCount(3));
		System.out.println(helper.pageItemCount(4));
	}
}