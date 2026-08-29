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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null;
        ListNode cur = head;
        if (head == null) {return head;}

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        
        ListNode bug = prev;
        int nth = n-1;
        if (nth == 0) {        
            prev = prev.next;
        } else {
            while (nth > 0) {
                if (nth == 1) {
                    bug.next = bug.next.next;
                    break;
                }
                bug = bug.next;
                nth--;
            }
        }   
        ListNode cur2 = prev;
        ListNode prev2 = null;
        while (cur2 != null) {
            ListNode temp = cur2.next;
            cur2.next = prev2;
            prev2 = cur2;
            cur2 = temp;
        }

    return prev2;
    }
}
