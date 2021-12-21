package J2010;

import java.util.*;

public class p3_2010 {

    static Scanner input = new Scanner(System.in);
    static int a;
    static int b;
    public static void main(String[] args) {
        int A = 0;
        int B = 0;
        while (true)
           myFunction1();


    }

    public static void myFunction1(){
            int a1 = 0;
            String b1 = null, c1 = null;
            String program = input.nextLine();
            if (program.equals("7")) {
                System.exit(0);
            }

            String[] programButIsSplit = program.split(" ");
            if (programButIsSplit[0].equals("2")) {
                if (programButIsSplit[1].equals("A"))
                    System.out.println(a);
                else
                    System.out.println(b);
                return;
            } else if (Integer.parseInt(programButIsSplit[0]) == 1) {
                if (programButIsSplit[1].equals("A"))
                    a = Integer.parseInt(programButIsSplit[2]);
                else
                    b = Integer.parseInt(programButIsSplit[2]);
                return;
            } else {
                a1 = Integer.parseInt(programButIsSplit[0]);
                b1 = programButIsSplit[1];
                c1 = programButIsSplit[2];
            }
            if (a1 == 3) {
                if (b1.equals("A")) {
                    if (c1.equals("A"))
                        a = a + a;
                    else
                        a = a + b;
                } else {
                    if (c1.equals("A"))
                        b = b + a;
                    else
                        b = b + b;
                }
            }
            if (a1 == 4) {
                if (b1.equals("B")) {
                    if (c1.equals("A"))
                        a = a * a;
                    else
                        a = a * b;
                } else {
                    if (c1.equals("A"))
                        b = b * a;
                    else
                        b = b * b;
                }
            }
            if (a1 == 5) {
                if (b1.equals("A")) {
                    if (c1.equals("A"))
                        a = a - a;
                    else
                        a = a - b;
                } else {
                    if (c1.equals("A"))
                        b = b - a;
                    else
                        b = b - b;
                }
            }
            if (a1 == 6) {
                if (b1.equals("A")) {
                    if (c1.equals("A"))
                        a = a / a;
                    else
                        a = a / b;
                } else {
                    if (c1.equals("A"))
                        b = b / a;
                    else
                        b = b / b;
                }
            }
    }
}