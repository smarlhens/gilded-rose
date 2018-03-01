package fr.esiea.models;

public class LegendaryItem extends Item {

    private Item item;

    /**
     * Make any item legendary
     */
    public LegendaryItem(Item item) {
        this.item = item;
    }

    public String getName() {
        return this.item.name;
    }

    public void setName(String name) {
        this.item.name = name;
    }

    public int getQuality() {
        return this.item.quality;
    }

    public int getSellIn() {
        return this.item.sellIn;
    }

    public String toString() {
        return this.item.name + ", " + this.item.sellIn + ", " + this.item.quality;
    }

    /**
     * The Quality of a legendary item can never be altered.
     */
    public void updateQuality() {
    }

}
