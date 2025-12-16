import java.util.Arrays;

public class EditDistance {
    int mn = 501;
    int[][] memo ;
    public int minDistance(String word1, String word2) {
        // -- we can delete only when the size of word1 greater than word2
        // -- we can insert only when the size of word 1 less than word2
        // -- if size becomes same we will only do replacement

        memo = new int[word1.length()][word2.length()];
        for(int i = 0; i < word1.length(); i++)Arrays.fill(memo[i], -1);

        StringBuilder sb1 = new StringBuilder(word1);
        StringBuilder sb2 = new StringBuilder(word2);
        return dfs(sb1, sb2, word1.length() - 1, word2.length() - 1);
    }
    public int dfs(StringBuilder word1, StringBuilder word2, int idx1, int idx2){
        if(idx1 < 0 && idx2 < 0 ){
            return 0;
        }

        if(idx1 < 0){
            return idx2 + 1;// insert remaining
        }

        if(idx2 < 0){
            return idx1 + 1;// delete remaining
        }
        
        if(memo[idx1][idx2] != -1)return memo[idx1][idx2];

        if(word1.charAt(idx1) == word2.charAt(idx2)){
            return memo[idx1][idx2] = dfs(word1, word2, idx1 - 1, idx2 - 1);
        }
        
        // replace
        char original = word1.charAt(idx1);
        word1.setCharAt(idx1, word2.charAt(idx2));
        int replace = 1 + dfs(word1, word2, idx1 - 1, idx2 - 1);
        word1.setCharAt(idx1, original);// backtrack


        // delete
        char deleted = word1.charAt(idx1);
        word1.deleteCharAt(idx1);
        int delete = 1 + dfs(word1, word2, idx1 - 1, idx2);
        word1.insert(idx1, deleted); // backtrack

        // insert
        word1.insert(idx1 + 1, word2.charAt(idx2));
        int insert = 1 + dfs(word1, word2, idx1, idx2 - 1);
        word1.deleteCharAt(idx1 + 1);

        return memo[idx1][idx2] = Math.min(replace, Math.min(insert, delete));
    }
}

// pure recursion
class Solution {
    int mn = 10000001;
    public int minDistance(String word1, String word2) {
        // -- we can delete only when the size of word1 greater than word2
        // -- we can insert only when the size of word 1 less than word2
        // -- if size becomes same we will only do replacement
        StringBuilder sb1 = new StringBuilder(word1);
        StringBuilder sb2 = new StringBuilder(word2);
        dfs(sb1, sb2, word1.length() - 1, word2.length() - 1, 0);
        return mn;
    }
    public void dfs(StringBuilder word1, StringBuilder word2, int idx1, int idx2, int cnt){
        if(idx1 < 0 && idx2 < 0 ){
            mn = Math.min(mn, cnt);
            return ;
        }

        if(idx1 < 0){
            mn = Math.min(mn, cnt + idx2 + 1);// insert remaining
            return;
        }

        if(idx2 < 0){
            mn = Math.min(mn, cnt + idx1 + 1);// delete remaining
            return;
        }

        if(word1.charAt(idx1) == word2.charAt(idx2)){
            dfs(word1, word2, idx1 - 1, idx2 - 1, cnt);
            return ;
        }

        // replace
        char original = word1.charAt(idx1);
        word1.setCharAt(idx1, word2.charAt(idx2));
        dfs(word1, word2, idx1 - 1, idx2 - 1, cnt + 1);
        word1.setCharAt(idx1, original);// backtrack


        // delete
        char deleted = word1.charAt(idx1);
        word1.deleteCharAt(idx1);
        dfs(word1, word2, idx1 - 1, idx2, cnt + 1);
        word1.insert(idx1, deleted); // backtrack

        // insert
        word1.insert(idx1 + 1, word2.charAt(idx2));
        dfs(word1, word2, idx1, idx2 - 1, cnt + 1);
        word1.deleteCharAt(idx1 + 1);
    }
}