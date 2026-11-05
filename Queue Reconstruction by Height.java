class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);  // compare (h, k) by h in reverse order; in case of ties compare k
        List<int[]> list = new LinkedList<>();
        for(int[] p: people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[people.length][2]);
    }
}
