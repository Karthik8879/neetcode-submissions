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
        HashMap<Node, Node> hm = new HashMap<>();
        Node temp = head;
        while(temp != null) {
            Node copy = new Node(temp.val);
            hm.put(temp, copy);
            temp = temp.next;
        }

        temp = head;

        while(temp != null) {
            Node copyHead = hm.get(temp);
            copyHead.next = hm.get(temp.next);
            copyHead.random = hm.get(temp.random);
            temp = temp.next;
        }

        return hm.get(head);
    }
}
