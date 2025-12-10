package Array;

public class ComputerUnlockingPermutations {
    static final int MOD = 1_000_000_007;
    public int countPermutations(int[] complexity) {
        for(int i = 1; i < complexity.length; i++){
            if(complexity[i] <= complexity[0])return 0;

        }
        long ans = 1;
        for(int i = complexity.length - 1; i > 0; i--){
            ans = (ans * i) % MOD;
        }
        return (int)ans;
    }
}
