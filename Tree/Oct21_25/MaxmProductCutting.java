package Oct21_25;

public class MaxmProductCutting {
    public int maxProduct(int n) {
        // Your code goes here
        if(n==2)return 1;
        if(n==3)return 2;
        int rem = n%3;
        int div = n/3;
        if(rem == 1){
            div-=1;
            return (int)(4*Math.pow(3,div));
        }else if(rem == 2){
            return (int)(2*Math.pow(3,div));
        }else{
            return (int)(Math.pow(3,div));
        }
    }
};
