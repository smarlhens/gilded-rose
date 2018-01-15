package fr.esiea;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void non_specific_object_quality_and_sellin_decrease_by_one(){
        Item item = new Item("Groot", 10, 10);
        Item[] items = new Item[] {item};

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
}
