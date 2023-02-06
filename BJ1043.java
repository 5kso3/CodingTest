import java.util.ArrayList;
import java.util.Scanner;

public class BJ1043 {
    int[] list;

    public BJ1043() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        list = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            list[i] = i;
        }
        int party = sc.nextInt();
        int know = sc.nextInt();
        int[] knowList = new int[know];
        ArrayList<int[]> map = new ArrayList<>();
        for (int i = 0; i < know; i++) {
            knowList[i] = sc.nextInt();
        }
        for (int i = 1; i < knowList.length; i++) {
            union(knowList[i - 1], knowList[i]);
        }
        for(int i = 0; i < party; i++) {
            int loop = sc.nextInt();
            int[] people = new int[loop];
            for(int j = 0; j < loop; j++) {
                people[j] = sc.nextInt();
            }
            map.add(people);
            for(int j = 1; j <people.length; j++) {
                union(people[j - 1], people[j]);
            }
        }
        int result = 0;
        if(know == 0) {
            System.out.println(party);
        } else {
            int link = find(list[knowList[0]]);
            for(int i = 0; i < party; i++) {
                boolean flag = true;
                for (int j = 0; j < map.get(i).length; j++) {
                    if(find(map.get(i)[j]) == link) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    result++;
                }
            }
            System.out.println(result);
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
        BJ1043 bj1043 = new BJ1043();
    }
}
