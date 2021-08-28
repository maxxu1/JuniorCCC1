package J2018;

import java.util.Scanner;

public class P3_2018 {
    static Scanner input;
    static int[] nums =new int[5];
    public static void main(String[] args){
        input = new Scanner(System.in);
        nums[0] = 0;
        for(int i = 1; i< nums.length; i++){
            nums[i] = input.nextInt() + nums[i-1];
        }
        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
        for(int i =0; i< nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        for(int i = 0; i< nums.length; i++){
            if(nums[i] > nums[1])
                System.out.print(nums[i] - nums[1] + " ");
            else
                System.out.print(nums[1] - nums[i] + " ");
        }
        System.out.println();
        for(int i = 0; i< nums.length; i++){
            if(nums[i] > nums[2])
                System.out.print(nums[i] - nums[2] + " ");
            else
                System.out.print(nums[2] - nums[i] + " ");
        }

        System.out.println();
        for(int i = 0; i< nums.length - 1; i++){
            System.out.print(nums[3] - nums[i] + " ");
        }
        System.out.print(nums[4] - nums[3] + " ");
        System.out.println();
        for(int i = 0; i< nums.length; i++){
            System.out.print(nums[4] - nums[i] + " ");
        }


    }
}
