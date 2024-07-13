package leetcode.LinkedList.medium;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesFromSortedList2_82 {
     public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null) return head;
            List<ListNode> list = new ArrayList<>();
            int number = head.val;
            int count = 0;
            while(head != null){
                if(number == head.val){
                    count++;
                } else {
                    if(count == 1){
                        list.add(new ListNode(number));
                    }
                    number = head.val;
                    count = 1;
                }
                head = head.next;
            }
            if(count == 1){
                list.add(new ListNode(number));
            }
            if(list.size() == 0) return null;
            for(int i = 0; i < list.size()-1; i++){
                ListNode node = list.get(i);
                node.next = list.get(i+1);
            }
            return list.get(0);
        }
    }
}
