package J2011;

import java.util.Scanner;

public class p4_2011V2 {
    final static String ANSI_RESET = "\u001B[0m";
    final static String ANSI_RED = "\u001B[31m";
    static Scanner input = new Scanner(System.in);
    static boolean[][] map = new boolean[401][200];
    public static void main(String[] args) {
        // for x 0 = -200; 200 = 0; 400 = 200;
        int[] listx = {0,0,0,1,2,3,3,3,4,5,5,5,6,7,7,7,7,7,6,5,4,3,2,1,0,-1,-1,-1,};
        int[] listy = {1,2,3,3,3,3,4,5,5,5,4,3,3,3,4,5,6,7,7,7,7,7,7,7,7,7,6,5};
        for(int i = 0;i<listy.length;i++){
            int x = listx[i] + 200;
            int y = (listy[i] * -1) - 1;
            map[x][y*-1]=true;
        }
        verifyWell(-10,-1,10,-10);
        String d = input.next();
        int s = input.nextInt();
        int x = -1;
        int y = -5;
        while (!d.equals("q")){
            boolean notSafe = false;
            for(int i = 0;i<s;i++){
                if(d.equals("r")){
                    x++;
                }
                else if(d.equals("l")){
                    x--;
                }
                else if(d.equals("u")){
                    y++;
                }
                else
                    y--;
                if(map[x+200][-y+1]){
                    notSafe = true;
                }
                map[x+200][-y+1] = true;
            }
            if(notSafe){
                System.out.printf("%d, %d DANGER\n" , x,y);
                return;
            }
            else System.out.printf("%d, %d SAFE\n" , x,y);
            d = input.next();
            s = input.nextInt();
            verifyWell(-10,-1,10,-10);

        }

    }
    static void verifyWell(int xs, int ys, int xe, int ye){
        int x_start = xs+200; int x_end = x_start + xe - xs;
        int y_start = ys+1; int y_end = y_start - ye + 1;
        System.out.print(" ");
        for(int x = x_start; x < x_end; x++){
            System.out.printf(" %2d ",x-200);
        }
        System.out.println();
        for(int y=y_start; y < y_end; y++){
            System.out.printf("%d",y);
            for(int x = x_start; x < x_end; x++){
                if(map[x][y])
                    System.out.print(ANSI_RED + "  x " + ANSI_RESET);
                else
                    System.out.print("  o ");
            }
            System.out.println();
        }
    }
}