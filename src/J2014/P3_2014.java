package J2014;

import java.util.Scanner;

public class P3_2014 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int a = 100;
        int d = 100;
        int n = input.nextInt();
        for(int i = 0;i<n;i++){
            int aDice = input.nextInt();
            int dDice = input.nextInt();
            if(aDice>dDice){
                d -=aDice;
            }
            else if(aDice < dDice){
                a -= dDice;
            }
        }
        System.out.println(a);
        System.out.println(d);
    }
}
