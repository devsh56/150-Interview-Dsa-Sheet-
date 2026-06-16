/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return GetLCA(root,p,q);
    }
    public static TreeNode GetLCA(TreeNode root,TreeNode p , TreeNode q){
        if(root.left == null && root.right == null){
            if(root == p || root == q){
                return root;
            }else{
                return null;
            }
        }
        TreeNode left = null;
        TreeNode right = null;

        if(root.left != null){
            left = GetLCA(root.left,p,q);
        }
        if(root.right != null){
            right = GetLCA(root.right,p,q);
        }
        if(left != null && right != null){
            return root;
        }else if(left != null ){
            if(root == p || root ==q){
                return root;
            }else{
                return left;
            }
        }else{
            if(root == p || root ==q){
                return root;
            }else{
                return right;
            }
        }
    }
}