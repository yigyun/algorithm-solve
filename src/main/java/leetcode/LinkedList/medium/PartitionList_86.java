package leetcode.LinkedList.medium;

public class PartitionList_86 {

     public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    static class Solution {
        public ListNode partition(ListNode head, int x) {
            if(head == null) return head;
            ListNode high = null;
            ListNode lower = null;
            ListNode temp = null;
            ListNode result = null;
            if(head.val < x) {lower = new ListNode(head.val); result = lower;}
            else { high = new ListNode(head.val); temp = high;}
            head = head.next;

            while(head != null){
                if(head.val < x){
                    if(lower == null){
                        lower = new ListNode(head.val);
                        result = lower;
                    }else{
                        lower.next = new ListNode(head.val);
                        lower = lower.next;
                    }
                } else{
                    if(high == null){
                        high = new ListNode(head.val);
                        temp = high;
                    }else{
                        high.next = new ListNode(head.val);
                        high = high.next;
                    }
                }
                head = head.next;
            }

            if(lower == null){
                return temp;
            } else if(high == null){
                return result;
            }
            lower.next = temp;
            return result;
        }
    }
}
