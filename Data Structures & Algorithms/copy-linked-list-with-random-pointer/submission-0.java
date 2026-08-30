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
        HashMap<Node,Node> oldToCopy = new HashMap<>();
        Node cur = head;
        Node copy = null;
        while (cur !=null) {
            copy = new Node(cur.val);
            oldToCopy.put(cur,copy);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            oldToCopy.get(cur).next = oldToCopy.get(cur.next);
            oldToCopy.get(cur).random = oldToCopy.get(cur.random);
            cur = cur.next;
        }
        cur = head;
        return oldToCopy.get(cur);
    }

    
}

