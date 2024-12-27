
import java.util.Scanner;

public class Program {

     
    public static void main(String[] args) {

        int number = 0;
        boolean isPrime = true;
        double squareRout = 0;
        int i = 0;
        Scanner Scanner = new Scanner(System.in);


        try{

            System.out.println("-> ");
            number = Scanner.nextInt();
            if (number <= 1){
                System.err.println("IllegalArgument");
                System.exit(-1);
            }

            squareRout = Math.sqrt(number);
            for ( i = 2; i <= Math.round(squareRout); i++){
                if (number % i == 0){
                    isPrime = false;
                    break;
                }
            }

            System.out.format(" %b  %d\n", isPrime, i - 1);
            Scanner.close();

        } catch(Exception ex) {
            System.err.println("Error");
            Scanner.close();
            System.exit(-1);
        }

    }
}