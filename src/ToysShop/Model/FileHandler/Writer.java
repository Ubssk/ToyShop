package ToysShop.Model.FileHandler;

import java.io.IOException;

public interface Writer {
    public void save(String str) throws IOException;
    public void read() throws  Exception;
    public void delete() throws Exception;

}
