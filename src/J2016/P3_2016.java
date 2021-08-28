package J2016;

import java.util.Scanner;

public class P3_2016 {
    static Scanner input = new Scanner(System.in);
    static String word = input.next();
    public static void main(String[] args) {
        char[] wordArray = word.toCharArray();
        checking(wordArray);
    }
    static boolean isPalindrome(char[] words){
        for(int i = 0; i < words.length/2; i++){
            if(words[i] != words[words.length-i - 1]){
                return false;
            }
        }
        return true;
    }
    static void checking(char[] wordsArray){
        int output = 1;
        for(int i = wordsArray.length ; i > 0; i--){
            for(int j = 0; j < i; j++){
                char[] checkPalindrome = new char[ i-j];
                int l = 0;
                for(int k = j; k < i;k++){
                    checkPalindrome[l] = wordsArray[k];
                    l++;
                }
                //System.out.println(new String(checkPalindrome) + (i-j));
               // System.out.println(i-j);
                if(isPalindrome(checkPalindrome)){
                    int currentOutput = i - j;
                    //System.out.println(currentOutput);
                    //System.out.println(i - j);
                    if(currentOutput > output){
                        output = currentOutput;
                    }
                }
            }
        }
        System.out.println(output);
    }
}
