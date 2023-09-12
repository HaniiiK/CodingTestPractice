import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        Set<Long> set = new HashSet<>();

        for(long i=2; i<=Math.sqrt(max); i++) {
            long ii = i*i;
            long tmp = min/ii; //
            if(min%ii != 0) {
                tmp += 1;
            }

            long j = tmp;
            while(true) {
                if(ii*j>max) {
                    break;
                }

                if(ii*j>=min) {
                    set.add(ii*j);
                }
                j++;
            }
        }
        int answer = (int)(max-min+1) - set.size();

        System.out.println(answer);
    }

}