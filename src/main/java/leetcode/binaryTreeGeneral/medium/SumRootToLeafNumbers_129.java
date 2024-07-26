package leetcode.binaryTreeGeneral.medium;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers_129 {

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

        static List<String> list;

        public int sumNumbers(TreeNode root) {

            list = new ArrayList<>();

            preorder(root, "");

            int sum = 0;
            for(String num : list){
                sum += Integer.parseInt(num);
            }
            return sum;
        }

        static void preorder(TreeNode node, String str){
            if(node != null){
                str += Integer.toString(node.val);
                if(node.left != null) preorder(node.left, str);
                if(node.right != null) preorder(node.right, str);
            }
            if(node.left == null && node.right == null){
                list.add(str);
            }
        }
    }
}
