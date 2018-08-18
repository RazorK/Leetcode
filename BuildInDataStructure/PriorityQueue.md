# PriorityQueue
A queue with a comparator, is a heap actually.

offer(), poll(), add() has O(logN) complexity.

```
// init
PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> (a.val -b.val));

// with capacity
Queue<Integer> pq = new PriorityQueue<Integer>(11,
    new Comparator<Integer>() {
        public int compare(Integer i1, Integer i2) {
            return i2 - i1;
        }
    });

// peek poll
pq.peek();
pq.poll();

// offer
pq.offer(e);
pq.add(e);

// clear
pq.clear();
```
