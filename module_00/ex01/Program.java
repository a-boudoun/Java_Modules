
import java.util.Scanner;

public class Program {

     
    public static void main(String[] args) {

        int number = 0;
        int iterations = 0;
        boolean isPrime = true;
        double squareRout = 0;
        int i = 0;


        try{
            Scanner Scanner = new Scanner(System.in);

            System.out.print("-> ");
            number = Scanner.nextInt();
            if (number <= 1){
                System.out.println("IllegalArgument");
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

        } catch(Exception ex) {
            System.err.println("Error");
        }

    }
}