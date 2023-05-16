import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] num = new int[t][2];
        
        for(int i=0; i<t; i++) {
            for(int j=0; j<2; j++) {
                num[i][j] = sc.nextInt();
            }
        }
        
        int tmp = 1;
        for(int i=0; i<t; i++) {
            tmp = 1;
        	for(int j=0; j<num[i][1]; j++) {
        		tmp = tmp*num[i][0]%10;
        	}
            if(tmp==0) {
        		tmp = 10;
        	}
            System.out.println(tmp);
        }
    }
}