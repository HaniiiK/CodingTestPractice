class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int len = numbers.length;
        
        int cnt=1;
        for(int i=0; i<=len+1; i+=2) {
            if(i == len) { //배열의 뒤에서 두번째걸 가르키고 있으면 0번 인덱스로
                i=0;
            } else if(i == len+1) { //배열의 제일 마지막걸 가르키고 있으면 1번 인덱스로
                i=1;
            }
            if(cnt==k) { //k번째가 되면 return
                answer = numbers[i];
                break;
            } else { 
                cnt++;                
            }
        }
        return answer;
    }
}