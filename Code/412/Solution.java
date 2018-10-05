import java.util.ArrayList;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            StringBuilder cur = new StringBuilder();
            if(i%3 == 0) cur.append("Fizz");
            if(i % 5 == 0) cur.append("Buzz");
            if(cur.length() == 0) cur.append(i);
            res.add(cur.toString());
        }
        return res;
    }
}