package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DesignMemoryAllocator {
    public static class Allocator {
        private Map<Integer, Map<Integer, Integer>> alloc;
        private TreeMap<Integer, Integer> avail;

        public Allocator(int n) {
            alloc = new HashMap<>();
            avail = new TreeMap<>();
            avail.put(0, n);
        }

        public int allocate(int size, int mID) {
            int addr = -1;
            for (int offset: avail.keySet()) {
                if (avail.get(offset) >= size) {
                    addr = offset;
                    alloc.putIfAbsent(mID, new HashMap<>());
                    alloc.get(mID).put(addr, size);
                    if (avail.get(offset) > size) {
                        avail.put(offset + size, avail.get(offset) - size);
                    }
                    avail.remove(offset);
                    break;
                }
            }
            return addr;
        }

        public int freeMemory(int mID) {
            int freed = 0;

            if(!alloc.containsKey(mID)) {
                return freed;
            }

            for (int addr : alloc.get(mID).keySet())  {
                int size = alloc.get(mID).get(addr);
                freed += size;
                int l = addr, r = addr + size - 1;
                while (true) {
                    Integer offset = avail.floorKey(l);
                    if (offset == null || offset + avail.get(offset) < l - 1) {
                        break;
                    }
                    l = offset;
                    avail.remove(offset);
                }
                while (true) {
                    Integer offset = avail.ceilingKey(r);
                    if (offset == null || offset > r + 1) {
                        break;
                    }
                    r = offset + avail.get(offset) - 1;
                    avail.remove(offset);
                }
                avail.put(l, r - l + 1);
            }
            alloc.remove(mID);
            return freed;
        }
    }
}
