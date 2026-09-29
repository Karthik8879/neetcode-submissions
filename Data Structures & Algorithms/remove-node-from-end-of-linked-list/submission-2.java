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
        if(head == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode temp = head;
        int len = 0;
        while(temp != null) {
            temp = temp.next;
            len++;
        }

        if(len == n) {
            return head.next;
        }

        temp = dummy;
        temp = temp.next;

        for(int i = 0; i < len - n - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }

    // public ListNode removeNthFromEnd1(ListNode head, int n) {
    //     ListNode temp = head;
    //     int len = lenHelper(temp);
    //     if (n == len) {
    //         return head.next;
    //     }
    //     temp = head;

    //     for(int i = 0; i < len - n - 1; i++) {
    //         temp = temp.next;
    //     }
    //     temp.next = temp.next.next;
    //     return head;
    // }

    // private int lenHelper1(ListNode head) {
    //     int len = 0;
    //     while(head != null) {
    //         len++;
    //         head = head.next;
    //     }
    //     return len;
    // }
}
