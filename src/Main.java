

public class Main {
    public static void main(String[] args) {
        Database database = new Database("iris.txt",2);
        System.out.println(database.calculatingVectors("test.txt"));
    }
}