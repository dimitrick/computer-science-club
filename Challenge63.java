import java.util.Scanner;

public class Challenge63 {

    static String checker(String input) {
        boolean colons = false;
        boolean periods = false;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ':') {
                colons = true;
            }
            if (input.charAt(i) == '.') {
                periods = true;
            }
        }

        //IPv4
        if (periods && !colons) {
            String[] numbers = input.split("\\.", -1);
            
            if (numbers.length != 4) {
                return "Neither";
            }
            
            //iterate through sections split by periods
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i].isEmpty()) {
                    return "Neither";
                }
                
                //iterate through characters
                for (int j = 0; j < numbers[i].length(); j++) {
                    if (!Character.isDigit(numbers[i].charAt(j))) {
                        return "Neither";
                    }
                }

                if (numbers[i].length() > 1 && numbers[i].charAt(0) == '0') {
                    return "Neither";
                }
                
                if (Integer.parseInt(numbers[i]) > 255 || Integer.parseInt(numbers[i]) < 0) {
                    return "Neither";
                }
            }
            return "IPv4";
        }

        //IPv6
        if (!periods && colons) {
            String[] hexnums = input.split(":", -1);

            if (hexnums.length != 8) {
                return "Neither";
            }

            //iterate through sections split by colons
            for (int i = 0; i < hexnums.length; i++) {
                if (hexnums[i].isEmpty() || hexnums[i].length() > 4) {
                    return "Neither";
                }
                //iterate through characters
                for (int j = 0; j < hexnums[i].length(); j++) {
                    if (!Character.isDigit(hexnums[i].charAt(j))) {
                        if (!((hexnums[i].charAt(j) >= 'a' && hexnums[i].charAt(j) <= 'f') || (hexnums[i].charAt(j) >= 'A' && hexnums[i].charAt(j) <= 'F'))) {
                            return "Neither";
                        }
                    }

                }
            }
            return "IPv6";
        }

        return "Neither";
    }

    public static void main (String[]args){
            Scanner scan = new Scanner(System.in);

            String input = scan.nextLine();
            System.out.println(checker(input));
    }
}
