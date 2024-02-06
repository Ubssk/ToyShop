package ToysShop.View;

import ToysShop.Presenter.Presenter;
import ToysShop.View.Command.MainMenu;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scan;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scan = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);


    }

    @Override
    public void start() {
        System.out.println("Розыгрыш призов в магазине игрушек\n " +
                "Выберите одну из операций ниже по номеру");
        while (work) {
            printMenu();
            choice();

        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    private void choice(){
        int line = scan.nextInt();
        if(line > 0 && line <= menu.size()) menu.execute(line);
        else error();
    }
    private void error(){
        System.out.println("Операции с таким номером не существует, выберите из списка!");
    }
    private void printMenu(){
        System.out.println(menu.menu());
    }
    public void finish(){
        System.out.println("До новых встреч!");
        work = false;
    }


    public void add() {
        System.out.println("Введите id: ");
        String id = scan.next();
        System.out.println("Введите назавание игрушки: ");
        String name = scan.next();
        System.out.println("Введите количество игрушек: ");
        String quantity = scan.next();
        System.out.println("Введите вес(чатоту выпадения): ");
        String weight  = scan.next();
        presenter.add(id,name,quantity,weight);
    }
    public void getLottery(){
        presenter.getLottery();

    }
    public  void getPrize(){
        presenter.getPrize();
    }
    public void allPrizes(){
        presenter.allPrizes();
    }
    public  void delete(){
        presenter.delete();
    }



}