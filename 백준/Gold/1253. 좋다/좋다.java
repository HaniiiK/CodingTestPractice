import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int firstP, lastP;
        boolean isFound = false;
        for(int i=0; i<N; i++) {
            isFound = false;

            for(int j=0; j<N-1; j++) {
                if(i==j) {
                    continue;
                }

                firstP = nums[j];
                for(int k=j+1; k<N; k++) {
                    if(i==k) {
                        continue;
                    }
                    lastP = nums[k];
                    if(firstP+lastP==nums[i]) {
                        answer++;
                        isFound = true;
                        break;
                    }
                }
                if(isFound) {
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}