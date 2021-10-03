import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        //Quiz1(new int[]{1,2,7,8},4);
        Quiz2("RGRGRGRG");
    }
    static void Quiz1(int[] array,int target){
        boolean a = false;
        for(int i = 0;i<array.length-1;i++){
            for(int j =i+1;j<array.length;j++){
                if(array[i]+array[j] == target)
                    a=true;
            }
        }
        System.out.println(a);
    }
    static void Quiz2(String string){
        char[] a = string.toCharArray();
        int[] position = new int[2];
        int direction = 0;
        for(int i =0;i<a.length;i++){
            if(a[i]=='G'){
                if(direction==0) position[1]++;
                else if(direction==2) position[1]--;
                else if(direction==3) position[0]--;
                else position[0]++;
            }
            else if(a[i]=='L'){
                if(direction==0) direction=3;
                else direction--;
            }
            else{
                if(direction==3) direction=0;
                else direction++;
            }

        }
        System.out.println(Arrays.toString(position));
    }
}
