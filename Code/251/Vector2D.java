import java.util.ArrayList;
import java.util.List;

public class Vector2D implements Iterator<Integer> {

    private List<Integer> data;
    private int ptr;
    public Vector2D(List<List<Integer>> vec2d) {
        data = new ArrayList<>();
        for(List<Integer> list : vec2d) {
            for(Integer cur : list) {
                data.add(cur);
            }
        }
        ptr = 0;
    }

    @Override
    public Integer next() {
        return data.get(ptr++);
    }

    @Override
    public boolean hasNext() {
       if(ptr == data.size())  return false;
       return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */