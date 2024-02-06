package ToysShop.Model.ToyShop;

import ToysShop.Model.Toy.Toy;

public class ToyBuilder {
    public Toy toyBuild(String id, String name, String quantity, String weight) {
        Toy toy = new Toy(id,name,quantity,weight);
        return toy;
    }
}
