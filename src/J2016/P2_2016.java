package J2016;

import java.util.Scanner;

public class P2_2016 {
    static Scanner input = new Scanner(System.in);
    static int[][] squares = new int[4][4];
    public static void main(String[] args) {
        for(int i = 0; i<4 ;i++){
            for(int j =0; j<4;j++){
                squares[i][j] = input.nextInt();
            }
        }
        if(isMagic()){
            System.out.println("magic");
        }
        else
            System.out.println("not magic");

    }
    static boolean isMagic() {
        int sum = squares[0][0] + squares[0][1] + squares[0][2] + squares[0][3];
        for(int i = 0; i<4 ;i++){
            int sum1 = squares[i][0] + squares[i][1] + squares[i][2] + squares[i][3];
            if(sum1 != sum){
                return false;
            }
        }
        sum= squares[0][0] + squares[1][0] + squares[2][0] + squares[3][0];
        for(int i = 0; i<4 ;i++){
            int sum1 = squares[0][i] + squares[1][i] + squares[2][i] + squares[3][i];
            if(sum1 != sum){
                return false;
            }
        }
        return true;
    }
}
