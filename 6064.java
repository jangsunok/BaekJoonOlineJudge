import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for (int i = 0; i < testCase; i++) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int ret = getResult(M, N, x, y);
            System.out.println(""+ret);
        }
        scanner.close();
    }

    public static int getResult(int M, int N, int x, int y) {
        for(int j=0;j<N;j++) {
            if (y == ((x - 1) + j * M) % N + 1) {
                return (x - 1) + j * M + 1;
            }
        }
        return -1;
    }
}