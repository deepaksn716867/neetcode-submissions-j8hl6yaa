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
        if (head == null) return;
        ListNode front = head;
        Deque<ListNode> queue = new ArrayDeque<>();
        ListNode node = head.next;
        while(node != null) {            
            queue.offer(node);
            node = node.next;
        }
        int i = 1;
        ListNode curr;
        while(!queue.isEmpty()) {
            if(i % 2 == 0) {
                curr = queue.removeFirst();
            } else {
                curr = queue.removeLast();
            }
            front.next = curr;
            front = curr;
            i++;
        }
        front.next = null;
    }
}
