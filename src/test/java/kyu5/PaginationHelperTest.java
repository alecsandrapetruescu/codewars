package kyu5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PaginationHelperTest {
    @Test
    public void testSomething() {
        List<Integer> items = getItems();
        PaginationHelper<Integer> helper = new PaginationHelper<>(items, 12);
        assertEquals("item count",55, helper.itemCount());
        assertEquals("page index",0, helper.pageIndex(1));
        assertEquals("page count",5, helper.pageCount());
        assertEquals("nr of items per page",7, helper.pageItemCount(4));
    }

    private List<Integer> getItems() {
        List<Integer> items = new ArrayList<>();
        for (int i=0; i< 55; i++) {
            items.add(i);
        }
        return items;
    }
}
