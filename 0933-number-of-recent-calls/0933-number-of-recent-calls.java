import java.util.Queue;
import java.util.LinkedList;

class RecentCounter {
    
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        // Add current ping
        queue.add(t);
        
        // Remove pings older than t - 3000
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        
        // Return number of valid pings
        return queue.size();
    }
}