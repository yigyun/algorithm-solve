package leetcode.Array_String;

class IntegerToRoman_12 {

    static String str;

    public String intToRoman(int num) {
        str = "";
        int[] array = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for(int number : array){
            num = cal(num, number);
        }

        return str;
    }

    static int cal(int num, int val){
        int quo = num / val;
        int rem = num % val;
        if(quo != 0){
            String s = "";
            if(val == 1000) s = "M";
            else if(val == 900) s ="CM";
            else if(val == 500) s = "D";
            else if(val == 400) s = "CD";
            else if(val == 100) s = "C";
            else if(val == 90) s = "XC";
            else if(val == 50) s = "L";
            else if(val == 40) s = "XL";
            else if(val == 10) s = "X";
            else if(val == 9) s = "IX";
            else if(val == 5) s = "V";
            else if(val == 4) s = "IV";
            else if(val == 1) s = "I";
            for(int i = 0; i < quo; i++) str += s;
            return rem;
        }
        return num;
    }
}