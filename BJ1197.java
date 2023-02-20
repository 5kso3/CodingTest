import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1197 {

    int[] check;

    public BJ1197() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int route = sc.nextInt();
        check = new int[size + 1];
        PriorityQueue<Node> que = new PriorityQueue<>();
        for(int i = 1; i <= size; i++) {
            check[i] = i;
        }
        for(int i = 0; i < route; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int d = sc.nextInt();
            que.add(new Node(s, e, d));
        }
        int count = 0;
        int result = 0;
        while(count < size - 1) {
            Node node = que.poll();
            if(find(node.s) != find(node.e)) {
                union(node.s, node.e);
                result += node.d;
                count++;
            }
        }
        System.out.println(result);
    }

    private void union(int s, int e) {
        if(find(s) != find(e)) {
            check[find(e)] = find(s);
        }
    }

    private int find(int s) {
        if(check[s] != s) {
            check[s] = find(check[s]);
            return check[s];
        } else {
            return s;
        }
    }

    private class Node implements Comparable<Node>{
        public int s, e, d;

        public Node(int s, int e, int d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }

        public int compareTo(Node o) {
            return this.d - o.d;
        }
    }

    public static void main(String[] args) {
        BJ1197 bj1197 = new BJ1197();
    }
}
