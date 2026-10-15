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
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenref = head.next;
        ListNode oddref = null;

        while(odd != null && even != null) {
            if(odd.next.next == null) {
                oddref = odd;
            }

            ListNode oddTempNext = odd.next.next;
            odd.next = oddTempNext;
            odd = odd.next;

            if (even.next == null) {
                break;
            }

            ListNode evenTempNext = even.next.next;
            even.next = evenTempNext;
            even = even.next;
        }

         if (oddref == null) {
            oddref = odd;
        }

        oddref.next = evenref;

        return head;
    }
}
