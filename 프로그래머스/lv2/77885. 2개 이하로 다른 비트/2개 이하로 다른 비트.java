class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
            if(numbers[i]%2==0) {
                answer[i] = numbers[i]+1;
            }else {
                String binary = Long.toBinaryString(numbers[i]);
                String newBinary = "";
                binary = "0".concat(binary);
//                System.out.println("binary="+binary);
                int j;
                for(j=binary.length()-1; j>=0; j--) {
                    if(binary.charAt(j)=='0') {
                        newBinary = newBinary.substring(1);
                        newBinary = "10".concat(newBinary);
                        j--;
//                        System.out.println(newBinary);
                        break;
                    }else {
                        newBinary = (binary.charAt(j)+"").concat(newBinary);
                    }
//                    System.out.println(newBinary);
                }
                if(j>0) {
                    newBinary = (binary.substring(0,j+1)).concat(newBinary);
                }
//                System.out.println(newBinary);
                answer[i] = Long.parseLong(newBinary, 2);
            }
        }
        
        return answer;
    }
}