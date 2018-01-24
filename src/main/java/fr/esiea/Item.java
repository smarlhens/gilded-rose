package fr.esiea;

public class Item {

    protected String name;
    protected int sellIn;
    protected int quality;

    public Item(){
        this.name = "";
        this.sellIn = 0;
        this.quality = 0;
    }

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return this.sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return this.quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void updateQuality(){
        this.quality -= (this.sellIn > 0) ? 1 : 2;
    }
}
