package leetcode.TwoPointers.easy;

class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {

        int front = 0;
        int rear = s.length()-1;

        char fc = ' ';
        char rc = ' ';

        if(rear == 0) return true;

        while(front != rear){
            fc = s.charAt(front);
            rc = s.charAt(rear);
            if(!Character.isAlphabetic(fc) & !Character.isDigit(fc)){
                front++;
                continue;
            } else if(!Character.isAlphabetic(rc) & !Character.isDigit(rc)){
                rear--;
                continue;
            }
            if(Character.toLowerCase(fc) == Character.toLowerCase(rc) || fc == rc){
                front++;
                rear--;
                if(front == rear || front > rear) return true;
                continue;
            }else{
                return false;
            }
        }

        return true;
    }
}