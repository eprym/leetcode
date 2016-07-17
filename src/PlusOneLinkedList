/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        if(head == null)    return null;
        int val = plusOneHelper(head);
        if(val > 0){
            ListNode dummy = new ListNode(val);
            dummy.next = head;
            return dummy;
        }
        else return head;
    }
    
    private int plusOneHelper(ListNode head){
        if(head.next == null)   head.val++;
        else    head.val += plusOneHelper(head.next);
        int carry = 0;
        if(head.val > 9){
            carry = 1;
            head.val %= 10;
        }
        return carry;
    }
}
