package J2013;

import java.util.ArrayList;
import java.util.Scanner;

public class P4_2013 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int t = input.nextInt();
        int[] c = new int[101];
        int a =0;
        int d= input.nextInt();
        for(int i =0;i<d;i++){
            int choresTime = input.nextInt();
            c[choresTime]=choresTime;
        }
        a=0;
        int b = 0;
        for(int i =0;i<100;i++){
            if(c[i] >0){
                for(int j=0;j<c[i];j++){
                    a+=i;
                    b++;
                   // System.out.println(a+""+b);
                    if(a==t){
                        System.out.println(b);
                        System.exit(1);
                    }
                    if(a>t){
                        System.out.println(--b);
                        System.exit(2);
                    }
                }
            }
        }
    }
}
