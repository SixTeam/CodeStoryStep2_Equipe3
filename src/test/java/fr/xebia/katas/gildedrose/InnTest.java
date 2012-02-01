package fr.xebia.katas.gildedrose;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InnTest {

    final private static int LAST_DAY = 0;


    @Test
   public void should_test_the_truth() throws Exception {
      assertThat(true).isTrue();
   }

    @Test
    public void item_quality_shouldnt_be_negative(){
        assertFalse(new Inn().updateItemQuality(new Item("Foobar", LAST_DAY, 0)).getQuality() < 0);
    }

    @Test
    public void item_quality_should_degrade_twice_as_fast(){
        assertEquals(2, new Inn().updateItemQuality(new Item("Foobar", LAST_DAY, 4)).getQuality());
    }

    @Test
    public void aged_brie_item_should_increase_the_older_it_gest(){
        assertEquals(6, new Inn().updateItemQuality(new Item("Aged Brie", LAST_DAY, 4)).getQuality());
    }

    @Test
    public void aged_brie_item_shouldnt_increase_more_than_50(){
        assertEquals(50, new Inn().updateItemQuality(new Item("Aged Brie", LAST_DAY, 50)).getQuality());
    }

    @Test
    public void sulfuras_shouldnt_change(){
        assertEquals(10, new Inn().updateItemQuality(new Item("Sulfuras, Hand of Ragnaros", 5, 10)).getQuality());
        assertEquals(5, new Inn().updateItemQuality(new Item("Sulfuras, Hand of Ragnaros", 5, 10)).getSellIn());
    }

    @Test
    public void backstage_passes_item_should_increase_the_older_it_gets_by_2_between_10_and_5(){
        assertEquals(6, new Inn().updateItemQuality(new Item("Backstage passes to a TAFKAL80ETC concert", 9, 4)).getQuality());
    }

    @Test
    public void backstage_passes_item_should_increase_the_older_it_gets_by_3_between_5_and_0(){
        assertEquals(7, new Inn().updateItemQuality(new Item("Backstage passes to a TAFKAL80ETC concert", 3, 4)).getQuality());
    }

    @Test
    public void backstage_passes_item_quality_drop_to_0_after_sell(){
        assertEquals(0, new Inn().updateItemQuality(new Item("Backstage passes to a TAFKAL80ETC concert", LAST_DAY, 4)).getQuality());
    }


    @Test
    public void conjured_item_decrease_in_quality_twice_as_normal(){
        assertEquals(0, new Inn().updateItemQuality(new Item("Conjured Mana Cake", LAST_DAY, 4)).getQuality());
        assertEquals(2, new Inn().updateItemQuality(new Item("Conjured Mana Cake", 2, 4)).getQuality());
    }
}
