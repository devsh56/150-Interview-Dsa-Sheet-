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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> pq = new LinkedList<TreeNode>();
         List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        pq.add(root);
        while(!pq.isEmpty()){
            int size = pq.size();
            for(int i =0 ;i<size;i++){
                TreeNode firstNode = pq.poll();
                if(firstNode.left != null) pq.add(firstNode.left);
                if(firstNode.right != null)pq.add(firstNode.right);
                if(i == size-1) ans.add(firstNode.val);
            }
        }
        return ans;
    }
}