package ToysShop.View.Command;

import ToysShop.View.ConsoleUI;

public class Finish extends Command {
    public Finish( ConsoleUI consoleUI) {
        super("Закончить работу", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();

    }

}
