package ToysShop.View.Command;

import ToysShop.View.ConsoleUI;
import ToysShop.View.Command.Command;

public class GetPrize extends Command {
    public GetPrize( ConsoleUI consoleUI) {
        super("Получить приз", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getPrize();

    }
}