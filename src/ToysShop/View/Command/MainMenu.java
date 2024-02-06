package ToysShop.View.Command;

import ToysShop.View.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new Add(consoleUI));
        commands.add(new Lottery(consoleUI));
        commands.add(new GetPrize(consoleUI));
        commands.add(new Prize(consoleUI));
        commands.add(new Delete(consoleUI));
        commands.add(new Finish(consoleUI));
    }
    public  String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1)
                    .append(". ")
                    .append(commands.get(i).getDescription())
                    .append("\n");
        }
        return stringBuilder.toString();
    }
    public void execute(int choice){
        Command command = commands.get(choice-1);
        command.execute();
    }
    public int size(){
        return  commands.size();
    }
}