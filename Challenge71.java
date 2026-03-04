import java.util.Scanner;

public class Challenge71 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int inputSum = scan.nextInt();

        String[] inputWords = input.split(" ");
        int[] words = new int[inputWords.length];
        for (int i = 0; i < inputWords.length; i++) {
            words[i] = Integer.parseInt(inputWords[i]);
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i] + words[j] == inputSum) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }
}
