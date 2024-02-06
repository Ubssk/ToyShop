package ToysShop.Presenter;

import ToysShop.Model.FileHandler.FileHandler;
import ToysShop.Model.ToyShop.ShopToys;
import ToysShop.View.View;

import java.io.IOException;

public class Presenter {
    View view;
    ShopToys shop;

    public Presenter(View view) {
        this.view = view;
        this.shop = new ShopToys(new FileHandler());
    }
    public void add(String id,String name,String quantity,String weight){
        shop.add(id,name,quantity,weight);
    }
    public void getLottery() {
        try {
            shop.lotteryPrizeNumber();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
    public void getPrize() {
        try {
            shop.getPrize();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
    public void allPrizes() {
        try {
            shop.allPrizes();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void delete(){
        shop.delete();

    }

}