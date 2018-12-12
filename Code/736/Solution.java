class Solution {
    public int evaluate(String expression) {
        return eval(expression, 0, expression.length()-1, new ArrayList<Map<String, Integer>>());
    }
    
    public int eval(String expression, int start, int end, List<Map<String, Integer>> scopes) {
        if(expression.charAt(start) != '(') {
            // variable or integer
            if(Character.isDigit(expression.charAt(start)) || expression.charAt(start) == '-') {
                int res = 0;
                boolean neg = false;
                if(expression.charAt(start) == '-') {
                    neg =true;
                    start ++;
                }
                for(int i=start; i<=end; i++) {
                    res = res * 10 + expression.charAt(i) - '0';
                }
                return neg ? -res : res;
            } else {
                StringBuilder sb = new StringBuilder();
                for(int i=start; i<=end; i++) {
                    sb.append(expression.charAt(i));
                }
                return findValueInScopes(sb.toString(), scopes);
            }
        }
        
        char com = expression.charAt(start+1);
        if(com == 'l') {
            // find end
            int endExpStart = findStartForExp(expression, end-1);

            int ptr = start + 5;
            Map<String, Integer> newScope = new HashMap<>();
            scopes.add(newScope);

            while(ptr < endExpStart) {
                // find variable
                StringBuilder va = new StringBuilder();
                int variableEnd = findEndForVar(expression, ptr, va);
                ptr = variableEnd + 2;

                // get val
                int expEnd = findEndForExp(expression, ptr);
                int expValue = eval(expression, ptr, expEnd, scopes);
                newScope.put(va.toString(), expValue);
                ptr = expEnd + 2;
            }
            
            int res = eval(expression, endExpStart, end-1, scopes);
            scopes.remove(scopes.size()-1);
            return res;
        } else if(com == 'a') {
            int ptr = start + 5;
            int fisrtEnd = findEndForExp(expression, ptr);
            int firstVal = eval(expression, ptr, fisrtEnd, scopes);

            ptr = fisrtEnd + 2;
            int scondVal = eval(expression, ptr, end-1, scopes);
            return firstVal + scondVal;
        } else if(com == 'm') {
            int ptr = start + 6;
            int fisrtEnd = findEndForExp(expression, ptr);
            int firstVal = eval(expression, ptr, fisrtEnd, scopes);

            ptr = fisrtEnd + 2;
            int scondVal = eval(expression, ptr, end-1, scopes);
            return firstVal * scondVal;
        }
        return 0;
    }

    public int findEndForExp(String exp, int start) {
        if(exp.charAt(start) == '(') {
            int count = 0;
            while(start < exp.length()) {
                char cur = exp.charAt(start);
                if(cur == '(') count++;
                else if(cur == ')') {
                    count --;
                    if(count == 0) return start;
                }
                start ++;
            }
        } else {
            while(exp.charAt(start) != ' ') start++;
            return start-1;
        }
        return 0;
    }

    public int findEndForVar(String exp, int start, StringBuilder sb) {
        while(exp.charAt(start) != ' '){
            sb.append(exp.charAt(start));
            start++;
        }
        return start-1;
    }

    public int findStartForExp(String exp, int end) {
        if(exp.charAt(end) == ')') {
            int count = 0;
            while(end >= 0) {
                char cur = exp.charAt(end);
                if(cur == ')') count++;
                else if(cur == '(') {
                    count --;
                    if(count == 0) return end;
                }
                end--;
            }
        } else {
            while(exp.charAt(end) != ' ') {
                end--;
            }
            return end+1;
        }
        return 0;
    }

    public int findValueInScopes(String va, List<Map<String, Integer>> scopes) {
        for(int i=scopes.size()-1; i>=0; i--) {
            if(!scopes.get(i).containsKey(va)) continue;
            return scopes.get(i).get(va);
        }
        return 0;
    }

}