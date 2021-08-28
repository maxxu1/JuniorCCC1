package J2017;

import java.util.Arrays;
import java.util.Scanner;

public class P4_2017 {
    static Scanner input = new Scanner(System.in);
    static int min = input.nextInt();
    static int nums;
    public static void main(String[] args) {
        int[] clock = {1,2,0,0};
        findArithmeticSequence(clock);
        System.out.println(nums);

    }

    static void findArithmeticSequence(int[] clock){
        int hours = min / 60;
        for(int i = 0; i < hours; i++){
            for(int j =0;j<6;j++){
                for(int k =0;k<10;k++){
                    clock[2]=j;
                    clock[3]=k;
                    if(clock[0] == 1){
                        if (clock[1] - clock[0] == clock[2] - clock[1] && clock[2] - clock[1] == clock[3] - clock[2]) {
                            nums++;
                        }
                    }
                    else
                        if(clock[2] - clock[1] == clock[3] - clock[2]){
                            nums++;
                        }

                }
            }
            clock[1]++;
            clock[2] = 0;
            clock[3] = 0;
            if(clock[1] == 10){
                clock[0]=1;
                clock[1]=0;
            }
            if(clock[0] ==1 && clock[1] == 3){
                clock[0] = 0;
                clock[1] = 1;
            }
        }
        int remainMinuit = min%60;
            for(int j =0;j<6;j++){
                for(int k =0;k<10;k++){
                    if((j+1)*6+k+1 > remainMinuit){
                        return;
                    }
                    clock[2]=j;
                    clock[3]=k;
                    if(clock[1] - clock[0] == clock[2] - clock[1] && clock[2] - clock[1] == clock[3] - clock[2]){
                        nums++;
                    }
                }
            }

    }
}
