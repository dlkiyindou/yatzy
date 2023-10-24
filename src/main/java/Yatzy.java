import roll.*;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Yatzy {

    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        return d1 + d2 + d3 + d4 + d5;
    }

    public static int yatzy(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Integer> groupedValues =  RollHelper.groupByValues(new Roll(d1, d2, d3, d4, d5));
        return groupedValues.values().stream().anyMatch(e -> e == 5) ? 50 : 0;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        return RollHelper.sumByValue(1, new Roll(d1, d2, d3, d4, d5));
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        return RollHelper.sumByValue(2, new Roll(d1, d2, d3, d4, d5));
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        return RollHelper.sumByValue(3, new Roll(d1, d2, d3, d4, d5));
    }

    public static int fours(int d1, int d2, int d3, int d4, int d5) {
        return RollHelper.sumByValue(4, new Roll(d1, d2, d3, d4, d5));
    }

    public static int fives(int d1, int d2, int d3, int d4, int d5) {
        return RollHelper.sumByValue(5, new Roll(d1, d2, d3, d4, d5));
    }

    public static int sixes(int d1, int d2, int d3, int d4, int d5) {
        return RollHelper.sumByValue(6, new Roll(d1, d2, d3, d4, d5));
    }

    public static int pair(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Integer> groupedValues =  RollHelper.groupByValues(new Roll(d1, d2, d3, d4, d5));
        return groupedValues.entrySet()
            .stream()
            .filter(e -> e.getValue() >= 2)
            .mapToInt(e -> e.getKey()*2)
            .max()
            .orElse(0);
    }

    public static int twoPair(int d1, int d2, int d3, int d4, int d5) {
        return RollHelper.xOfAKind(2, new Roll(d1, d2, d3, d4, d5));
    }

    public static int threeOfAKind(int d1, int d2, int d3, int d4, int d5) {
        return RollHelper.xOfAKind(3, new Roll(d1, d2, d3, d4, d5));
    }

    public static int fourOfAKind(int d1, int d2, int d3, int d4, int d5) {
        return RollHelper.xOfAKind(5, new Roll(d1, d2, d3, d4, d5));
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Integer> groupedValues =  RollHelper.groupByValues(new Roll(d1, d2, d3, d4, d5));
        return groupedValues.values().stream().allMatch(v -> v == 1) ? 15 : 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Integer> groupedValues =  RollHelper.groupByValues(new Roll(d1, d2, d3, d4, d5));
        return groupedValues.values().stream().allMatch(v -> v == 1) ? 20 : 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        AtomicInteger twoPosition = new AtomicInteger();
        AtomicInteger threePosition = new AtomicInteger();

        Map<Integer, Integer> groupedValues =  RollHelper.groupByValues(new Roll(d1, d2, d3, d4, d5));
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
}

