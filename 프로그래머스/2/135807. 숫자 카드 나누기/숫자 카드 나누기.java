import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        //첫번째 경우
        int gcdA = arrayA[0];
        for(int i=1; i<arrayA.length; i++) {
            if(i==1) {
                gcdA = gcd(arrayA[i-1], arrayA[i]);
            }else {
                gcdA = gcd(gcdA, arrayA[i]);
            }
        }
        int answerA = gcdA;
        
        for(int i=0; i<arrayB.length; i++) {
            if(arrayB[i]%gcdA==0) {
                answerA = 0;
                break;
            }
        }
        
        //두번째 경우
        int gcdB = arrayB[0];
        for(int i=1; i<arrayB.length; i++) {
            if(i==1) {
                gcdB = gcd(arrayB[i-1], arrayB[i]);
            }else {
                gcdB = gcd(gcdB, arrayB[i]);
            }
        }
        int answerB = gcdB;

        for(int i=0; i<arrayA.length; i++) {
            if(arrayA[i]%gcdB==0) {
                answerB = 0;
                break;
            }
        }
        
        int answer = Integer.max(answerA, answerB);
        
        return answer;
    }
    
    public static int gcd(int a, int b) {
        if(b==0) {
            return a;
        }else {
            return gcd(b, a%b);
        }
    }
}