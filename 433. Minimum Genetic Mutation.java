class Solution {

    public int countDiff(String str1 , String str2){
        int count =0;
        for(int i = 0 ; i< str1.length();i++)
            if(str1.charAt(i) != str2.charAt(i)) count++;
        return count;
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        Queue<String> qu = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        for(String str:bank) set.add(str);
        if (!set.contains(endGene)) 
            return -1;
        
        int count =0;

        qu.offer(startGene);
        while(!qu.isEmpty()){
            int size = qu.size();
            for(int i = 0 ; i< size;i++){
                String str = qu.poll();
                if(str.equals(endGene)) return count;
                set.remove(str);
                for(String next:set){
                    int diff = countDiff(str ,next); 
                    if(diff == 1)qu.offer(next);
                    
                }

            }
            count++;
        }




        return -1;
    }
}
