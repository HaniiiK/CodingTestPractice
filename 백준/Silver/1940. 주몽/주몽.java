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
        int M = Integer.parseInt(st.nextToken());
               
        st = new StringTokenizer(br.readLine());    
        int[] uniqueNum = new int[N];
        for(int i=0; i<N; i++) {
            uniqueNum[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = 0;
        for(int i=0; i<N-1; i++) {
        	for(int j=i+1; j<N; j++) {
        		if(uniqueNum[i]!=-1 && uniqueNum[j]!=-1 && uniqueNum[i]+uniqueNum[j]==M) {
        			uniqueNum[i] = -1;
        			uniqueNum[j] = -1;
        			answer++;
        			break;
        		}
        	}
        }
        System.out.println(answer);
    }
}