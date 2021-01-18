package restaurant;

public class CardItem {
    private final String typ;
    private final String name;
    private final double price;

    public CardItem(String typ, String name, double price) {
        this.typ = typ;
        this.name = name;
        this.price = price;
    }

    public String getTyp() {
        return typ;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
