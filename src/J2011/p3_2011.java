package J2011;

import java.util.*;

public class p3_2011 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int t1 = input.nextInt();
        int t2= input.nextInt();
        ArrayList<Integer> t = new ArrayList<>();
        t.add(t1);
        t.add(t2);
        while(true){
            if(t.get(t.size()-2) - t.get(t.size()-1)>t.get(t.size()-1)){
                System.out.println(t.size()+1);
                System.exit(0);
            }
            else
                t.add(t.get(t.size()-2) - t.get(t.size()-1));
        }

    }
}