package J2018;

import java.util.Scanner;

public class p4_2018v2 {
    static Scanner input = new Scanner(System.in);
    static int n = input.nextInt();
    static int[][] grid = new int[n][n];
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for(int i =0; i < n; i++) {
            for(int j =0; j < n; j++) {
                grid[i][j] = input.nextInt();
            }
        }
        check();
        for(int i =0; i < n; i++) {
            for(int j =0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("Excution time in milli seconds "+ timeElapsed);
        System.out.println("Excution time in seconds "+ timeElapsed / 1000.0);
    }
    static void rotateGrid(){
        int[][] grid1 = new int[n][n];
        for(int i = 0; i < n ; i++) {
            for(int j = 0; j < n; j++) {
                grid1[i][n- 1 - j] = grid[j][i];
            }
        }
        grid = grid1;
    }
    static void check(){
        for(int i = 1; i < n; i++){
            if(grid[i][0] < grid[i - 1][0]){
                rotateGrid();
                check();
            }

        }
        for(int i = 0; i < n;i++){
            for(int j = 1;j<n;j++){
                if(grid[i][j] < grid[i][j-1]){
                    rotateGrid();
                    check();
                }
            }
        }

    }
}
