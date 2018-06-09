class MinStack {
    Deque stack;
    Integer min;

    public MinStack() {
        this.stack  = new LinkedList<>();
    }

    public void push(int x) {
        min = (stack.size() == 0)?x:Math.min(min, x);
        stack.offerLast(x);
    }

    public void pop() {
        if(stack.size() == 0) throw new RuntimeException();
        int x = (int)stack.pollLast();
        if(x == min) {
            if(stack.size() == 0) min = null;
            else {
                min = Integer.MAX_VALUE;
                Iterator<Integer> it = stack.iterator();
                while(it.hasNext()) {
                    min = Math.min(min, it.next());
                }
            }
        }
    }

    public int top() {
        if(stack.size() == 0) throw new RuntimeException();
        return (int)stack.peekLast();
    }

    public int getMin() {
        if(min != null) return min;
        return 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
