import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    static Set<Integer> truth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //사람 수
        int m = Integer.parseInt(st.nextToken()); //파티 수

        arr = new int[n+1];
        for(int i=0; i<=n; i++) {
            arr[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int truthNum = Integer.parseInt(st.nextToken()); //진실을 아는 사람의 수
        truth = new HashSet<>(); //진실을 아는 사람의 번호
        for(int i=0; i<truthNum; i++) {
            int t = Integer.parseInt(st.nextToken());
            truth.add(t);
        }

        /**
         * 파티 온 사람들끼리 커넥션 리스트
         */
        int[][] participants = new int[m][];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int participantNum = Integer.parseInt(st.nextToken()); //파티에 오는 사람의 수
            participants[i] = new int[participantNum];

            for (int j = 0; j < participantNum; j++) {
                participants[i][j] = Integer.parseInt(st.nextToken());

                if (j == 0) {
                    continue;
                }
                union(participants[i][j - 1], participants[i][j]);
            }
        }

        /**
         * 정답 추려내기
         */
        int answer = 0;
        boolean done;
        for(int i=0; i<m; i++) {
            done = false;

            for(int j=0; j<participants[i].length; j++) {
                Iterator<Integer> iter = truth.iterator();
                while(iter.hasNext()) {
                    if(find(participants[i][j])==find(iter.next())) {
                        answer++;
                        done = true;
                        break;
                    }
                }
                if(done) {
                    break;
                }
            }
        }

        System.out.println(m-answer);
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if(x==y) {
            return;
        }
        arr[y] = x;
    }

    private static int find(int a) {
        if(a==arr[a]) {
            return a;
        }
        int tmp = find(arr[a]);
        arr[a] = tmp;
        return arr[a];
    }

}