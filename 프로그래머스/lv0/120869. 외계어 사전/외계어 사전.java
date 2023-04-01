class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        int flag=0;
        for(int i=0; i<dic.length; i++) {
            flag = 0;
            for(int j=0; j<spell.length; j++) {
                if(dic[i].contains(spell[j])) {
                    continue;                        
                } else {
                    flag = 1;
                    break;
                }
            }
            if(flag==0) {
                answer = 1;
                break;
            }
        }
        return answer;
    }
}