package fr.esiea;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void non_specific_object_quality_and_sellin_decrease_by_one() {
        Item item = new Item("Groot", 10, 10);
        Item[] items = new Item[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.quality)
            .as("Groot quality")
            .isEqualTo(9);

        solftly.assertThat(item.sellIn)
            .as("Groot price")
            .isEqualTo(9);

        solftly.assertAll();
    }

    @Test
    public void non_specific_object_sellin_lower_than_zero() {
        Item item = new Item("Groot", 0, 10);
        Item[] items = new Item[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.quality)
            .as("Groot quality")
            .isEqualTo(8);

        solftly.assertThat(item.sellIn)
            .as("Groot price")
            .isEqualTo(-1);

        solftly.assertAll();
    }

    @Test
    public void aged_brie_quality_and_sellin() {
        Item item = new Item("Aged Brie", 0, 10);
        Item[] items = new Item[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.quality)
            .as("Aged Brie quality")
            .isEqualTo(12);

        solftly.assertThat(item.sellIn)
            .as("Aged Brie price")
            .isEqualTo(-1);

        solftly.assertAll();
    }

    @Test
    public void tafkal80etc_quality_and_sellin() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
        Item[] items = new Item[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.quality)
            .as("TAFKAL80ETC quality")
            .isEqualTo(0);

        solftly.assertThat(item.sellIn)
            .as("TAFKAL80ETC price")
            .isEqualTo(-1);

        solftly.assertAll();
    }

    @Test
    public void non_specific_object_to_string() {
        Item item = new Item("Groot", 10, 10);
        SoftAssertions solftly = new SoftAssertions();

        solftly.assertThat(item.toString())
            .as("Groot toString")
            .isEqualTo("Groot, 10, 10");

        solftly.assertAll();
    }
}
