class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        double[] avg = new double[score.length];
        
        for(int i=0; i<score.length; i++) {
            avg[i] = (double)(score[i][0] + score[i][1])/2;
            System.out.println(avg[i]);
            answer[i] = 1;
        }
        
        for(int i=0; i<score.length; i++) {
            for(int j=0; j<score.length; j++) {
                if(i!=j && avg[i]<avg[j]) {
                    answer[i]++;
                }
            }
        }
        
        
        
        
        
        
        
        
//         int len = score.length;
//         int[] avg = new int[len];
//         int[] answer = new int[len];
                
//         for(int i=0; i<len; i++) {
//             avg[i] = (score[i][0] + score[i][1]) /2;
//             answer[i] = 1;
//         }
        
//         for(int i=0; i<len; i++) {
//             for(int j=0; j<len; j++) {
//                 if(i!=j && avg[i]<avg[j]) {
//                     answer[i]++;
//                 }
//             }
//         }
        
        return answer;
    }
}