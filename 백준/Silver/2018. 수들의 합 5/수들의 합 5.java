import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        int N = Integer.parseInt(st.nextToken());
        int answer = 0;
        int sum = 0;
        for(int i=1; i<=N; i++) {
        	sum = 0;
        	for(int j=i; j<=N; j++) {
            	sum += j;
            	if(sum==N) {
            		answer++;
            		break;
            	}
            	if(sum>N) {
            		break;
            	}
        	}
        }
        System.out.println(answer);
    }
}