import java.util.*;

class AlienDictionaryDFSTopo {
    Stack<Integer> ans;
    public String foreignDictionary(String[] words) {
      ans = new Stack<>();
      boolean[] exists = new boolean[26];

      for(String w: words){
        for(char c: w.toCharArray()){
          exists[c - 'a'] = true;
        }
      }

      List<List<Integer>> adj = new ArrayList<>();
      for(int i = 0; i < 26; i++)adj.add(new ArrayList<>());

      for(int i = 1; i < words.length; i++){
        String prev = words[i - 1];
        String curr = words[i];
        if (prev.startsWith(curr) && prev.length() > curr.length()) {
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
      if(!topo(adj, 26))return "";
      StringBuilder res = new StringBuilder();

      while(!ans.isEmpty()){
        int x = ans.pop();
        char ch = (char)(x + 'a');
        if(exists[x])res.append(ch);
      }

      return res.toString();
    }

    public boolean topo(List<List<Integer>> adj, int chars){
      boolean[] vis = new boolean[chars];
      boolean[] path = new boolean[chars];

      for(int i = 0; i < chars; i++){
        if(!vis[i]){
          if(!dfs(adj, vis, path, chars, i))return false;
        }
      }
      return true;
    }
    public boolean dfs(List<List<Integer>> adj, boolean[] vis, boolean[] path, int chars, int node){
      path[node] = true;
      vis[node] = true;
      for(int nei: adj.get(node)){
        if(!vis[nei]){
          if(!dfs(adj, vis, path, chars, nei))return false;
        }else if(path[nei]){
          return false;
        }
      }
      path[node] = false;
      ans.push(node);
      return true;
     }
}
