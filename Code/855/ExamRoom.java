class ExamRoom {
    List<Integer> sorted;
    int size;
    public ExamRoom(int N) {
        sorted = new ArrayList<>();
        size = N;
    }
    
    public int seat() {
        if(sorted.size() == 0) {
            sorted.add(0);
            return 0;
        }
        // find seats
        int maxGap = -1;
        int seat = -1;
        int index = -1;

        if(sorted.get(0) != 0) {
            maxGap = sorted.get(0) - 0;
            seat = 0;
            index = 0;
        }

        for(int i=0; i<sorted.size()-1; i++) {
            int cur = sorted.get(i);
            int next = sorted.get(i+1);
            if(maxGap >= (next - cur) / 2) continue;
            maxGap = (next - cur)/2;
            seat = cur + (next - cur)/2;
            index = i+1;
        }

        if(sorted.get(sorted.size()-1) != size-1 && size - 1 - sorted.get(sorted.size()-1) > maxGap) {
            maxGap = size - sorted.get(sorted.size()-1) - 1;
            seat = size-1;
            index = sorted.size();
        }

        sorted.add(index, seat);
        return seat;
    }
    
    public void leave(int p) {
        for(int i=0; i<sorted.size(); i++) {
            if(sorted.get(i) == p) sorted.remove(i);
        }
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */