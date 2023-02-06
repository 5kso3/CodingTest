import java.util.Scanner;

public class BJ1976 {

    int[] list;

    public BJ1976() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        list = new int[size + 1];
        int vSize = sc.nextInt();
        int[] city = new int[vSize];
        for(int i = 1; i <= size; i++) {
            list[i] = i;
        }
        for(int i = 1; i <= size; i++) {
            for(int j = 1; j <= size; j++) {
                int op = sc.nextInt();
                if(op == 1) {
                    union(i, j);
                }
            }
        }
        for(int i = 0; i < vSize; i++) {
            city[i] = sc.nextInt();
        }
        int link = find(city[0]);
        boolean isPossible = true;
        for(int i = 1; i < city.length; i++) {
            if(find(city[i]) != link) {
                isPossible = false;
            }
        }
        if(isPossible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
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

    private void union(int s, int e) {
        int l = find(s);
        int r = find(e);
        if(l != r) {
            list[l] = r;
        }
    }


    public static void main(String[] args) {
        BJ1976 bj1976 = new BJ1976();
    }
}
