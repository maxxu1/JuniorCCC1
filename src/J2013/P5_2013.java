package J2013;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P5_2013 {
    static Scanner input = new Scanner(System.in);
    static int wining=0;
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
        ArrayList<int[]> futureGames = new ArrayList<>();
        for(int i = 0;i<3;i++){
            for(int j =1;j<4;j++){
                if(scoreboard[i][j+1]==0) {
                    int[] array = new int[2];
                    array[0]=i;
                    array[1]=j;
                    futureGames.add(array);
                    scoreboard[i][j] = 1;
                    scoreboard[j][i+1] = 1;
                }



            }
        }
        gamesInFuture(t,futureGames,scoreboard);
        System.out.println(wining);
    }
    static void gamesInFuture(int t,ArrayList<int[]> futureGames,int[][]scoreboard){
        if(futureGames.isEmpty()){
            int biggestnum=0;
            int bestteam=0;
            for(int i =0;i<4;i++){
                if(scoreboard[i][0]>biggestnum){
                    biggestnum=scoreboard[i][0];
                    bestteam=i;
                }
            }
            if(bestteam==t-1)
                wining++;
            return;
        }

        int[][] scoreboard1 = new int[4][5];
        scoreboard1=deepcopy(scoreboard);
        int[] thisGame= futureGames.get(0);
        futureGames.remove(0);
        int team1=thisGame[0];
        int team2=thisGame[1];
        ArrayList<int[]> fg = new ArrayList<>();
        fg = (ArrayList<int[]>) futureGames.clone();
        scoreboard[team1][0]+=3;
        gamesInFuture(t,futureGames,scoreboard);
        scoreboard=deepcopy(scoreboard1);
        futureGames= (ArrayList<int[]>) fg.clone();
        scoreboard[team2][0]+=3;
        gamesInFuture(t,futureGames,scoreboard);
        futureGames= (ArrayList<int[]>) fg.clone();
        scoreboard=deepcopy(scoreboard1);
        scoreboard[team1][0]++;
        scoreboard[team2][0]++;
        gamesInFuture(t,futureGames,scoreboard);
    }

    static int[][] deepcopy(int[][] a){
        int[][]b=new int[4][5];
        for(int i =0;i<4;i++){
            for(int j =0;j<5;j++)
                b[i][j]=a[i][j];
        }
        return b;
    }

}
