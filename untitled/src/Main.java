import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Sample data
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filtering
        List<Integer> evenNumbers = numbers.stream()
                .filter(num -> num % 2 == 0)
                .toList();
        System.out.println("Filtered even numbers: " + evenNumbers);

        // Mapping
        List<String> numberStrings = numbers.stream()
                .map(num -> "Number " + num)
                .toList();
        System.out.println("Mapped numbers: " + numberStrings);

        // Sorting
        List<Integer> sortedNumbers = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("Sorted numbers (reverse order): " + sortedNumbers);

        // Reducing
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum of numbers: " + sum);

        // Collecting to Map
        Map<Integer, String> numberMap = numbers.stream()
                .collect(Collectors.toMap(
                        num -> num,
                        num -> "Number " + num
                ));
        System.out.println("Number map: " + numberMap);

        // Grouping
        Map<Boolean, List<Integer>> evenOddMap = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println("Even and odd numbers: " + evenOddMap);

        // Counting
        long count = numbers.size();
        System.out.println("Number of elements: " + count);

        // Finding
        Optional<Integer> max = numbers.stream()
                .max(Integer::compareTo);
        System.out.println("Maximum number: " + max.orElse(0));

        // Matching
        boolean allEven = numbers.stream()
                .allMatch(num -> num % 2 == 0);
        System.out.println("All numbers even? " + allEven);

        // Generating
        Stream<String> generatedStream = Stream.generate(() -> "Hello, World!")
                .limit(3);
        generatedStream.forEach(System.out::println);

        // Distinct and Limit
        List<Integer> distinctLimitedNumbers = numbers.stream()
                .distinct()
                .limit(5)
                .toList();
        System.out.println("Distinct and limited numbers: " + distinctLimitedNumbers);

        // Peeking
        List<Integer> peekedNumbers = numbers.stream()
                .peek(num -> System.out.println("Processing: " + num))
                .toList();
        System.out.println("Peeked numbers: " + peekedNumbers);


        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        Map<Boolean, Long> partitionedCounts = words.stream()
                .collect(Collectors.partitioningBy(
                        word -> word.length() % 2 == 0,
                        Collectors.counting()
                ));

        System.out.println("Count of even-length words: " + partitionedCounts.get(true));
        System.out.println("Count of odd-length words: " + partitionedCounts.get(false));

        // Counting
        long count2 = numbers.size();
        System.out.println("Count: " + count2);

        // Summation
        int sum2 = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + sum2);

        // Averaging
        double average = numbers.stream().collect(Collectors.averagingInt(Integer::intValue));
        System.out.println("Average: " + average);

        // Max and Min
        Optional<Integer> max2 = numbers.stream().max(Comparator.naturalOrder());
        Optional<Integer> min = numbers.stream().min(Comparator.naturalOrder());
        System.out.println("Max: " + max2.orElse(0));
        System.out.println("Min: " + min.orElse(0));

        // List of strings
        List<String> words2 = Arrays.asList("apple", "banana", "cherry", "date");

        // Joining
        String joined = String.join(", ", words);
        System.out.println("Joined: " + joined);

        // Grouping by length
        Map<Integer, List<String>> wordsByLength = words2.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Words by length: " + wordsByLength);

        // Mapping and Collecting
        Map<Integer, Set<String>> wordsByLengthToUpperCase = words.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(String::toUpperCase, Collectors.toSet())
                ));
        System.out.println("Words by length to upper case: " + wordsByLengthToUpperCase);

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> result = applyFunctionToList(list1, list2, Integer::sum);
        System.out.println(result);


        String str ="{}()";
        String str1 ="{()}";
        String str2 ="{()";

        System.out.println("hacker rank problem solved:");

        System.out.println(str+" isBalanced: "+ isBalanced(str));
        System.out.println(str1+" isBalanced: "+ isBalanced(str1));
        System.out.println(str2+" isBalanced: "+ isBalanced(str2));


        System.out.println(str+" isBalancedUsingDeque: "+ isBalancedUsingDeque(str));
        System.out.println(str1+" isBalancedUsingDeque: "+ isBalancedUsingDeque(str1));
        System.out.println(str2+" isBalancedUsingDeque: "+ isBalancedUsingDeque(str2));
        //is balanced? true/false


        String strPad = "ABC";
        System.out.printf("%15s \n", strPad );
        int n = 9;
        System.out.printf("%03d",n);


        ZeroFinder zeroFinder = new ZeroFinder();
        System.out.println("zeroFinder 1041: "+ zeroFinder.solution(1041));
        System.out.println("zeroFinder 15: "+ zeroFinder.solution(15));
        System.out.println("zeroFinder 32: "+ zeroFinder.solution(32));
        System.out.println("zeroFinder 328: "+ zeroFinder.solution(328)+ " should be 2");
        System.out.println("zeroFinder 66561: "+ zeroFinder.solution(66561)+ " should be 9");

        int[] A = {1,2,3,4} ;
        int[] B = {3,8,9,7,6};
        System.out.println("queue rotate [1,2,3,4],4: "+ IntStream.of(zeroFinder.solution2(A,4)).mapToObj(String::valueOf).toList()+ " should be [1, 2, 3, 4]");
        System.out.println("queue rotate [3,8,9,7,6],3 "+ IntStream.of(zeroFinder.solution2(B,3)).mapToObj(String::valueOf).toList()+ " should be [9, 7, 6, 3, 8]");
        System.out.println("queue rotate [],3 "+ IntStream.of(zeroFinder.solution2(B,3)).mapToObj(String::valueOf).toList()+ " should be [9, 7, 6, 3, 8]");

        int[][] testCases = {
                {1, 3, 6, 4, 1, 2},
                {-1, -3, -6, -4, -1, -2},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5, 7},
                {1, 1, 2, 2, 3, 3},
                {}
        };

        int[] expectedResults = {5, 1, 6, 6, 4, 1};

        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            int minPositiveVal = ZeroFinder.solutionB(testCase);
            System.out.println("Test " + (i+1) + ": " + minPositiveVal);
            // Add assertions here if needed
            assertResult(testCase, minPositiveVal, expectedResults[i]);
        }

        System.out.println("All test cases executed!");


        int[][] testCases2 = {
                {}, // Empty Array
                {1, 2, 3, 4, 5}, // All Elements Present
                {2, 3, 4, 5}, // One Element Missing at the Beginning
                {1, 2, 3, 4}, // One Element Missing at the End
                {1, 2, 4, 5}, // One Element Missing in the Middle
                {}, // All Elements Missing
                {3, 3, 3, 3}, // All Elements Same
                {5, 3, 4, 1, 2}, // Random Order with No Missing
                {5, 3, 1, 2} // Random Order with One Missing
        };
        int[] expectedResults2 = {1, 6, 1, 5, 3, 1, 1, 6, 4};

        for (int i = 0; i < testCases2.length; i++) {
            int[] testCase = testCases2[i];
            int expectedResult = expectedResults2[i];

            System.out.println("Evaluating Array: " + IntStream.of(testCase).mapToObj(String::valueOf).toList());
            int result4 = ZeroFinder.solution4(testCase);
            System.out.println("Result: " + result4 + " | Correct Answer: " + expectedResult);
            assertResult(result4, expectedResult);
            System.out.println();
        }
    }

    public static void assertResult(int[] input, int result, int expected) {
        assert expected == result : "Test failed for input: " + Arrays.toString(input) +
                ", expected: " + expected + ", actual: " + result;
    }
    public static void assertResult(int input, int expected) {
        assert input == expected : "Test failed for input: " + input + ", expected: " + expected + ", actual: " + input;
    }

    public static boolean isBalanced(String str) {

        LinkedList<String> linkedList = str.chars()
                .mapToObj(c -> Character.valueOf((char)c).toString())
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println("linkedList elements: "+ linkedList);

        while (linkedList.size() >= 1) {
            if(linkedList.getFirst().compareTo("{") == 0 && linkedList.getLast().compareTo("}") == 0) {
                linkedList.removeFirst();
                linkedList.removeLast();
            }else if(linkedList.getFirst().compareTo("{") == 0 && linkedList.get(1).compareTo("}") == 0) {
                linkedList.removeFirst();
                linkedList.remove();
            }else if(linkedList.getFirst().compareTo("(") == 0 && linkedList.getLast().compareTo(")") == 0) {
                linkedList.removeFirst();
                linkedList.removeLast();
            }else if(linkedList.getFirst().compareTo("(") == 0 && linkedList.get(1).compareTo(")") == 0){
                linkedList.removeFirst();
                linkedList.remove();
            }else return false;
        }
        return linkedList.isEmpty();
    }
    public static boolean isBalancedUsingDeque(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            if (c == '{' || c == '(') {
                stack.push(c);
            } else if (c == '}' || c == ')') {
                if (stack.isEmpty()) {
                    return false; // Unmatched closing bracket
                }

                char top = stack.pop();
                if ((c == '}' && top != '{') || (c == ')' && top != '(')) {
                    return false; // Mismatched brackets
                }
            }
        }

        return stack.isEmpty(); // All brackets matched
    }


    static <T, U, R> List<R> applyFunctionToList(List<T> list1, List<U> list2, BiFunction<T, U, R> function) {
        return IntStream.range(0, Math.min(list1.size(), list2.size()))
                .mapToObj(i -> function.apply(list1.get(i), list2.get(i)))
                .collect(Collectors.toList());
    }
}
