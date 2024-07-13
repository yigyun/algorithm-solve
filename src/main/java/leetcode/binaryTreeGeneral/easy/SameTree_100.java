package leetcode.binaryTreeGeneral.easy;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree_100 {



      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
     }


    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if((p == null && q != null) || (p != null && q == null)) return false;
            return bfs(p, q);
        }

        static boolean bfs(TreeNode p, TreeNode q){
            Queue<TreeNode> pq = new LinkedList<>();
            Queue<TreeNode> qq = new LinkedList<>();
            pq.add(p);
            qq.add(q);

            while(!pq.isEmpty() && !qq.isEmpty()){
                TreeNode pt = pq.poll();
                TreeNode qt = qq.poll();
                if(pt == null && qt == null) continue;
                else if((pt == null && qt != null) || (pt != null && qt == null)) return false;;

                if(pt.val == qt.val){
                    pq.add(pt.left); pq.add(pt.right);
                    qq.add(qt.left); qq.add(qt.right);
                } else {
                    return false;
                }
            }

            if(!pq.isEmpty() || !qq.isEmpty()) return false;
            return true;
        }
    }
}
