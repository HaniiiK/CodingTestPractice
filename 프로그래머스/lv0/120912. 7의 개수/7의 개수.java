class Solution {
    public int solution(int[] array) {
        int answer = 0;
        String[] str = new String[array.length];
        for(int i=0; i<array.length; i++) {
            str[i] = array[i]+"";
        }
        String fin = null;
        for(int i=0; i<str.length; i++) {
            fin += str[i];
        }
        
        for(int i=0; i<fin.length(); i++) {
            if(fin.charAt(i)=='7') {
                answer ++;
            }
        }
        return answer;
    }
}