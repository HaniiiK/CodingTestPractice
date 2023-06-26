class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        new_id = new_id.toLowerCase(); //1단계
        // for(int i=0; i<new_id.length(); i++) { //2단계
        //     if((new_id.charAt(i)>='0' && new_id.charAt(i)<='9') ||
        //        (new_id.charAt(i)>='a' && new_id.charAt(i)<='z') ||
        //        new_id.charAt(i)=='-' || new_id.charAt(i)=='_' ||
        //        new_id.charAt(i)=='.') {
        //         answer += new_id.charAt(i);
        //     }
        // }
        answer = new_id.replaceAll("[^a-z0-9|[-]|[_]|[.]]", ""); //2단계

        answer = answer.replaceAll("[.]*[.]", "."); //3단계
        if(answer.charAt(0)=='.') { //4단계
            answer = answer.substring(1);
        }
        if(!answer.isEmpty() && answer.charAt(answer.length()-1)=='.') {
            answer = answer.substring(0, answer.length()-1);
        }

        if(answer.isEmpty()) { //5단계
            answer = "a";
        }
        
        if(answer.length()>=16) { //6단계
            answer = answer.substring(0, 15);
            if(answer.charAt(answer.length()-1)=='.') {
                answer = answer.substring(0, answer.length()-1);
            }
        }
        
        if(answer.length()<=2) {
            while(answer.length()<3) {
                answer += answer.charAt(answer.length()-1);
            }
        }
        System.out.println(answer);
                
        return answer;
    }
}