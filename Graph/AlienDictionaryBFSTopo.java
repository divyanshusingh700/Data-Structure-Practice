import java.util.*;

class AlienDictionaryBFSTopo {
    Stack<Integer> ans;
    boolean[] exists = new boolean[26];

    public String foreignDictionary(String[] words) {
      ans = new Stack<>();
      int cnt = 0;
      for(String w: words){
        for(char c: w.toCharArray()){
          exists[c - 'a'] = true;
        }
      }

      for(boolean b: exists){
        if(b)cnt++;
      }

      List<List<Integer>> adj = new ArrayList<>();
      for(int i = 0; i < 26; i++)adj.add(new ArrayList<>());

      for(int i = 1; i < words.length; i++){
        String prev = words[i - 1];
        String curr = words[i];
        if (prev.startsWith(curr) && prev.length() > curr.length()) {// according to alien dictionary
          return "";
        }
        int len = Math.min(prev.length(), curr.length());
        for(int j = 0; j < len; j++){
          if(prev.charAt(j) != curr.charAt(j)){
            adj.get(prev.charAt(j) - 'a').add(curr.charAt(j) - 'a');
            break;
          }
        }
      }
      List<Integer> ans = topoBFS(adj, 26);
      StringBuilder res = new StringBuilder();
      if(ans.size() != cnt)return "";
      for(int e: ans){
        res.append((char)(e + 'a'));
      }

      return res.toString();
    }

    public List<Integer> topoBFS(List<List<Integer>> adj, int chars){
      int[] indegree = new int[chars];
      List<Integer> ans = new ArrayList<>();
      Queue<Integer> q = new LinkedList<>();

      for(int i = 0; i < chars; i++){
        for(int v: adj.get(i)){
          indegree[v]++;
        }
      }

      for(int i = 0; i < chars; i++){
        if(exists[i] && indegree[i] == 0){
          q.offer(i);
        }
      }

      while(!q.isEmpty()){
        int u = q.poll();
        ans.add(u);
        for(int v: adj.get(u)){
          indegree[v]--;
          if(indegree[v]==0){
            q.offer(v);
          }
        }
      }
      return ans;
    }
}