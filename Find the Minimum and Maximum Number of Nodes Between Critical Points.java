class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = -1;
        int previous = -1;

        int min = Integer.MAX_VALUE;
        int max = -1;

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;

        int position = 2;

        while (next != null) {

            // Check whether curr is a critical point
            if ((curr.val > prev.val && curr.val > next.val) ||
                (curr.val < prev.val && curr.val < next.val)) {

                // First critical point
                if (first == -1) {
                    first = position;
                }

                // If this is not the first critical point
                if (previous != -1) {
                    min = Math.min(min, position - previous);
                }

                previous = position;
            }

            prev = curr;
            curr = next;
            next = next.next;

            position++;
        }

        // Less than two critical points
        if (first == previous) {
            return new int[]{-1, -1};
        }

        // Distance between first and last critical point
        max = previous - first;

        return new int[]{min, max};
    }
}
