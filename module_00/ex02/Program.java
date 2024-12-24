import java.util.Scanner;

public class Program {

    private static final int STOP = 42;


    public static int calcSumDigits(int number){
        
        int sum = 0;

        while (number != 0){
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

    public static boolean isPrime(int number){

        boolean isPrime = true;
        double squareRout = 0;
        int i = 0;

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
        return isPrime;
    }


    public static void main(String[] args){

        int number = 0;
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        
        try{
            while(number != STOP){
                System.out.print("-> ");
                number = scanner.nextInt();
                if (isPrime(calcSumDigits(number))){
                    count++;
                }
                scanner.nextLine();
            }

            System.out.format(" %s %d", "Count of coffee-request : ", count);
            scanner.close();

        } catch(Exception ex) {
            System.err.println("Error");
            scanner.close();
            System.exit(-1);
        }

    }
}