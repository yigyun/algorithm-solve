package leetcode.LinkedList.medium;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList_19 {

     public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            List<ListNode> list = new ArrayList<>();
            ListNode result = head;
            while(head != null){
                list.add(head);
                head = head.next;
            }
            if(list.size() - n == 0){
                result = result.next;
            }else{
                ListNode node = list.get(list.size()-n-1);

                if(list.size()-1 == list.size()-n) node.next = null;
                else node.next = list.get(list.size()-n+1);
            }
            return result;
        }
    }
}
