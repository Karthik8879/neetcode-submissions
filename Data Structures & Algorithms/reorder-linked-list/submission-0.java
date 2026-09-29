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
        if(head == null || head.next == null) {
            return;
        }
        ListNode mid = findMiddle(head);
        ListNode head2 = mid.next;
        mid.next = null; // breaking the 2 nodes
        head2 = reverse(head2);
        ListNode head1 = head;
        while(head1 != null && head2 != null) {
            ListNode firstNext = head1.next;
            ListNode secondNext = head2.next;

            head1.next = head2;
            head2.next = firstNext;

            head1 = firstNext;
            head2 = secondNext;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // [2,4,6,8]
    // approach 1
    // split into 2 making use of find middle now
    // now 2 lists are 1. [2, 4] and 2. [6,8] --> save in the reversed order so
    // [2,4] and [8,6]
    // 2, 8, 4, 6
    // public void reorderList1(ListNode head) {
    //     // base case
    //     if(head == null || head.next == null) return;

    //     ListNode firstHead = head;
    //     ListNode middle = middleHelper(head);
    //     // Split the list
    //     ListNode secondHead = middle.next;
    //     middle.next = null;

    //     while(firstHead != null && secondHead != null) {
    //         ListNode firstNext = firstHead.next;
    //         ListNode secondNext = secondHead.next;

    //         firstHead.next = secondHead;
    //         secondHead.next = firstNext;

    //         firstHead = firstNext;
    //         secondHead = secondNext;
    //     }
    // }

    // public ListNode reverse1(ListNode head) {
    //     ListNode prev = null;
    //     ListNode curr = head;
    //     ListNode next = null;
    //     while(curr != null) {
    //         next = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = next;
    //     }
    //     return prev;
    // }

    // public ListNode middleHelper1(ListNode head) {
    //     ListNode slow = head;
    //     ListNode fast = head;
    //     while(fast != null && fast.next != null) {
    //         slow = slow.next;
    //         fast = fast.next.next;
    //     }
    //     return slow;
    // }
}
