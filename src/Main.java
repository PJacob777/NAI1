

public class Main {
    public static void main(String[] args) {
        Database database = new Database("Trainset.txt",2);
        System.out.println(database.calculatingVectors("TestSet.txt"));
    }
}