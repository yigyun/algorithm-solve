package leetcode.LinkedList;

public class LinkedListCycle_141 {
    static public class Solution {
        public boolean hasCycle(ListNode head) {

            ListNode front = head;
            ListNode second = head;

            while(front != null && front.next != null){
                front = front.next.next;
                second = second.next;
                if(front == second) return true;
            }

            return false;
        }
    }

    static class ListNode {
   int val;
    ListNode next;
   ListNode(int x) {
        val = x;
       next = null;
   }
    }
}
