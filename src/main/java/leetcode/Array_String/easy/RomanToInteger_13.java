package leetcode.Array_String.easy;

class RomanToInteger_13 {
    public int romanToInt(String s) {
        int sum = 0;
        char[] array = s.toCharArray();
        int number = 0;
        for(int i = array.length-1; i >= 0; i--){
            if(array[i] == 'I'){
                sum += 1;
                if(number == 5 || number == 10) sum -= 2;
                number = 1;
            }
            else if(array[i] == 'V'){
                sum += 5;
                number = 5;
            }else if(array[i] == 'X'){
                sum += 10;
                if(number == 50 || number == 100) sum -= 20;
                number = 10;
            }else if(array[i] == 'L'){
                sum += 50;
                number = 50;
            }else if(array[i] == 'C'){
                sum += 100;
                if(number == 500 || number == 1000) sum -= 200;
                number = 100;
            }else if(array[i] == 'D'){
                sum += 500;
                number = 500;
            }else if(array[i] == 'M'){
                sum += 1000;
                number = 1000;
            }
        }


        return sum;
    }
}