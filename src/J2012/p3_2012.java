package J2012;

import java.util.Scanner;

public class p3_2012 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        //0=*;1=x;2= ;
        char[][] areaCode = new char[3][3];
        areaCode = new char[][]{{'*','x','*'},{' ','x','x'},{'*',' ','*'}};
        int k = input.nextInt();
        char[][] outputGrid=new char[3*k][3*k];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int x =i*k;
                int y = j*k;
                for(int a = 0;a<k;a++) {
                    for (int b = 0; b < k; b++)
                        outputGrid[x + a][y + b] = areaCode[i][j];
                }
            }
        }
        for (int i =0;i< outputGrid.length;i++){
            for(int j = 0;j< outputGrid.length;j++) {
                System.out.print(outputGrid[i][j]);

            }
            System.out.println();
        }

    }
}
