import java.util.*;

class Solution {
    LinkedList<String> result;
    Map<String, PriorityQueue<String>> adj;
    int res = 0;
    public List<String> findItinerary(List<List<String>> tickets) {
        res = tickets.size();
        result = new LinkedList<>();
        adj = new HashMap<>();
        for(List<String> t: tickets){
            adj.computeIfAbsent(t.get(0), k -> new PriorityQueue<>()).offer(t.get(1));
        }

        dfs("JFK");

        return result;

    }

    public void dfs(String city){
        PriorityQueue<String> pq = adj.get(city);
        while(pq != null && !pq.isEmpty()){
            dfs(pq.poll());
        }
        result.addFirst(city);
    }
}


// TLE original sol'n

class Solution {
    List<String> result;
    Map<String, List<String>> adj;
    int res = 0;
    public List<String> findItinerary(List<List<String>> tickets) {
        res = tickets.size();
        result = new ArrayList<>();
        adj = new HashMap<>();
        for(List<String> t: tickets){
            adj.computeIfAbsent(t.get(0), k -> new ArrayList<>()).add(t.get(1));
        }

        for(Map.Entry<String, List<String>> entry:adj.entrySet()){
            List<String> lis = entry.getValue();
            Collections.sort(lis);
        }
        dfs("JFK", new Stack<>());

        return result;

    }

    public boolean dfs(String city, Stack<String> path){
        path.add(city);
        if(path.size() == res + 1){
            result = new ArrayList<>(path);
            return true;
        }
        List<String> neighs = adj.get(city);
        for(int i = 0; i < neighs.size(); i++){
            String toCity = neighs.get(i);
            if(toCity.equals("#"))continue;
            neighs.set(i, "#");

            if(dfs(toCity, path))return true;

            neighs.set(i, toCity);
        }
        path.pop();
        return false;
    }
}