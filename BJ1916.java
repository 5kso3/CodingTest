import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1916 {

    public BJ1916() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int route = sc.nextInt();
        ArrayList<int[]>[] list = new ArrayList[size + 1];
        for(int i = 1; i <= size; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < route; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int d = sc.nextInt();
            int[] temp = new int[2];
            temp[0] = e;
            temp[1] = d;
            list[s].add(temp);
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        int[] result = new int[size + 1];
        boolean[] check = new boolean[size + 1];
        for (int i = 1; i <= size; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(start, 0));

        while(!que.isEmpty()) {
            Node node = que.poll();
            if(check[node.s]) {
                continue;
            }
            check[node.s] = true;
            if(result[node.s] > node.d) {
                result[node.s] = node.d;
            }
            for(int[] next : list[node.s]) {
                if(!check[next[0]]) {
                    que.add(new Node(next[0], result[node.s] + next[1]));
                }
            }
        }
        System.out.println(result[end]);
    }

    private class Node implements Comparable<Node>{
        public int s, d;

        public Node(int s, int d) {
            this.s = s;
            this.d = d;
        }

        public int compareTo(Node o) {
            return this.d - o.d;
        }
    }

    public static void main(String[] args) {
        BJ1916 bj1916 = new BJ1916();
    }
}
