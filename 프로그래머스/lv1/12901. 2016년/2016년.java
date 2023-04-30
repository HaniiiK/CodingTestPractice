import java.util.Calendar;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, 2016);
        date.set(Calendar.MONTH, a-1);
        date.set(Calendar.DATE, b);
        
        switch(date.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                answer = "SUN";
                break;
            case 2:
                answer = "MON";
                break;
            case 3:
                answer = "TUE";
                break;
            case 4:
                answer = "WED";
                break;
            case 5:
                answer = "THU";
                break;
            case 6:
                answer = "FRI";
                break;
            case 7:
                answer = "SAT";
                break;                
        }
        return answer;
    }
}