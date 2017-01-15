import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for (int i = 0; i < testCase; i++) {
            int H = scanner.nextInt();
            int W = scanner.nextInt();
            int N = scanner.nextInt();
            int ret = getResult(H, W, N);
            System.out.println(""+ret);
        }
        scanner.close();
    }

    public static int getResult(int H, int W, int N) {
        int height;
        int room;

        height = N%H;
        room = N/H +1;
        if (height==0){
            height = H;
            room = N/H;
        }


        return height*100+room;
    }
}