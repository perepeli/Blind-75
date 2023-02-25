package problems;

import java.util.LinkedList;
import java.util.Queue;

public class DesignHitCounter {
    Queue<Integer> q;

    public DesignHitCounter() {
        q = new LinkedList<>();
    }

    public void hit(int timestamp) {
        q.offer(timestamp);
    }

    public int getHits(int timestamp) {
        while(!q.isEmpty() && timestamp - q.peek() >= 300) {
            q.poll();
        }
        return q.size();
    }
}
