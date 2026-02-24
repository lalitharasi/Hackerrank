import java.util.*;

public class QueuePrg{

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        Deque<Integer> deque = new ArrayDeque<Integer>();
        HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        int maxUnique = 0;

        for (int i = 0; i < n; i++) {

            int num = in.nextInt();

            // Add element to deque
            deque.addLast(num);

            // Manually handle frequency update
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            } else {
                frequencyMap.put(num, 1);
            }

            // Maintain window size m
            if (deque.size() > m) {
                int removed = deque.removeFirst();
                int count = frequencyMap.get(removed) - 1;

                if (count == 0) {
                    frequencyMap.remove(removed);
                } else {
                    frequencyMap.put(removed, count);
                }
            }

            // Update max unique count
            if (deque.size() == m) {
                maxUnique = Math.max(maxUnique, frequencyMap.size());
            }
        }

        System.out.println(maxUnique);
        in.close();
    }
}