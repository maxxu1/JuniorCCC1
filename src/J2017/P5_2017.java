package J2017;

import java.util.*;

public class P5_2017 {
    static Scanner input = new Scanner(System.in);
    static int longestLength = 0;
    static ArrayList<Integer> differentHeight = new ArrayList<Integer>() ;
    public static void main(String[] args) {
        int n = input.nextInt();
        int[] boards = new int[2001];
        for (int i =0;i<n;i++)
            boards[input.nextInt()]++;
     /*   for(int i =0;i<n;i++){
            for(int j = i+1;j<n;j++){
                findBiggestLength(boards[i]+boards[j],boards,n);
            }
        }
        System.out.println(longestLength);
        findDifferentHeight(longestLength,boards,n);
        Collections.sort(differentHeight);
        for(int i =1;i<differentHeight.size();i++){
            if(differentHeight.get(i) == differentHeight.get(i-1)){
                differentHeight.remove(i);
            }
        }
        System.out.println(differentHeight.size());
*/
        int[] stackedBoards = new int[4001];
        int biggestLength = 0;
        for(int i =1;i<2001;i++){
            if(boards[i]==0)
                continue;
            for(int j = i;j<2001;j++){
                if(boards[j]==0)
                    continue;
                if(i==j){
                    stackedBoards[i+j] += boards[i]/2;
                }
                else
                    stackedBoards[i+j] += Math.min(boards[i],boards[j]);
                if(stackedBoards[i+j]>biggestLength)
                    biggestLength = stackedBoards[i+j];
            }
        }
        int differentHeight=0;
        for(int i = 0;i<4001;i++){
            if(stackedBoards[i] == biggestLength){
                differentHeight++;
            }
        }
        System.out.println(biggestLength + " " + differentHeight);
    }
    static void findBiggestLength(int height,int[] boards,int n){
        int length = 0;
        boolean[] alreadyUsed = new boolean[n];
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(alreadyUsed[i] == false && alreadyUsed[j] == false){
                    if(boards[i]+boards[j] == height){
                        length++;
                        alreadyUsed[i] = true;
                        alreadyUsed[j] = true;
                }

                }
            }
        }
        if(length>longestLength)
            longestLength = length;
    }
    static void findDifferentHeight(int length,int[] boards,int n){
        for(int i =0;i<n;i++){
            for(int j = i+1;j<n;j++){
                usingDifferentHeight(length,boards,n,boards[i]+boards[j]);
            }
        }
    }
    static void usingDifferentHeight(int length,int[] boards,int n,int height){
        int currentLength = 0;
        boolean[] alreadyUsed = new boolean[n];
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(alreadyUsed[i] == false && alreadyUsed[j] == false){
                    if(boards[i]+boards[j] == height){
                        currentLength++;
                        alreadyUsed[i] = true;
                        alreadyUsed[j] = true;
                    }

                }
            }
        }
        if(currentLength == length){
            differentHeight.add(height);
        }

    }

}
