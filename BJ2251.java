import java.util.*;

public class BJ2251 {

    public BJ2251() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] max = new int[3];
        max[0] = a;
        max[1] = b;
        max[2] = c;
        boolean check[][] = new boolean[201][201];
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Node> que = new LinkedList<>();
        Node start = new Node(0, 0, c, 2);
        que.add(start);
        check[0][0] = true;
        answer.add(c);

        while (!que.isEmpty()) {
            Node node = que.poll();
            for(int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int[] temp = node.waters.clone();
                    if (i == j) {
                        continue;
                    }
                    int move = max[j] - temp[j];
                    if (move < temp[i]) {
                        temp[j] = max[j];
                        temp[i] -= move;
                    } else {
                        temp[j] += temp[i];
                        temp[i] = 0;
                    }
                    if(!check[temp[0]][temp[1]]) {
                        check[temp[0]][temp[1]] = true;
                        if(temp[0] == 0 && !answer.contains(temp[2])) {
                            answer.add(temp[2]);
                        }
                        que.add(new Node(temp[0], temp[1], temp[2], j));
                    }
                }
            }
        }
        Collections.sort(answer);
        for(int ans : answer) {
            System.out.print(ans + " ");
        }
    }

    private class Node {
        public int[] waters = new int[3];
        public int s;

        public Node(int a, int b, int c, int s) {
            waters[0] = a;
            waters[1] = b;
            waters[2] = c;
            this.s = s;
        }

    }


    public static void main(String[] args) {
        BJ2251 bj2251 = new BJ2251();
    }
}
