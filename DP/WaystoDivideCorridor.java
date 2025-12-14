public class WaystoDivideCorridor {
    long ans;
    int mod = 1_000_000_007;
    public int numberOfWays(String corridor) {
        ans = 1;
        int sCnt = 0;
        for(char ch: corridor.toCharArray()){
            if(ch == 'S')sCnt++;
        }
        if((sCnt & 1) == 1 || sCnt == 0)return 0;
        dfs(corridor, corridor.length() - 1, 0, 0);
        return (int)ans;

    }
    public int dfs(String corridor, int idx, int cntS, int res){
        if(idx == -1)return 1;
        if(corridor.charAt(idx) == 'S')cntS++;
        if(cntS > 0 && (cntS & 1) == 0){
            res++;
        }else if((cntS & 1) == 1 && res != 0){
            ans = (ans * res) % mod;
            res = 0;
        }
        
        return dfs(corridor, idx - 1, cntS, res);
    }
}