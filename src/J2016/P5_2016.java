package J2016;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class P5_2016 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int question = input.nextInt();
        int n = input.nextInt();
        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];
        for(int i = 0;i<n;i++)
            a[i] = input.nextInt();
        for(int i = 0;i<n;i++)
            b[i] = input.nextInt();

        Arrays.sort(a, Collections.reverseOrder());
        Arrays.sort(b,Collections.reverseOrder());
        if(question == 1)
            question1(n, a, b);
        else
            question2(n,a,b);
    }

    static void question1(int n1,Integer[] a1,Integer[] b1){
        int sum = 0;
        for(int i = 0;i <n1;i++){
            sum += Math.max(a1[i],b1[i]);
        }
        System.out.println(sum);
    }
    static void question2(int n2,Integer[] a2,Integer[] b2){
        int sum = 0;
        int a = 0;
        int b = 0;
        for(int i = 0; i<n2;i++){
            if(a2[a] > b2[b])
                sum+=  a2[a++];
            else
                sum+=  b2[b++];
        }
        System.out.println(sum);
    }


}
