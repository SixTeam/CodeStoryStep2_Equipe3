package fr.xebia.katas.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class Inn {
    private List<Item> items;

    public Inn() {
        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
    }

    public void updateQuality() {
        for (int i = 0; i < items.size(); i++) {
            updateItemQuality(items.get(i));
        }
    }

    Item updateItemQuality(Item item) {

        updateSellIn(item);

        updateQuality(item);

        return item;
    }

    private void updateQuality(Item item) {
        if (isNotAgedBrie(item) && isNotBackstagePasses(item)) {
            decreaseQuality(item);
        } else {
            increaseQuality(item);

            increaseBackstageQuality(item);
        }

        if (sellIn(item).isUnder(0)) {
            if (isNotAgedBrie(item)) {
                if (isNotBackstagePasses(item)) {
                    decreaseQuality(item);
                } else {
                    item.setQuality(0);
                }
            } else {
                increaseQuality(item);
            }
        }
    }

    private void increaseBackstageQuality(Item item) {
        if (isBackstage(item) && quality(item).isUnder(50)) {
            if (sellIn(item).isUnder(11) && quality(item).isUnder(50)) {
                increaseQuality(item);
            }

            if (sellIn(item).isUnder(6) && quality(item).isUnder(50)) {
                increaseQuality(item);
            }
        }
    }

    private void updateSellIn(Item item) {
        if (isNotLegendaryItem(item)) {
            decreaseSellin(item);
        }
    }

    private void decreaseSellin(Item item) {
        item.setSellIn(item.getSellIn() - 1);
    }

    private AttributeSpec sellIn(Item item) {
        return new AttributeSpec(item.getSellIn());
    }

    private AttributeSpec quality(Item item) {
        return new AttributeSpec(item.getQuality());
    }

    private boolean isBackstage(Item item) {
        return item.getName().equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void increaseQuality(Item item) {
        if (quality(item).isUnder(50)) {
            item.setQuality(item.getQuality() + 1);
        }

    }

    private void decreaseQuality(Item item) {
        if (qualityIsPositive(item) && isNotLegendaryItem(item)) {
            if (isConjured(item)) {
                item.setQuality(item.getQuality() - 1);
            }

            item.setQuality(item.getQuality() - 1);
        }
    }

    private boolean isConjured(Item item) {
        return item.getName().equals("Conjured Mana Cake");
    }

    private boolean qualityIsPositive(Item item) {
        return item.getQuality() > 0;
    }

    private boolean isNotLegendaryItem(Item item) {
        return !item.getName().equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isNotBackstagePasses(Item item) {
        return !isBackstage(item);
    }

    private boolean isNotAgedBrie(Item item) {
        return !item.getName().equals("Aged Brie");
    }

    public static void main(String[] args) {
        System.out.println("OMGHAI!");
        new Inn().updateQuality();
    }

    private class AttributeSpec {
        private int attribute;

        public AttributeSpec(int sellIn) {
            this.attribute = sellIn;
        }

        public boolean isUnder(int n) {
            return this.attribute < n;
        }

    }
}
