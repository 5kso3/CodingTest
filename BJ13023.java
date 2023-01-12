import java.util.ArrayList;
import java.util.Scanner;

public class BJ13023 {

    boolean[] check;
    ArrayList<Integer>[] list;
    boolean flag = false;

    public BJ13023(){
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        check = new boolean[node];
        int loop = sc.nextInt();
        list = new ArrayList[node];
        for(int i = 0; i < node; i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < loop; i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            list[l].add(r);
            list[r].add(l);
        }

        for(int i = 0; i < node; i++){
            if(!check[i]){
                dfs(i, 0);
                if(flag){
                    break;
                }
            }
        }
        if(flag){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private void dfs(int num, int deep){
        if(check[num]){
            return;
        }
        check[num] = true;
        if(deep == 4){
            flag = true;
            return;
        }
        for(int next : list[num]){
            dfs(next, deep + 1);
        }
        check[num] = false;
    }

    public static void main(String[] args) {
        BJ13023 bj13023 = new BJ13023();
    }
}
