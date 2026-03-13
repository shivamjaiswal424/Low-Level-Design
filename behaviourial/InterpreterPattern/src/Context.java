import java.util.HashMap;
import java.util.Map;

public class Context {
    public final Map<String,Integer> map = new HashMap<>();
    public void setVariable(String key, int value) {
        map.put(key, value);
    }
    public int getVariables(String key){
        return map.getOrDefault(key,0);
    }
    @Override
    public String toString() {
        return map.toString();
    }

}
