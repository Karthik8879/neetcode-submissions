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

        // populating the hm
        Node temp = head;
        while(temp != null) {
            Node copy = new Node(temp.val);
            hm.put(temp, copy);
            temp = temp.next;
        }

        // resetting the temp
        temp = head;

        // looping the copy and setting it wrt next and random ptr
        while(temp != null) {
            Node newCopy = hm.get(temp);
            newCopy.next = hm.get(temp.next);
            newCopy.random = hm.get(temp.random);
            temp = temp.next;
        }

        return hm.get(head);
    }
}
