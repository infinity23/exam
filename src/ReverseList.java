/**
 * @author wuenbang
 * @date 2019-07-14
 */
public class ReverseList {
    public Node reverseListByLoop(Node head){
        if (head == null) {
            return null;
        }
        Node pre = head;
        Node cur = head.next;
        Node tmp;

        while(cur != null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        head.next = null;
        return pre;
    }

    public Node reverseListByRecurse(Node head){
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        if (head == null || head.next == null) {
            return head;// 若为空链或者当前结点在尾结点，则直接还回
        }
        Node reHead = reverseListByRecurse(head.next);// 先反转后续节点
        head.next.next = head;// 将当前结点的指针域指向前一结点
        head.next = null;// 前一结点的指针域令为null;
        return reHead;// 反转后新链表的头结点
    }
}

