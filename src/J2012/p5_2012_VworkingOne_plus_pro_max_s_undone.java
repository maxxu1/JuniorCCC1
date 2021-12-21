package J2012;

import java.util.*;

public class p5_2012_VworkingOne_plus_pro_max_s_undone {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        //String[] s1={"A","B","C"};
        //String[] s2={"A","B","C"};
        //System.out.println(Arrays.equals(s1,s2));
//        String a = "321";
//        char a0 = a.charAt(0);
//        char a2 = a.charAt(2);
//        System.out.printf("%d > %d? \n ", (int) a0,(int)a2);
//        System.out.println(a0>a2);
        while (true) {
            int nums = input.nextInt();
            if (nums == 0) return;
            String[] cases = new String[nums];
            for (int i = 0; i < nums; i++) {
                cases[i] = input.next();
            }
           /* if(checkIfItIsSorted(cases))
                System.out.println("sorted");
            else
                System.out.println("not sorted");
            if(moveTheCoin(cases,1,0)){
                System.out.println(Arrays.toString(cases) + " true");
            }
            else
                System.out.println("unable to move this coin" + Arrays.toString(cases));*/
            ArrayList<String[]> states = new ArrayList<>();
            ArrayList<Integer> steps = new ArrayList<>();
            okIMightGonnaStartSolvingThisSimplifiedJavaCodingProgramThatIsWrittenInIntelliJIDEA(cases,states,steps);
            System.out.println(steps);
        }
    }
    public static void okIMightGonnaStartSolvingThisSimplifiedJavaCodingProgramThatIsWrittenInIntelliJIDEA(String[] cases,ArrayList<String[]> states,ArrayList<Integer> steps){
        System.out.println(Arrays.toString(cases) + " " + states.size());
        if(! checkIfItIsInTheList(cases,states))
            return;

        if(checkIfItIsSorted(cases)){
            steps.add(states.size());

            return;
        }


        states.add(cases);
       // System.out.println(Arrays.toString(cases));
        for(int i = 1;i< cases.length;i++){
            String[] stack = cases.clone();
            if(moveTheCoin(stack,i-1,i))
                okIMightGonnaStartSolvingThisSimplifiedJavaCodingProgramThatIsWrittenInIntelliJIDEA(stack,states,steps);
            else {
                moveTheCoin(stack, i, i-1);
                okIMightGonnaStartSolvingThisSimplifiedJavaCodingProgramThatIsWrittenInIntelliJIDEA(stack,states,steps);
            }

        }


    }
    public static boolean checkIfItIsSorted(String[] cases) {
        for (int i =0;i< cases.length-1;i++){
            if(cases[i].equals("")||cases[i+1].equals("") )
                return false;
            if(Integer.parseInt(cases[i])>Integer.parseInt(cases[i+1])){
                return false;
            }
        }
        return true;
    }

    public static boolean moveTheCoin(String[] cases,int startPosition,int targetPosition){
//        if(cases[targetPosition].equals("")) {
//            int a = Integer.parseInt(cases[startPosition]);
//            cases[targetPosition] = Integer.toString(a%10);
//            if(a/10 == 0){
//                cases[startPosition] = "";
//            }
//            else
//                cases[startPosition] = Integer.toString(a/10);
//            return true;
//        }
//        if(cases[startPosition].equals(""))
//            return false;
//        int a = Integer.parseInt(cases[startPosition]);
//        int b = Integer.parseInt(cases[targetPosition]);
//
//        if(b%10 < a%10){
//            return false;
//        }
//        b = b*10 +a;
//        cases[targetPosition] = Integer.toString(b);
//        if(a/10 == 0){
//            cases[startPosition] = "";
//        }
//        else
//            cases[startPosition] = Integer.toString(a/10);
//        return true;
        String start = cases[startPosition];
        String target = cases[targetPosition];
        if(start.equals(""))
            return false;
        if(target.equals("")){
            cases[targetPosition] += start.charAt(start.length()-1);
            cases[startPosition] = start.substring(0, start.length()-1);
            return true;
        }
        char lDOS = start.charAt(start.length()-1);
        char lDOT = target.charAt(target.length()-1);
        if(lDOS < lDOT){
            cases[targetPosition] += start.charAt(start.length()-1);
            cases[startPosition] = start.substring(0, start.length()-1);
            return true;
        }

        return false;
    }

    public static boolean checkIfItIsInTheList(String[] cases, ArrayList<String[]> states){
        for(String[] state:states){
            if(Arrays.equals(cases,state)){
                return false;
            }
        }
//        for(int i =0;i<states.size();i++){
//            if(Arrays.equals(cases,states.get(i))){
//                return false;
//            }
//
//        }
        return true;
    }


}