import java.util.HashSet;

class Solution {
    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<time.length(); i++) {
            if(i == 2) continue;
            set.add(time.charAt(i) - '0');
        }

        List<Integer> chars = new ArrayList<>(set);
        List<Time> times = new ArrayList<>();

        for(int h1 : chars) {
            for(int h2 : chars) {
                int hour = h1*10  + h2;
                if(hour >=24) continue;
                for(int m1 : chars) {
                    for(int m2 : chars) {
                        int minute = m1*10 + m2;
                        if(minute >= 60) continue;
                        times.add(new Time(hour, minute));
                    }
                }
            }
        }
        
        System.out.println(times.toString());

        Time cur = new Time(time);

        Time min = null, biggerMin = null;
        boolean hasMax = false;
        for(Time t : times) {
            if(min == null || compare(min, t) >= 0) min = t;
            if(compare(t, cur) > 0) {
                hasMax = true;
                if(biggerMin == null || compare(t, biggerMin) < 0) biggerMin = t;
            }
        }

        return hasMax ? biggerMin.toString() : min.toString();

    }
    
    public static int compare(Time o1, Time o2) {
        if(o1.hour != o2.hour) return o1.hour - o2.hour;
        else if(o1.minute != o2.minute) return o1.minute - o2.minute;
        else return 0;
    }

    public class Time {
        int hour, minute;
        public Time(int h, int m) {
            hour = h;
            minute = m;
        }

        public Time(String s) {
            hour = (s.charAt(0) - '0') * 10 + s.charAt(1) - '0';
            minute = (s.charAt(3) - '0') * 10 + s.charAt(4) - '0';
        }

        public String toString() {
            return String.format("%02d", hour) + ":" + String.format("%02d", minute);
        }
    }
}