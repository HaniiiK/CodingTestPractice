class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] cnt = new int[8]; //R T / C F / J M / A N 순서
        String[][] letter = {{"R","T"}, {"C","F"}, {"J","M"}, {"A","N"}};
        
        for(int i=0; i<survey.length; i++) {
            switch(survey[i]) {
                case "RT":
                    if(choices[i]<4) {
                        cnt[0] += 4-choices[i];
                    }else if(choices[i]>4) {
                        cnt[1] += choices[i]-4;
                    }                   
                    break;
                case "TR":
                    if(choices[i]<4) {
                        cnt[1] += 4-choices[i];
                    }else if(choices[i]>4) {
                        cnt[0] += choices[i]-4;
                    }                    
                    break;
                case "CF":
                    if(choices[i]<4) {
                        cnt[2] += 4-choices[i];
                    }else if(choices[i]>4) {
                        cnt[3] += choices[i]-4;
                    }                    
                    break;
                case "FC":
                    if(choices[i]<4) {
                        cnt[3] += 4-choices[i];
                    }else if(choices[i]>4) {
                        cnt[2] += choices[i]-4;
                    }
                    break;
                case "JM":
                    if(choices[i]<4) {
                        cnt[4] += 4-choices[i];
                    }else if(choices[i]>4) {
                        cnt[5] += choices[i]-4;
                    }
                    break;
                case "MJ":
                    if(choices[i]<4) {
                        cnt[5] += 4-choices[i];
                    }else if(choices[i]>4) {
                        cnt[4] += choices[i]-4;
                    }
                    break;
                case "AN":
                    if(choices[i]<4) {
                        cnt[6] += 4-choices[i];
                    }else if(choices[i]>4) {
                        cnt[7] += choices[i]-4;
                    }
                    break;
                case "NA":
                    if(choices[i]<4) {
                        cnt[7] += 4-choices[i];
                    }else if(choices[i]>4) {
                        cnt[6] += choices[i]-4;
                    }
                    break;
            }
        }
        
        for(int i=0; i<4; i++) {
            if(cnt[i*2]>=cnt[i*2+1]) {
                answer += letter[i][0];
            }else if(cnt[i*2]<cnt[i*2+1]) {
                answer += letter[i][1];
            }
        }
        
//         if(cnt[0]>=cnt[1]) {
//             answer += "R";
//         }else if(cnt[0]<cnt[1]) {
//             answer += "T";
//         }

//         if(cnt[2]>=cnt[3]) {
//             answer += "C";
//         }else if(cnt[2]<cnt[3]) {
//             answer += "F";
//         }

//         if(cnt[4]>=cnt[5]) {
//             answer += "J";
//         }else if(cnt[4]<cnt[5]) {
//             answer += "M";
//         }

//         if(cnt[6]>=cnt[7]) {
//             answer += "A";
//         }else if(cnt[6]<cnt[7]) {
//             answer += "N";
//         }
        return answer;
    }
}