import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1753 {
    int size;
    ArrayList<int[]>[] list;
    PriorityQueue<Node> que = new PriorityQueue<Node>();
    int[] result;
    boolean[] check;

    public BJ1753() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        int route = sc.nextInt();
        int start = sc.nextInt();
        list = new ArrayList[size + 1];
        result = new int[size + 1];
        check = new boolean[size + 1];
        for (int i = 1; i <= size; i++) {
            result[i] = Integer.MAX_VALUE;
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < route; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int d = sc.nextInt();
            int[] temp = new int[2];
            temp[0] = e;
            temp[1] = d;
            list[s].add(temp);
        }

        result[start] = 0;
        que.add(new Node(start, 0));
        while (!que.isEmpty()) {
            Node node = que.poll();
            if(check[node.s]) {
               continue;
            }
            check[node.s] = true;
            for (int[] next : list[node.s]) {
                if (result[next[0]] > result[node.s] + next[1]) {
                    result[next[0]] = result[node.s] + next[1];
                    que.add(new Node(next[0], result[next[0]]));
                }
            }
        }

        for (int i = 1; i <= size; i++) {
            if (!check[i]) {
                System.out.println("INF");
            } else {
                System.out.println(result[i]);
            }
        }
    }

    private class Node implements Comparable<Node>{
        public int s, d;
        public Node(int s, int d) {
            this.s = s;
            this.d = d;
        }

        public int compareTo(Node node) {
            return this.d - node.d;
        }
    }

    public static void main(String[] args) {
        BJ1753 bj1753 = new BJ1753();
    }
}
