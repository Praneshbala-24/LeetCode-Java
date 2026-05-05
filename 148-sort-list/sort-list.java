class Solution {
    public ListNode sortList(ListNode head) {
        // Add this at the top of sortList:
        if (head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;
        ListNode splitA = sortList(head);
        ListNode splitB = sortList(secondHead);
        return merge(splitA, splitB);
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null)
            temp.next = l1;

        if (l2 != null)
            temp.next = l2;
        return dummy.next;
    }
}