class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numberArray = new HashSet<Integer>();
        for(int num : nums) {
            if(numberArray.contains(num)) {
                return true;
            }
            numberArray.add(num);
        }
        return false;
    }
}