import java.util.Scanner;

public class Main {
    static int[] list;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = scanner.nextInt();
        }
        bubbleSort(list);
        for(int i=0;i<list.length;i++){
            System.out.println(list[i]);
        }
        scanner.close();
    }
    public static void bubbleSort(int[] list){
        for(int j=list.length-1;j>0;j--){
            for(int i=0;i<j;i++){
                if(list[i]>list[i+1]){
                    int tmp  = list[i];
                    list[i] = list[i+1];
                    list[i+1] = tmp;
                }
            }
        }
    }
}