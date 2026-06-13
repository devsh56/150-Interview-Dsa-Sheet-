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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
       return getTreeNode(0,inorder.length-1,inorder,0,postorder.length-1,postorder,map);
    }
    public static TreeNode getTreeNode(int instart,int inend,int [] in,int postart,int poend,int[]po, HashMap<Integer,Integer>map){
        if(instart > inend || postart > poend ) return null;
        int root = map.get(po[poend]);
        int dis = root-instart;
        TreeNode mm =new TreeNode(in[root]);
        mm.left = getTreeNode(instart,root-1,in,postart,postart+dis-1,po,map);
        mm.right = getTreeNode(root+1,inend,in,postart+dis,poend-1,po,map);
         return mm;
    }
}


// Inorder → Left → Root → Right ✅
// Preorder → Root → Left → Right ✅
// Postorder → Left → Right → Root ✅