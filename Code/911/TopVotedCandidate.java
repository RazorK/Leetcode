import java.util.Map;
import java.util.TreeMap;

class TopVotedCandidate {

    // maintain a treemap for history, and a treemap for current vote
    // key: time, value: person
    TreeMap<Integer, Integer> his;

    // key: person, value: vote
    Map<Integer, Integer> votes;
    public TopVotedCandidate(int[] persons, int[] times) {
        his = new TreeMap<>();
        votes = new HashMap<>();
        
        int max = 0;
        int curPerson = -1;
        for(int i=0; i<persons.length; i++) {
            int cur = votes.getOrDefault(persons[i], 0) + 1;
            if(cur >= max) {
                max = cur;
                if(persons[i] != curPerson) {
                    curPerson = persons[i];
                    his.put(times[i], curPerson);
                }
            }
            votes.put(persons[i], cur);
        }
    }
    
    public int q(int t) {
        // search floor in treeMap
        return his.floorEntry(t).getValue();
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */