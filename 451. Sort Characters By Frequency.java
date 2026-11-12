
class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        for(char c : s.toCharArray())
            mp.put(c, mp.getOrDefault(c,0)+1);

        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>(
            (a,b) -> b.getValue() - a.getValue()
        );

        pq.addAll(mp.entrySet());

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> entry = pq.poll();
            for(int i=0;i<entry.getValue();i++)
                sb.append(entry.getKey());
        }

        return sb.toString();
    }
}
