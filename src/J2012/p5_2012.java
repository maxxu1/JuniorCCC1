package J2012;

import java.util.*;

public class p5_2012 {

    static Scanner input = new Scanner(System.in);
    static int abc = 0;
    public static void main(String[] args) {
        ArrayList<int[][]> cases= new ArrayList<int[][]>();
        boolean end = false;
        while(!end){
            int nums = input.nextInt();
            if(nums==0)
                end=true;
            else{
                int[][] Case = new int[nums][nums];
                for(int i =0;i<nums;i++){
                    Case[i][0] = input.nextInt();
                }
                cases.add(Case);
            }
        }
        for(int i =0;i<cases.size();i++)
            startSolving(cases.get(i), cases.size());

    }

    public static void startSolving(int[][] cases,int num){
        int lowestStep = 0;
        int currentStep = 0;
        ArrayList<int [][]> anArrayListForCheckingWhetherThisListIsAlreadyShownOrNot = new ArrayList<>();
        //anArrayListForCheckingWhetherThisListIsAlreadyShownOrNot.add(cases);
        for(int i =0;i<num;i++) {
            getPossibleAnswer(cases, anArrayListForCheckingWhetherThisListIsAlreadyShownOrNot, lowestStep, currentStep);
            if(abc ==0)
                System.out.println("IMPOSSIBLE");
            else
                System.out.println(abc);
            abc=0;
        }
    }
    public static void getPossibleAnswer(int[][] cases,ArrayList<int[][]> aALFCWTLIASON,int lowestStep,int cS){
        int abcdefghijklmnopqrstuvwyz=0 ;
        for(int i =0;i<aALFCWTLIASON.size();i++){
            if(cases == aALFCWTLIASON.get(i)){
                return;
            }
        }
        for(int i = 0;i<cases.length-1;i++){
            if(cases[i][0]<=cases[i+1][0]){
                abcdefghijklmnopqrstuvwyz++;
            }
        }
        if(abcdefghijklmnopqrstuvwyz== (cases.length-1) && (cS<lowestStep || lowestStep==0) ){
            lowestStep = cS;
            abc=lowestStep;
            return;
        }
        for(int i =0;i< cases.length;i++){
            for(int  j=0;j< cases.length;j++){
                if(cases[i][j] != 0){
                    if(i==0){
                        if(cases[i+1][0]==0){
                            int [][] a = switchPosition(cases, new int[]{i, j},0,true);
                            getPossibleAnswer(a,aALFCWTLIASON,lowestStep,cS++);
                        }
                        for(int k = 1;k< cases.length;k++){
                            if(checkingIfItIsPossibleToMakeChangesToMyCodeThatIReallySpendLotsOfTimeOnItAndItIsReallyHardForMe(cases,new int[]{i, j},new int[]{i+1, k})){
                                int [][] a = switchPosition(cases, new int[]{i, j},k,true);
                                getPossibleAnswer(a,aALFCWTLIASON,lowestStep,cS++);
                            }
                        }
                    }
                    else if(i == cases.length-1){
                        if(cases[i-1][0]==0){
                            int [][] a = switchPosition(cases, new int[]{i, j},0,false);
                            getPossibleAnswer(a,aALFCWTLIASON,lowestStep,cS++);
                        }
                        for(int k = 1;k< cases.length;k++){
                            if(checkingIfItIsPossibleToMakeChangesToMyCodeThatIReallySpendLotsOfTimeOnItAndItIsReallyHardForMe(cases,new int[]{i, j},new int[]{i-1, k})){
                                int [][] a = switchPosition(cases, new int[]{i, j},k,false);
                                getPossibleAnswer(a,aALFCWTLIASON,lowestStep,cS++);
                            }
                        }
                    }
                    else{
                        if(cases[i+1][0]==0){
                            int [][] a = switchPosition(cases, new int[]{i, j},0,true);
                            getPossibleAnswer(a,aALFCWTLIASON,lowestStep,cS++);
                        }
                        for(int k = 1;k< cases.length;k++){
                            if(checkingIfItIsPossibleToMakeChangesToMyCodeThatIReallySpendLotsOfTimeOnItAndItIsReallyHardForMe(cases,new int[]{i, j},new int[]{i+1, k})){
                                int [][] a = switchPosition(cases, new int[]{i, j},k,true);
                                getPossibleAnswer(a,aALFCWTLIASON,lowestStep,cS++);
                            }
                        }
                        if(cases[i-1][0]==0){
                            int [][] a = switchPosition(cases, new int[]{i, j},0,false);
                            getPossibleAnswer(a,aALFCWTLIASON,lowestStep,cS++);
                        }
                        for(int k = 1;k< cases.length;k++){
                            if(checkingIfItIsPossibleToMakeChangesToMyCodeThatIReallySpendLotsOfTimeOnItAndItIsReallyHardForMe(cases,new int[]{i, j},new int[]{i-1, k})){
                                int [][] a = switchPosition(cases, new int[]{i, j},k,false);
                                getPossibleAnswer(a,aALFCWTLIASON,lowestStep,cS++);
                            }
                        }
                    }
                }
            }
        }
    }


    public static int[][] switchPosition(int[][] oA,int[] Position,int newPositiony,boolean direction){
        if(!direction) {
            oA[Position[0]-1][newPositiony] =  oA[Position[0]][Position[1]];
            oA[Position[0]][Position[1]] = 0;
        }
        else{
            oA[Position[0]+1][newPositiony] =  oA[Position[0]][Position[1]];
            oA[Position[0]][Position[1]] = 0;
        }
        return oA;
    }
    public static boolean checkingIfItIsPossibleToMakeChangesToMyCodeThatIReallySpendLotsOfTimeOnItAndItIsReallyHardForMe(int[][]cases,int[] position,int[]objectPosition){
        if(cases[position[0]][position[1]] < cases[objectPosition[0]][objectPosition[1]-1] && cases[objectPosition[0]][objectPosition[1]]==0){
            return true;
        }
        else
            return false;
    }
}