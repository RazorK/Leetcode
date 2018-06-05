class Solution {
    // Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    //
    // Valid operators are +, -, *, /. Each operand may be an integer or another expression.
    //
    // Note:
    //
    // Division between two integers should truncate toward zero.
    // The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
    // Example 1:
    //
    // Input: ["2", "1", "+", "3", "*"]
    // Output: 9
    // Explanation: ((2 + 1) * 3) = 9
    // Example 2:
    //
    // Input: ["4", "13", "5", "/", "+"]
    // Output: 6
    // Explanation: (4 + (13 / 5)) = 6
    // Example 3:
    //
    // Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
    // Output: 22
    // Explanation:
    //   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
    // = ((10 * (6 / (12 * -11))) + 17) + 5
    // = ((10 * (6 / -132)) + 17) + 5
    // = ((10 * 0) + 17) + 5
    // = (0 + 17) + 5
    // = 17 + 5
    // = 22

    // first idea, use stack
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String tk:tokens) {
            switch(tk) {
                case "+":
                    st.push(st.pop() + st.pop());
                    break;
                case "-":
                    st.push(-st.pop() + st.pop());
                    break;
                case "*":
                    st.push(st.pop() * st.pop());
                    break;
                case "/":
                    st.push((int)(1.0/st.pop() * st.pop()));
                    break;
                default:
                    st.push(Integer.parseInt(tk));
            }
        }
        return st.pop();
    }
}
