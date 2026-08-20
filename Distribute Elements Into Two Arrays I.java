import java.util.*;

class Solution {
    public int[] resultArray(int[] nums) {

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        // First element goes to arr1
        arr1.add(nums[0]);

        // Second element goes to arr2
        arr2.add(nums[1]);

        // Start from third element
        for (int i = 2; i < nums.length; i++) {

            // Compare last elements
            if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }

        // Add arr2 at the end of arr1
        arr1.addAll(arr2);

        // Convert ArrayList to int[]
        int[] result = new int[arr1.size()];

        for (int i = 0; i < arr1.size(); i++) {
            result[i] = arr1.get(i);
        }

        return result;
    }
}
