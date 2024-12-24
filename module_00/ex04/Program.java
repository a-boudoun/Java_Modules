
// import java.util.Scanner;



// public class Program {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         String input = scanner.nextLine();

//         if (input.length() == 0 || input.length() > 100) {
//             System.out.println("IllegalArgument");
//             System.exit(-1);
//         }

//         char[] charArray = input.toCharArray();
        
//     }
// }

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); // Read input until newline
        scanner.close();

        int[] frequencies = new int[65536]; // Array to store character frequencies

        // Step 1: Count character frequencies
        for (char c : input.toCharArray()) {
            frequencies[c]++;
        }

        // Step 2: Create an array to store characters and their frequencies
        CharFrequency[] charFrequencies = new CharFrequency[65536];
        int count = 0; // To count the valid characters
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > 0) {
                charFrequencies[count++] = new CharFrequency((char) i, frequencies[i]);
            }
        }

        // Step 3: Sort by frequency (descending) and lexicographic order if equal
        CharFrequency[] topChars = new CharFrequency[count];
        System.arraycopy(charFrequencies, 0, topChars, 0, count);

        java.util.Arrays.sort(topChars, 0, count, (a, b) -> {
            if (b.frequency != a.frequency) {
                return b.frequency - a.frequency; // Descending frequency
            }
            return Character.compare(a.character, b.character); // Lexicographic
        });

        // Step 4: Extract top 10 characters
        int topCount = Math.min(10, count);
        CharFrequency[] topTen = new CharFrequency[topCount];
        System.arraycopy(topChars, 0, topTen, 0, topCount);

        // Step 5: Determine maximum height of histogram
        int maxFrequency = topTen[0].frequency;
        int scaleFactor = Math.max(maxFrequency / 10, 1);

        // Step 6: Print the histogram
        for (int height = 10; height > 0; height--) {
            for (int i = 0; i < topCount; i++) {
                if (topTen[i].frequency / scaleFactor >= height) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        // Step 7: Print the characters at the bottom
        for (int i = 0; i < topCount; i++) {
            System.out.print(topTen[i].character + " ");
        }
        System.out.println();
    }

    // Helper class to store a character and its frequency
    static class CharFrequency {
        char character;
        int frequency;

        CharFrequency(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }
    }
}
