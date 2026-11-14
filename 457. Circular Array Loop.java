class Solution {
    public static boolean circularArrayLoop(int[] nums) {
    int slow = 0, fast = 0;
    int size = nums.length;
    for (int i = 1; i <= size; i++) {
      int prev = slow;
      slow = nextStep(slow, nums[slow], size);
      if (isNotCycle(nums, prev, slow)) {
        fast = i;
        slow = i;
        continue;
      }
      boolean nextIter = false;
      int moves = 2;
      for (int j = 0; j < moves; j++) {
        prev = fast;
        fast = nextStep(fast, nums[fast], size);
        if (isNotCycle(nums, prev, fast)) {
          fast = i;
          slow = i;
          nextIter = true;
          break;
        }
      }
      if (nextIter) {
        continue;
      }
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
  private static int nextStep(int pointer, int value, int size) {
    int result = (pointer + value) % size;
    if (result < 0) {
      result += size;
    }
    return result;
  }
  private static boolean isNotCycle(int[] nums, int prev, int pointer) {
    if ((nums[prev] >= 0 && nums[pointer] < 0) || (Math.abs(nums[pointer] % nums.length) == 0)) {
      return true;
    } else {
      return false;
    }
  }
}
