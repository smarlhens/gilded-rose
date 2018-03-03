package fr.esiea;

import fr.esiea.web.GildedRoseApplication;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class GildedRoseApplicationTest {
    @Test
    public void testMain() {
        String[] args = null;
        SoftAssertions solftly = new SoftAssertions();
        GildedRoseApplication.main(args);
        solftly.assertThat(GildedRoseApplication.status)
            .as("int statusMain")
            .isEqualTo(0);
    }
}
