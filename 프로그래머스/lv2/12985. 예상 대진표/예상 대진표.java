class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        long a2 = (long)a;
        long b2 = (long)b;
        while(true) {
            if(a2%2==1 && a2-b2==-1) {
                break;
            }
            if(b2%2==1 && b2-a2==-1) {
                break;
            }
            answer++;
            a2 = (a2+1)/2;
            b2 = (b2+1)/2;
            // System.out.println(a2);
            // System.out.println(b2);
        }
        return answer;
    }
}