package J2016;

import java.util.Scanner;

    public class P4_2016 {
        static Scanner input = new Scanner(System.in);
        static String[] time= input.next().split(":");
        public static void main(String[] args) {
            int distance = 240;
            int hour = Integer.parseInt(time[0]);
            int min = Integer.parseInt(time[1]);
            int currentDistance = 0;
             while(currentDistance < distance){
                if((hour <7 || hour >= 10) && (hour < 15 || hour>=19)){
                    currentDistance +=2;
                }
                else
                    currentDistance +=1;
                min++;

            }

             hour += min/60;
             min %= 60;
             hour %= 24;

            System.out.printf("%02d:%02d\n",hour,min);


        }


}
