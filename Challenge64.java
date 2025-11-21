import java.util.Scanner;
import java.util.ArrayList;

public class Challenge64 {

    public static boolean canJump(ArrayList<Integer> nums) {

        if (nums.size() == 1) {
            return true;
        }
        for (int i = 0; i < nums.size(); i++) {
            //if current number is 0
            if (nums.get(i) == 0) {
                //if it is the first number return false
                if (i == 0) {
                    return false;
                }
                //if it is the last number return true
                if (i == nums.size() - 1) {
                    return true;
                }
                int needed = 2; // minimum the number before 0 can be to skip
                boolean canSkip = false;
                //j starts at the number before zero and iterates backwards through the list
                for (int j = i - 1; j >= 0; j--) {
                    //if the number at j is greater than or equal to needed then zero can be skipped
                    if (nums.get(j) >= needed) {
                        canSkip = true;
                        break;
                    }
                    needed++;
                }
                //if canSkip doesn't become true, there is a zero that can't be skipped
                if (!canSkip) {
                    return false;
                }
            }
        }
        //no zeros or all zeros can be skipped
        return true;
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] strings = input.split(" ");
        ArrayList<Integer> nums = new ArrayList<Integer>();
        boolean endReachable = false;

        for (String string : strings) {
            nums.add(Integer.parseInt(string));
        }
        System.out.println(canJump(nums));
    }
}
