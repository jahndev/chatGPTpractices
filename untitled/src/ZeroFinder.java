import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class ZeroFinder {
    public int solution(int N) {
        // Implement your solution here
        String strBinary = Integer.toBinaryString(N);

        int onesCounter = 0;
        int zeros = 0;
        int maxZeros = 0;
        for(char c : strBinary.toCharArray()){
            if(c == '1') {
                onesCounter++;
                if(onesCounter > 1) {
                    maxZeros = Math.max(maxZeros, zeros);
                    zeros = 0;
                    onesCounter--;
                }
            }
            if(c == '0' && onesCounter == 1) {
                zeros ++;
            }
        }
        return maxZeros;
        /*
        if(!strBinary.substring(1).contains("1")) {
            return 0;
        }
        String s = Arrays.stream(Integer.toBinaryString(N).split("1.*?1"))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        return s.length();
        */
    }

    public String solution(int[] A, int K) {
        // Implement your solution here
        LinkedList<String> linkedList = IntStream.of(A).mapToObj(String::valueOf).collect(Collectors.toCollection(LinkedList::new));

        for(int j = 0; j < K; j++) {
            linkedList.add(linkedList.getFirst());
            linkedList.pop();
        }
        return linkedList.stream().collect(Collectors.joining());
    }

    public int[] solution2(int[] A, int K) {
        //System.out.println("A "+IntStream.of(A).mapToObj(String::valueOf).toList()+" K "+K);
        //if(A.length == K) return A;
        // Implement your solution here
        LinkedList<String> linkedList = IntStream.of(A).mapToObj(String::valueOf).collect(Collectors.toCollection(LinkedList::new));
        Collections.reverse(linkedList);
        for(int j = 0; j < K; j++) {
            linkedList.add(linkedList.pop());
            //System.out.println(linkedList.stream().toList());
        }
        Collections.reverse(linkedList);
        return linkedList.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int solution3(int[] A) {
        // Implement your solution here
        Optional<Integer> result = IntStream.of(A)
                .boxed()
                .collect(Collectors.toMap(
                        key -> key,
                        key -> 1,
                        Integer::sum,
                        HashMap::new
                ))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();

        return result.orElse(0);
    }

    public int solution3B(int[] A) {
        // Implement your solution here
        Map<Integer,Integer> map = new HashMap<>();
        int odd = 0;
        for(int i = 0; i<A.length;i++){
            if(!map.containsKey(A[i])){
                map.put(A[i],1);
            }else {
                map.remove(A[i]);
            }
        }
        odd = map.keySet().stream().findFirst().orElse(0);
        return odd;
    }

    /**
     * intermediate solution fails in performance
     * @param A
     * @return
     */
    public static int solutionB(int[] A) {
        int val = 1;
        if(A == null || A.length == 0) {
            return val;
        }
        if(A.length > 1){
            List<Integer> list = Arrays.stream(A)
                    .boxed()
                    .sorted()
                    .filter(i -> i > 0)
                    .collect(Collectors.toCollection(LinkedHashSet::new)).stream().toList();

            if(list.isEmpty()) return 1;

            val = IntStream.range(1, list.size()+1)
                    .filter(i -> !list.contains(i))
                    .findFirst().orElse(list.size()+1);
        }
        return val;
    }

    /**
     * worst solution
     * @param A
     * @return
     */
    public static int solution(int[] A) {
        Set<Integer> set = IntStream.of(A)
                .boxed()
                .collect(Collectors.toSet());

        int val = 0;

        List<Integer> list = new LinkedList<>(set);
        for(int i = 0; i< list.size(); i++){
            if(i <list.size()-1 && list.get(i) + 1 < list.get(i+1)) {
                val = list.get(i) + 1;
                break;
            }
            if(i == list.size()-1){
                val = list.get(i);
                val++;
            }
        }
        int last = list.size() > 0 ? list.get(list.size()-1) : 1;
        return last <= 0 ? 1 : val;
    }

    /**
     * best solution
     */
    public static int solution2(int[] A) {
        Set<Integer> set = Arrays.stream(A).boxed().collect(Collectors.toSet());
        int smallestPositive = 1;

        for (int i = 1; i <= A.length + 1; i++) {
            if (!set.contains(i)) {
                smallestPositive = i;
                break;
            }
        }

        return smallestPositive;
    }
    public int solution(int X, int Y, int D) {
        // Implement your solution here
        return (X == Y || X + D == Y) ? 0 :
                (int)Math.ceil((double)(Y - X) / D);
    }
    public static int solution4(int[] A) {
        // Implement your solution here
        if(A.length == 0) return 1;
        List<Integer> sd = IntStream.of(A).boxed().sorted().collect(Collectors.toList());
        for(int i = 0; i < A.length; i++) {
            if(i+1 < sd.get(i))
                return i + 1;
        }
        return A.length+1;
    }
    public int solution5(int[] A) {
        // Implement your solution here
        int v1 =0,v2 =0, minDiff = 999999999;
        HashMap<Integer,Integer> map = new HashMap();
        for(int p = 1; p < A.length; p++){
            for(int i = 0;i< A.length ; i++){
                if(i < p) v1 += A[i];
                else v2 += A[i];
                System.out.println("i "+i+" p "+p+ " v1 "+v1+" v2 "+ v2);
            }
            int diff = Math.abs(v1 - v2);
            minDiff = diff < minDiff ? diff : minDiff;
            v1 = 0;
            v2 = 0;
            System.out.println(" diff " + diff + " minDiff " + minDiff);
        }
        return minDiff;
    }
    public int solution4b(int[] A) {
        // Implement your solution here
        int totalSum = 0;
        for (int num : A) {
            totalSum += num;
        }

        int v1 = 0, minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < A.length - 1; i++) {
            v1 += A[i];
            int v2 = totalSum - v1;
            int diff = Math.abs(v1 - v2);
            minDiff = Math.min(diff, minDiff);
        }
        return minDiff;
    }
}