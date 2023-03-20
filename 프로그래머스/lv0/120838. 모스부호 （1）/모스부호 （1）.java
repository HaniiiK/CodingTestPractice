class Solution {
    public String solution(String letter) {
        String answer = "";
        String[] arr = letter.split(" ");
        char[] str = new char[arr.length];
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals(".-")) {
                str[i] = 'a';
            } else if(arr[i].equals("-...")) {
                str[i] = 'b';
            } else if(arr[i].equals("-.-.")) {
                str[i] = 'c';
            } else if(arr[i].equals("-..")) {
                str[i] = 'd';
            } else if(arr[i].equals(".")) {
                str[i] = 'e';
            } else if(arr[i].equals("..-.")) {
                str[i] = 'f';
            } else if(arr[i].equals("--.")) {
                str[i] = 'g';
            } else if(arr[i].equals("....")) {
                str[i] = 'h';
            } else if(arr[i].equals("..")) {
                str[i] = 'i';
            } else if(arr[i].equals(".---")) {
                str[i] = 'j';
            } else if(arr[i].equals("-.-")) {
                str[i] = 'k';
            } else if(arr[i].equals(".-..")) {
                str[i] = 'l';
            } else if(arr[i].equals("--")) {
                str[i] = 'm';
            } else if(arr[i].equals("-.")) {
                str[i] = 'n';
            } else if(arr[i].equals("---")) {
                str[i] = 'o';
            } else if(arr[i].equals(".--.")) {
                str[i] = 'p';
            } else if(arr[i].equals("--.-")) {
                str[i] = 'q';
            } else if(arr[i].equals(".-.")) {
                str[i] = 'r';
            } else if(arr[i].equals("...")) {
                str[i] = 's';
            } else if(arr[i].equals("-")) {
                str[i] = 't';
            } else if(arr[i].equals("..-")) {
                str[i] = 'u';
            } else if(arr[i].equals("...-")) {
                str[i] = 'v';
            } else if(arr[i].equals(".--")) {
                str[i] = 'w';
            } else if(arr[i].equals("-..-")) {
                str[i] = 'x';
            } else if(arr[i].equals("-.--")) {
                str[i] = 'y';
            } else if(arr[i].equals("--..")) {
                str[i] = 'z';
            }
        }
        answer = String.valueOf(str);
        return answer;
    }
}