import java.util.*;

public class BJ18352 {

    public BJ18352() {
        Scanner sc = new Scanner(System.in);
        int city = sc.nextInt();
        int road = sc.nextInt();
        int distance = sc.nextInt();
        int start = sc.nextInt();
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer>[] list = new ArrayList[city + 1];
        boolean[] check = new boolean[city + 1];
        int[] result = new int[city + 1];

        for(int i = 1; i <= city; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i <= road; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list[s].add(e);
        }
        check[start] = true;
        Queue<Integer> que = new LinkedList<>();
        for(int move : list[start]) {
            result[move] = 1;
            check[move] = true;
            que.add(move);
        }

        while(!que.isEmpty()) {
            int now = que.poll();
            for(int move : list[now]) {
                if(!check[move]) {
                    que.add(move);
                    result[move] = result[now] + 1;
                    check[move] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= city; i++) {
            if(result[i] == distance) {
                answer.add(i);
            }
        }
        if(answer.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(answer);
            for(int ans : answer) {
                System.out.println(ans);
            }
        }
    }

    public static void main(String[] args) {
        BJ18352 bj18352 = new BJ18352();
    }
}
