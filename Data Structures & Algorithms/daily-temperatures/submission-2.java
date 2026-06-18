class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> maxStack = new Stack<int[]>();
        int[] res = new int[temperatures.length];

        for(int i = 0; i < res.length; i++) {
            res[i] = 0;
        }

        for(int i = 0; i < temperatures.length; i++) {
            while(!maxStack.isEmpty() && temperatures[i]> maxStack.peek()[1]) {
                int[] temperature = maxStack.pop();
                res[temperature[0]] = i - temperature[0];
            }
            maxStack.push(new int[]{i, temperatures[i]});
        }
        return res;
    }
}
