package J2020;

import java.util.Arrays;
import java.util.Scanner;

public class P3_2020 {
    static Scanner input;
    public static void main(String[] args){
        input = new Scanner(System.in);
        int N = input.nextInt();
        int[] X = new int[N];
        int[] Y = new int[N];
        String[] a;
        for(int i = 0; i < N;i++){
            a = input.next().split(",");
            X[i] = Integer.parseInt(a[0]);
            Y[i] = Integer.parseInt(a[1]);
        }
        int XBiggest = X[0];
        int YBiggest = Y[0];
        int XSmallest = X[0];
        int YSmallest = Y[0];
        for(int i = 0; i < N;i++){
            if(X[i] > XBiggest)
                XBiggest = X[i];
            else if(X[i] < XSmallest)
                XSmallest = X[i];
            if(Y[i] > YBiggest)
                YBiggest = Y[i];
            else if(Y[i] < YSmallest)
                YSmallest = Y[i];

        }
        System.out.println(--XSmallest + "," + --YSmallest);
        System.out.println(++XBiggest + "," + ++YBiggest);

    }


}
