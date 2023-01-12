import java.util.ArrayList;
import java.util.Scanner;

public class BJ11724 {

    int loop;
    ArrayList<Integer>[] list;
    boolean[] check;

    public BJ11724() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        list = new ArrayList[size + 1];
        loop = sc.nextInt();
        check = new boolean[size + 1];
        for (int i = 0; i <= size; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < loop; i++){
            int index = sc.nextInt();
            int value = sc.nextInt();
            list[index].add(value);
            list[value].add(index);
        }

        int result = 0;
        for (int i = 1; i <= size; i++) {
            if(!check[i]){
                dfs(i);
                result++;
            }
        }
        System.out.println(result);
    }

    private void dfs(int num){
        if(check[num]){
           return;
        }
        check[num] = true;
        for(int next : list[num]){
            dfs(next);
        }
    }


    public static void main(String[] args) {
        BJ11724 bj11724 = new BJ11724();
    }
}
