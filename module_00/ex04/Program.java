import java.util.Scanner;

class Program {

    private static final int MAX_BPM = 65536;


    private static void display(char[] topChars, int[] topCounts, double histogramScale) {
        for (int i = 11; i > 0; i--) {
            for (int j = 0; j < 10; j++) {
                if (topCounts[j] == 0) {
                    continue;
                }
                if ((int) (topCounts[j] / histogramScale) + 1 == i) {
                    System.out.print(topCounts[j] + "  ");
                } else if ((int) (topCounts[j] / histogramScale) >= i) {
                    System.out.print("#  ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }


        for (int i = 0; i < 10; i++) {
            if (topChars[i] == 0) {
                continue;
            }
            System.out.print(topChars[i] + "  ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] counts = new int[MAX_BPM];
        int maxCount = 0;
        char[] topChars = new char[10];
        int[] topCounts = new int[10];
        double histogramScale = 1;


        String line = scanner.nextLine();
        scanner.close();

        char[] charArray = line.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            counts[charArray[i]]++;
            if (counts[charArray[i]] > maxCount) {
                maxCount = counts[charArray[i]];
            }
        }

        for (int i = 0; i < 10; i++) {
            int max = 0;
            int maxIndex = 0;
            for (int j = 0; j < MAX_BPM; j++) {
                if (counts[j] > max) {
                    max = counts[j];
                    maxIndex = j;
                }
            }
            topChars[i] = (char) maxIndex;
            topCounts[i] = max;
            counts[maxIndex] = -1;
        }


        if (maxCount > 10) {
            histogramScale = (double) maxCount / 10.0;
        }

        display(topChars, topCounts, histogramScale);       
    }
}