import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char[] c = skip.toCharArray();
        Arrays.sort(c);
        
        char[] arr = new char[26-skip.length()];
        int idx_arr = 0;
        int idx_skip = 0;
        for(int i=0; i<26; i++) {   //skip 없는 알파벳들 -> list에 담았음
            if(idx_skip<c.length && i==c[idx_skip]-'a') {
                idx_skip++;
                continue;
            }
            arr[idx_arr] = (char)(i+'a');
            idx_arr++;
        }
        
        for(int i=0; i<s.length(); i++) {
            for(int j=0; j<arr.length; j++) {
                if(s.charAt(i)==arr[j]) {
                    answer += (char)(arr[(j+index)%arr.length]);
                }
            }
        }
        
        
//         List<Character> list = new ArrayList<>();
//         int idx=0;
//         for(int i=0; i<26; i++) {   //skip 없는 알파벳들 -> list에 담았음
//             if(idx<c.length && i==c[idx]-'a') {
//                 idx++;
//                 continue;
//             }
//             list.add((char)(i+'a'));
//         }
        
//         for(int i=0; i<s.length(); i++) {
//             System.out.println(list.get("a"));
//             answer += list.get((s.charAt(i)-'a'+index)%list.size());
//         }
        
//        char[] c = new char[s.length()];      
//         for(int i=0; i<s.length(); i++) {
//             c[i] = (char)((s.charAt(i)+index)%122);
//             for(int j=0; j<skip.length(); j++) {
//                 if(s.charAt(i) < skip.charAt(j) && s.charAt(i)+index > skip.charAt(j)) {
// //                    System.out.println(skip.charAt(j));
//                     c[i]++;
//                 }
//             }
//             System.out.println(c[i]);
//         }
        return answer;
    }
}