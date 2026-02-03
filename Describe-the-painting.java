/******************************************************************************* JAVA ************************************************************************************************/
//Approach (Using Line Sweep)
//T.C : O(n * logn), where n = number of segments
//S.C : O(n) to store events in map
class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        TreeMap<Integer, Long> events = new TreeMap<>();

        for(int[] seg : segments) {
            int start = seg[0];
            int end = seg[1];
            int color = seg[2];

            events.put(start, events.getOrDefault(start, 0L) + color);
            events.put(end, events.getOrDefault(end, 0L) - color);
        }

        List<List<Long>> result = new ArrayList<>();

        long sum = 0;
        Integer prev = null;

        for(Map.Entry<Integer, Long> entry : events.entrySet()) {
            int point = entry.getKey();
            if(prev != null && sum > 0){
                result.add(Arrays.asList((long) prev, (long) point, sum));
            }
            sum += entry.getValue();
            prev = point;
        }
        return result;
        
    }
}
