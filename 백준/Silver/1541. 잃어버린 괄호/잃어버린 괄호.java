import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String formula = st.nextToken();

        String[] num = formula.split("[+,-]");
        String[] opr = formula.split("[0-9]+");

        int answer = Integer.parseInt(num[0]);
        boolean chk = false; //처음으로 -가 나온 순간부터 끝날 때까지 -할거임
        for(int i=1; i<num.length; i++) {

            if(chk) {
                answer -= Integer.parseInt(num[i]);
            }else {
                if(opr[i].equals("-")) {
                    answer -= Integer.parseInt(num[i]);
                    chk = true;
                }else if(opr[i].equals("+")) {
                    answer += Integer.parseInt(num[i]);
                }
            }
        }

        System.out.println(answer);
    }
}