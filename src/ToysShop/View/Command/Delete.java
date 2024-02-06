package ToysShop.View.Command;

import ToysShop.View.ConsoleUI;

public class Delete extends Command{
    public Delete( ConsoleUI consoleUI) {
        super("Удалить список призов", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().delete();

    }
}
