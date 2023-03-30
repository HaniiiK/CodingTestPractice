class Solution {
    public int solution(int n) {    
        int answer = 0;
        int factorial = 1;
int index = 1;
while(factorial <= n){
    factorial *= index;
    
    if(factorial <= n){
         index++;
     }else if(factorial == n){
         answer = index;
     }else if(n < factorial){
        answer = (index-1);
    } 
    if(factorial == 0){
        answer = 0;
        return answer;
    }
}
return answer;
        
        
    /*    int answer = 0;
        int i=1, res=n;
        while(true) {
            res = res/i;
            if(res>i) {
                i++;
            } else {
                answer = i;
                break;
            }
        }
        return answer;*/
    }
}