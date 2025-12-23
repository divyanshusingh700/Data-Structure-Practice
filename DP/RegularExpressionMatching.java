public class RegularExpressionMatching {
    Boolean memo[][];
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];

        return dfs(s, p, 0, 0);
    }
    public boolean dfs(String s, String p, int i, int j){
        if(j == p.length()){
            return i == s.length();
        }

        if(memo[i][j] != null)return memo[i][j];
        
        boolean firstMatch = (i < s.length() 
                                && (s.charAt(i) == p.charAt(j) ||
                                    p.charAt(j) == '.'));
        if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
            // skip x* or use
            return memo[i][j] = dfs(s, p, i, j + 2) || (firstMatch && dfs(s, p, i + 1, j));
        }else{
            return memo[i][j] = firstMatch && dfs(s, p, i + 1, j + 1);
        }
    }
}
