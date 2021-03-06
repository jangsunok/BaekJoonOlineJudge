import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] list;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.println(getResult(K));
        scanner.close();
    }


    public static long getResult(int K){
        long ret=0;
        int[] sortList = new int[K];

        for(int start=0;start<list.length-K+1;start++){
            if(start==0){
                for(int i=0;i<K;i++){
                    sortList[i] = list[i];
                }
            }else {
                popAndInsert(sortList, list[start-1], list[start+K-1]);
            }
            Arrays.sort(sortList);
            ret+=sortList[(K+1)/2-1];
        }
        return ret;

    }

    public static void popAndInsert(int[] list, int pop, int insert){
        for(int i=0;i<list.length;i++){
            if(list[i]==pop){
                list[i]=insert;
                break;
            }
        }
    }

}

