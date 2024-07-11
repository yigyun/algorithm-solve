package leetcode.LinkedList.medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer_138 {


        static class Node {
            int val;
            Node next;
            Node random;

            public Node(int val) {
                this.val = val;
                this.next = null;
                this.random = null;
            }
        }


    static class Solution {
        public Node copyRandomList(Node head) {

            if(head == null) return head;

            Map<Node, Node> map = new HashMap<>();

            Node result = head;

            while(head != null){
                map.put(head, new Node(head.val));
                head = head.next;
            }

            head = result;
            while(head != null){
                map.get(head).next = map.get(head.next);
                map.get(head).random = map.get(head.random);
                head = head.next;
            }

            return map.get(result);
        }
    }
}
