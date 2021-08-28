package J2017;

import java.util.Scanner;

public class P3_2017 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int[] startPoint = new int[2];
        int[] destination = new int[2];
        startPoint[0] = input.nextInt();
        startPoint[1] = input.nextInt();
        destination[0] = input.nextInt();
        destination[1] = input.nextInt();
        int eletricCharges = input.nextInt();
        int distance =Math.abs(destination[0] - startPoint[0] ) + Math.abs(destination[1] - startPoint[1]);
        if(distance > eletricCharges){
            System.out.println("N");
        }
        else
            check(distance,eletricCharges);

    }
    static void check(int a,int b){
        if(a%2== b%2){
            System.out.println("Y");
        }
        else
            System.out.println("N");
    }
}
