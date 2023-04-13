class Solution {
    public String[] solution(String my_str, int n) {
        String str = "";
        
        while(my_str.length()>0){
             
            //n개만큼 앞에서부터 자르고 자른 문자열은 삭제처리하는 방식
            if(my_str.length()>=n){
                str += my_str.substring(0, n) + " ";
                my_str = my_str.substring(n);
//                my_str = my_str.replace(my_str.substring(0, n), "");
                System.out.println(my_str);
                }
else{ //마지막에 남은 개수가 n이 아닐 때 오류 해결 불가
                str +=my_str.substring(0,my_str.length());
                my_str = "";
                }
        
        }
        String[] arr = str.split(" ");
       System.out.println(arr.length);
            return str.split(" ");
              
        
        /*String[] answer = new String[(my_str.length()+n-1)/n];
        int index=0;
        for(int i=0; i<my_str.length(); i++) {
            if(i!=0 && i%n==0) {
                index++;
            }
            answer[index] += my_str.charAt(i);            
        }*/
        
        
/*        String[] answer = new String[(my_str.length()+n-1)/n];    
        for(int i=0; i<answer.length; i++) {
            answer[i] = "";
        }
        
        int index=0;
        for(int i=0; i<my_str.length(); i++) {
            if(i!=0 && i%n==0) {
                index++;
            }
            answer[index] += my_str.charAt(i);         
        }*/
       // return answer;
    }
}