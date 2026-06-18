class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> positionSpeedPairs = new ArrayList<>();
        for(int i = 0; i < position.length; i++) {
            positionSpeedPairs.add(new int[]{position[i], speed[i]});
        }
        positionSpeedPairs.sort((a,b) -> a[0] - b[0]);
        Stack<Double> timeStack = new Stack<Double>();
        for(int i = positionSpeedPairs.size() - 1; i >= 0; i--) {
            int[] positionSpeedpair = positionSpeedPairs.get(i);
            double time = (double)(target - positionSpeedpair[0]) / positionSpeedpair[1];
            if(!timeStack.isEmpty() && time > timeStack.peek()) {
                timeStack.push(time);
            } else if(timeStack.isEmpty()) {
                timeStack.push(time);
            }
        }
        return timeStack.size();
    }
}
