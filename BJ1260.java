import java.util.*;

public class BJ1260 {

    int size;
    int loop;
    PriorityQueue<Integer>[] list;
    PriorityQueue<Integer>[] bfsList;
    Queue<Integer> que = new LinkedList<>();
    boolean[] check;

    public BJ1260(){
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        list = new PriorityQueue[size + 1];
        bfsList = new PriorityQueue[size + 1];
        check = new boolean[size + 1];
        loop = sc.nextInt();
        int start = sc.nextInt();
        for(int i = 0; i <= size; i++){
            list[i] = new PriorityQueue<>();
            bfsList[i] = new PriorityQueue<>();
        }
        for (int i = 0; i < loop; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            list[l].add(r);
            list[r].add(l);
            bfsList[l].add(r);
            bfsList[r].add(l);
        }
        String d = dfs(start);

        check = new boolean[size + 1];
        check[start] = true;
        while(!bfsList[start].isEmpty()){
            que.add(bfsList[start].poll());
        }
        String b = start + " ";
        b += bfs();
        System.out.println(d);
        System.out.println(b);
    }

    private String dfs(int node){
        String result = "";
        if(check[node]){
            return "";
        }
        check[node] = true;
        result += node + " ";
        while(!list[node].isEmpty()){
            result += dfs(list[node].poll());
        }
        return result;
    }

    private String bfs(){
        StringBuilder sb = new StringBuilder();
        while (!que.isEmpty()) {
            int node = que.poll();
            if(check[node]){
                continue;
            }
            check[node] = true;
            sb.append(node);
            sb.append(' ');
            while(!bfsList[node].isEmpty()){
                int next =bfsList[node].poll();
                if(!check[next]){
                    que.add(next);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BJ1260 bj1260 = new BJ1260();
    }
}
