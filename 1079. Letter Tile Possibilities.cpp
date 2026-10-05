class Solution {
    public int numTilePossibilities(String tiles) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(char c:tiles.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        return helper(map);
    }
    public static int helper(HashMap<Character,Integer>map){
        int ans=0;
        for(char chr:map.keySet()){
            int freq=map.get(chr);
            if(freq==0)continue;
            map.put(chr,freq-1);
            ans+=1+helper(map);
            map.put(chr,freq);
        }
        return ans;
    }
}
