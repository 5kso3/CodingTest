import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1325 {

    ArrayList<Integer>[] list;
    int[] result;
    int net;
    int com;

    public BJ1325() {
        Scanner sc = new Scanner(System.in);
        com = sc.nextInt();
        net = sc.nextInt();
        list = new ArrayList[com + 1];
        for(int i = 1; i <= com; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < net; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list[s].add(e);
        }
        result = new int[com  + 1];
        for(int i = 1; i <= com; i++) {
            bfs(i);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= com; i++) {
            if(result[i] > max) {
                max = result[i];
            }
        }
        for(int i = 1; i <= com; i++) {
            if(result[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    private void bfs(int start) {
        boolean[] check = new boolean[com + 1];
        check[start] = true;
        Queue<Integer> que = new LinkedList();
        que.add(start);
        while (!que.isEmpty()) {
            int now = que.poll();
            for(int move : list[now]) {
                if(!check[move]) {
                    check[move] = true;
                    result[move]++;
                    que.add(move);
                }
            }
        }
    }


    public static void main(String[] args) {
        BJ1325 bj1325 = new BJ1325();
    }
}
