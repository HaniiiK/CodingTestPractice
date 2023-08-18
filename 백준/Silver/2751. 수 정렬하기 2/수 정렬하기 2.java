import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] buff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        buff = new int[N];
        mergeSort(arr, 0, N-1);

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++) {
            sb.append(arr[i]+"\n");
        }
        System.out.println(sb.toString());
    }

    public static void mergeSort(int[] a, int first, int last) {
        if (first < last) {
            int i;
            int center = (first+last)/2;
            int p = 0;
            int j = 0;
            int k = first;

            mergeSort(a, first, center);
            mergeSort(a, center+1, last);

            for (i = first; i <= center; i++) {
                buff[p++] = a[i];
            }

            while (i <= last && j < p) {
                a[k++] = (buff[j] <= a[i]) ? buff[j++]: a[i++];
            }

            while (j < p) {
                a[k++] = buff[j++];
            }
        }
    }
}