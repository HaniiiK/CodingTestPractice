class Solution {
    
    static StringBuffer sb = new StringBuffer();
    
    public String solution(int n) {
        loof(n);

        return sb.toString();
    }
    
    private static void loof(int n) {
        if(n==1) {
            sb.append("1");
        }else if(n==2) {
            sb.append("2");
        }else if(n==3 || n==0) {
            sb.append("4");
        }else {
            loof((n-1)/3);
            loof(n%3);
        }
        
    }
}