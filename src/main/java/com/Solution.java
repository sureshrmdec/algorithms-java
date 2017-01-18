package com;

import java.io.*;
import java.util.*;

// (5,9) (4,5) (4,7)
public class Solution {

    public static void main(String[] args) {
//        InputStream inputStream = System.in;
//        OutputStream outputStream = System.out;
//        InputReader in = new InputReader(inputStream);
//        PrintWriter out = new PrintWriter(outputStream);
//        TaskA solver = new TaskA();
//        solver.solve(in, out);
//        out.close();
//        "[\"X..X\",\"...X\",\"...X\"]";
//        int[][] input = new int[6][2];
//        input[0] = new int[]{7, 0};
//        input[1] = new int[]{4, 4};
//        input[2] = new int[]{7, 1};
//        input[3] = new int[]{5, 0};
//        input[4] = new int[]{6, 1};
//        input[5] = new int[]{5, 2};
//        System.out.println(new Solution().reconstructQueue(input));
//        //[[46,89],[50,53],[52,68],[72,45],[77,81]]
//        int[][] envelopes = new int[5][2];
//        envelopes[0] = new int[]{46,89};
//        envelopes[1] = new int[]{50,53};
//        envelopes[2] = new int[]{52,68};
//        envelopes[3] = new int[]{72,45};
//        envelopes[4] = new int[]{77,81};
//        System.out.println(new Solution().maxEnvelopes(envelopes));
//        System.out.println(new Solution().maxProduct(new int[]{2, 3,-2,4}));
//        System.out.println(new Solution().maxProduct(new int[]{2, 3,-2,2,-2}));
        //[1,2,3,4], return [24,12,8,6]
//        int[] ints = new Solution().productExceptSelf(new int[]{1, 2, 3, 4});
//        for (int i = 0; i < ints.length; i++) {
//            System.out.print(ints[i]+" ");
//        }
        //[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4] 0, 0, 1, 6, 8
//        System.out.println(new Solution().minMoves(new int[]{1, 0, 0, 8, 6}));
//        int[] ar = {1, 2, 0, 8, 6};
//        System.out.println(new Solution().findKth(ar,0,ar.length-1,3));
//        System.out.println(new Solution().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));

//        System.out.println(new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4,0,4}));
//        System.out.println(new Solution().find132pattern(new int[]{-2,1,2,-2,1,2}));
//        System.out.println(new Solution().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
//        System.out.println(new Solution().isValidSerialization("1,#"));
//        System.out.println(new Solution().isValidSerialization("9,#,#,1"));
//        System.out.println(new Solution().isValidSerialization("9,8,#,#"));
//        System.out.println(new Solution().isValid("{he}[{sa{d}]"));
//        System.out.println(new Solution().isPalindrome("race a car"));
//        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(new Solution().hammingDistance(4, 14));
//        System.out.println(new Solution().findTheDifference("hello", "qolehl"));
//        int[] intersect = new Solution().intersect(new int[]{1}, new int[]{1,1});
//        System.out.println(new Solution().singleNumber(new int[]{1, 2, 3, 4, 3, 1, 2, 5, 5}));
//        System.out.println(new Solution().isSameTree(getTree(), getTree()));
//        TreeNode treeNode = new Solution().sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7 });
//        System.out.println(new Solution().isSameTree(getTree(), getTree()));
//        TreeNode treeNode = new Solution().sortedListToBSTIterative(getSortedList());
//        System.out.println(new Solution().isValidBSTIteratively(getTree()));
//        System.out.println(new Solution().rob(new int[]{1, 3, 9, 7, 3, 8}));
//        System.out.println(new Solution().climbStairs(5));
//        System.out.println(new Solution().integerBreak(11));
//        System.out.println(new Solution().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
//        System.out.println(new Solution().isSubsequence("acb", "ahbgdc"));
//        System.out.println(new Solution().coinChange(new int[]{2}, 3));
//        System.out.println(new KnapSack().run(50, new int[]{10, 20, 30}, val, val.length));
//        System.out.println(new Solution().findDuplicate(new int[]{1,2,3,4,6,8,9,0,1,1,100}));
//        System.out.println(new Solution().canPartition(new int[]{8, 3, 3,1,1}));
        System.out.println(new Solution().numberOfwaysToFormNumber(new int[]{8, 3, 3,1,1},8));


    }

    public static char[][] getACharGrid(){
        char[][] ar = new char[4][5];
        ar[0] = new char[]{1,1,0,0,0};
        ar[1] = new char[]{1,1,0,0,0};
        ar[2] = new char[]{0,0,1,0,0};
        ar[3] = new char[]{0,0,0,1,1};
        return ar;
    }

    public static ListNode getSortedList(){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next= new ListNode(7);
        return node;
    }

    public static void printBoolMatrix(boolean[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static TreeNode getTree(){
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.left.left.left = new TreeNode(1);

        node.right = new TreeNode(10);
        node.right.right = new TreeNode(100);
        return node;
    }

    public static class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }

        static ListNode build(int[] ar){
            ListNode first = new ListNode(ar[0]);
            ListNode current = first;
            for (int i = 1; i < ar.length; i++) {
                current.next = new ListNode(ar[i]);
                current = current.next;
            }
            return first;
        }
    }

    public static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }

    public int numberOfwaysToFormNumber(int[] nums,int n) {
        // dp def
        int[] dp = new int[n + 1];
        // dp init
        dp[0] = 1;
        // dp transition
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <nums.length-nums[i-1] ; j++) {
                dp[j] += dp[j+nums[i-1]];
            }
        }
        return dp[n];
    }


    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int volumn = 0;
        for (int num : nums) {
            volumn += num;
        }
        if (volumn % 2 != 0) {
            return false;
        }
        volumn /= 2;
        // dp def
        boolean[] dp = new boolean[volumn + 1];
        // dp init
        dp[0] = true;
        // dp transition
        for (int i = 1; i <= nums.length; i++) {
            for (int j = volumn - nums[i-1]; j >=0 ; j--) {
                if(dp[j])  dp[j+nums[i-1]] = true;
            }
        }
        return dp[volumn];
    }


    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        return findBinary(nums,0,nums.length-1);
    }

    private int findBinary(int[] nums, int s, int e) {
        int mid = s+ (e-s)/2;
        if(nums[mid]==nums[mid-1]){
            return nums[mid-1];
        }else {
            int res = findBinary(nums, s, mid);
            if(res==-1){
                res = findBinary(nums,mid+1,e);
            }
            return res;
        }
    }


    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length;
        int mid;
        while(left<right){
            mid = (left + right)/2;
            if(nums[mid]>mid) right = mid;
            else left = mid+1;
        }
        return left;
    }


    public void moveZeroes(int[] nums) {
        int n = 0;
        int z = 0;
        while(true){
            while(n<nums.length && nums[n]==0) n++;
            while(z<nums.length && nums[z]!=0) z++;
            if(n==nums.length || z==nums.length) break;
            if(n>z) {
                int tmp = nums[n];
                nums[n] = nums[z];
                nums[z] = tmp;
            }else{
                n++;
            }
        }
        System.out.println();
    }

    private int knapsack(int W, int[] weights, int[] val) {
        int[][] dp = new int[val.length+1][W+1];

        for (int i = 0; i <= weights.length; i++) {

        }

        return dp[val.length+1][W];
    }

    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        if(coins.length==0) return -1;
        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
                for (int j=0;j<coins.length;j++){
                    if(coins[j]==i){
                        dp[i] = 1;
                    }else if(i-coins[j]>0 && dp[i - coins[j]]!=Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
        }

        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

    public boolean isSubsequence(String s, String t) {
        if(s.length()==0) return true;
        if(t.length()==0 && s.length()>0) return false;
        int sCount = 0;
        int tCount = 0;
        while(sCount<s.length() && tCount<t.length()){
            if(t.charAt(tCount)==s.charAt(sCount)){
                sCount++;
            }
            tCount++;
        }
        return sCount==s.length();
    }

    public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if(dp[i]>res){
                res = dp[i];
            }
        }
        return res;
    }

    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i < n; i++) {
            dp[i] = i;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i-j; j++) {
                dp[i] = Math.max(dp[j]*dp[i-j],dp[i]);
            }
        }
        return dp[n];
    }

    public int climbStairs(int n) {
        if(n<3) return n;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+ dp[i-2];
        }
        return dp[n];
    }

    public int rob(int[] nums) {
        int[][] dp = new int[nums.length+1][2];
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = Math.max(dp[i-1][1],dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0]+nums[i-1],nums[i-1]);
        }
        return Math.max(dp[nums.length][0],dp[nums.length][1]);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            list.add(pop.val);
            root = pop.right;
        }
        return list;
    }

    public boolean isValidBSTIteratively(TreeNode root) {
        if(root==null) return true;
        Stack<TreeNode> stack = new Stack<>();
        Integer pre = null;
        while (!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if(pre!=null && pre>=pop.val){
                return false;
            }
            pre = pop.val;
            root = pop.right;
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        return isValidBSTReq(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean isValidBSTReq(TreeNode node, int min, int max) {
        if(node==null) return true;
        if(node.val<=min || node.val>=max){
            return false;
        }
        return isValidBSTReq(node.left,min,node.val) && isValidBSTReq(node.right,node.val,max);
    }


    public TreeNode sortedListToBSTIterative(ListNode head) {
        if(head==null) return null;
        return sortedListToBSTIterativeReq(head, null);
    }

    public TreeNode sortedListToBSTIterativeReq(ListNode head,ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if(head==tail) return null;
        while(fast!=tail && fast.next !=tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = sortedListToBSTIterativeReq(head,slow);
        node.right = sortedListToBSTIterativeReq(head.next,tail);
        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
        ListNode c = head;
        int length = 0;
        while(c!=null) {
            length++;
            c=c.next;
        }
        this.head = head;
        return sortedListToBstReq(0,length);
    }
    private ListNode head;
    private TreeNode sortedListToBstReq(int s, int e) {
        if(s>e || head==null)return null;
        int mid = s + (e-s)/2;
        TreeNode left = sortedListToBstReq(s,mid-1);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        head = head.next;
        root.right = sortedListToBstReq(mid+1,e);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBstReq(nums,0,nums.length-1);
    }

    private TreeNode sortedArrayToBstReq(int[] nums, int s, int e) {
        if(s>e) return null;
        int mid = s + (e-s)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBstReq(nums,s,mid-1);
        node.right = sortedArrayToBstReq(nums,mid+1,e);
        return node;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right) && p.val==q.val;
    }

    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    public int singleNumber(int[] nums) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            c ^= nums[i];
        }
        return c;
    }


    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> cache = new HashMap<>();
        int[] smaller = nums1;
        int[] longer = nums2;
        if (nums1.length > nums2.length) {
            smaller = nums2;
            longer = nums1;
        }
        for (int i = 0; i < smaller.length; i++) {
            cache.put(smaller[i], cache.getOrDefault(smaller[i], 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < longer.length; i++) {
            if (cache.getOrDefault(longer[i],0)>0) {
                res.add(longer[i]);
                cache.put(longer[i],cache.get(longer[i])-1);
            }
        }

        int[] resA = new int[res.size()];
        int c = 0;
        for (Integer num : res) {
            resA[c++] = num;
        }
        return resA;
    }

    public char findTheDifference(String s, String t) {
        int c = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            c = c ^ c1;
        }
        return (char) c;
    }

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int res = 0;
        while (xor != 0) {
            res += xor & 1;
        }
        return res;
    }


    public boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (end > start && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return start >= end;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        List<Character> open = Arrays.asList('{', '[', '(');
        List<Character> close = Arrays.asList('}', ']', ')');
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (open.contains(curr)) {
                stack.push(curr);
            } else if (close.contains(curr)) {
                if (stack.isEmpty()) return false;
                Character pop = stack.pop();
                if ((pop == '{' && curr != '}') || (pop == '[' && curr != ']') || (pop == '(' && curr != ')')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        int start = 0;
        while (start < nums.length - 1) {
            while (start < nums.length && nums[start] >= nums[start + 1]) start++;

            int next = start + 1;
            while (next < nums.length && nums[next] < nums[next + 1]) next++;

            for (int i = next + 1; i < nums.length; i++) {
                if (nums[i] < nums[next] && nums[i] > nums[start]) {
                    return true;
                }
            }
            start = start + 1;
        }
        return false;
    }


    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max += Math.max(0, prices[i] - prices[i - 1]);
        }
        return max;
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List[] buckets = new LinkedList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (buckets[entry.getValue()] == null) {
                buckets[entry.getValue()] = new LinkedList<>();
            }
            buckets[entry.getValue()].add(entry.getKey());
        }
        List<Integer> res = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) continue;
            if (buckets[i].size() <= k) res.addAll(buckets[i]);
            else res.addAll(buckets[i].subList(0, k));
            k -= buckets[i].size();
        }
        return res;
    }

    public int findKth(int[] ar, int start, int end, int k) {
        int pivot = ar[end];
        int left = start;
        int right = end;
        while (true) {
            while (ar[left] < pivot && left < right) left++;
            while (ar[right] >= pivot && right > left) right--;
            if (left == right) break;
            swap(ar, left, right);
        }
        swap(ar, end, left);
        if (left + 1 == k) return pivot;
        else if (k < left + 1) {
            return findKth(ar, start, left - 1, k);
        } else {
            return findKth(ar, left + 1, end, k - left);
        }
    }

    private void swap(int[] ar, int left, int right) {
        int tmp = ar[left];
        ar[left] = ar[right];
        ar[right] = tmp;
    }

    public int minMoves(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        int mid;
        int m = nums.length / 2;
        if (nums.length % 2 == 0) {
            mid = (nums[m] + nums[m - 1]) / 2;
        } else {
            mid = nums[m];
        }
        for (int i = 0; i < nums.length; i++) {
            res += (Math.abs(mid - nums[i]));
        }
        return res;
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int localMax;
        int localMin;
        int maxHere = nums[0];
        int minHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            localMax = Math.max(nums[i], Math.max(maxHere * nums[i], minHere * nums[i]));
            localMin = Math.min(nums[i], Math.min(maxHere * nums[i], minHere * nums[i]));
            max = Math.max(max, localMax);
            minHere = localMin;
            maxHere = localMax;
        }
        return max;
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert2(root, nums[i], i, res, 0);
        }
        return Arrays.asList(res);
    }

    private Node insert2(Node root, int val, int i, Integer[] res, int presum) {
        if (root == null) {
            res[i] = presum;
            root = new Node(val, 0);
        } else if (root.val == val) {
            root.dup++;
            res[i] = presum + root.sum;
        } else if (val < root.val) {
            root.sum++;
            root.left = insert2(root.left, val, i, res, presum);
        } else {
            root.right = insert2(root.right, val, i, res, presum + root.dup + root.sum);
        }
        return root;
    }

    private Node insert(int num, Node node, int[] ans, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) {
            node.dup++;
            ans[i] = preSum + node.sum;
        } else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else {
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        if (envelopes.length == 1) return 1;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if (ints[0] == t1[0]) {
                    return ints[1] > t1[1] ? -1 : 1;
                }
                return ints[0] > t1[0] ? 1 : -1;
            }
        });
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        for (int i = 1; i < envelopes.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] > b[1] ? 1 : -1;
                return a[0] > b[0] ? -1 : 1;
            }
        });
        int n = people.length;
        ArrayList<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++)
            tmp.add(people[i][1], people[i]);

        for (int i = 0; i < tmp.size(); i++) {
            people[i] = tmp.get(i);
        }
        return people;
    }

    static class TaskA {

        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();

        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

    class Pair {
        int val;
        int count;
        Pair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    class Node {
        Node right;
        int val;
        Node left;
        int sum;
        int dup = 1;

        Node(int val, int sum) {
            this.val = val;
            this.sum = sum;
        }
    }
}
