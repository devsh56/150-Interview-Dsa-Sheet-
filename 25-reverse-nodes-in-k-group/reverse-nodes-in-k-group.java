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
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode PrevNextNode = null;
        ListNode NewHead = null;
        ListNode temp = head;
        while(temp != null){
            ListNode kth = countNode(temp,k);
            if(kth == null){
                if(PrevNextNode != null) PrevNextNode.next = temp;
                break;
            }
            ListNode nextNode = kth.next;
            kth.next = null;
            ListNode reverse = reverse(temp);
            if(NewHead == null) NewHead = reverse;
            else{
            PrevNextNode.next = reverse;
            }
            temp.next = nextNode;
            PrevNextNode=temp;
            temp=temp.next;
        }
        return NewHead == null ? head : NewHead;
    }
    public static ListNode countNode(ListNode temp,int k){
        int count = 1;
       while(temp != null && count < k){
    temp = temp.next;
    count++;
}
        return temp;
    }
    public static ListNode reverse(ListNode temp){
        ListNode prev = null;
        while(temp != null){
            ListNode next = temp.next;
            temp.next=prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}