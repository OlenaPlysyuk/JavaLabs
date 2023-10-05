import java.util.Comparator;
import java.util.Scanner;
public class Main {

    public static Abiturient[] ListCreation(int size) {
        Scanner scan = new Scanner(System.in);
        Abiturient[] list = new Abiturient[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter id:");
            int id = scan.nextInt();
            System.out.println("Enter last name:");
            String lastname = scan.next();
            System.out.println("Enter first name:");
            String fistname = scan.next();
            System.out.println("Enter patronymic name:");
            String patronymicname = scan.next();
            System.out.println("Enter address:");
            String address = scan.next();
            System.out.println("Enter phonenumb:");
            String phonenumb = scan.next();
            System.out.println("Enter average score:");
            double averagescore = scan.nextDouble();

            list[i] = new Abiturient(id, lastname, fistname, patronymicname, address, phonenumb, averagescore);

        }


        return list;
    }

    public static void printout(int size, Abiturient[] list) {
        for (int i = 0; i < size; i++) {
            System.out.println(list[i].toString());
        }

    }

    public static void taskA(int size, String targetFname, Abiturient[] list) {
        System.out.println("a) Abiturients with Name " + targetFname + ":");

        for (int i = 0; i < size; i++) {
            if (list[i].getFirstName().equals(targetFname)) {
                System.out.println(list[i]);

            }
        }
    }

    public static void taskB(int size, double minAvScore, Abiturient[] list) {
        System.out.println("b) Abiturients with minimal average score" + minAvScore + ":");

        for (int i = 0; i < size; i++) {
            if (list[i].getAverageScore() >= minAvScore) {
                System.out.println(list[i]);

            }
        }
    }

    public static void bubbleSort(Abiturient[] list, int size, int quantity) {

        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < size; i++) {
                if (list[i - 1].getAverageScore() < list[i].getAverageScore()) {
                    // Обмін елементів, якщо поточний менший за наступний
                    Abiturient temp = list[i - 1];
                    list[i - 1] = list[i];
                    list[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }


    public static void taskC(int size, int quantity, Abiturient[] list) {

        System.out.println("c)" + quantity + "abitureints with the highest avarage scores:");

        bubbleSort(list, size, quantity);
        for (int i = 0; i < quantity && i < size; i++) {
            System.out.println(list[i]);


        }
    }


    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        System.out.println("Enter students quantity:");
        int size = scan.nextInt();

        Abiturient[] list = ListCreation(size);
        printout(size, list);

        System.out.println("Enter target name:");
        String targetFname = scan.next();
        taskA(size, targetFname, list);
        System.out.println("Enter minimal avarage score:");
        double minAvScore = scan.nextDouble();
        taskB(size, minAvScore, list);
        System.out.println("Enter quantity of abitureints with the highest avarage scores:");
        int quantity = scan.nextInt();
         taskC(size,quantity,list);

    }
}