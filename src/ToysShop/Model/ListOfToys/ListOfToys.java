package ToysShop.Model.ListOfToys;

import ToysShop.Model.Toy.Toy;

import java.util.ArrayList;
import java.util.List;

public class ListOfToys {
    private List<Toy> toys;

    public ListOfToys() {
        this.toys = new ArrayList<>();
    }
    public void add(Toy toy){
        toys.add(toy);
    }


    public List<Toy> getToys() {
        return toys;
    }
}
