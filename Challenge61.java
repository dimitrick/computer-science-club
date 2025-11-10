import java.util.Scanner;

public class Challenge61 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        char starter = input.charAt(0);
        String idk = input.substring(2);
        boolean hi = false;

        for (int i = 1; i < idk.length(); i++) {
            if (idk.charAt(i-1) > idk.charAt(i)) {
                hi = true;
                break;
            }
        }
        
        if (hi) {
            System.out.println(1);
        } else {
            System.out.println(starter - idk.charAt(idk.length() - 1));
        }
    }
}