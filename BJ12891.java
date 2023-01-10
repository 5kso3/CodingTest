import java.util.Scanner;

public class BJ12891 {

    public BJ12891(){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int length = sc.nextInt();
        char[] line = new char[size];
        String input = sc.next();
        for(int i = 0; i < size; i++){
            line[i] = input.charAt(i);
        }
        int[] dnaNum = new int[4];
        for(int i = 0; i < 4; i++){
            dnaNum[i] = sc.nextInt();
        }

        int start = 0;
        int end = length - 1;
        int[] temp = new int[4];
        int result = 0;

        for(int i = 0; i < length; i++){
            if(line[i] == 'A'){
                temp[0]++;
            } else if(line[i] == 'C'){
                temp[1]++;
            } else if(line[i] == 'G'){
                temp[2]++;
            } else {
                temp[3]++;
            }
        }

        while(end < size) {
            if(check(dnaNum, temp)){
                result++;
            }
            if(line[start] == 'A'){
                temp[0]--;
            } else if(line[start] == 'C'){
                temp[1]--;
            } else if(line[start] == 'G'){
                temp[2]--;
            } else {
                temp[3]--;
            }
            start++;
            end++;
            if(end < size){
                if(line[end] == 'A'){
                    temp[0]++;
                } else if(line[end] == 'C'){
                    temp[1]++;
                } else if(line[end] == 'G'){
                    temp[2]++;
                } else {
                    temp[3]++;
                }
            }
        }

        System.out.println(result);
    }

    private boolean check(int[] dna, int[] temp){
        for(int i = 0; i < 4; i++){
            if(dna[i] > temp[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BJ12891 bj12891 = new BJ12891();
    }
}
