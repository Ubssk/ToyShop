package ToysShop.Model.FileHandler;

import java.io.*;
import java.util.Arrays;

public class FileHandler implements Writer {

    @Override
    public void save(String str) {
        try (FileWriter wr = new FileWriter(".\\src\\.result.txt", true)) {
            wr.write(str);
            wr.write("\n");
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    @Override
    public void read() throws Exception {
        boolean have = false;
        try (FileReader reader = new FileReader(".\\src\\.result.txt")) {
            char[] buf = new char[256];
            int c;
            while ((c = reader.read(buf)) > 0) {
                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.println(buf);
                have = true;
            }
            if (have==false) {
                throw new NullPointerException("Список призов пуст." +
                        " Сначало заполните список с игрушками и проведите розыгрыш!");
            }


        }

    }

    @Override
    public void delete() throws Exception {
        File file = new File(".\\src\\.result.txt");
        file.delete();
        System.out.println("Список призов удален!");


    }
}
