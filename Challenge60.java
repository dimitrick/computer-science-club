import java.util.ArrayList;
import java.util.Scanner;

public class Challenge60 {
    
    public static ArrayList<Integer> prefSum(int[] arr) {
        int n = arr.length;

        // to store the prefix sum
        ArrayList<Integer> prefixSum = new ArrayList<>();

        // initialize the first element
        prefixSum.add(arr[0]);

        // Adding present element with previous element
        for (int i = 1; i < n; i++)
            prefixSum.add(prefixSum.get(i - 1) + arr[i]);

        return prefixSum;
    }
    
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        String input1 = scan.nextLine();
        int n = Integer.valueOf(input1.substring(0,1));
        int k = Integer.valueOf(input1.substring(2));
        String input2 = scan.nextLine();
        String[] splitinputs = input2.split(" ");
        int[] chests = new int[n];

        for (int i = 0; i < splitinputs.length; i++) {
            chests[i] = Integer.parseInt(splitinputs[i]);
        }

        ArrayList<Integer> prefixsum = prefSum(chests);
        prefixsum.add(0,0);
        
        int maxGold;
        maxGold = Integer.MIN_VALUE;
            for (int i = 0; i < prefixsum.size() - k; i++) {
                int gold = prefixsum.get(i + k) - prefixsum.get(i);
                if (gold > maxGold) {
                    maxGold = gold;
                }
            }   
        System.out.println(maxGold);
    }
}
