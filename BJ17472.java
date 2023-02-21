import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ17472 {
    int h, w;
    int[][] map;
    int[] parentList;
    boolean[][] check;
    ArrayList<Node>[] island;
    int[] dy = {0, -1, 0, 1};
    int[] dx = {1, 0, -1, 0};

    public BJ17472() {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();
        map = new int[h][w];
        check = new boolean[h][w];
        island = new ArrayList[7];
        for(int i = 1; i < 7; i++) {
            island[i] = new ArrayList<>();
        }
        for(int y = 0; y < h; y++) {
            for(int x = 0; x < w; x++) {
                map[y][x] = sc.nextInt();
            }
        }
        int count = 1;
        for(int y = 0; y < h; y++) {
            for(int x = 0; x < w; x++) {
                if(map[y][x] != 0 && !check[y][x]) {
                    island[count].add(new Node(y, x, 0));
                    map[y][x] = count;
                    check[y][x] = true;
                    dfs(y, x, count++);
                }
            }
        }
        PriorityQueue<Node> que = new PriorityQueue<Node>();
        parentList = new int[count];
        for(int i = 1; i < count; i++) {
            parentList[i] = i;
        }
        for(int l = 1; l < count; l++) {
            int[] d = new int[count];
            for(int i = 1; i < count; i++) {
                d[i] = Integer.MAX_VALUE;
            }
            for(Node node : island[l]) {
                for(int i = 0; i < 4; i++) {
                    int v = 0;
                    int mx = node.x + dx[i];
                    int my = node.y + dy[i];
                    while (my > -1 && my < h && mx > -1 && mx < w) {
                        if(map[my][mx] == l) {
                            break;
                        } else if(map[my][mx] != 0) {
                            if(v < 2) {
                                break;
                            }
                            int index = map[my][mx];
                            if(d[index] > v) {
                                d[index] = v;
                                break;
                            }
                        }
                        v++;
                        mx += dx[i];
                        my += dy[i];
                    }
                }
            }
            for(int i = 1; i < count; i++) {
                if(d[i] != Integer.MAX_VALUE) {
                    que.add(new Node(l, i, d[i]));
                }
            }
        }
        int usedNodeCount = 1;
        int result = 0;
        while(usedNodeCount < count - 1) {
            Node node = que.poll();
            if(node == null) {
                System.out.println(-1);
                return;
            }
            if(find(node.y) != find(node.x)) {
                union(node.y, node.x);
                result += node.d;
                usedNodeCount++;
            }
        }
        System.out.println(result);
    }

    private void union(int s, int e) {
        int a = find(s);
        int b = find(e);
        if(a != b) {
            parentList[b] = a;
        }
    }

    private int find(int i) {
        if(parentList[i] != i) {
            parentList[i] = find(parentList[i]);
            return parentList[i];
        }
        return i;
    }


    private class Node implements Comparable<Node>{
        int y, x, d;
        public Node(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }

        public int compareTo(Node o) {
            return this.d - o.d;
        }
    }

    private void dfs(int y, int x, int count) {
        for(int i = 0; i < 4; i++) {
            int my = y + dy[i];
            int mx = x + dx[i];
            if(my > -1 && my < h && mx > -1 && mx < w) {
                if(!check[my][mx] && map[my][mx] != 0) {
                    map[my][mx] = count;
                    check[my][mx] = true;
                    island[count].add(new Node(my, mx, 0));
                    dfs(my, mx, count);
                }
            }
        }
    }

    public static void main(String[] args) {
        BJ17472 bj17472 = new BJ17472();
    }
}
