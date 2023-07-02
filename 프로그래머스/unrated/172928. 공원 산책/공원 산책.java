class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        char[][] arr = new char[park.length][park[0].length()];
        for(int i=0; i<park.length; i++) { //park를 char[][]에 넣어주기
            for(int j=0; j<park[i].length(); j++) {
                arr[i][j] = park[i].charAt(j);
            }
        }

        for(int i=0; i<park.length; i++) { //시작 위치 찾기
            if(park[i].contains("S")) {
                answer[0] = i;
                answer[1] = park[i].indexOf("S");
                break;
            }
        }
        
        int distance = 0; //이동할 거리
        boolean chk = true; //장애물 있는지 chk
        for(int i=0; i<routes.length; i++) {
            distance = Integer.parseInt(routes[i].substring(2));
            chk = true;

            switch(routes[i].charAt(0)) {
                case 'E':
                    if(answer[1]+distance<park[0].length()) {
                        for(int j=1; j<=distance; j++) {
                            if(arr[answer[0]][answer[1]+j] == 'X') {
                                chk = false;
                                break;
                            }
                        }
                    }else {
                        chk = false;
                    }
                    if(chk) {
                        answer[1] += distance;
                    }
                    break;
                case 'W':
                    if(answer[1]-distance>=0) {
                        for(int j=1; j<=distance; j++) {
                            if(arr[answer[0]][answer[1]-j] == 'X') {
                                chk = false;
                                break;
                            }
                        }
                    }else {
                        chk = false;
                    }
                    if(chk) {
                        answer[1] -= distance;
                    }
                    break;
                case 'S':
                    if(answer[0]+distance<park.length) {
                        for(int j=1; j<=distance; j++) {
                            if(arr[answer[0]+j][answer[1]] == 'X') {
                                chk = false;
                                break;
                            }
                        }
                    }else {
                        chk = false;
                    }
                    if(chk) {
                        answer[0] += distance;
                    }
                    break;
                case 'N':
                    if(answer[0]-distance>=0) {
                        for(int j=1; j<=distance; j++) {
                            if(arr[answer[0]-j][answer[1]] == 'X') {
                                chk = false;
                                break;
                            }
                        }
                    }else {
                        chk = false;
                    }
                    if(chk) {
                        answer[0] -= distance;
                    }
                    break;
            }
//            System.out.println(answer[0]+", "+answer[1]);
        }
        
        
        return answer;
    }
}