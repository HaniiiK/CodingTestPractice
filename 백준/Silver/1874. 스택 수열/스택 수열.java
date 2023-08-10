import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        int stackNum = 1;
        int i = 0;
        while(true) {
            if(!stack.contains(arr[i])) {
                stack.add(stackNum);
                stackNum++;
                sb.append("+\n");
                continue;
            }else {
                if(stack.peek()==arr[i]) {
                    stack.pop();
                    sb.append("-\n");
                }else {
                    sb.delete(0, sb.capacity());
                    sb.append("NO");
                    break;
                }
            }
            i++;
            if(i==N) {
                break;
            }
        }
        System.out.println(sb.toString());
    }
}