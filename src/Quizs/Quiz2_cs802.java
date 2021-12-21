package Quizs;

import java.util.*;

public class Quiz2_cs802 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
       /* int[] a = new int[]{5,4,3,2,1,2,3,4,5};
        int b =0;
        while(true){
            String c=input.next();
            int[] d= a.clone();
            if(c.equals("L")){
                for(int i = 0;i<9;i++){
                    if(i==0){
                        a[i]=d[8];
                    }
                    else
                        a[i]=d[i-1];
                }
            }
            if(c.equals("R")){
                for(int i = 0;i<9;i++){
                    if(i==8){
                        a[i]=d[0];
                    }
                    else
                        a[i]=d[i+1];
                }
            }
            System.out.println(Arrays.toString(a));
        }*/
        int[] a= new int[]{2,5,6,7,10,12};
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<Integer> c = new ArrayList<Integer>();
        for(int i=0;i<6;i++){
            if(a[i]%2==0)
                b.add(a[i]);
            else
                c.add(a[i]);
        }
        int[] d=new int[6];
        for(int i =0;i<b.size();i++)
            d[i]=b.get(i);
        for(int i =0;i<c.size();i++)
            d[i+b.size()]=c.get(i);
        System.out.println(Arrays.toString(d));
    }
}