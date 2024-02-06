package ToysShop.View.Command;

import ToysShop.View.ConsoleUI;

public class Prize extends Command{
    public Prize( ConsoleUI consoleUI) {
        super("Список полученных призов", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().allPrizes();

    }
}
