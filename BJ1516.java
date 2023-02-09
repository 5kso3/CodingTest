import java.util.ArrayList;
import java.util.Scanner;

public class BJ1516 {

    public BJ1516() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Integer>[] visitList = new ArrayList[size + 1];
        boolean[] check = new boolean[size + 1];
        int[] time = new int[size + 1];
        int[] list = new int[size + 1];
        for(int i = 1; i <= size; i++) {
            visitList[i] = new ArrayList();
        }
        for(int i = 1; i <= size; i++) {
            time[i] = sc.nextInt();
            int op = 0;
            while(op != -1) {
                op = sc.nextInt();
                if(op != -1) {
                    visitList[op].add(i);
                    list[i]++;
                }
            }
        }
        int[] result = new int[size + 1];
        int count = 0;
        while(count != size) {
            for(int i = 1; i < size + 1; i++) {
                if(list[i] == 0 && !check[i]) {
                    check[i] = true;
                    result[i] = result[i] + time[i];
                    count++;
                    for(int j = 0; j < visitList[i].size(); j++) {
                        result[visitList[i].get(j)] = Math.max(result[i], result[visitList[i].get(j)] + time[i]);
                        list[visitList[i].get(j)]--;
                    }
                }
            }
        }

        for(int i = 1; i < size + 1; i++) {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) {
        BJ1516 bj1516 = new BJ1516();
    }
}
