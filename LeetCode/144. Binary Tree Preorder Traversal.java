/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root == null){
            return list;
        }    
        preOrder(list, root);
        return list;
    }
    public void preOrder(List<Integer> list, TreeNode node){
        if(node == null){
            return;
        }
        list.add(node.val);
        preOrder(list, node.left);
        preOrder(list, node.right);
    }
}