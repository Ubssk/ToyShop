package ToysShop.Model.ToyShop;

import ToysShop.Model.FileHandler.Writer;
import ToysShop.Model.FileHandler.FileHandler;
import ToysShop.Model.ListOfToys.ListOfToys;
import ToysShop.Model.Toy.Toy;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;

public class ShopToys {
    private ToyBuilder toyBuilder;
    private ListOfToys listOfToys;
    private PriorityQueue<Toy> prizeToys;
    private Random lottery;
    Writer writer;



    public ShopToys(FileHandler fl) {
        this.toyBuilder = new ToyBuilder();
        this.listOfToys = new ListOfToys();
        this.prizeToys = new PriorityQueue<>();
        this.lottery = new Random();
        this.writer = fl;
    }
    public void  add(String id,String name,String quantity,String weight){
        try {
            int a = Integer.parseInt(quantity);
            int b = Integer.parseInt(weight);

        }catch (NumberFormatException e){
            System.out.println("В поле количество или в поле масса вы ввели не число!");
        }
        Toy toy = toyBuilder.toyBuild(id,name,quantity,weight);
        listOfToys.add(toy);
    }
    public void lotteryPrizeNumber(){
        if (listOfToys.getToys().size() == 0) {
            throw new NullPointerException(" Для розыгрыша необходимо добавить хотябы одну игрушку!");
        }else {
            int count = 0;
            for (int i = 0; i < listOfToys.getToys().size(); i++) {
                count += Integer.parseInt(listOfToys.getToys().get(i).getWeight());
            }

            int prizeNumber = lottery.nextInt(count * 10 + 1);
            int j = 0;
            for (int i = 0; i < listOfToys.getToys().size(); i++) {
                if (prizeNumber <= (Integer.parseInt(listOfToys.getToys().get(i).getWeight()) * 10 + j)
                        && Integer.parseInt(listOfToys.getToys().get(i).getQuantity()) != 0) {
                    prizeToys.add(listOfToys.getToys().get(i));
                    listOfToys.getToys().get(i).
                            setQuantity(String.valueOf(Integer.parseInt(listOfToys.getToys().get(i).getQuantity()) - 1));
                    break;

                } else if (prizeNumber <= (Integer.parseInt(listOfToys.getToys().get(i).getWeight()) * 10 + j)
                        && Integer.parseInt(listOfToys.getToys().get(i).getQuantity()) == 0) {
                    listOfToys.getToys().remove(listOfToys.getToys().get(i));
                    break;
                }
                j += Integer.parseInt(listOfToys.getToys().get(i).getWeight()) * 10;
            }
        }

        System.out.println("Розыгрышь состоялся!");

    }

    public  void  getPrize() throws IOException {
        try {
            String prize = prizeToys.peek().getId() + " " + prizeToys.peek().getName();
            writer.save(prize);
            System.out.println("Приз получен!");
        }catch (IOException e){
            throw new IOException("Список игрушек для розыгрыша пуст!");

        }catch (NullPointerException e){
            throw new NullPointerException("Для розыгрыша необходимо добавить хотябы одну игрушку или провести розыгрышь!");
        }
        prizeToys.poll();
    }
    public void allPrizes() throws Exception{
        System.out.println("Полученные призы: ");
        writer.read();
    }
    public void delete() {
        try {
            writer.delete();
        } catch (Exception e) {
            System.out.println("!!!");
        }
    }


}
