package fr.xebia.katas.gildedrose;

public class Item {
   private String name;
   private int sellIn;
   private int quality;

   public Item(String name, int sellIn, int quality) {
      this.name = name;
      this.sellIn = sellIn;
      this.quality = quality;
   }

   public void setSellIn(int sellIn) {
      this.sellIn = sellIn;
   }

   public void setQuality(int quality) {
      this.quality = quality;
   }

   public String getName() {
      return name;
   }

   public int getSellIn() {
      return sellIn;
   }

   public int getQuality() {
      return quality;
   }
}
