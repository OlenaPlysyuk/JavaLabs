package florist;

public class Flower {
    private String name;
    private String color;
    private String scent;
    private String size;
    private String description;
    private String producer;
    private String countryOfOrigin;
    private int price;

    public Flower(String name, String color, String scent, String size, String description, String producer, String countryOfOrigin, int price) {
        this.name = name;
        this.color = color;
        this.scent = scent;
        this.size = size;
        this.description = description;
        this.producer = producer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getScent() {
        return scent;
    }

    public void setScent(String scent) {
        this.scent = scent;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flower: " +
                " name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", scent='" + scent + '\'' +
                ", size='" + size + '\'' +
                ", description='" + description + '\'' +
                ", producer='" + producer + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", price=" + price +
                ' ';
    }
}
