class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        int[] stu1 = {1, 2, 3, 4, 5};
        int[] stu2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] stu3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] cnt= new int[3];
        
        for(int i=0; i<answers.length; i++) {
            if(answers[i]==stu1[i%stu1.length]) {
                cnt[0]++;
            }
            if(answers[i]==stu2[i%stu2.length]) {
                cnt[1]++;
            }
            if(answers[i]==stu3[i%stu3.length]) {
                cnt[2]++;
            }
        }

        int max = cnt[0];
        int tmp = 0;
        int chk = 1;
        for(int i=1; i<3; i++) {
            if(cnt[i]>max) {
                max = cnt[i];
                tmp = i;
            }else if(cnt[i]==max) {
                chk++;
            }            
        }
        
        if(chk==1) {
            return new int[] {tmp+1};
    //        answer = new int[] {1};
        }else if(chk==2) {
            if(cnt[0]==cnt[1]) {
                return new int[] {1,2};
           //     answer = new int[] {1,2};
            }else if(cnt[0]==cnt[2]) {
                return new int[] {1,3};
         //       answer = new int[] {1,3};
            }else if(cnt[1]==cnt[2]) {
                return new int[] {2,3};
       //         answer = new int[] {2,3};
            }               
        }else {
            return new int[] {1,2,3};
     //       answer = new int[] {1,2,3};            
        }
        return null;
    }
}