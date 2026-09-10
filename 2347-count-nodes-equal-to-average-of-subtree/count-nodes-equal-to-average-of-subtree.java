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
    int ans=0;
    public int averageOfSubtree(TreeNode root) {
        find(root);
        return ans;
    }
    public int[] find(TreeNode node){
        if(node==null){
            return new int[]{0,0};
        }
        int[] left=find(node.left);
        int[] right=find(node.right);
        int avg=(int)Math.ceil(node.val+left[0]+right[0])/(left[1]+right[1]+1);
        if(node.val==avg){
            ans++;
        }
        return new int[]{node.val+left[0]+right[0],left[1]+right[1]+1};
    }
}