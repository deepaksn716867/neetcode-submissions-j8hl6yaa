class Solution {
      private static class ClosestPoints {
        int distance;
        int point[];
        ClosestPoints(int distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<ClosestPoints> minHeap = new PriorityQueue<ClosestPoints>(Comparator.comparingInt(t -> t.distance));
        for(int[] point : points) {
            int distance = point[0] * point[0] + point[1] * point[1];
            ClosestPoints closestPoint = new ClosestPoints(distance, point);
            minHeap.offer(closestPoint);
        }
        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++) {
            ClosestPoints closestpoint = minHeap.poll();
            result[i] =closestpoint.point;
        }
        return result;
    }
}
