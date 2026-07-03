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
        Node node = head;
        Node copyHead;
        Map<Node, Node> oldToCopy = new HashMap<>();
        oldToCopy.put(null, null);
        while(node != null) {
            Node copy = new Node(node.val);
            oldToCopy.put(node, copy);
            node = node.next;
        }
        node = head;
        while(node != null) {
            Node copy = oldToCopy.get(node);
            copy.next = oldToCopy.get(node.next);
            copy.random = oldToCopy.get(node.random);
            node = node.next;
        }
        return oldToCopy.get(head);
    }
}
