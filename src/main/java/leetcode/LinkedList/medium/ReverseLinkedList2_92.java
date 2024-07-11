package leetcode.LinkedList.medium;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList2_92 {

     public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    static class reverse {
        public ListNode reverseBetween(ListNode head, int left, int right) {

            if(head == null) return null;
            left -= 1;
            right -= 1;

            List<ListNode> list = new ArrayList<>();

            while(head != null){
                list.add(head);
                head = head.next;
            }

            for(int i = 0; i < list.size(); i++){
                if(left >= right){
                    break;
                } else if(i == left){
                    ListNode temp = list.get(right);
                    list.set(right, list.get(i));
                    list.set(i, temp);
                    left++; right--;
                }
            }

            for(int i = 0; i < list.size(); i++){
                ListNode temp = list.get(i);
                if(i == list.size()-1){
                    temp.next = null; break;
                }
                temp.next = list.get(i+1);
            }

            return list.get(0);
        }
    }
}
