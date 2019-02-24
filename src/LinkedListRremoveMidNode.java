public class LinkedListRremoveMidNode {
    public class Node {
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public Node removeMidNode(Node head){
        if(head == null || head.next == null){
            return head;
        }
        if(head.next.next == null){
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while(cur.next != null && cur.next.next != null){
            pre = pre.next;
            cur = cur.next.next;
        }
        head = pre.next;
        pre.next = pre.next.next;
        return head;
    }
}
