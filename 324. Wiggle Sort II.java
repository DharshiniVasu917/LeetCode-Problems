class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int i = 1;
        int j = n - 1;
        // step 1: sort array
        Arrays.sort(nums);
        //step 2: make an extra array and managed equality in it
        int res[] = new int[n];
        while(i < n) {
            res[i] = nums[j];
            i = i + 2;
            j--;
        }

        i = 0; 
        while(i < n) {
            res[i] = nums[j];
            i = i + 2;
            j--;
        }
        //step 3: fill input array from res
        for(int k=0; k<n; k++) {
            nums[k] = res[k];
        }
    }
}
