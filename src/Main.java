import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wspolczynnik k ");
        int k = scanner.nextInt();
        System.out.println("Czy chcesz wpisac swoj wektor? T czy N? ");
        String ans = scanner.next();
        Database database = new Database("Trainset.txt",k);
        if(ans.equals("N"))
            System.out.println(database.calculatingVectors("TestSet.txt"));
        else {
            do {
                System.out.println("Podaj wspolzedne wektora oddzielone przecinkami ");
                String vec = scanner.next();
                String[] tmp = vec.split(",");
                System.out.println("Twoj kwiatek to " + database.findNameOfFlower(Double.parseDouble(tmp[0]), Double.parseDouble(tmp[1]), Double.parseDouble(tmp[2]), Double.parseDouble(tmp[3])));
                System.out.println("Czy chcesz kontynuowac ?");
            }while (!scanner.next().equals("N"));
            scanner.close();
        }
    }
}