class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> maxStack = new Stack<int[]>();
        int[] res = new int[temperatures.length];
        for(int i = temperatures.length - 1; i >= 0; i--) {
            while(!maxStack.isEmpty() && temperatures[i]>= maxStack.peek()[1]) {
                maxStack.pop();
            }
            if(maxStack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = maxStack.peek()[0] - i;
            }
            maxStack.push(new int[]{i, temperatures[i]});
        }
        return res;
    }
}
