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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode a = list1;
        ListNode b = list2;
        ListNode res = null;
        ListNode head = null;

        if (a == null & b == null) {
            return res;
        }
        else if (a == null) {
            return b;
        
        }
        else if (b == null) {
            return a;
        
        } 
        else {
            // very first check
            if (a.val <= b.val) {
                ListNode temp = a.next;
                res = a;
                a = temp;
                

            } else {
                ListNode temp = b.next;
                res = b;
                b = temp;
            }
            head = res;
            while (a != null && b != null) {
                if (a.val <= b.val) {
                    ListNode temp = a.next;
                    res.next = a;
                    a = temp;
                } else {        
                    ListNode temp = b.next;
                    res.next = b;
                    b = temp;
                }
                res = res.next;
            }

        }
        while (a != null) {
            ListNode temp = a.next;
            res.next = a;
            a = temp;
            res = res.next;
        }
        
        while (b != null) {
            ListNode temp = b.next;
            res.next = b;
            b = temp;
            res = res.next;
        }
        return head;
    }
}