class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] result = new int[nums.length];
        //prefix product.
        int prefixProd = 1;
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                result[i] = 1;
                continue;
            }
            result[i] = result[i - 1] * nums[i - 1];
        }

        //suffix product.
        int suffixProd = 1;
        for(int j = nums.length - 1; j >=0; j--) {
            if(j == nums.length - 1) {
                suffixProd = suffixProd * nums[j];
                continue;
            }
            result[j] = result[j] * suffixProd;
            suffixProd = suffixProd * nums[j];
        }
        return result;
    }
}  
