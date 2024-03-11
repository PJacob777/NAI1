import java.io.BufferedReader;;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Database {
    private List<Flower> flowers;
    private int k;
    private Map<Double,Flower> flowerMap;

    public Database(String path,int k) {
        this.k=k;
        flowers= new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(path))){
            String line;
            while ((line= bf.readLine())!= null){
                String[] words = line.split(",");
                flowers.add(new Flower(Double.parseDouble(words[0]),Double.parseDouble(words[1]),Double.parseDouble(words[2]),words[3]));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void calculatingVectors(String path){
        try (BufferedReader bf = new BufferedReader(new FileReader(path))){
            flowerMap= new TreeMap<>();
            String line;
            int counter;
            while ((line=bf.readLine())!=null){
                String[] words = line.split(",");
                Flower a = new Flower(Double.parseDouble(words[0]),Double.parseDouble(words[1]),Double.parseDouble(words[2]),words[3]);
                for (Flower i : flowers){
                    double vector = Math.sqrt(Math.pow((a.getX()-i.getX()),2)+Math.pow((a.getY()-i.getY()),2)+Math.pow((a.getZ()-i.getZ()),2));
                    flowerMap.put(vector,i);
                }
                Map<Double,Flower> tmp = new TreeMap<>();

            }
        }catch (IOException x) {
            x.printStackTrace();
        }

    }
}
