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
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        //ListNode tail = head;
        if (head == null) {return false;}
        while (head.next != null) {

            if (seen.contains(head.next)) {
                return true;
            }
            seen.add(head.next);
            head = head.next;
        }
        return false;
    }
}
