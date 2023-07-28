import java.util.*;

class Solution {
    
    List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();    
    
    public int solution(String str1, String str2) {
        int answer = 0;

        //대소문자 구분 x
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        //집합 생성
        String[] arr1 = new String[str1.length()-1];
        String[] arr2 = new String[str2.length()-1];        
        for(int i=0; i<str1.length()-1; i++) {
            arr1[i] = str1.substring(i,i+2);
        }
        for(int i=0; i<str2.length()-1; i++) {
            arr2[i] = str2.substring(i,i+2);
        }
        
        //영문자만 유효
        makeList(arr1, list1);
        makeList(arr2, list2);
        
        //교집합
        int intersec = 0;
        for(int i=0; i<list1.size(); i++) {
            if(list2.contains(list1.get(i))) {
                int idx = list2.lastIndexOf(list1.get(i));
                list1.set(i, "0"); //겹치지 않을 아무 임의의 문자로 변경
                list2.set(idx, "-1");
                intersec++;
            }
        }
        if(intersec==0 && list1.size()+list2.size()-intersec==0) {
            answer = 65536;
        }else {
            answer = 65536 * intersec / (list1.size() + list2.size() - intersec);            
        }
        
        return answer;
    }
    
    public void makeList(String[] arr, List list) {
        boolean alphabetOnly = true;
        for(int i=0; i<arr.length; i++) {
            alphabetOnly = true;
            for(int j=0; j<arr[i].length(); j++) {
                if(!(arr[i].charAt(j)>='a' && arr[i].charAt(j)<='z')) {
                    alphabetOnly = false;
                    break;
                }                
            }
            if(alphabetOnly) {
                list.add(arr[i]);
            }
        }
    }
}