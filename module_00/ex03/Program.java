
import java.util.Scanner;

public class Program {
    private static final String STOP = "42";


    static void display(int grade, int week) {
        System.out.format("Week %d ", week);
        while (grade > 0) {
            System.out.print("=");
            grade--;
        }
        System.out.println(">");
    }

    static int reverse(int number) {
        int reverse = 0;
        while (number > 0) {
            reverse = (reverse * 10) + (number % 10);
            number /= 10;
        }
        return reverse;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int storage = 0;
        int weekCount = 1;

        try{
            for (; weekCount <= 18; weekCount++){
                System.out.print("-> ");
                String week = scanner.nextLine();
                if (week.equals(STOP)){
                    break;
                }
                if (!week.equals("Week " + (weekCount))){
                    System.out.println("IllegalArgument");
                    System.exit(-1);
                }
                int min = 9;
                System.out.print("-> ");
                for (int j = 0; j < 5; j++){
                    int grade = scanner.nextInt();
                    if (grade < 1 || grade > 9){
                        System.out.println("IllegalArgument");
                        System.exit(-1);
                    }
                    min = grade < min ? grade : min;
                }
                storage = storage * 10 + min;

                scanner.nextLine();
            }
            scanner.close();

            
            storage = reverse(storage);

            for (int i = 1; i <= weekCount ; i++){
                display(storage % 10, i);
                storage /= 10;
            }

        } catch( Exception e){
            System.out.println("Error");
            System.exit(-1);
        }
    }
}


