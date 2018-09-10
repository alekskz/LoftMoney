package kz.aleksey.loftmoney;

public class Item {

    public static final String TYPE_EXPENSE = "expense";
    public static final String TYPE_INCOME = "income";
    public static final String TYPE_BALANS = "balans";

    private String name;
    private String price;

    public Item(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
