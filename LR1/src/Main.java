// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


        Scanner quantity = new Scanner(System.in);
        System.out.println("Enter quantity of Fibonachi numbers:");
        int N = quantity.nextInt();


        FibonachiNumb[] array = new FibonachiNumb[50];
        for (int i = 0; i < N; i++) {
            array[i] = new FibonachiNumb();
        }
        array[0].setNumber(1);
        array[0].setValue(1);
        array[1].setNumber(2);
        array[1].setValue(1);
          for(int i=2;i<N;i++) {
              array[i].setNumber(i+1);
              array[i].setValue(array[i-1].getValue()+array[i-2].getValue());
          }
        for(int i=0;i<N;i++) {
            System.out.println(array[i].getNumber()+".  "+array[i].getValue());
        }
        Scanner number = new Scanner(System.in);
        System.out.println("Enter number:");
        int k = number.nextInt();
        FibonachiNumb[] selectednums = new FibonachiNumb[50];
        for (int i = 0; i < N; i++) {
            selectednums[i] = new FibonachiNumb();
        }
        int j = 0;
        for(int i=0;i<N;i++) {
            long temp = (long) array[i].getValue() % 10;
            if (temp == k) {
                selectednums[j] = array[i];
                j++;

            }
        }
        for(int i=0;i<j;i++) {
            System.out.println(selectednums[i].getNumber()+".  "+selectednums[i].getValue());
        }


    }
}
