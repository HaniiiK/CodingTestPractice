class Solution {
    public int[] solution(int[] numbers, String direction) {
        int len = numbers.length;
        int[] answer = new int[len];

        if(direction.equals("right")) {
            int first = numbers[len-1];
            for(int i=1; i<len; i++) {
                answer[i] = numbers[i-1];
            }
            answer[0] = first;
        } else if(direction.equals("left")) {
            int last = numbers[0];
            for(int i=0; i<len-1; i++) {
                answer[i] = numbers[i+1];
            }
            answer[len-1] = last;
        }
        return answer;
    }
}