package linkedList;



class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class reverseList_206 {
    public ListNode iterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    public ListNode recursion(ListNode head) {
        ListNode prev = null;
        if (head == null || head.next == null) return head;
        ListNode p = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {

    }
}
