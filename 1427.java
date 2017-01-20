import java.util.Scanner;

public class Main {
    static int[] list;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String[] l = s.split("");
        int[] list = new int[l.length];
        for(int i=0;i<l.length;i++){
            list[i] = Integer.parseInt(l[i]);
        }
        quickSort(list, 0, l.length-1);
        for(int i=l.length-1;i>=0;i--){
            System.out.print(list[i]);
        }

    }
    public static void quickSort(int[] array, int left, int right){
        int pivot = array[left];
        int l = left;
        int r = right;

        while (l<r){
            while (array[r]>=pivot && l<r){
                r--;
            }
            if(l!=r){
                array[l] = array[r];
            }
            while (array[l]<=pivot && l<r){
                l++;
            }
            if(l!=r){
                array[r] = array[l];
                r--;
            }
        }

        array[l] = pivot;
        pivot = l;

        if(left<pivot){
            quickSort(array, left, pivot-1);
        }
        if(right>pivot){
            quickSort(array, pivot+1, right);
        }

    }
}