package kyu6;

public class ShopInventoryManager {

    private Item[] items;

    public ShopInventoryManager(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    public void updateQuality() {
        for (Item item : getItems()) {
            Goods goods = GoodsFactory.getType(item.getName());
            goods.updateQuality(item);
        }
    }
}

class Item {
    private String name;
    private Integer quality;
    private Integer sellIn;

    public Item(String name, int quality, int sellIn) {
        this.name = name;
        this.quality = quality;
        this.sellIn = sellIn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public String getName() {
        return name;
    }

    public Integer getQuality() {
        return quality;
    }

    public Integer getSellIn() {
        return sellIn;
    }
}

class GoodsFactory {
    public static Goods getType(String itemName) {
        itemName = itemName.toLowerCase();
        if (itemName.contains("aged brie")) {
            return new AgedBrie();
        } else if (itemName.contains("sulfuras")) {
            return new Sulfuras();
        } else if (itemName.contains("backstage passes")) {
            return new BackstagePass();
        } else if (itemName.contains("conjured")) {
            return new Normal(2);
        } else {
            return new Normal();
        }
    }
}

abstract class Goods {
    int BASE_QUALITY = 0;
    int MAX_QUALITY = 50;

    abstract void updateQuality(Item i);

    public boolean isBaseQuality(Item i, int quality) {
        if (quality < BASE_QUALITY) {
            i.setQuality(BASE_QUALITY);
            return true;
        }
        return false;
    }
}

class Normal extends Goods {
    private int degradeFactor = 1;

    public Normal(int degradeFactor) {
        this.degradeFactor = degradeFactor;
    }

    public Normal() {
    }

    public void updateQuality(Item i) {
        i.setSellIn(i.getSellIn() - 1);
        int quality = i.getQuality();
        if (isBaseQuality(i, quality)) return;
        if (i.getSellIn() < 0) {
            quality = quality - (2 * degradeFactor);
        } else {
            quality = quality - (1 * degradeFactor);
        }
        if (quality < BASE_QUALITY) {
            quality = BASE_QUALITY;
        }
        i.setQuality(quality);
    }

}

class AgedBrie extends Goods {
    public void updateQuality(Item i) {
        i.setSellIn(i.getSellIn() - 1);
        if (isBaseQuality(i, i.getQuality())) return;
        if (i.getQuality() < MAX_QUALITY) {
            i.setQuality(i.getQuality() + 1);
        }
    }
}

class BackstagePass extends Goods {
    public void updateQuality(Item i) {
        i.setSellIn(i.getSellIn() - 1);
        if (i.getSellIn() <= 0) {
            i.setQuality(BASE_QUALITY);
            return;
        }
        if (isBaseQuality(i, i.getQuality())) return;
        if (i.getQuality() < MAX_QUALITY) {
            if (i.getSellIn() <= 5) {
                i.setQuality(i.getQuality() + 3);
            } else if (i.getSellIn() <= 10) {
                i.setQuality(i.getQuality() + 2);
            } else {
                i.setQuality(i.getQuality() + 1);
            }

            if (i.getQuality() > MAX_QUALITY) {
                i.setQuality(MAX_QUALITY);
            }
        }
    }
}

class Sulfuras extends Goods {
    public void updateQuality(Item i) {
        return;
    }
}