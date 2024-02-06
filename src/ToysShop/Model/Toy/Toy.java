package ToysShop.Model.Toy;

public class Toy  implements Comparable<Toy>{
    private String id;
    private String name;
    private String quantity;
    private String weight;

    public Toy(String id, String name, String quantity, String weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Toy o) {
        return weight.compareTo(o.getWeight());

    }
}
