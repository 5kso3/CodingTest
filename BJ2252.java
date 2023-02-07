import java.util.ArrayList;
import java.util.Scanner;

public class BJ2252 {

    public BJ2252() {
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        ArrayList<Integer>[] arrayList = new ArrayList[node + 1];
        int[] list = new int[node + 1];
        boolean[] check = new boolean[node + 1];
        for(int i = 1; i <= node; i++) {
            arrayList[i] = new ArrayList<>();
        }
        int loop = sc.nextInt();
        for(int i = 0; i < loop; i++) {
            int s = sc.nextInt();
            int l = sc.nextInt();
            arrayList[s].add(l);
            list[l]++;
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(count != node) {
            for(int i = 1; i <= node; i++) {
                if(list[i] == 0 && !check[i]) {
                    sb.append(i);
                    sb.append(' ');
                    count++;
                    check[i] = true;
                    for(int j = 0; j < arrayList[i].size(); j++) {
                        list[arrayList[i].get(j)]--;
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        BJ2252 bj2252 = new BJ2252();
    }
}
