import java.util.Scanner;

public class Challenge68 {

    static int ha(String input) {
        int maxHas = 0;
        int currentHas = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.substring(i, i + 2).equals("ha")) {
                currentHas++;
                if (currentHas > maxHas) {
                    maxHas = currentHas;
                }
                i++;
            } else {
                currentHas = 0;
            }
        }
        return maxHas;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        System.out.println(ha(input));
    }
}
