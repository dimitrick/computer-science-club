import java.util.Scanner;

public class Challenge69 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        int requests = scan.nextInt();

        String binary = Integer.toBinaryString(input);
        if (binary.length() < 8) {
            binary = "0".repeat(8 - binary.length()) + binary;
        }
        String output = "";

        for (int i = 0; i <= requests; i++) {
            String request = scan.nextLine();
            if (request.contains("GRANT")) {
                int position = Integer.parseInt(request.split(" ")[1]);
                binary = binary.substring(0, binary.length() - position - 1) + '1' + binary.substring(binary.length() - position);
            } else if (request.contains("REVOKE")) {
                int position = Integer.parseInt(request.split(" ")[1]);
                binary = binary.substring(0, binary.length() - position - 1) + '0' + binary.substring(binary.length() - position);
            } else if (request.contains("CHECK")) {
                int position = Integer.parseInt(request.split(" ")[1]);
                if (binary.charAt(binary.length() - position - 1) == '1') {
                    output += "yes\n";
                } else {
                    output += "no\n";
                }
            }
        }
        output = output.substring(0, output.length() - 1);
        System.out.println(output);
        System.out.println(Integer.parseInt(binary, 2));

    }
}
