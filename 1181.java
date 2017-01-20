import java.util.Scanner;

public class Main {
    static int MAX_WORD_LENGTH = 50;

    public static void main(String[] args) {

        String[] words;
        int[] lengths;
        int[] count;

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        words = new String[N];
        lengths = new int[N];
        count = new int[MAX_WORD_LENGTH+1];

        int index=0;
        for(int i=0;i<N;i++){
            String t = scanner.next();
            if(count[t.length()]==0){
                words[index] = t;
                lengths[index] = t.length();
                count[t.length()]++;
                index++;
            }else {
                //단어 중복체크
                int flag = 0;
                for(int j=0;j<index;j++){
                    if(words[j].equals(t)){//중복이 있으면 flag=1
                        flag=1;
                        break;
                    }
                }
                if(flag==0){//중복없음
                    words[index] = t;
                    lengths[index] = t.length();
                    count[t.length()]++;
                    index++;
                }
            }
        }

        //길이에 따른 정렬
        quickSort(words, lengths, 0, lengths.length-1);

        int j=0;
        while(lengths[j]==0){
            j++;
        }

        //같은길이의 단어들끼리 정렬.....>>mergeSort활용
        for(int len=1;len<=MAX_WORD_LENGTH;len++){
            if(count[len]>1){
                //해당 길이의 단어가 여러개 있는경우
                wordSort(words, j, j+count[len]-1);
                j+=count[len];
            }else if(count[len]==1){
                j+=count[len];
            }
        }

        for(int i=0;i<words.length;i++){
            if(lengths[i]>0){
                System.out.println(words[i]);
            }
        }


    }
    public static void quickSort(String[] words, int[] lengths, int left, int right){
        int pivot = lengths[left];
        String pivotWord = words[left];
        int l = left;
        int r = right;

        while (l<r){
            while (lengths[r]>=pivot && l<r){
                r--;
            }
            if(l!=r){
                lengths[l] = lengths[r];
                words[l] = words[r];
            }
            while (lengths[l]<=pivot && l<r){
                l++;
            }
            if(l!=r){
                lengths[r] = lengths[l];
                words[r] = words[l];
                r--;
            }
        }

        lengths[l] = pivot;
        words[l] = pivotWord;
        pivot = l;

        if(left<pivot){
            quickSort(words, lengths, left, pivot-1);
        }
        if(right>pivot){
            quickSort(words, lengths, pivot+1, right);
        }

    }

    public static void wordSort(String[] words, int left, int right){
        int mid;
        if(left<right){
            //분할이 다 안됬을때> 분할&정복
            mid = (left+right)/2;
            wordSort(words, left, mid);
            wordSort(words, mid+1, right);
            wordMerge(words, left, mid, right);
        }
    }

    public static void wordMerge(String[] words, int left, int mid, int right){
        String[] tmp = new String[right-left+1];
        int i = left;
        int j = mid+1;
        int k=0;

        while(i<=mid && j<=right){

            if(minString(words[i], words[j]).equals(words[i])){
                tmp[k] = words[i];
                i++;
            }else {
                tmp[k] = words[j];
                j++;
            }
            k++;
        }

        if (i > mid){
            for (int m = j; m <= right; m++){
                tmp[k] = words[m]; k++;
            }

        } else {
            // left 블록의 index가 아직 남아있을 경우 left index를 순차적으로 결과 result에 복사
            for (int m = i; m <= mid; m++){
                tmp[k] = words[m]; k++;
            }
        }


        for(int a=0;a<tmp.length;a++){
            words[left+a] = tmp[a];
        }
    }


    public static int charToAscii (char str){
        return (int)str;
    }

    public static String minString(String a, String b){
        String ret="";
        for(int i=0;i<a.length();i++){
            //같은길이의 a,b라는 문자열을 비교해서
            if(a.charAt(i)!=b.charAt(i)){
                if(charToAscii(a.charAt(i))<charToAscii(b.charAt(i))){
                    ret = a;
                }else{
                    ret = b;
                }
                break;
            }
        }
        return ret;
    }
}