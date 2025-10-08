import java.util.ArrayList;
import java.util.Scanner;

public class Challenge56 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int classes = scan.nextInt();
        scan.nextLine();
        ArrayList<String> schedule = new ArrayList<String>();
        for (int i = 0; i < classes; i++) {
            schedule.add(scan.nextLine());
        }
        
        ArrayList<Integer> pds = new ArrayList<Integer>();
        ArrayList<String> clsses = new ArrayList<String>();
        //Splitting the list
        for (int i = 0; i < schedule.size(); i++) {
            String temp[] = schedule.get(i).split(" ", 2);
            pds.add(Integer.valueOf(temp[0]));
            clsses.add(temp[1]);
        }

        //Sorting
        for (int i = 0; i < classes - 1; i++) {
            for (int j = 0; j < classes - i - 1; j++) {
                if (pds.get(j) > pds.get(j + 1)) {
                    int temp = pds.get(j);
                    String temp2 = clsses.get(j);
                    pds.set(j, pds.get(j + 1));
                    clsses.set(j, clsses.get(j + 1));
                    pds.set(j + 1, temp);
                    clsses.set(j + 1, temp2);
                }
            }
        }
        

        //Output
        for (int i = 0; i < classes; i++) {
            System.out.println(pds.get(i) + " " + clsses.get(i));
        }
        scan.close();
    }
}