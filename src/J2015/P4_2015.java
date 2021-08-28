package J2015;

import java.util.ArrayList;
import java.util.Scanner;

public class P4_2015 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int M = input.nextInt();
        ArrayList<Integer> names = new ArrayList<>();
        int[][] nameAndWaitingTime = new int[2][M];
        int lineUsed = 0;
        for (int i = 0; i < M; i++) {
            String whatToDo = input.next();
           /* System.out.println(whatToDo);
            switch (whatToDo) {
                case "R":

                    break;
                case "W":

                    break;
                case "S":

                    break;
                default:
                    System.out.println("default case: " + whatToDo);


            }*/
            if (whatToDo.equals("R")) {
                Integer friend = input.nextInt();
                names.add(friend);
                nameAndWaitingTime[0][lineUsed++] = friend;
                nameAndWaitingTime[1][lineUsed++] = -1;
            }
            if (whatToDo.equals("W")) {
                int skippingTime = input.nextInt();
                for (int n : names) {
                    for (int j = 0; j < lineUsed; j++) {
                        if (nameAndWaitingTime[0][j] == n) {
                            nameAndWaitingTime[1][j] += skippingTime;
                            nameAndWaitingTime[1][j]-=2;
                        }
                    }


                }
            }
            if (whatToDo.equals("S")) {
                int a = input.nextInt();
                for (int j = 0; j < names.size(); j++) {
                    if (names.get(j) == a) {
                        names.remove(j);
                    }

                }
            }

            for (int n : names) {
                for (int j = 0; j < lineUsed; j++) {
                    if (nameAndWaitingTime[0][j] == n)
                        nameAndWaitingTime[1][j]++;
                }
            }
        }
        for (int i = 0; i < lineUsed; i++) {
            for (int j = 0; j < lineUsed - i - 1; j++) {
                if (nameAndWaitingTime[0][j] > nameAndWaitingTime[0][j + 1]) {
                    int[] temp = new int[2];
                    temp[0] = nameAndWaitingTime[0][j];
                    temp[1] = nameAndWaitingTime[1][j];
                    nameAndWaitingTime[0][j] = nameAndWaitingTime[0][j + 1];
                    nameAndWaitingTime[1][j] = nameAndWaitingTime[1][j + 1];
                    nameAndWaitingTime[0][j + 1] = temp[0];
                    nameAndWaitingTime[1][j + 1] = temp[1];
                }
                if(nameAndWaitingTime[0][j] == nameAndWaitingTime[0][j + 1]){
                    nameAndWaitingTime[0][j+1] = 0;
                }
            }
            if (names.contains(nameAndWaitingTime[0][i]))
                nameAndWaitingTime[1][i] = -1;
        }

        for (int i = 0; i < lineUsed; i++) {

            if (nameAndWaitingTime[0][i] != 0)
                System.out.println(nameAndWaitingTime[0][i] + " " + nameAndWaitingTime[1][i]);
        }
    }




        /*boolean[]FriendsName = new boolean[M];
        int[] AllFriendWaitingTime = new int[M];
        for(int i = 0;i<M;i++){
            String whatToDo = input.next();
            if(whatToDo.equals("R")){
                 int friendSendMsg = input.nextInt();
                 FriendsName[friendSendMsg] = true;
                 AllFriendWaitingTime[friendSendMsg] = -1;
            }
            else if(whatToDo.equals("W")){
                int skippingTime = input.nextInt();
                for(int j = 0;j<M;j++){
                    if(FriendsName[j] == true){
                        AllFriendWaitingTime[j] += skippingTime;
                        AllFriendWaitingTime[j]--;
                    }
                }
            }
            else
                FriendsName[input.nextInt()]=false;

            for(int j = 0;j<M;j++){
                if(FriendsName[j] == true){
                    AllFriendWaitingTime[j] ++;
                }
            }
        }
        for(int i =0;i<M;i++){
            if(AllFriendWaitingTime[i] >0){
                if(FriendsName[i] == false)
                    System.out.println(i + " " + AllFriendWaitingTime[i]);
                else
                    System.out.println(i + " " + -1);

            }
        }*/
    }

