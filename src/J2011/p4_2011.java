package J2011;

import java.util.*;

public class p4_2011 {

    static Scanner input = new Scanner(System.in);
    static int[] currentPositionInMap = {-1,-5};
    static boolean[][] map = new boolean[401][200];
    public static void main(String[] args) {
        // for x 0 = -200; 200 = 0; 400 = 200;
        int[] listx = {0,0,0,1,2,3,3,3,4,5,5,5,6,7,7,7,7,7,6,5,4,3,2,1,0,-1,-1,-1,};
        int[] listy = {1,2,3,3,3,3,4,5,5,5,4,3,3,3,4,5,6,7,7,7,7,7,7,7,7,7,6,5};
        for(int i = 0;i<listy.length;i++){
            int x = listx[i] + 200;
            int y = (listy[i] * -1) - 1;
            map[x][y*-1]=true;
        }verifyWell(-3,-1,10,-8);
        while(true){
            String a = input.next();
            int b = input.nextInt();
            if(a.equals("l")){
                currentPositionInMap[0] -= b;
                if(doTheMove(0, b, map)){
                    System.out.println(currentPositionInMap[0] + " " + currentPositionInMap[1] + "SAFE");
                    currentPositionInMap[0] = currentPositionInMap[0] - b;
                }
                else{
                    System.out.println(currentPositionInMap[0] + " " + currentPositionInMap[1] + "DANGER");
                   // System.exit(0);
                }

            }
            if(a.equals("d")){
                currentPositionInMap[1] -= b;
                if(doTheMove(3, b, map)){
                    System.out.println(currentPositionInMap[0] + " " + currentPositionInMap[1] + "SAFE");
                    currentPositionInMap[1] = currentPositionInMap[1] - b;
                }
                else{
                    System.out.println(currentPositionInMap[0] + " " + currentPositionInMap[1] + "DANGER");
                   // System.exit(0);
                }

            }
            if(a.equals("r")){
                currentPositionInMap[0] += b;
                if(doTheMove(1, b, map)){
                    System.out.println(currentPositionInMap[0] + " " + currentPositionInMap[1] + "SAFE");
                    currentPositionInMap[0] = currentPositionInMap[0] + b;
                }
                else{
                    System.out.println(currentPositionInMap[0] + " " + currentPositionInMap[1] + "DANGER");

                    //System.exit(0);
                }

            }
            if(a.equals("u")){
                currentPositionInMap[1] += b;
                if(doTheMove(2, b, map)){
                    System.out.println(currentPositionInMap[0] + " " + currentPositionInMap[1] + "SAFE");
                    currentPositionInMap[1] = currentPositionInMap[1] + b;
                }
                else{
                    System.out.println(currentPositionInMap[0] + " " + currentPositionInMap[1] + "DANGER");
                   // System.exit(0);
                }

            }
          //  System.out.printf("d = %s,s=%d\n",a,b);
            verifyWell(-10,-1,10,-10);
            if(a.equals("q")){
                System.exit(0);
            }
        }
    }
    //0=left,1=right,2=up,3=down
    static boolean doTheMove(int direction,int value, boolean[][] map){
        int x = currentPositionInMap[0] + 200+2;
        int y = -currentPositionInMap[1] +1;
        boolean isInDangerousForThisDrillingMachine = false;
        if(direction==0){
            for(int i =value;i>0; i--){
                if (map[x-i][y] ){
                    isInDangerousForThisDrillingMachine = true;
                }
                map[x-i][y] = true;

            }
        }
        if(direction==1){
            for(int i =0;i<value; i++){
                if (map[x+i][y] ){
                    isInDangerousForThisDrillingMachine = true;
                }
                map[x+i][y] = true;

            }
        }
        if(direction==2){
            for(int i =0;i<value; i++){
                if (map[x][y+i] ){
                    isInDangerousForThisDrillingMachine = true;
                }
                map[x][y+i] = true;

            }
        }
        if(direction==3){
            for(int i =value;i>0; i--){
                if (map[x][y-i] ){
                    isInDangerousForThisDrillingMachine = true;
                }
                map[x][y-i] = true;

            }
        }


        if(!isInDangerousForThisDrillingMachine)
            return true;
        return false;
    }

    final static String ANSI_RESET = "\u001B[0m";
    final static String ANSI_RED = "\u001B[31m";


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