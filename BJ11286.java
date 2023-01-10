import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ11286 {

    public BJ11286(){
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        PriorityQueue<Node> que = new PriorityQueue();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < loop; i++) {
            int input = sc.nextInt();
            if(input != 0){
                que.add(new Node(Math.abs(input), input));
            } else {
                if(!que.isEmpty()){
                    sb.append(que.poll().value);
                    sb.append('\n');
                } else {
                    sb.append(0);
                    sb.append('\n');
                }
            }
        }
        System.out.println(sb.toString());
    }

    private class Node implements Comparable<Node>{
        int abs;
        int value;

        public Node(int abs, int value){
            if(abs < 0){
                this.abs = -abs;
            } else {
                this.abs = abs;
            }
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if(o.abs == this.abs){
                if(o.value > this.value){
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return this.abs - o.abs;
            }
        }
    }

    public static void main(String[] args) {
        BJ11286 bj11286 = new BJ11286();
    }
}
