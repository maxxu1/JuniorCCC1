package J2011;

import java.util.*;


public class p5_2011 {

    static Scanner input = new Scanner(System.in);
    static int n = input.nextInt();
    static ArrayList<String[]> iDUW = new ArrayList<>();
    static int abc = n * (n-1);
    public static void main(String[] args) {
        String[] server = new String[n];
        for (int i = 0; i < n - 1; i++) {
            String a = input.next();
            if (server[Integer.parseInt(a) - 1] == null)
                server[Integer.parseInt(a) - 1] = Integer.toString(i);
            else
                server[Integer.parseInt(a) - 1] = server[Integer.parseInt(a) - 1] + "," + Integer.toString(i);
        }
        findDifferentUnfriendingWays(server);
        System.out.println(iDUW.size());
        abc--;

    }
    public static void findDifferentUnfriendingWays(String[] server){
        if(abc==0){
            System.out.println(iDUW.size());
            System.exit(0);
        }
        String[] jeSuisServer = server;
        if(server.length==1){
            return;

        }
        if(!amIInTheListQuestionMark(jeSuisServer,iDUW)){
            iDUW.add(server);
        }
        for(int i =0;i<n-1;i++){
            abc--;
            RemoveAPerson(server,i+1);
            findDifferentUnfriendingWays(server);

        }
    }
    public static boolean amIInTheListQuestionMark(String[] whoAreYou,ArrayList<String[]>whoIsTheList){
        for(String[] s : whoIsTheList){
            if(whoAreYou.equals(s)){
                return true;
            }
        }
        return false;
    }

    public static void RemoveAPerson(String[] server, int theRemovingPerson) {
        theRemovingPerson--; //0 basing
        String[] partA = new String[n-1];
        if(server[theRemovingPerson]==null){
            for (int i = 0;i<n-1;i++){
                if( i < theRemovingPerson)
                    partA[i]=server[i];
                if(i>theRemovingPerson)
                    partA[i]=server[i++];
            }
            return;
        }
        String[] newTarget = server[theRemovingPerson].split(",");
        ArrayList<Integer> targetList = new ArrayList<>();
        for (String s : newTarget) {
            targetList.add(Integer.parseInt(s));
        }
        for (int i = 0;i<n-1;i++){
            if( i < theRemovingPerson)
                partA[i]=server[i];
            if(i>theRemovingPerson)
                partA[i]=server[i++];
        }
        server=partA;
        for(int i : targetList){
            RemoveAPerson(server,i++);
        }


    }
}
