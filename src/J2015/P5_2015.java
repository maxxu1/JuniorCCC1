package J2015;

import java.util.Scanner;

public class P5_2015 {
    static Scanner input = new Scanner(System.in);
    static int possibleWays = 0;
    public static void main(String[] args) {
        int n = input.nextInt();
        int k = input.nextInt();
        int[]piecesOfPieForEveryone = new int[k];
        int[]nullIntList = new int[k];
        for(int i = n/k;i>0;i--){
            piecesOfPieForEveryone[0] = i;
            givingPies(n,k,piecesOfPieForEveryone,1,n-i,k-1);
            piecesOfPieForEveryone=nullIntList;
        }
        System.out.println(possibleWays);
    }

    static void givingPies(int n,int k,int[] pieList,int currentPerson,int cn,int ck){
        if(ck == 1){
            possibleWays++;
            return;
        }
        for(int i = cn/ck;i>0;i--){
            pieList[0] = i;
            givingPies(n,k,pieList,1,cn-i,ck-1);
        }
    }
}
