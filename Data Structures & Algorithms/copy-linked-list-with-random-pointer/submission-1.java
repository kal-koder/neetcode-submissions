/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
 public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Pass 1: Create cloned nodes and interleave them (A -> A' -> B -> B')
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        // Pass 2: Assign random pointers for cloned nodes
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next; // cur.next is copy, cur.random.next is copy of random
            }
            cur = cur.next.next;
        }

        // Pass 3: Unweave original list and copied list
        cur = head;
        Node dummyHead = new Node(0);
        Node copyCur = dummyHead;

        while (cur != null) {
            Node nextOriginal = cur.next.next;

            // Extract the copy node
            Node copy = cur.next;
            copyCur.next = copy;
            copyCur = copy;

            // Restore original list pointer
            cur.next = nextOriginal;

            cur = nextOriginal;
        }

        return dummyHead.next;
    }

    
}

