import java.io.BufferedReader;;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Database {
    private List<Flower> flowers;
    private int k;

    public Database(String path,int k) {
        this.k=k;
        try {
            BufferedReader bf = new BufferedReader(new FileReader(path));
            String line;
            while ((line= bf.readLine())!= null){

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
