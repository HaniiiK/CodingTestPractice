import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, N-1);

        System.out.println(arr[K-1]);
    }

    public static void quickSort(int[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        int x = arr[(pl+pr)/2]; //피벗(가운데 요소)
        int tmp;
        do {
            while (arr[pl] < x) {
                pl++;
            }
            while (arr[pr] > x) {
                pr--;
            }
            if (pl <= pr) {
                tmp = arr[pl];
                arr[pl] = arr[pr];
                arr[pr] = tmp;
                pl++;
                pr--;
            }
        } while (pl <= pr);

        if (left < pr) {
            quickSort(arr, left, pr);
        }
        if (pl < right) {
            quickSort(arr, pl, right);
        }
    }

}