package J2014;

import java.util.Scanner;

public class P5_2014 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int n = input.nextInt();
        String[] names = new String[n];
        String[][] partners = new String[2][n];
        boolean isConsistent = true;
        for(int i = 0; i < n; i++) {
            partners[0][i] = input.next();
        }
        for(int i = 0;i < n;i++){
            partners[1][i] = input.next();
        }
        names = partners[0];
        for(int i = 0;i<n;i++){
            String p1 = partners[0][i];
            String p2 = partners[1][i];
            for(int j = 1;j<n;j++){
                if(partners[0][j].equals(p1)&&! partners[1][j].equals(p2)){
                    isConsistent=false;
                }
            }
            if(p1.equals(p2))
                isConsistent=false;
        }
        if(isConsistent)
            System.out.println("good");
        else
            System.out.println("bad");

    }
}
