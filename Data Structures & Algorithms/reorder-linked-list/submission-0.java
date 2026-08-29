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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode cons = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // mid = slow
        ListNode mid = slow;
        ListNode rev = null;
        
        while (mid != null) {
            ListNode temp = mid.next;
            mid.next = rev;
            rev = mid;
            mid = temp;
        }

        ListNode merge = head;
        while (rev != null && merge != null) {
            ListNode temp = merge.next;
            ListNode tRev = rev.next;
            
            merge.next = rev;
            rev.next = temp;
            merge = temp;
            rev = tRev;
        }
        
     




    }
   
}
