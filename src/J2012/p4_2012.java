package J2012;
import java.util .*;
public class p4_2012 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int k = input.nextInt();
        String word = input.next();
        char[] alphabet = new char[26];
        for(int i =0;i<26;i++){
            alphabet[i] = (char)(65+i);
        }
        char[] wordChar = word.toCharArray();
        char[] output = new char[wordChar.length];
        for(int i =0;i<word.length();i++)
            output[i] = alphabet[(findNumberOfLetterInAlphabetChartThatIsDesignedForPeopleWhoDoNotUseEnglishAsFirstLanguage(wordChar[i], alphabet) - 3 * (i + 1) - k + 26 )% 26];
        System.out.println(output);
    }
    public static int findNumberOfLetterInAlphabetChartThatIsDesignedForPeopleWhoDoNotUseEnglishAsFirstLanguage(char alphabet,char[]aC){
        for(int i=0;i<26;i++){
            if(alphabet==aC[i]){
                return i;
            }
        }
        return 4;
    }
}