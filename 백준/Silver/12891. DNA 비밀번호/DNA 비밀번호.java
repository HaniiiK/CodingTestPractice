import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String DNA = st.nextToken();

        st = new StringTokenizer(br.readLine());
        int[] minNums = new int[4];
        for(int i=0; i<4; i++) {
            minNums[i] = Integer.parseInt(st.nextToken());
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        int answer = 0;
        char c;
        for(int i=0; i<S; i++) {
            c = DNA.charAt(i);
            minNums[map.get(c)]--;

            if(i<P-1) {
                continue;
            }

            if(minNums[0]<=0 && minNums[1]<=0 && minNums[2]<=0 && minNums[3]<=0) {
                answer++;
            }

            //슬라이딩
            minNums[map.get(DNA.charAt(i-P+1))]++;
        }

        System.out.println(answer);
    }
}