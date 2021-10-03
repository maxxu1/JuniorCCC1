package J2013;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P5_2013 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int t = input.nextInt();
        int g = input.nextInt();
        int[][] game = new int[g][4];
        int[][] scoreboard = new int[4][5];
        for (int i = 0; i < g; i++) {
            game[i][0] = input.nextInt();
            game[i][1] = input.nextInt();
            game[i][2] = input.nextInt();
            game[i][3] = input.nextInt();
        }
        for (int i = 0; i < g; i++) {
            int a = game[i][0];
            int b = game[i][1];
            int sa = game[i][2];
            int sb = game[i][3];
            scoreboard[a - 1][b] = 1;
            scoreboard[a - 1][a] = 1;
            scoreboard[b - 1][b] = 1;
            scoreboard[b - 1][a] = 1;
            if (sa == sb) {
                scoreboard[b - 1][0]++;
                scoreboard[a - 1][0]++;
            } else if (sa > sb) {
                scoreboard[a - 1][0] += 3;
            } else
                scoreboard[b - 1][0] += 3;
        }
        for(int[] row:scoreboard){
            System.out.println(Arrays.toString(row));
        }
        ArrayList<int[]> futureGames = new ArrayList<>();
        for(int i = 0;i<4;i++){
            for(int j =1;j<5;j++){
                if(scoreboard[i][j]==0) {
                    int[] array = new int[2];
                    array[0]=i;
                    array[0]=j;
                    futureGames.add(array);
                    scoreboard[i][j] = 1;
                    scoreboard[j][i+1] = 1;
                }



            }
        }


    }
    static void gamesInFuture(int t,int g,int[][]scoreboard){
        for(int i = 0;i<6-g;i++){

        }
    }
}
