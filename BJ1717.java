import java.util.Scanner;

public class BJ1717 {
    int[] list;

    public BJ1717() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int loop = sc.nextInt();
        list = new int[size + 1];
        for(int i = 1; i <= size; i++) {
            list[i] = i;
        }

        for(int i = 0; i < loop; i++) {
            int order = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(order == 1) {
                if(find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                union(a, b);
            }
        }
    }

    private void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if(x != y) {
            list[y] = x;
        }
    }

    private int find(int i) {
        if(list[i] == i) {
            return i;
        } else {
            list[i] = find(list[i]);
            return list[i];
        }
    }

    public static void main(String[] args) {
        BJ1717 bj1717 = new BJ1717();
    }
}
