// import java.util.*;
class Solution {
    // private static class TasksSlotPriority {
    //     char task;
    //     int time;
    //     TasksSlot(int task, int time) {
    //         this.tasks = tasks;
    //         this.time = time;
    //     }
    // }
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        HashMap<Character, Integer> freqCount = new HashMap<Character, Integer>();
        for(char task: tasks) {
            freqCount.put(task, freqCount.getOrDefault(task, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry: freqCount.entrySet()) {
            maxHeap.offer(entry.getValue());
        }
        int currentTime = 0;
        Queue<int[]> taskQueue = new ArrayDeque<int[]>();
        while(maxHeap.size() > 0 || taskQueue.size() > 0) {
            currentTime++;
            if(maxHeap.size() > 0) {
                int task = maxHeap.poll();
                task--;
                if(task > 0) {
                    taskQueue.offer(new int[]{task,currentTime + n});
                }
            }
            
            if(taskQueue.size() > 0 && taskQueue.peek()[1] == currentTime) {
                int[] readyTask = taskQueue.poll();
                maxHeap.offer(readyTask[0]);
            }
        }
        return currentTime;
    }
}
