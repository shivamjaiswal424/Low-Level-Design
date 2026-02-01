import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }

    public int minTransactions(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] transaction : transactions) {
            int from = transaction[0];
            int to = transaction[1];
            int amount = transaction[2];
            map.put(from, map.getOrDefault(from, 0) - amount);
            map.put(to, map.getOrDefault(to, 0) + amount);
        }
        List<Integer> balances = new ArrayList<>();
        for(int amount : map.values()) {
            if(amount!=0) balances.add(amount);
        }
        return dfs(balances,0);
    }
    private int dfs(List<Integer> balances, int index) {
        if(balances.isEmpty() || index>=balances.size()) return 0;
        int current = balances.get(index);
        int minTransactionCount = Integer.MAX_VALUE;

        for (int transactionIdx=current; transactionIdx<balances.size(); transactionIdx++) {
            int next = balances.get(transactionIdx);
            if(current*next<0){
                balances.set(transactionIdx,current+ next);
                minTransactionCount = Math.min(minTransactionCount,dfs(balances,transactionIdx+1));
                balances.set(transactionIdx,current-next);

                if(current+next==0){
                    break;
                }

            }
        }
        return minTransactionCount;
    }
}