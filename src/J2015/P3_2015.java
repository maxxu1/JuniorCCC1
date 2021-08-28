package J2015;

import java.util.Scanner;

public class P3_2015 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        String alphabet ="abcdefghijklmnopqrstuvwxyz";
        String a = "abc";
        String e = "defg";
        String i = "hijkl";
        String o = "mnopqr";
        String u = "stuvwxyz";
        char[] alphabetChar = alphabet.toCharArray();
        String originalWord= input.next();
        char[] originalWordChar  = originalWord.toCharArray();
        char[] output = new char[originalWordChar.length*3];
        for(int I = 0;I< originalWordChar.length;I++){
            if(originalWordChar[I] =='a'||originalWordChar[I] =='e'||originalWordChar[I] =='i'||originalWordChar[I] =='o'||originalWordChar[I] =='u'){
                output[I*3]=originalWordChar[I];
                continue;
            }
            output[I*3] = originalWordChar[I];
            char thirdAlphabet = 0;
            if(originalWordChar[I] == 'z'){
                thirdAlphabet = 'z';
            }
            else {
                for (int j = 0; j < alphabetChar.length; j++) {
                    if (originalWordChar[I] == alphabetChar[j])
                        thirdAlphabet = alphabetChar[j + 1];
                        if(thirdAlphabet =='a'||thirdAlphabet =='e'||thirdAlphabet =='i'||thirdAlphabet =='o'||thirdAlphabet =='u')
                            thirdAlphabet = alphabetChar[j+2];

                }
            }
            output[I*3+2] = thirdAlphabet;
            String alphabet1 = String.valueOf(originalWordChar[I]);
            char secondAlphabet = 0;
            if (a.contains(alphabet1)) {
                secondAlphabet= 'a';
            }
            else if (e.contains(alphabet1)) {
                secondAlphabet= 'e';
            }
            else if (i.contains(alphabet1)) {
                secondAlphabet= 'i';
            }
            else if (o.contains(alphabet1)) {
                secondAlphabet= 'o';
            }
            else
                secondAlphabet='u';
            output[I*3+1]= secondAlphabet;

        }
        System.out.println(output);
    }

}
