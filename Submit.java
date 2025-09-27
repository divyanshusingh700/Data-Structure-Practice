import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Submit {
 
    static int grid[][] = {{0, 0, 1, -1, 1, 1, -1, -1}, {1, -1, 0, 0, 1, -1, 1, -1}};
    static long[][] dp2;
    static int[][][] dp;
    static int mod = (int) 1e9 + 7;
    static int mo = 998244353;
    static int nu;
    static ArrayList<Integer> conCom;
    static int num[], lowesLink[], max1[], max2[];
    static boolean inStack[];
    static Stack<Integer> st;
    static LinkedList<ArrayList<Integer>> stronConCom;
 
    static boolean cycle[];
    static boolean vi[], s[];
    static boolean ca;
    static ArrayList<Integer>[] g, rg;
    static int oo = (int) 1e9;
    static Reader input = new Reader();
 
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
    static int anc[][], depth[], in[], out[], timer, nodes[];
    // static ArrayList<tp> ans;
    static long cost[];
    static ArrayList<Long> primeFactors;
    static boolean big[];
    static StringBuffer path;


    // For taking negative mod
    // int mod = 1000000007;
    // int result = ((-11 % mod) + mod) % mod; 
    // For taking negative mod
    // why deque is very efficient than stack
    static long[] basis = new long[64];

    public static void main(String[] args) throws IOException {
        //Reader input = new Reader("input.txt");
        //BufferedWriter log = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt")));
        int test = input.nextInt();

        for (int te = 0; te < test; te++) {

            String ans = solve();
            // int n = input.nextInt();
            // if(ans[0] == -1){
            //     log.write(-1+"\n");
            //     continue;
            // }
            // System.out.printf("%.7f\n", ans);
            // log.write(ans+"\n");
            // for (Integer it : ans) {
                // log.write(it+" ");
            // }
            // for(int i=0; i<ans.length; i++){
            //     log.write(ans[i]+" ");
            // }
            // mp = new HashMap<>(2);
            // while (!ans.isEmpty()) {
            //     log.write(ans.pollFirst()+" ");
            // }
            log.write(ans+"\n");
            // if(ans)log.write("YES\n");
            // else log.write("NO\n");
        }
        log.flush();
    }
    public static String solve(){
        int n = input.nextInt();
        int m = input.nextInt();
        int a = input.nextInt();
        int b = input.nextInt();
        // double h = input.nextDouble();
        // int m = input.nextInt();
        // int x = input.nextInt();
        // String s = input.nextLine();
        // String t = input.nextLine();
        // long x = input.nextLong();
        // long y = input.nextLong();
        // long z = input.nextLong();
        // int k = input.nextInt();
        // long[] a = new long[n];
        int left = b-1 * n;
        int right = m-b * n;
        int up = a-1 * m;
        int down = n-a * m;
        if(left>right){
            if(left>up){
                if(left>down){
                    m -= b;
                }else{
                    n = a;
                }
            }else{
                if(up>down){
                    n -= a;
                }else{
                    n = a;
                }
            }
        }else{
            if(right>up){
                if(right>down){
                    m = b;
                }else{
                    n=a;
                }
            }else{
                if(up>down){
                    n-=a;
                }else{
                    n = a;
                }
            }
        }

       
    }
    static void insertToBasis(long x) {
        for (int i = 63; i >= 0; i--) {
            if (((x >> i) & 1) == 0) continue;
            if (basis[i] == 0) {
                basis[i] = x;
                return;
            }
            x ^= basis[i];
        }
    }

    static long maximize(long x) {
        for (int i = 63; i >= 0; i--) {
            if ((x ^ basis[i]) > x) {
                x ^= basis[i];
            }
        }
        return x;
    }

    public static long pairAbsDiffSum(long[] a) {
        Arrays.sort(a);  // Sort the array
        int n = a.length;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += a[i] * (2L * i - n + 1);
        }

        return sum;
    }
    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public static int[] top3Max(long[] arr){
        int n = arr.length;
        int firstMax = -1, secondMax = -1, thirdMax = -1;
        for(int i=0; i<n; i++){
            if(firstMax==-1 || arr[i] > arr[firstMax]){
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = i;
            }
            else if(secondMax==-1 || arr[i] > arr[secondMax]){
                thirdMax = secondMax;
                secondMax = i;
            }
            else if(thirdMax==-1 || arr[i] > arr[thirdMax]){
                thirdMax = i;
            }
        }
        return new int[]{firstMax, secondMax, thirdMax};
    }
    public static long[][] top3MaxWithIdxes(long[] arr){
        int n = arr.length;
        long[] firstMax = new long[2], secondMax = new long[2], thirdMax = new long[2];
        for(int i=0; i<n; i++){
            if(arr[i] > firstMax[0]){
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = new long[]{arr[i],i};
            }
            else if(arr[i]> secondMax[0]){
                thirdMax = secondMax;
                secondMax = new long[]{arr[i],i};
            }
            else if(arr[i]> thirdMax[0]){
                thirdMax = new long[]{arr[i],i};
            }
        }
        return new long[][]{firstMax, secondMax, thirdMax};
    }
    public static int lowerBound(List<Integer> arr, int target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    public static long exactSqrt(long x) {
        long left = 1, right = (long)1e9 + 1; // since sqrt(1e18) ≈ 1e9
        long ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid <= x / mid) { // avoid mid*mid to prevent overflow
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    public static int maxNForAPSum(long sum, long a, long d) {
        int low = 1, high = (int) 1e6;
        int best = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            long apSum = mid * (2 * a + (mid - 1) * d) / 2;
            if (apSum <= sum) {
                best = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return best;
    }
    public static long smArray(long[] arr, long totalSm){
        int n = arr.length;
        if(n == 2){
            return Math.max(totalSm, Math.abs(arr[1] - arr[0]));
        }
        long[] fin = new long[n - 1];
        long finSm = 0;
        for(int i = 1; i < n; i++){
            fin[i - 1] = arr[i] - arr[i - 1];
            finSm += fin[i - 1];
        }
        totalSm = Math.max(Math.abs(finSm), totalSm);
        return smArray(fin, totalSm);
    } 
    public static void reverse(long[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            // Swap elements
            long temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
    public static long rowSum(long[] row) {
        int sum = 0;
        for (long val : row) sum += val;
        return sum;
    }
    public static int lower_bound (long[] arr, long num){
        int n = arr.length, low = 0, high = n - 1, ans = n - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (arr[mid] >= num){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    public static int upper_bound (long[] arr, long num){
        int n = arr.length, low = 0, high = n - 1, ans = 0;
        while (low <= high){
            int mid = (low + high) / 2;
            if (arr[mid] <= num){
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return ans;
    }
    public static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
    public static long sumOfAP(long a, long d, long n) {
        return n * (2 * a + (n - 1) * d) / 2;
    }
    public static List<Long> getFactors(long n, long mx) {
        Set<Long> result = new HashSet<>();
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i <= mx) result.add(i);
                if (n / i <= mx) result.add(n / i);
            }
        }
        return new ArrayList<>(result);
    }
    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static List<Long> getPrimeFactors(long a) {
        List<Long> primeFactors = new ArrayList<>();
        while (a % 2 == 0) {
            long val = 2;
            primeFactors.add(val);
            a /= 2;
        }
        for (long i = 3; i * i <= a; i += 2) {
            while (a % i == 0) {
                primeFactors.add(i);
                a /= i;
            }
        }
        if (a > 1) {
            primeFactors.add(a);
        }
        return primeFactors;
    }
    static class Reader extends PrintWriter {
 
        private BufferedReader r;
        private StringTokenizer st;
        // standard input
 
        public Reader() {
            this(System.in, System.out);
        }
 
        public Reader(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input
 
        public Reader(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName));
        }
 
        // returns null if no more input
        String nextLine() {
            String str = "";
            try {
                str = r.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
 
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(r.readLine());
                }
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
        public double nextDouble() {
            return Double.parseDouble(next());
        }
 
        public long nextLong() {
 
            return Long.parseLong(next());
        }
    }
    static int randomInt(int l, int r) {
        return l + (int) (Math.random() * ((r - l) + 1));
    }
 
    static int upperDiv(int a, int b) {
        return (a / b) + ((a % b == 0) ? 0 : 1);
    }
 
    static long upperDiv(long a, long b) {
        return (a / b) + ((a % b == 0) ? 0 : 1);
    }
 
    static <T extends Number> long sum(List<T> a) {
        return a.stream().map(Number::longValue).reduce(0L, Long::sum);
    }
 
    static <T extends Comparable<T>> T max(List<T> a) {
        return a.stream().max(Comparable::compareTo).get();
    }
 
    static <T extends Comparable<T>> T min(List<T> a) {
        return a.stream().min(Comparable::compareTo).get();
    }
 
    static long sum(int[] a) {
        return Arrays.stream(a).asLongStream().sum();
    }
 
    static int max(int[] a) {
        return Arrays.stream(a).max().getAsInt();
    }
 
    static int min(int[] a) {
        return Arrays.stream(a).min().getAsInt();
    }
 
    static long sum(long[] a) {
        return Arrays.stream(a).sum();
    }
 
    static long max(long[] a) {
        return Arrays.stream(a).max().getAsLong();
    }
 
    static long min(long[] a) {
        return Arrays.stream(a).min().getAsLong();
    }
 
    static long[] post(int[] a) {
        long[] post = new long[a.length + 1];
        post[0] = 0;
        for (int i = 0; i < a.length; i++) {
            post[i + 1] = post[i] + a[a.length - 1 - i];
        }
        return post;
    }
 
    static long[] pre(int[] a) {
        long[] pre = new long[a.length + 1];
        pre[0] = 0;
        for (int i = 0; i < a.length; i++) {
            pre[i + 1] = pre[i] + a[i];
        }
        return pre;
    }
}
