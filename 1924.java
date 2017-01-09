import java.util.Scanner;


public class Main {
    static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] yoil = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int startday = 1;
        int ret = (findDays(x, y) + startday)%7;
        System.out.println(yoil[ret]);
    }

    public static int findDays(int month, int day){
        int sum = 0;
        for(int i=1;i<month;i++){
            sum += days[i-1];
        }
        sum += day -1;
        return (sum%7);
    }
}