class Solution {
    public String solution(int age) {
        String answer = "";
        String arr = age+"";
        char[] a = new char[arr.length()];
        for(int i=0; i<arr.length(); i++) {
            if(arr.charAt(i)=='0') {
                a[i] = 'a';              
            } else if(arr.charAt(i)=='1') {
                a[i] = 'b';              
            } else if(arr.charAt(i)=='2') {
                a[i] = 'c';              
            } else if(arr.charAt(i)=='3') {
                a[i] = 'd';              
            } else if(arr.charAt(i)=='4') {
                a[i] = 'e';              
            } else if(arr.charAt(i)=='5') {
                a[i] = 'f';              
            } else if(arr.charAt(i)=='6') {
                a[i] = 'g';              
            } else if(arr.charAt(i)=='7') {
                a[i] = 'h';              
            } else if(arr.charAt(i)=='8') {
                a[i] = 'i';              
            } else if(arr.charAt(i)=='9') {
                a[i] = 'j';              
            }
        }
        answer = String.valueOf(a);
        return answer;
    }
}