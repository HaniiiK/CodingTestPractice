import java.io.*;
import java.util.*;

public class Main {
    static List<Character>[] list;
    static boolean[] visited;
    static String answerPre, answerIn, answerPost;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);

            list[a-'A'].add(b);
            list[a-'A'].add(c);
        }

        visited = new boolean[n];
        answerPre = "";
        dfsPre('A');

        visited = new boolean[n];
        answerIn = "";
        dfsIn('A');

        visited = new boolean[n];
        answerPost = "";
        dfsPost('A');
        answerPost += 'A';

        System.out.println(answerPre);
        System.out.println(answerIn);
        System.out.println(answerPost);
    }

    //전위
    private static void dfsPre(char start) {
        answerPre += start;
        int idx = start-'A';
        visited[idx] = true;

        for(int i=0; i<list[idx].size(); i++) {
            if (list[idx].get(i) != '.' && !visited[list[idx].get(i)-'A']) {
                dfsPre(list[idx].get(i));
            }
        }
    }

    //중위
    private static void dfsIn(char start) {

        for (int i = 0; i < n; i++) {
            if (i + 'A' == start) {
                if (list[i].get(0) != '.') {
                    dfsIn(list[i].get(0));
                }
                answerIn += (char)(i+'A');
                if (list[i].get(1) != '.') {
                    dfsIn(list[i].get(1));
                }
                break;
            }
        }
    }

    //후위
    private static void dfsPost(char start) {
        int idx = start-'A';
        visited[idx] = true;

        for (int i = 0; i < list[idx].size(); i++) {
            if (list[idx].get(i) != '.' && !visited[list[idx].get(i)-'A']) {
                dfsPost(list[idx].get(i));
                answerPost += list[idx].get(i);
            }
        }
    }
}