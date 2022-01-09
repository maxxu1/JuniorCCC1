package J2010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p4_2010 {

    static Scanner input = new Scanner(System.in);
    static int shortestOutput=0;

    public static void main(String[] args) {
        String testCases;

        while (true){
            shortestOutput = 0;
            int n = input.nextInt();
            if(n == 0){
                System.exit(0);
            }
            int[] intarray = new int[n];
            for(int i =0;i<n;i++){
                intarray[i]=input.nextInt();
            }
            System.out.println(Arrays.toString(intarray));
            int[] differenceArray = createArrayOfDifference(intarray,n);

            findMinCycle(differenceArray);

        }


    }

    public static void findMinCycle(int[] differenceArray){
        System.out.println(Arrays.toString(differenceArray));
        ArrayList<Integer> cycle=new ArrayList<>();
        for(int i =0;i< differenceArray.length-1;i++){
            cycle.add(differenceArray[i]);
            if(cycle.contains(differenceArray[i+1])){
                System.out.println(cycle.size());
                return;
            }

        }
        System.out.println(differenceArray.length);
    }

    public static int[] createArrayOfDifference(int[] originArray, int n){
        int[] newArray = new int[n-1];
        for(int i=0;i<n-1;n++){
            newArray[i] = originArray[i+1]-originArray[i];
        }
        return newArray;
    }

}
