package kyu6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShopInventoryManagerTest {
    private Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Conjured Mana Cake", 3, 6)
    };

    @Test
    public void test_basicCases() {
        ShopInventoryManager sim = new ShopInventoryManager(items);
        sim.updateQuality();

        System.out.println("Testing: " + items[0].getName());
        assertEquals("Expected different value", new Integer(9), items[0].getSellIn());
        assertEquals("Expected different value", new Integer(19), items[0].getQuality());

        System.out.println("Testing: " + items[1].getName());
        assertEquals("Expected different value", new Integer(1), items[1].getSellIn());
        assertEquals("Expected different value", new Integer(1), items[1].getQuality());

        System.out.println("Testing: " + items[2].getName());
        assertEquals("Expected different value", new Integer(4), items[2].getSellIn());
        assertEquals("Expected different value", new Integer(6), items[2].getQuality());

        System.out.println("Testing: " + items[3].getName());
        assertEquals("Expected different value", new Integer(0), items[3].getSellIn());
        assertEquals("Expected different value", new Integer(80), items[3].getQuality());

        System.out.println("Testing: " + items[4].getName());
        assertEquals("Expected different value", new Integer(14), items[4].getSellIn());
        assertEquals("Expected different value", new Integer(21), items[4].getQuality());

        System.out.println("Testing: " + items[5].getName());
        assertEquals("Expected different value", new Integer(2), items[5].getSellIn());
        assertEquals("Expected different value", new Integer(4), items[5].getQuality());
    }
}
