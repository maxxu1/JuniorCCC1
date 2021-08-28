package J2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P5_2019 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[] rule1 = input.nextLine().split(" ");
        String[] rule2 = input.nextLine().split(" ");
        String[] rule3 = input.nextLine().split(" ");
        String[][] rules = {rule1, rule2, rule3};
        int step = input.nextInt();
        String initialSequence = input.next();
        String finalSequence = input.next();
        String[] solution = new String[step];
        solve(rules,initialSequence,finalSequence,step,0,solution);

    }

    static ArrayList<String> getSubs(String[][] rules, String currentSequence) {
        ArrayList<String> subs = new ArrayList<>();

        for (int i = 0; i < rules.length; i++) {
            String rule = rules[i][0];
            String sub = rules[i][1];
            int rl = rule.length();
            for (int j = 0; j < currentSequence.length()-rl+1; j++) {
                if(currentSequence.contains(rule)){
                    String a = currentSequence.substring(j, j+rl);
                    if(a.equals(rule)){
                        String newSequence = currentSequence;
                        String pre = currentSequence.substring(0, j);
                        String post = currentSequence.substring(j + rl);
                        newSequence = pre + sub + post;
                        subs.add((i+1) +" " + (j+1) + " " +newSequence);
                        //System.out.println(newSequence);
                    }

                }

            }

        }
        return subs;


    }
    static void solve(String[][] rules, String currentSequence,String endSequence,int stepTotal,int stepsTaken,String[] solution){
        if(stepsTaken == stepTotal){
            if(currentSequence.equals(endSequence)){
                for(String s:solution){
                    System.out.println(s);
                }//print solution
                System.exit(0);
            }//if sequences match
            else
                return;
        }//if reached steps total
        ArrayList<String> subs = getSubs(rules,currentSequence);
        for(String s:subs){
            String[] splitSub = s.split(" ");

            //for(int i =0; i < stepsTaken;i++){
              //  System.out.print("\t");
            //}
           // System.out.println(stepsTaken + " " + s);
            solution[stepsTaken] = s;
            solve(rules,splitSub[2],endSequence,stepTotal,stepsTaken+1,solution);
        }
    }
    static void test() {
      /* for (int i = 0; i < rules.length; i++) {
            String[] rule = rules[i];
            int rl = rule[0].length();
            for (int j = 0; j < initialSequence.length() + 1 - rl; j++) {
                String sub = initialSequence.substring(j, j + rl);
                if (sub.equals(rule[0])) {
                    System.out.print((i + 1) + " " + (j + 1));
                    String pre = initialSequence.substring(0, j);
                    String post = initialSequence.substring(j + rl);
                    initialSequence = pre + rule[1] + post;
                    System.out.println(initialSequence);
                }
            }
        }*/
    }
}
