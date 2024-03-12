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
                flowers.add(new Flower(Double.parseDouble(words[0]),Double.parseDouble(words[1]),Double.parseDouble(words[2]),Double.parseDouble(words[3]),words[4]));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public double calculatingVectors(String path){
        double counter=0;
        double checked=0;
        try (BufferedReader bf = new BufferedReader(new FileReader(path))){
            flowerMap= new TreeMap<>();
            String line;
            while ((line=bf.readLine())!=null){
                counter++;
                String[] words = line.split(",");
                Flower a = new Flower(Double.parseDouble(words[0]),Double.parseDouble(words[1]),Double.parseDouble(words[2]),Double.parseDouble(words[3]),words[4]);
                for (Flower i : flowers){
                    double vector = Math.sqrt(Math.pow((a.getX()-i.getX()),2)+Math.pow((a.getY()-i.getY()),2)+Math.pow((a.getZ()-i.getZ()),2)+Math.pow((a.getP()-i.getP()),2));
                    flowerMap.put(vector,i);
                }
                Map<Flower,Double> tmp = new HashMap<>();
                Set<Map.Entry<Double,Flower>> entries= flowerMap.entrySet();
                Iterator<Map.Entry<Double,Flower>> iterator = entries.iterator();
                for(int i =0; i <k && iterator.hasNext();i++){
                    Map.Entry<Double,Flower> entry = iterator.next();
                    if(!tmp.containsKey(entry.getValue()))
                        tmp.put(entry.getValue(),entry.getKey());
                    else {
                        tmp.replace(entry.getValue(),entry.getKey(),entry.getKey()+1);
                    }
                }
                String resultName = getMaxDescription(tmp);
                if(a.getDesc().equals(resultName))
                    checked++;
            }
        }catch (IOException x) {
            x.printStackTrace();
        }
        return checked/counter;
    }
    private String getMaxDescription(Map<Flower,Double> map){
        double max =0;
        String name="";
        Map<Flower,Double> tmp= new HashMap<>();
        for (Map.Entry<Flower,Double> i : map.entrySet()){
            if (!tmp.containsKey(i.getKey()))
                tmp.put(i.getKey(),1.0);
            else
                tmp.replace(i.getKey(),tmp.get(i.getKey()),tmp.get(i.getKey())+1);
        }
        for (Map.Entry<Flower,Double> e : tmp.entrySet()){
                if (e.getValue()>max) {
                    max=e.getValue();
                    name=e.getKey().getDesc();
                }
            }
        return name;
        }
    }

