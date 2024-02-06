package ToysShop.View.Command;

import ToysShop.View.ConsoleUI;

public class Lottery extends Command {
    public Lottery( ConsoleUI consoleUI) {
        super("Провести лотерею", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getLottery();

    }
}
