package J2013;

import java.util.Scanner;

public class P3_2013 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int startingYear = input.nextInt();
        boolean isDistinct = false;
        while (!isDistinct){
            startingYear++;
            String year;
            year = Integer.toString(startingYear);
            char[] yearChar = year.toCharArray();
            isDistinct=true;
            for( char y :yearChar){
                int a = 0;
                for(char Year:yearChar) {
                    if (Year==y) {
                        a++;
                    }
                }
                if(a>1)
                    isDistinct=false;

            }
        }
        System.out.println(startingYear);
    }
}
