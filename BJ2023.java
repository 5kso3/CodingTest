import java.util.Scanner;

public class BJ2023 {

    int size;
    int max;
    StringBuilder sb;

    public BJ2023(){
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        sb = new StringBuilder();
        max = 1;
        for(int i = 0; i < size; i++){
            max = max * 10;
        }
        if(size == 1){
            System.out.println(2);
            System.out.println(3);
            System.out.println(5);
            System.out.println(7);
            return;
        }
        dfs(20);
        dfs(30);
        dfs(50);
        dfs(70);

        System.out.println(sb.toString());
    }

    private void dfs(int num){

        if(num >= max){
            return;
        }

        for(int i = 1; i < 10; i++){
            boolean isSosu = true;
            for(int j = 2; j < num + i; j++){
                if((num + i) % j == 0){
                    isSosu = false;
                    break;
                }
            }
            if(isSosu){
                if(num + i > max / 10){
                    sb.append(num + i);
                    sb.append('\n');
                }
                dfs((num + i) * 10);
            }
        }
    }

    public static void main(String[] args) {
        BJ2023 bj2023 = new BJ2023();
    }
}
