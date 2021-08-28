package J2018;

import java.util.*;

public class P5_2018 {
    static Scanner input = new Scanner(System.in);
    static int n = input.nextInt();
    static boolean[] reachable = new boolean[n];
    static boolean[] reached = new boolean[n];

    public static void main(String[] args) {
       // reachable[0] = true;
        int[][] book = new int[n][n];
        for (int i = 0; i < n; i++) {
            int m = input.nextInt();
            int[] canReach = new int[m];
            for (int j = 0; j < m; j++) {
                canReach[j] = input.nextInt() - 1;
            }
            book[i] = canReach;
        }
      /*ArrayList<Integer> steps = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        findShortestPath(book, 1, 0, steps,path);
        Collections.sort(steps);
        boolean a = true;
        for (int i = 0; i < reachable.length; i++) {
            if (reachable[i] == false) {
                a = false;
            }
        }
        if (a == true) {
            System.out.println("Y");
        } else
            System.out.println("N");
        System.out.println(steps.get(0));*/
        findShortestPath(book);


    }
    static void findShortestPath(int[][] book){
        ArrayList<Integer> pagesToSearch = new ArrayList<>();
        int stepsTaken = 0;
        int minSteps = Integer.MAX_VALUE;
        pagesToSearch.add(0);
        while (pagesToSearch.size()>0){
            ArrayList<Integer> newPages = new ArrayList<>();
            for(int page : pagesToSearch){
                if(page==-1){
                    if(stepsTaken<minSteps)
                        minSteps = stepsTaken;
                    continue;
                }
                if(reachable[page]){
                    continue;

                }
                else
                    reachable[page] = true;
                newPages.addAll(getPossiblePages(book,page));
            }

            stepsTaken++;
           /* pagesToSearch.clear();
            pagesToSearch.addAll(newPages);*/
            pagesToSearch = newPages;
           // System.out.println("1");
        }
        boolean a = true;
        for (int i = 0; i < reachable.length; i++) {
            if (reachable[i] == false) {
                a = false;
            }
        }
        if (a == true) {
            System.out.println("Y");
        } else
            System.out.println("N");
        System.out.println(minSteps);
    }
    static ArrayList<Integer> getPossiblePages(int[][] book,int page){
        ArrayList<Integer> array = new ArrayList<>();
        for(int i =0;i<book[page].length;i++){
            array.add(book[page][i]);
        }
        if(array.size()==0)
            array.add(-1);
        return array;
    }
    static void findShortestPath2(int[][] book, int steps, int currentPage, ArrayList<Integer> allSteps, ArrayList<Integer> path) {
        reachable[currentPage] = true;
        reached[currentPage] = true;
        path.add(currentPage+1);
        if (book[currentPage].length == 0) {
            allSteps.add(steps);
            for(int i =0;i<reached.length;i++)
                reached[i] = false;
            //System.out.println(path);
        }
        for (int i = 0; i < book[currentPage].length; i++) {
            int nextPage = book[currentPage][i] - 1;
            if(reached[nextPage] == false)
                findShortestPath2(book, steps + 1, nextPage, allSteps,path);

        }
    }
}