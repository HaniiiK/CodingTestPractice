import java.util.*;

class Solution {
    
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String[] file1 = detach(s1);
                String[] file2 = detach(s2);
                
                if(file1[0].equals(file2[0])) {
                    return Integer.parseInt(file1[1]) - Integer.parseInt(file2[1]);
                }
                return file1[0].compareTo(file2[0]);
            }            
        });
        
        return files;
    }
    
    public String[] detach(String s) {
        String head = "";
        String number = "";
        String tail = "";
        
        int idx = 0;
        for(; idx<s.length(); idx++) {
            if(s.charAt(idx)>='0' && s.charAt(idx)<='9') {
                break;
            }
            head += s.charAt(idx);
        }

        int cnt = 0;
        for(; idx<s.length(); idx++) {
            if(s.charAt(idx)>='0' && s.charAt(idx)<='9') {
                number += s.charAt(idx);
                cnt++;
                if(cnt==5) {
                    idx++;
                    break;
                }
            }else {
                break;
            }
        }
//        System.out.println(number);
        
        for(; idx<s.length(); idx++) {
            tail += s.charAt(idx);
        }
        
        String[] file = {head.toLowerCase(), number, tail};
        return file;
    }
}