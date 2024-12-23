public class Main {
  public static void main(String[] args) {
    int number = 479598;
    int numberLength = String.valueOf(number).length();
    int sum = 0;

    for (int i = 0; i < numberLength; i++) {
      sum += number % 10;
      number /= 10;
    }

    System.out.println(sum);
  }
}