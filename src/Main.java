import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Database database = new Database("iris.txt",2);
        TreeMap<Double,String> map = new TreeMap<>();
        map.put(2.0,"as");
        map.put(1.0,"asdasd");
        map.put(3.0,"asa");
        for (Map.Entry<Double,String> e : map.entrySet()){
            Double key = e.getKey();
            String val = e.getValue();
            System.out.println("key ="+key+", Val = "+ val);
        }
    }
}