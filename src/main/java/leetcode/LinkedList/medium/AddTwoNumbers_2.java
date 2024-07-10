package leetcode.LinkedList.medium;
import java.util.*;

public class AddTwoNumbers_2 {


     public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    static
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            List<Integer> list = new ArrayList<>();

            int number1 = 0;
            int number2 = 0;
            boolean check = false;

            while(l1 != null || l2 != null){

                if(l1 != null){
                    number1 = l1.val;
                    l1 = l1.next;
                }
                else number1 = 0;
                if(l2 != null){
                    number2 = l2.val;
                    l2 = l2.next;
                }
                else number2 = 0;

                int sum = number1 + number2;
                if(check) sum += 1;
                if(sum >= 10){
                    check = true;
                    sum %= 10;
                } else check = false;

                list.add(sum);
            }
            if(check) list.add(1);


            ListNode head = new ListNode();
            ListNode node = head;

            for(int i = 0; i < list.size(); i++){
                node.val = list.get(i);
                if(i+1 < list.size()){
                    node.next = new ListNode();
                    node = node.next;
                }
            }

            return head;
        }
    }
}
