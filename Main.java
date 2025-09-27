 
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
 
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
    static ArrayList<tp> ans;
    static long cost[];
    static ArrayList<Integer> primeFactors;
    static boolean big[];
    static StringBuffer path;


    // For taking negative mod
    // int mod = 1000000007;
    // int result = ((-11 % mod) + mod) % mod; 
    // For taking negative mod


    public static void main(String[] args) throws IOException {
        //Reader input = new Reader("input.txt");
        //BufferedWriter log = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt")));
        int test = input.nextInt();
        for (int te = 0; te < test; te++) {

            long ans = solve();
            log.write(ans+"\n");
            // for(int i=0; i<ans.length; i++){
            //     log.write(ans[i]+" ");
            // }
            // log.write("\n");
            // if(ans == 1)log.write("YES\n");
            // else log.write("NO\n");
        }
        log.flush();
    }
    public static long solve(){
        int n = input.nextInt();
        // long k = input.nextLong();
        long[] b = new long[n];
        long[] a = new long[n];
        for(int i=0; i<n;i++){
            b[i] = input.nextLong();
        }
        for(int i=0; i<n;i++){
            a[i] = input.nextLong();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int j=0;
        long ans=1;
        for(int i=0; i<n;i++){
            while(j<n && b[j]<=a[i]){
                j++;
            }
            if(j<n){
                if((n-j)<=0)return 0;
                ans=(ans*((n-j)-(n-i-1)))%mod;
            }else{
                return 0;
            }
        }
        // for(int m=0; m<n;m++){
        //     System.out.print(c[m]+" ");
        // }
        // System.out.println();

        return ans;

    }
    public static long kadane(long[] nums) {
        long maxSoFar = nums[0];
        long currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }
    public static List<Integer> listOneZero(){
        List<Integer> arr = new ArrayList<>();
        for(int i = 2; i<32; i++){
            String binary = Integer.toBinaryString(i);
            arr.add(Integer.valueOf(binary));
        }
        return arr;
    }
    public static long quadratic(long a, long b, long c){
        double value = (Math.sqrt(4.0 * a * c + b * b) - b+1) / (2.0 * a);
        return (long) value;
    }
    public static long exactSqrt(long x) {
        long left = 0, right = (long)1e9 + 1; // since sqrt(1e18) ≈ 1e9
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
    public static int minDivisor(int n){
        for(int i=2; i<Math.round(Math.sqrt(n))+1;i++){
            if(n%i == 0){
                return i;
            }
        }
        return n;
    }
    public static int binLength(long n){
        int cnt = 0;
        while(n>0){
            n>>=1;
            cnt+=1;
        }
        return cnt-1;
    }
    public static long getBorderValue(int bins){
        long ans = 0;
        while(bins>=0){
            ans+=(1<<bins);
            bins-=2;
        }
        return ans;
    }
    public static long modPow(long base, long exp, int mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
    public static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            // Swap arr[left] and arr[right]
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    private static int countDigits(long l) {
        if (l >= 1000000000000000000L) return 19;
        if (l >= 100000000000000000L) return 18;
        if (l >= 10000000000000000L) return 17;
        if (l >= 1000000000000000L) return 16;
        if (l >= 100000000000000L) return 15;
        if (l >= 10000000000000L) return 14;
        if (l >= 1000000000000L) return 13;
        if (l >= 100000000000L) return 12;
        if (l >= 10000000000L) return 11;
        if (l >= 1000000000L) return 10;
        if (l >= 100000000L) return 9;
        if (l >= 10000000L) return 8;
        if (l >= 1000000L) return 7;
        if (l >= 100000L) return 6;
        if (l >= 10000L) return 5;
        if (l >= 1000L) return 4;
        if (l >= 100L) return 3;
        if (l >= 10L) return 2;
        return 1;
    }
    static int bitDiff(int val, String bin){
        String binar = Integer.toBinaryString(val);
        int start = bin.length() - binar.length();
        String binary = String.format("%"+bin.length()+"s", Integer.toBinaryString(val)).replace(' ', '0');
        if(start<=0)return -1;
        int ans = 0;
        for(int i=start;i<bin.length();i++){
            if(binary.charAt(i)!=bin.charAt(i)){
                if(binary.charAt(i)=='1'){
                    ans--;
                }else{
                    ans++;
                }
            }
        }
        return ans;
    }
    static class pp {
        int x;
        int y;
        long z;
 
        public pp(int x, int y, long z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
 
    static class SegTreeRegularBracket {
        pair seg[];
 
        public SegTreeRegularBracket(char ch[]) {
            seg = new pair[4 * ch.length];
            build(1, 1, ch.length - 1, ch);
        }
 
        void build(int idx, int s, int e, char ch[]) {
            if (s == e) {
                if (ch[s] == '(') {
                    seg[idx] = new pair(1, 0);
                } else {
                    seg[idx] = new pair(0, 1);
                }
                return;
            }
            build(idx << 1, s, (s + e) / 2, ch);
            build(idx << 1 | 1, (s + e) / 2 + 1, e, ch);
            seg[idx] = new pair(seg[idx << 1 | 1].x, seg[idx << 1].y);
            int dif = seg[idx << 1].x - seg[idx << 1 | 1].y;
            if (dif > 0) {
                seg[idx].x += dif;
            } else {
                seg[idx].y -= dif;
            }
        }
 
        pair query(int idx, int s, int e, int l, int r) {
            if (l > e || s > r) {
                return new pair(0, 0);
            }
            if (s >= l && e <= r) {
                return seg[idx];
            }
            pair p1 = query(idx << 1, s, (s + e) / 2, l, r);
            pair p2 = query(idx << 1 | 1, (s + e) / 2 + 1, e, l, r);
            pair ans = new pair(p2.x, p1.y);
            int dif = p1.x - p2.y;
            if (dif > 0) {
                ans.x += dif;
            } else {
                ans.y -= dif;
            }
            return ans;
        }
    }
 
 
    static int getNumberOfOnes(long x) {
        int cnt = 0;
        while (x >= 1) {
            if ((x & 1) > 0) cnt++;
            x >>= 1;
        }
        return cnt;
    }
 
    static boolean areAllSame(int[] num) {
        boolean allSame = true;
        for (int i = 1; i < num.length; i++) {
            if (num[i] != num[i - 1]) {
                allSame = false;
                break;
            }
        }
        return allSame;
    }

    static boolean isPal(int l, int r, int n, HashedString h, HashedString rh) {
        long v = h.getHash(l, r);
        long u = rh.getHash(n - r - 1, n - l - 1);
        return v == u;
    }
 
    static void dfs(int node, int par) {
        anc[node][0] = par;
        for (Integer ch : g[node]) {
            if (ch == par) continue;
            depth[ch] = depth[node] + 1;
            dfs(ch, node);
            nodes[node] += nodes[ch];
        }
        nodes[node]++;
    }
 
     static int bs(int[] nums, int left, int right, int target){
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]==target){
                return mid;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }

    static long[][] dij(int node, ArrayList<pair> g[], TreeSet<Integer> a) {
        PriorityQueue<paii> q = new PriorityQueue<>(new Comparator<paii>() {
            @Override
            public int compare(paii o1, paii o2) {
                return Long.compare(o1.y, o2.y);
            }
        });
        q.add(new paii(node, 0, 1));
        long distance[][] = new long[g.length][2];
        long oo = 1L << 60;
        for (int i = 0; i < g.length; i++) {
            Arrays.fill(distance[i], oo);
        }
        while (!q.isEmpty()) {
            paii p = q.poll();
            long cost = p.y;
            if (distance[p.x][p.z - 1] != oo) {
                continue;
            }
            int d = p.z;
            if (a.contains(p.x)) d = 2;
            distance[p.x][p.z - 1] = cost;
            ArrayList<pair> nodes = g[p.x];
            for (pair node1 : nodes) {
                if (distance[node1.x][d - 1] == oo) {
                    paii pa = new paii(node1.x, cost + node1.y / d, d);
                    q.add(pa);
                }
            }
        }
        return distance;
    }

    private void quickSelect(int[][] arr, int low, int high, int k) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            if (pivotIndex == k) {
                return; 
            } else if (pivotIndex > k) {
                quickSelect(arr, low, pivotIndex - 1, k);
            } else {
                quickSelect(arr, pivotIndex + 1, high, k);
            }
        }
    }
    private int partition(int[][] arr, int low, int high) {
        int[] pivot = arr[high];
        int pivotValue = pivot[0];  
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j][0] >= pivotValue) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1; 
    }
    private void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        u = lift(u, depth[u] - depth[v], anc);
 
        if (u == v) return u;
        for (int i = anc[0].length - 1; i >= 0; i--) {
            if (anc[u][i] != anc[v][i]) {
                u = anc[u][i];
                v = anc[v][i];
            }
        }
        return anc[u][0];
    }
 
    static int lift(int v, int d, int anc[][]) {
        int p = 1;
        for (int i = 0; i < anc[0].length; i++) {
            if ((p & d) > 0) {
                v = anc[v][i];
            }
            p <<= 1;
        }
        return v;
    }
 
    static class SegmentTreeEdu {
        private class Node {
            long value;
 
            public Node(long value) {
                this.value = value;
            }
        }
 
        private Node seg[];
        private int size;
        private int arr[];
 
        public SegmentTreeEdu(int a[]) {
            seg = new Node[a.length * 4];
            size = a.length - 1;
            arr = a.clone();
            build(1, 1, size, a);
        }
 
        public SegmentTreeEdu(int n) {
            seg = new Node[(n + 1) * 4];
            size = n;
            arr = new int[n + 1];
            build(1, 1, size, arr);
        }
 
        private Node merge(Node left, Node right) {
            return new Node(Math.max(left.value, right.value));
        }
 
        private void build(int idx, int l, int r, int a[]) {
            if (l == r) {
                seg[idx] = new Node(a[l]);
                return;
            }
            build(idx * 2, l, (l + r) / 2, a);
            build(idx * 2 + 1, (l + r) / 2 + 1, r, a);
            seg[idx] = merge(seg[idx * 2], seg[idx * 2 + 1]);
        }
 
        private void update(int idx, int l, int r, int index, int val) {
            if (index > r || index < l) return;
            if (index == l && index == r) {
                arr[l] = val;
                seg[idx] = new Node(arr[l]);
                return;
            }
            update(idx * 2, l, (l + r) / 2, index, val);
            update(idx * 2 + 1, (l + r) / 2 + 1, r, index, val);
            seg[idx] = merge(seg[idx * 2], seg[idx * 2 + 1]);
        }
 
        public void update(int index, int val) {
            update(1, 1, size, index, val);
        }
 
        public Node getSum(int idx, int s, int e, int l, int r) {
            if (r < s || l > e) return new Node(-1);
            if (s >= l && e <= r) return new Node(seg[idx].value);
            return merge(getSum(idx * 2, s, (s + e) / 2, l, r), getSum(idx * 2 + 1, (s + e) / 2 + 1, e, l, r));
        }
 
        public long getAns(int l, int r) {
            return getSum(1, 1, size, l, r).value;
        }
    }
 
    static class SegmentTreeEduM {
        private class Node {
            long value;
 
            public Node(long value) {
                this.value = value;
            }
        }
 
        private Node seg[];
        private int size;
        private int arr[];
 
        public SegmentTreeEduM(int a[]) {
            seg = new Node[a.length * 4];
            size = a.length - 1;
            arr = a.clone();
            build(1, 1, size, a);
        }
 
        public SegmentTreeEduM(int n) {
            seg = new Node[(n + 1) * 4];
            size = n;
            arr = new int[n + 1];
            build(1, 1, size, arr);
        }
 
        private Node merge(Node left, Node right) {
            return new Node(Math.min(left.value, right.value));
        }
 
        private void build(int idx, int l, int r, int a[]) {
            if (l == r) {
                seg[idx] = new Node(a[l]);
                return;
            }
            build(idx * 2, l, (l + r) / 2, a);
            build(idx * 2 + 1, (l + r) / 2 + 1, r, a);
            seg[idx] = merge(seg[idx * 2], seg[idx * 2 + 1]);
        }
 
        private void update(int idx, int l, int r, int index, int val) {
            if (index > r || index < l) return;
            if (index == l && index == r) {
                arr[l] = val;
                seg[idx] = new Node(arr[l]);
                return;
            }
            update(idx * 2, l, (l + r) / 2, index, val);
            update(idx * 2 + 1, (l + r) / 2 + 1, r, index, val);
            seg[idx] = merge(seg[idx * 2], seg[idx * 2 + 1]);
        }
 
        public void update(int index, int val) {
            update(1, 1, size, index, val);
        }
 
        public Node getSum(int idx, int s, int e, int l, int r) {
            if (r < s || l > e) return new Node(Integer.MAX_VALUE);
            if (s >= l && e <= r) return new Node(seg[idx].value);
            return merge(getSum(idx * 2, s, (s + e) / 2, l, r), getSum(idx * 2 + 1, (s + e) / 2 + 1, e, l, r));
        }
 
        public long getAns(int l, int r) {
            return getSum(1, 1, size, l, r).value;
        }
    }
 
    static class tp {
        int x, y, z, w;
 
        public tp(int x, int y, int z, int w) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.w = w;
        }
    }
 
    static int first(int suc[], int x) {
        int a = suc[x];
        int b = suc[a];
        while (a != b) {
            a = suc[a];
            b = suc[suc[b]];
        }
        a = x;
        while (a != b) {
            a = suc[a];
            b = suc[b];
        }
        return a;
    }
 
    static class advancedSegmentTree {
        private ArrayList<Integer> distinctElements;
        private SegmentTree seg;
        private SegmentTree segSum;
        private int size;
 
        public advancedSegmentTree() {
            distinctElements = new ArrayList<>();
            for (int i = (int) -4e5 - 5; i <= 4e5 + 5; i++) {
                distinctElements.add(i);
            }
            size = distinctElements.size() + 5;
            seg = new SegmentTree(size);
            segSum = new SegmentTree(size);
        }
 
        public advancedSegmentTree(int a[]) {
            distinctElements = new ArrayList<>();
            Arrays.sort(a);
            distinctElements.add(a[0]);
            for (int i = 1; i < a.length; i++) {
                if (a[i] != distinctElements.get(distinctElements.size() - 1)) {
                    distinctElements.add(a[i]);
                }
            }
            size = distinctElements.size() + 5;
            seg = new SegmentTree(size);
            segSum = new SegmentTree(size);
        }
 
        public advancedSegmentTree(int len) {
            distinctElements = new ArrayList<>();
            for (int i = 0; i <= len + 5; i++) {
                distinctElements.add(i);
            }
            size = distinctElements.size() + 5;
            seg = new SegmentTree(size);
            segSum = new SegmentTree(size);
        }
 
        public void add(int val) {
            int idx = val + 2;//getIndex(val);
            seg.updateIndex(1, 1, size, idx, 1);
            segSum.updateIndex(1, 1, size, idx, val);
        }
 
        public void remove(int val) {
            int idx = val + 2;// getIndex(val);
            seg.updateIndex(1, 1, size, idx, -1);
            segSum.updateIndex(1, 1, size, idx, -val);
        }
 
        public int getSum(int val) {
            return segSum.sumInRange(1, 1, size, 1, val - 1);
        }
 
 
        private int getIndex(int val) {
            int max = distinctElements.size() - 1;
            int min = 0;
            int ans = -1;
            while (max >= min) {
                int mid = (max + min) / 2;
                if (distinctElements.get(mid) == val) {
                    return mid + 2;
                } else if (distinctElements.get(mid) > val) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
            return ans;
        }
 
        public long countNumbersGreaterThan(int val) {
            int idx = getIndex(val);
            return seg.sumInRange(1, 1, size, idx + 1, size);
        }
 
        public long countNumbersEqualTo(int val) {
            int idx = getIndex(val);
            return seg.sumInRange(1, 1, size, idx, idx);
        }
 
        public long countNumbersLessThan(int val) {
            int idx = getIndex(val);
            return seg.sumInRange(1, 1, size, 1, idx - 1);
        }
 
        private static class SegmentTree {
 
            int size;
            int seg[], la[];
 
            public SegmentTree(int size) {
                this.size = size;
                seg = new int[size * 4];
                //  lazy = new long[seg.length];
            }
 
            void process(int idx, int s, int e) {
                seg[idx] += la[idx];
                if (s < e) {
                    la[idx * 2] += la[idx];
                    la[idx * 2 + 1] += la[idx];
                }
                la[idx] = 0;
            }
 
            void updateRange(int idx, int s, int e, int l, int r, int val) {
                process(idx, s, e);
                if ((l > e) || s > r) {
                    return;
                }
                if (s >= l && e <= r) {
                    la[idx] += val;
                    process(idx, s, e);
                    return;
                }
                updateRange(idx * 2, s, (s + e) / 2, l, r, val);
                updateRange(idx * 2 + 1, (s + e) / 2 + 1, e, l, r, val);
                seg[idx] = seg[idx * 2] + seg[idx * 2 + 1];
            }
 
            void updateIndex(int idx, int s, int e, int ind, int val) {
                //     process(idx, s, e);
                if (ind < s || ind > e) {
                    return;
                }
                if (s == ind && ind == e) {
                    seg[idx] += val;
                    return;
                }
                updateIndex(idx << 1, s, (s + e) / 2, ind, val);
                updateIndex(idx << 1 | 1, (s + e) / 2 + 1, e, ind, val);
                seg[idx] = seg[idx << 1] + seg[idx << 1 | 1];
            }
 
            int sumInRange(int idx, int s, int e, int l, int r) {
                //   process(idx, s, e);
                if ((l > e) || s > r) {
                    return 0;
                }
                if (s >= l && e <= r) {
                    return seg[idx];
                }
                return sumInRange(idx << 1, s, (s + e) / 2, l, r) + sumInRange(idx << 1 | 1, (s + e) / 2 + 1, e, l, r);
            }
        }
    }
 
    static class LowestCommonAncestor {
 
        private final int nodes[];
        private final int first[];
        private final int last[];
        private final int height[];
        static int cnt;
        private SegmentTreeMin seg;
 
        public LowestCommonAncestor(ArrayList<Integer> g[]) {
            nodes = new int[g.length * 2 - 1];
            first = new int[g.length];
            height = new int[g.length];
            last = new int[g.length];
            Arrays.fill(first, -1);
            cnt = 0;
            dfs(0, g, 1);
            // seg = new SegmentTreeMin(nodes.length - 1, nodes);
        }
 
        public LowestCommonAncestor(ArrayList<Integer>[] g, int root) {
            nodes = new int[g.length * 2 - 1];
            first = new int[g.length];
            height = new int[g.length];
            last = new int[g.length];
            Arrays.fill(first, -1);
            cnt = 0;
            dfs(root, g, 1);
            seg = new SegmentTreeMin(nodes.length - 1, nodes);
        }
 
        private void dfs(int node, ArrayList<Integer> g[], int lev) {
            first[node] = cnt;
            nodes[cnt++] = node;
            height[node] = lev;
            for (Integer ch : g[node]) {
                if (first[ch] == -1) {
                    dfs(ch, g, lev + 1);
                    nodes[cnt++] = node;
                }
            }
            last[node] = cnt;
        }
 
        public int findLCA(int node1, int node2) {
            int idx1 = first[node1];
            int idx2 = first[node2];
            if (idx1 > idx2) {
                int c = idx1;
                idx1 = idx2;
                idx2 = c;
            }
            return seg.query(1, 0, nodes.length - 1, idx1, idx2);
        }
 
        private class SegmentTreeMin {
 
            int size;
            int seg[];
 
            public SegmentTreeMin(int size, int euler[]) {
                this.size = size;
                seg = new int[size * 4];
                build(1, 0, size, euler);
            }
 
            private void build(int node, int b, int e, int euler[]) {
                if (b == e) {
                    seg[node] = euler[b];
                } else {
                    int mid = (b + e) / 2;
                    build(node << 1, b, mid, euler);
                    build(node << 1 | 1, mid + 1, e, euler);
                    int l = seg[node << 1], r = seg[node << 1 | 1];
                    seg[node] = (height[l] < height[r]) ? l : r;
                }
            }
 
            private int query(int node, int b, int e, int L, int R) {
                if (b > R || e < L) {
                    return -1;
                }
                if (b >= L && e <= R) {
                    return seg[node];
                }
                int mid = (b + e) >> 1;
                int left = query(node << 1, b, mid, L, R);
                int right = query(node << 1 | 1, mid + 1, e, L, R);
                if (left == -1) {
                    return right;
                }
                if (right == -1) {
                    return left;
                }
                return height[left] < height[right] ? left : right;
            }
        }
    }
 
    public static long ceil(long a, long b) {
        return (a + b - 1) / b;
    }
 
    public static long round(long a, long b) {
        if (a < 0) {
            return (a - b / 2) / b;
        }
        return (a + b / 2) / b;
    }
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    public static long nCr(int n, int r) {
        if (r > n) return 0;
        return factorial(n) / (factorial(r) * factorial(n - r));
    }
    static void getPrimeFactors(int a) {
        while (a % 2 == 0) {
            primeFactors.add(2);
            a /= 2;
        }
        for (int i = 3; i * i <= a; i += 2) {
            while (a % i == 0) {
                primeFactors.add(i);
                a /= i;
            }
        }
        if (a > 1) {
            primeFactors.add(a);
        }
    }
 
 
    static class SegmentTreeSum {
 
        int size;
        long seg[];
        long lazy[];
        int arr[];
 
        public SegmentTreeSum(int size, int a[]) {
            this.size = size;
            arr = a;
            seg = new long[size * 4];
            lazy = new long[size * 4];
            Arrays.fill(lazy, -1);
            build(1, 1, size, a);
        }
 
        private void build(int idx, int s, int e, int a[]) {
            if (s == e) {
                seg[idx] = a[s];
                return;
            }
            build(idx * 2, s, (s + e) / 2, a);
            build(idx * 2 + 1, (s + e) / 2 + 1, e, a);
            seg[idx] = seg[idx * 2] + seg[idx * 2 + 1];
 
        }
 
        void process(int idx, int s, int e) {
            if (lazy[idx] == -1) return;
            seg[idx] = lazy[idx];
            if (s < e) {
                lazy[idx * 2] = lazy[idx];
                lazy[idx * 2 + 1] = lazy[idx];
            }
            lazy[idx] = -1;
        }
 
        void updateRange(int idx, int s, int e, int l, int r, int val) {
            process(idx, s, e);
            if ((l > e) || s > r) {
                return;
            }
            if (s >= l && e <= r) {
                lazy[idx] = val;
                process(idx, s, e);
                return;
            }
            updateRange(idx * 2, s, (s + e) / 2, l, r, val);
            updateRange(idx * 2 + 1, (s + e) / 2 + 1, e, l, r, val);
            seg[idx] = seg[idx * 2] + seg[idx * 2 + 1];
        }
 
        void updateIndex(int idx, int s, int e, int ind, int val) {
            process(idx, s, e);
            if (ind < s || ind > e) {
                return;
            }
            if (s == ind && ind == e) {
                seg[idx] = val;
                return;
            }
            updateIndex(idx * 2, s, (s + e) / 2, ind, val);
            updateIndex(idx * 2 + 1, (s + e) / 2 + 1, e, ind, val);
            seg[idx] = seg[idx * 2] + seg[idx * 2 + 1];
        }
 
 
        long sumInRange(int idx, int s, int e, int l, int r) {
            process(idx, s, e);
            if ((l > e) || s > r) {
                return 0;
            }
            if (s >= l && e <= r) {
                return seg[idx];
            }
            return sumInRange(idx * 2, s, (s + e) / 2, l, r) + sumInRange(idx * 2 + 1, (s + e) / 2 + 1, e, l, r);
        }
    }
 
    static long mul(long a, long b) {
        return (long) ((long) ((a % mod) * (b % mod)) % mod);
    }
 
    static int getLog(long v) {
        int cnt = 0;
        while (v > 1) {
            cnt++;
            v >>= 1;
        }
        return cnt;
    }
 
 
    static class Node {
        Node node[];
        int val;
        int c;
 
        public Node() {
            node = new Node[2];
            val = 0;
            c = 0;
        }
    }
 
    static class XorTrie {
 
        Node node;
 
        public XorTrie() {
            node = new Node();
        }
 
        void insert(int x) {
            Node curr = node;
            for (int i = 30; i >= 0; i--) {
                int val = (x >> i) & 1;
                if (curr.node[val] == null) curr.node[val] = new Node();
 
                curr = curr.node[val];
                curr.val++;
            }
        }
    }
     public static double approximateHPSum(double a, double d, int n) {
        if (2 * a - d <= 0) {
            throw new IllegalArgumentException("Invalid values leading to log of non-positive number.");
        }

        double numerator = 2 * a + (2 * n - 1) * d;
        double denominator = 2 * a - d;
        double result = (1.0 / d) * Math.log(numerator / denominator);
        return result;
    }
    public static long power(long a, long p) {
        long res = 1;
        while (p > 0) {
            if (p % 2 == 0) {
                a = (a * a);
                p /= 2;
            } else {
                res = (res * a);
                p--;
            }
        }
        return res;
    }
 
    static class Trie {
        Trie fre[];
        int cnt;
 
        public Trie() {
            fre = new Trie[26];
            cnt = 0;
        }
 
        public void insert(char ch[], int idx) {
            cnt++;
            if (idx == ch.length) return;
            if (fre[ch[idx] - 'a'] == null) {
                fre[ch[idx] - 'a'] = new Trie();
            }
            fre[ch[idx] - 'a'].insert(ch, idx + 1);
        }
    }
 
    static pai absSub(pai a, pai b) {
        doWork(a, b);
        pai c = new pai(Math.abs(a.x - b.x), a.y);
        simplifyFraction(b);
        return c;
    }
 
    static pai add(pai a, pai b) {
        doWork(a, b);
        pai c = new pai(a.x + b.x, a.y);
        simplifyFraction(b);
        return c;
    }
 
    static pai mu(pai a, pai b) {
        long v = b.x;
        b.x = (int) b.y;
        b.y = v;
        simplifyFraction(b);
        simplifyFraction(a);
        pai c = new pai(a.x * b.x, a.y * b.y);
        simplifyFraction(c);
        return c;
    }
 
    static long compar(pai a, pai b) {
        doWork(a, b);
        if (a.x < b.x) {
            return -1;
        } else {
            return Math.min(1, a.x - b.x);
        }
    }
 
    static void doWork(pai a, pai b) {
        simplifyFraction(a);
        simplifyFraction(b);
        long c = a.y;
        a.y *= b.y;
        a.x *= b.y;
        b.y *= c;
        b.x *= c;
    }
 
    static void simplifyFraction(pai b) {
        long g = GCD(b.x, b.y);
        b.x /= g;
        b.y /= g;
    }
 
    static int cmp(pair o1, pair o2) {
        if (o1.x > o2.x) {
            return 1;
        } else if (o1.x < o2.x) {
            return -1;
        } else if (o1.y > o2.y) {
            return 1;
        } else if (o1.y < o2.y) {
            return -1;
        }
        return 0;
    }
 
    public static long LCM(long x, long y) {
        return x / GCD(x, y) * y;
    }
 
    static class paii {
        int x;
        long y;
        int z;
 
        public paii(int x, long y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
 
    static class pai {
        long x;
        long y;
 
        public pai(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
 
 
    static int sum(int x) {
        int s = 0;
        while (x > 0) {
            s += x % 10;
            x /= 10;
        }
        return s;
    }
 
    static class tm {
        long x;
        int idx;
 
        public tm(long x, int idx) {
            this.x = x;
            this.idx = idx;
        }
    }
 
    static void prefixSum2D(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            prefixSum(arr[i]);
        }
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 1; j < arr.length; j++) {
                arr[j][i] += arr[j - 1][i];
            }
        }
    }
 
    static int sumOfRange(int x1, int y1, int x2, int y2, int a[][]) {
        return (a[x2][y2] - a[x1 - 1][y2] - a[x2][y1 - 1]) + a[x1 - 1][y1 - 1];
    }
 
    static class SparseTableGCD {
        long table[][];
        int logTable[], powers[];
        int a[];
 
        public SparseTableGCD(int a[]) {
            this.a = a;
            logTable = new int[a.length + 1];
            for (int i = 2; i <= a.length; i++) {
                logTable[i] = logTable[i / 2] + 1;
            }
            int maxLog = logTable[a.length] + 1;
            table = new long[a.length][maxLog];
            powers = new int[maxLog];
            powers[0] = 1;
            for (int i = 1; i < powers.length; i++) {
                powers[i] = powers[i - 1] * 2;
            }
            for (int i = 0; i < a.length; i++) {
                table[i][0] = a[i];
            }
            for (int i = 1; i < maxLog; i++) {
                for (int j = 0; j + powers[i] - 1 < a.length; j++) {
                    table[j][i] = GCD(table[j][i - 1], table[j + powers[i - 1]][i - 1]);
                }
            }
        }
 
        long query(int l, int r) {
            int log = logTable[r - l + 1];
            return GCD(table[l][log], table[r - powers[log] + 1][log]);
        }
    }
 
    static class SparseTable {
        int table[][], logTable[], powers[];
        int a[];
 
        public SparseTable(int a[]) {
            this.a = a;
            logTable = new int[a.length + 1];
            for (int i = 2; i <= a.length; i++) {
                logTable[i] = logTable[i / 2] + 1;
            }
            int maxLog = logTable[a.length] + 1;
            table = new int[a.length][maxLog];
            powers = new int[maxLog];
            powers[0] = 1;
            for (int i = 1; i < powers.length; i++) {
                powers[i] = powers[i - 1] * 2;
            }
            for (int i = 0; i < a.length; i++) {
                table[i][0] = a[i];
            }
            for (int i = 1; i < maxLog; i++) {
                for (int j = 0; j + powers[i] - 1 < a.length; j++) {
                    table[j][i] = Math.max(table[j][i - 1], table[j + powers[i - 1]][i - 1]);
                }
            }
        }
 
        int query(int l, int r) {
            int log = logTable[r - l + 1];
            return Math.max(table[l][log], table[r - powers[log] + 1][log]);
        }
    }
 
    static void tarjan(int node, int par) {
        num[node] = lowesLink[node] = nu++;
        st.add(node);
        inStack[node] = true;
        for (Integer ch : g[node]) {
            if (num[ch] == 0) {
                tarjan(ch, node);
                lowesLink[node] = Math.min(lowesLink[node], lowesLink[ch]);
            } else if (inStack[ch]) {
                lowesLink[node] = Math.min(lowesLink[node], num[ch]);
            }
        }
        if (lowesLink[node] == num[node]) {
            int x = -1;
            stronConCom.add(new ArrayList<>());
            while (x != node) {
                x = st.pop();
                inStack[x] = false;
                stronConCom.getLast().add(x);
            }
        }
    }
 
    static long add(long a, long b) {
        a += b;
        if (a >= mod) {
            a -= mod;
        }
        return a;
    }
 
 
    static long modinv(long x) {
        return fast_pow(x, mod - 2, mod);
    }
 
    static long Div(long x, long y) {
        return mul(x, modinv(y));
 
    }
 
    static long mod(long a, long b) {
        long r = a % b;
        return r < 0 ? r + b : r;
    }
 
    static long Sub(long x, long y) {
        long z = x - y;
        if (z < 0) {
            z += mod;
        }
        return z;
    }
 
    static long fast_pow(long a, long p, long mod) {
        long res = 1;
        while (p > 0) {
            if (p % 2 == 0) {
                a = ((a % mod) * (a % mod)) % mod;
                p /= 2;
            } else {
                res = ((res % mod) * (a % mod)) % mod;
                p--;
            }
        }
        return res;
    }
 
    public static pair[] dijkstra(int node, ArrayList<pair> a[]) {
        PriorityQueue<tri> q = new PriorityQueue<>(new Comparator<tri>() {
            @Override
            public int compare(tri o1, tri o2) {
                if (o1.y > o2.y) {
                    return 1;
                } else if (o1.y < o2.y) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        q.add(new tri(node, 0, -1));
        pair distance[] = new pair[a.length];
        while (!q.isEmpty()) {
            tri p = q.poll();
            int cost = p.y;
            if (distance[p.x] != null) {
                continue;
            }
            distance[p.x] = new pair(p.pa, cost);
            ArrayList<pair> nodes = a[p.x];
            for (pair node1 : nodes) {
                if (distance[node1.x] == null) {
                    tri pa = new tri(node1.x, cost + node1.y, p.x);
                    q.add(pa);
                }
            }
        }
        return distance;
    }
 
    static class tri {
 
        int x;
        int y;
        int pa;
 
        public tri(int x, int y, int pa) {
            this.x = x;
            this.y = y;
            this.pa = pa;
        }
 
    }
 
 
    static long sqrt(long v) {
        long max = (long) 4e9;
        long min = 0;
        long ans = 0;
        while (max >= min) {
            long mid = (max + min) / 2;
            if (mid * mid > v) {
                max = mid - 1;
            } else {
                ans = mid;
                min = mid + 1;
            }
        }
        return ans;
    }
 
    static long cbrt(long v) {
        long max = (long) 3e6;
        long min = 0;
        long ans = 0;
        while (max >= min) {
            long mid = (max + min) / 2;
            if (mid * mid > v) {
                max = mid - 1;
            } else {
                ans = mid;
                min = mid + 1;
            }
        }
        return ans;
    }
 
    static int revI(int n) {
        int re = 0;
        while (n > 0) {
            re = re * 10 + n % 10;
            n /= 10;
        }
        return re;
    }
 
    static class Edge {
        int u, v;
        long cost;
 
        public Edge(int u, int v, long cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
 
        public String toString() {
            return u + " " + v + " " + cost;
        }
    }
 
    public static void prefixSum(long[] a) {
        for (int i = 1; i < a.length; i++) {
            a[i] += a[i - 1];
        }
    }
 
    public static void suffixSum(int[] a) {
        for (int i = a.length - 2; i > -1; i--) {
            a[i] += a[i + 1];
        }
    }
 
    public static void prefixSum(int[] a) {
        for (int i = 1; i < a.length; i++) {
            a[i] = a[i] + a[i - 1];
        }
    }
 
    public static void suffixSum(long[] a) {
        for (int i = a.length - 2; i > -1; i--) {
            a[i] = a[i] + a[i + 1];
        }
    }
 
    static class HashedString {
        public static final long M = 911382323;
        public static final long B = 972663749;
        private static ArrayList<Long> pow = new ArrayList<>();
 
        private ArrayList<Long> pHash; // Change to ArrayList to allow resizing
        private int length; // Keep track of the current length
 
        // Constructor initializes the hash for the given string
        public HashedString(String s) {
            if (pow.isEmpty()) {
                pow.add(1L);
            }
            while (pow.size() <= s.length()) {
                pow.add((pow.get(pow.size() - 1) * B) % M);
            }
 
            pHash = new ArrayList<>(s.length() + 1);
            pHash.add(0L); // Initialize the first value
            for (int i = 0; i < s.length(); i++) {
                pHash.add((pHash.get(i) * B % M + s.charAt(i)) % M);
            }
            length = s.length(); // Set the initial length
        }
 
        // Method to append a new character to the string
        public void addChar(char c) {
            length++; // Increment length
            // Ensure pow array has enough precomputed values
            if (pow.size() <= length) {
                pow.add((pow.get(pow.size() - 1) * B) % M);
            }
            // Compute the new hash value and add it to pHash
            long newHash = (pHash.get(length - 1) * B % M + c) % M;
            pHash.add(newHash);
        }
 
        // Get hash of the substring from start to end (inclusive)
        public long getHash(int start, int end) {
            long rawVal = pHash.get(end + 1) - (pHash.get(start) * pow.get(end - start + 1) % M);
            return (rawVal % M + M) % M;
        }
 
        // Return the current length of the hashed string
        public int getLength() {
            return length;
        }
    }
 
 
    static class SegmentTreeMax {
 
        int size;
        int seg[];
        int lazy[];
        long arr[];
 
        public SegmentTreeMax(int size, long[] a) {
            this.size = size;
            arr = a;
            seg = new int[size * 4];
            //lazy = new int[size * 4];
            build(1, 1, size, a);
        }
 
        private void build(int idx, int s, int e, long a[]) {
            if (s == e) {
                seg[idx] = s;
                return;
            }
            build(idx * 2, s, (s + e) / 2, a);
            build(idx * 2 + 1, (s + e) / 2 + 1, e, a);
            if (arr[seg[idx * 2 + 1]] <= arr[seg[idx * 2]]) {
                seg[idx] = seg[idx * 2];
            } else {
                seg[idx] = seg[idx * 2 + 1];
            }
        }
 
        void process(int idx, int s, int e) {
            seg[idx] += lazy[idx];
            if (s < e) {
                lazy[idx * 2] += lazy[idx];
                lazy[idx * 2 + 1] += lazy[idx];
            }
            lazy[idx] = 0;
        }
 
        void updateRange(int idx, int s, int e, int l, int r, int val) {
            process(idx, s, e);
            if ((l > e) || s > r) {
                return;
            }
            if (s >= l && e <= r) {
                lazy[idx] += val;
                process(idx, s, e);
                return;
            }
            updateRange(idx * 2, s, (s + e) / 2, l, r, val);
            updateRange(idx * 2 + 1, (s + e) / 2 + 1, e, l, r, val);
            if (arr[seg[idx * 2 + 1]] <= arr[seg[idx * 2]]) {
                seg[idx] = seg[idx * 2];
            } else {
                seg[idx] = seg[idx * 2 + 1];
            }
        }
 
        void updateIndex(int idx, int s, int e, int ind, int val) {
            if (ind < s || ind > e) {
                return;
            }
            if (s == ind && ind == e) {
                arr[s] = val;
                return;
            }
            updateIndex(idx * 2, s, (s + e) / 2, ind, val);
            updateIndex(idx * 2 + 1, (s + e) / 2 + 1, e, ind, val);
            if (arr[seg[idx * 2 + 1]] <= arr[seg[idx * 2]]) {
                seg[idx] = seg[idx * 2];
            } else {
                seg[idx] = seg[idx * 2 + 1];
            }
        }
 
        int maxInRange(int idx, int s, int e, int l, int r) {
            //  process(idx, s, e);
            if ((l > e) || s > r) {
                return Integer.MIN_VALUE;
            }
            if (s >= l && e <= r) {
                return seg[idx];
            }
            int a1 = maxInRange(idx * 2, s, (s + e) / 2, l, r);
            int a2 = maxInRange(idx * 2 + 1, (s + e) / 2 + 1, e, l, r);
            if (a1 == Integer.MIN_VALUE) return a2;
            if (a2 == Integer.MIN_VALUE) return a1;
            if (arr[a1] >= arr[a2]) return a1;
            return a2;
        }
    }
 
    static boolean isPalindrome(String w) {
        for (int i = 0; i < w.length() / 2; i++) {
            if (w.charAt(i) != w.charAt(w.length() - i - 1)) return false;
        }
        return true;
    }
 
    public static boolean isValid(int i, int j, int n, int m) {
        return (i > -1 && i < n) && (j > -1 && j < m);
 
    }
 
 
    static int cmpDouble(double a, double b) {
        if (Math.abs(a - b) <= 1e-7) {
            return 0;
        }
        return a < b ? -1 : 1;
    }
 
 
    public static long GCD(long x, long y) {
        while (y != 0) {
            long c = x % y;
            x = y;
            y = c;
        }
        return x;
    }
 
    static boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        if (num == 3) {
            return true;
        }
        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
 
 
    public static int[] swap(int data[], int left, int right) {
 
        // Swap the data
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;
 
        // Return the updated array
        return data;
    }
 
    public static int[] reverse(int data[], int left, int right) {
 
        // Reverse the sub-array
        while (left < right) {
            int temp = data[left];
            data[left++] = data[right];
            data[right--] = temp;
        }
 
        // Return the updated array
        return data;
    }
 
 
    public static boolean findNextPermutation(int data[]) {
 
        if (data.length <= 1) {
            return false;
        }
 
        int last = data.length - 2;
 
        // find the longest non-increasing suffix
        // and find the pivot
        while (last >= 0) {
            if (data[last] < data[last + 1]) {
                break;
            }
            last--;
        }
 
        // If there is no increasing pair
        // there is no higher order permutation
        if (last < 0) {
            return false;
        }
 
        int nextGreater = data.length - 1;
 
        // Find the rightmost successor to the pivot
        for (int i = data.length - 1; i > last; i--) {
            if (data[i] > data[last]) {
                nextGreater = i;
                break;
            }
        }
 
        // Swap the successor and the pivot
        data = swap(data, nextGreater, last);
 
        // Reverse the suffix
        data = reverse(data, last + 1, data.length - 1);
 
        // Return true as the next_permutation is done
        return true;
    }
 
    static double calcArea(pair a, pair b, pair c) {
        double ret = Math.abs((a.x * (double) (b.y - c.y)) + (b.x * (double) (c.y - a.y)) + (c.x * (double) (a.y - b.y))) / 2.0;
        return ret;
    }
 
 
    static class MultiSet<T> {
 
        TreeMap<T, Integer> fre;
        TreeSet<T> set;
        int size;
 
        public MultiSet() {
            set = new TreeSet<>();
            fre = new TreeMap<>();
            size = 0;
        }
 
        public MultiSet(Comparator<T> cmp) {
            set = new TreeSet<>(cmp);
            fre = new TreeMap<>(cmp);
            size = 0;
        }
 
        public void add(T elem) {
            if (fre.get(elem) == null || fre.get(elem) == 0) {
                fre.put(elem, 0);
                set.add(elem);
            }
            fre.put(elem, fre.get(elem) + 1);
            size++;
        }
 
        public void remove(T elem) {
            if (!set.contains(elem)) return;
            fre.put(elem, fre.get(elem) - 1);
            if (fre.get(elem) == 0) {
                set.remove(elem);
            }
            size--;
        }
 
 
        public boolean contains(T elem) {
            return set.contains(elem);
        }
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
 
    static class pair {
        public int x, d, y;
        public long c;
 
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
 
        public String toString() {
            return x + " " + y;
        }
    }
 
    static class DSU {
        int[] parent, groupSize;
        int numberOfNodes, numberOfGroups, maxGroup;
 
        public DSU(int numberOfNodes) {
            this.numberOfNodes = numberOfNodes;
            parent = new int[numberOfNodes + 1];
            groupSize = new int[numberOfNodes + 1];
            numberOfGroups = numberOfNodes;
            maxGroup = 1;
            for (int i = 1; i <= numberOfNodes; i++) {
                parent[i] = i;
                groupSize[i] = 1;
            }
        }
 
        public int getLeader(int x) {
            return parent[x] = (parent[x] == x ? x : getLeader(parent[x]));
        }
 
        public boolean sameGroup(int x, int y) {
            return getLeader(x) == getLeader(y);
        }
 
        public long mergeGroups(int x, int y) {
            int leader1 = getLeader(x);
            int leader2 = getLeader(y);
            if (leader1 != leader2) {
                numberOfGroups--;
                if (groupSize[leader1] < groupSize[leader2]) {
                    int temp = leader1;
                    leader1 = leader2;
                    leader2 = temp;
                }
                parent[leader2] = leader1;
                long v = groupSize[leader2] * (long) (groupSize[leader2] - 1) / 2;
                v += groupSize[leader1] * (long) (groupSize[leader1] - 1) / 2;
                groupSize[leader1] += groupSize[leader2];
                maxGroup = Math.max(maxGroup, groupSize[leader1]);
                return groupSize[leader1] * (long) (groupSize[leader1] - 1) / 2 - v;
            } else {
                return 0;
            }
        }
 
        public int getSize(int x) {
            return groupSize[getLeader(x)];
        }
    }
 
}