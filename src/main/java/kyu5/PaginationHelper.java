package kyu5;

import java.util.List;

public class PaginationHelper<I> {
    private List<I> collection;
    private int itemsPerPage;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    public List<I> getCollection() {
        return collection;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return getCollection().size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        if (getCollection().size() == 0) return 0;
        return (int) Math.ceil((double) getCollection().size() / getItemsPerPage());
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex > pageCount() - 1 || pageIndex < 0 || pageCount() == 0) {
            return -1;
        }

        return getItemsPerPage() - (int) Math.ceil((((pageIndex + 1) * getItemsPerPage()) % itemCount()) % getItemsPerPage());
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex > itemCount() || itemIndex < 0 || itemCount() == 0) {
            return -1;
        }
        return (int) Math.round((itemIndex + 1)/getItemsPerPage());
    }
}