class StartegyByuSellStock {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] prefix = new long[n];
        prefix[0] = prices[0];
        for(int i = 1; i < n; i++){
            prefix[i] = prices[i] + prefix[i - 1];
        }

        long[] prefixStock = new long[n];
        prefixStock[0] = prefix[0]*strategy[0];
        for(int i = 1; i < n; i++){
            prefixStock[i] = prices[i] * strategy[i] + prefixStock[i - 1];
        }
        long base = prefixStock[n - 1];
        long mx = prefixStock[n - 1];

        for(int i = 0; (i + k) <= n; i++){
            int start = i + k / 2; 
            int end = i + k;
            long midSell = prefix[end - 1] - ((start > 0) ? prefix[start - 1] : 0);
            long window = prefixStock[end - 1] - (i > 0 ? prefixStock[i - 1] : 0);
            mx = Math.max(mx, base - window + midSell);
        }
        return mx;

    }
}

