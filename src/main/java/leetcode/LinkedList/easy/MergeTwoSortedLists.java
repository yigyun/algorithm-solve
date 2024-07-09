package leetcode.LinkedList.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeTwoSortedLists {
    static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            List<Integer> list = new ArrayList<>();
            while(list1 != null){
                list.add(list1.val);
                list1 = list1.next;
            }
            while(list2 != null){
                list.add(list2.val);
                list2 = list2.next;
            }

            Collections.sort(list);

            if(list.size() == 0) return null;

            ListNode node = new ListNode(list.get(0));
            ListNode nl = node;
            for(int i = 1; i < list.size(); i++){
                node.next = new ListNode(list.get(i));
                node = node.next;
            }

            return nl;
        }
    }
}
