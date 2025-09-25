import java.io.*;
import java.util.*;

public class test2 {
    // public static void main(String args[] ) throws Exception {
    //     Scanner sc = new Scanner(System.in);

    //     int days = sc.nextInt();
    //     int budget = sc.nextInt();

    //     int[] prices = new int[days];
    //     for(int i = 0; i < days; i++){
    //         prices[i] = sc.nextInt();
    //     }

    //     int maxlen = 0;
    //     int curSum = 0;
    //     int start = 0;

    //     for(int i = 0; i < days; i++){
    //         curSum += prices[i];

    //         while(curSum > budget){
    //             curSum -= prices[start];
    //             start++;
    //         }

    //         maxlen = Math.max(maxlen, i - start + 1);
    //     }
    //     System.out.println(maxlen);
    //     sc.close();
    // }


    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);

    //     String op = sc.nextLine().trim();
    //     String sp = sc.nextLine().trim();

    //     if(op.length() != sp.length()){
    //         System.out.println("false");
    //         return;
    //     }

    //     Map<Character, Integer> opFreq = new HashMap<>();
    //     Map<Character, Integer> spFreq = new HashMap<>();

    //     for(char c : op.toCharArray()){
    //         opFreq.put(c, opFreq.getOrDefault(c, 0) + 1);
    //     }
    //     for(char c : sp.toCharArray()){
    //         spFreq.put(c, spFreq.getOrDefault(c, 0) + 1);
    //     }

    //     if(opFreq.equals(spFreq)){
    //         System.out.println("true");
    //     } else{
    //         System.out.println("false");
    //     }
    //     sc.close();
    // }


    // static class Node {
    //     int val;
    //     Node next;
    //     Node (int val){
    //         this.val = val;
    //     }
    // }

    // private static Node buildLL(String input){
    //     String [] str = input.trim().split(" ");
    //     Node dummy = new Node(0);
    //     Node cur = dummy;
    //     for(String s : str){
    //         cur.next = new Node(Integer.parseInt(s));
    //         cur = cur.next;
    //     }
    //     return dummy.next;
    // }

    // private static void printfunc(Node head){
    //     while (head != null) {
    //         System.out.println(head.val);
    //         head = head.next;
    //     }
    //     System.out.println();
    // }

    // private static Node addNum(Node l1, Node l2){
    //     Stack<Node> st1 = new Stack<>();
    //     Stack<Node> st2 = new Stack<>();

    //     while (l1 != null) {
    //         st1.push(l1);
    //         l1 = l1.next;
    //     }
    //     while (l2 != null) {
    //         st2.push(l2);
    //         l2 = l2.next;
    //     }

    //     int carry = 0;
    //     Node ans = null;

    //     while (!st1.isEmpty() || !st2.isEmpty() || carry > 0) {
    //         int sum = carry;

    //         if(!st1.isEmpty()){
    //             sum += st1.pop().val;
    //         }
    //         if(!st2.isEmpty()){
    //             sum += st2.pop().val;
    //         }

    //         carry = sum / 10; // 10 / 10 = 1

    //         Node newNode = new Node(sum % 10); // 10 % 10 = 0
    //         newNode.next = ans;
    //         ans = newNode;
    //     }
    //     return ans;
    // }

    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //     String one = br.readLine();
    //     String two = br.readLine();

    //     Node l1 = buildLL(one);
    //     Node l2 = buildLL(two);

    //     Node total = addNum(l1, l2);

    //     printfunc(total);
    // }


    // public int minJumps(int[] nums) {
    //     int[] modelvern = nums;
    //     int n = nums.length;

    //     boolean[] isPrime = sieve(1000000);

    //     Map<Integer, List<Integer>> valueEachIdx = new HashMap<>();
    //     for(int i = 0; i < n; i++){
    //         valueEachIdx.computeIfAbset(nums[i], x -> new ArrayList<>()).add(i);
    //     }

    //     Queue<Integer> q = new LinkedList<>();
    //     boolean[] visited = new boolean[n];
    //     Set<Integer> usedPrimes = new HashSet<>();

    //     q.offer(0);
    //     visited[0] = true;
    //     int steps = 0;

    //     while (!q.isEmpty()) {
    //         int size = q.size();

    //         for(int k = 0; k < size; k++){
    //             int i = q.poll();
            
    //             if(i == n-1) return steps;

    //             if(i + 1 < n && !visited[i + 1]){
    //                 visited[i + 1] = true;
    //                 q.offer(i + 1);
    //             }

    //             if(i - 1 >= 0 && !visited[i - 1]){
    //                 visited[i - 1] = true;
    //                 q.offer(i - 1);
    //             }

    //             int val = nums[i];

    //             if(isPrime[val] && !usedPrimes.contains(val)){
    //                 usedPrimes.add(val);
    //             }

    //             for(Map.Entry<Integer, List<Integer>> entry : valueEachIdx.entrySet()){
    //                 if(entry.getKey() % val == 0){
    //                     for(int j : entry.getKey()){
    //                         if(!visited[j]){
    //                             visited[j] = true;
    //                             q.offer(j);
    //                         }
    //                     }
    //                 } 
    //             }
    //         }
    //         steps++;
    //     }
    //     return -1;
        
    // }

    // private boolean[] sieve(int num){
    //     boolean[] isPrime = new boolean[num + 1];
    //     Arrays.fill(isPrime, true);
    //     isPrime[0] = isPrime[1] = false;

    //     for(int i = 2; i * i < num; i++){
    //         if(isPrime[i]){
    //             for(int j = i * i; j <= num; j++){
    //                 isPrime[j] = false;
    //             }
    //         }
    //     }
    //     return isPrime;
    // }



    // public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
    //     int minFinishTime = Integer.MAX_VALUE;

    //     for(int i = 0; i < landStartTime.length; i++){
    //         for(int j = 0; j < waterStartTime.length; j++){

    //             int landStart = landStartTime[i];
    //             int landEnd = landStart + landDuration[i];

    //             int waterStart = Math.max(landEnd, waterStartTime[j]);
    //             int waterEnd = waterStart + waterDuration[j];

    //             int finish1 = waterEnd;

    //             int waterStart2 = waterStartTime[j];
    //             int waterEnd2 = waterStart2 + waterDuration[j];

    //             int landStart2 = Math.max(waterEnd2, landStartTime[i]);
    //             int landEnd2 = landStart2 + landDuration[i];

    //             int finish2 = landEnd2;

    //             minFinishTime = Math.min(minFinishTime, Math.min(finish1, finish2));
    //         }
    //     }
    //         return minFinishTime;
    // }

    // public int minRemoval(int[] nums, int k) {
        
    // }


    
}
