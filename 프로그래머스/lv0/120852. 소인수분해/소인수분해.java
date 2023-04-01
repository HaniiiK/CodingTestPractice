import java.util.ArrayList;

class Solution {
    public ArrayList solution(int n) {
        ArrayList<Integer> list = new ArrayList(); //2 이상의 약수를 저장한 list
        for(int i=2; i<=n; i++) {
            if(n%i==0) {
                list.add(i);                
            }
        }

        ArrayList<Integer> answer = new ArrayList();
        int chk=0;
        for(int i=0; i<list.size(); i++) {
            chk=0;
            for(int j=2; j<=list.get(i); j++) { //각각의 약수가 소수인지
                if(list.get(i)%j==0) {
                    chk++;
                }
            }
            if(chk==1) {
                answer.add(list.get(i));
            }
        }        
        return answer;
    }
}