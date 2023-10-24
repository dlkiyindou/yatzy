import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Yatzy {

    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        return d1 + d2 + d3 + d4 + d5;
    }

    public static int yatzy(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Integer> groupedValues =  groupValues(d1, d2, d3, d4, d5);
        return groupedValues.values().stream().anyMatch(e -> e == 5) ? 50 : 0;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        return sumByValue(1, d1, d2, d3, d4, d5);
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        return sumByValue(2, d1, d2, d3, d4, d5);
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        return sumByValue(3, d1, d2, d3, d4, d5);
    }

    public static int fours(int d1, int d2, int d3, int d4, int d5) {
        return sumByValue(4, d1, d2, d3, d4, d5);
    }

    public static int fives(int d1, int d2, int d3, int d4, int d5) {
        return sumByValue(5, d1, d2, d3, d4, d5);
    }

    public static int sixes(int d1, int d2, int d3, int d4, int d5) {
        return sumByValue(6, d1, d2, d3, d4, d5);
    }

    public static int onePair(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Integer> groupedValues =  groupValues(d1, d2, d3, d4, d5);
        return groupedValues.entrySet()
            .stream()
            .filter(e -> e.getValue() >= 2)
            .mapToInt(e -> e.getKey()*2)
            .max()
            .orElse(0);
    }

    public static int twoPair(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Integer> groupedValues =  groupValues(d1, d2, d3, d4, d5);
        return groupedValues.entrySet()
            .stream()
            .filter(e -> e.getValue() >= 2)
            .mapToInt(e -> e.getKey()*2)
            .sum();
    }

    public static int threeOfAKind(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Integer> groupedValues =  groupValues(d1, d2, d3, d4, d5);
        return groupedValues.entrySet()
            .stream()
            .filter(e -> e.getValue() >= 3)
            .mapToInt(e -> e.getKey()*3)
            .sum();
    }

    public static int fourOfAKind(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Integer> groupedValues =  groupValues(d1, d2, d3, d4, d5);
        return groupedValues.entrySet()
            .stream()
            .filter(e -> e.getValue() >= 4)
            .mapToInt(e -> e.getKey()*4)
            .sum();
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Integer> groupedValues =  groupValues(d1, d2, d3, d4, d5);
        return groupedValues.values().stream().allMatch(v -> v == 1) ? 15 : 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Integer> groupedValues =  groupValues(d1, d2, d3, d4, d5);
        return groupedValues.values().stream().allMatch(v -> v == 1) ? 20 : 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        AtomicInteger twoPosition = new AtomicInteger();
        AtomicInteger threePosition = new AtomicInteger();

        Map<Integer, Integer> groupedValues = groupValues(d1, d2, d3, d4, d5);
        groupedValues.forEach((k, v) -> {
            if (v == 2) {
                twoPosition.set(k);
            }

            if (v == 3) {
                threePosition.set(k);
            }
        });

        return twoPosition.get() * 2 + threePosition.get() * 3;
    }

    private static Map<Integer, Integer> groupValues(Integer ... dices) {
        Map<Integer, Integer> groupedValues = new HashMap<>();
        Stream.of(dices).forEach(
            d -> groupedValues.compute(d, (k, v) -> v == null ? 1 : v+1)
        );

        return groupedValues;
    }

    private static int sumByValue(int value, int d1, int d2, int d3, int d4, int d5) {
        int sum = 0;
        if (d1 == value) sum += value;
        if (d2 == value) sum += value;
        if (d3 == value) sum += value;
        if (d4 == value) sum += value;
        if (d5 == value) sum += value;
        return sum;
    }
}

