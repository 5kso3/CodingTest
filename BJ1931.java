import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1931 {

    public BJ1931() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Node> nodeList = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            nodeList.add(new Node(start, end));
        }
        Collections.sort(nodeList);
        int result = 1;
        Node tempNode = nodeList.get(0);
        for(int i = 1; i < size; i++) {
            if(nodeList.get(i).start >= tempNode.end) {
                tempNode = nodeList.get(i);
                result++;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        BJ1931 bj1931 = new BJ1931();
    }

    private class Node implements Comparable<Node> {
        public int start;
        public int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;

        }

        @Override
        public int compareTo(Node o) {
            if(o.end == end) {
                if(o.start < start) {
                    return end - o.end + 1 ;
                } else {
                    return o.end - 1 - end;
                }
            } else {
                return end - o.end;
            }
        }
    }
}
