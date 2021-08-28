package J2020;

import java.util.Arrays;
import java.util.Scanner;

public class P5_2020 {
    static Scanner input;
    static int m;
    static int n;
    static String[] a;
    static int currentNum;
    static int graph[][];
    public static void main(String[] args){
        input = new Scanner(System.in);;
        m = input.nextInt();
        n = input.nextInt();
        input.nextLine();
        graph = new int[m][n];
        for(int i = 0; i < m;i++){
            a = input.nextLine().split(" ");
            //System.out.println(Arrays.toString(a));
            for(int j = 0; j < n; j++){
                graph[i][j] = Integer.parseInt(a[j]);
            }
        }
       // PrintGrid();
        currentNum = m*n;
        if(NewCurrentNumber(currentNum)){
            System.out.println("yes");
        }
        else
            System.out.println("no");
    }
    static boolean NewCurrentNumber(int num){
        if(num == graph[0][0]){
            return true;
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j< n; j++){
                if(graph[i][j] == num) {
                    num = (i + 1) * (j + 1);
                    return NewCurrentNumber(num);
                }
            }
        }
        return false;

    }

    static void PrintGrid(){
        for(int i = 0; i < m; i++){
            for(int j = 0; j< n; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
