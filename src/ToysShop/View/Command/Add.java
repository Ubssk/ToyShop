package ToysShop.View.Command;

import ToysShop.View.ConsoleUI;

public class Add extends Command {
    public Add( ConsoleUI consoleUI) {
        super("Добавить игрушку",consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().add();

    }
}
