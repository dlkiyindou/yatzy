package roll;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class RollHelper {
    public static int xOfAKind(int x, Roll roll) {
        Map<Integer, Integer> groupedValues =  groupByValues(roll);
        return groupedValues.entrySet()
            .stream()
            .filter(e -> e.getValue() >= x)
            .mapToInt(e -> e.getKey()*x)
            .sum();
    }

    public static Map<Integer, Integer> groupByValues(Roll roll) {
        Map<Integer, Integer> groupedValues = new HashMap<>();
        Stream.of(
                roll.getOne(),
                roll.getTwo(),
                roll.getThree(),
                roll.getFour(),
                roll.getFive()
        ).forEach(
            d -> groupedValues.compute(d, (k, v) -> v == null ? 1 : v+1)
        );

        return groupedValues;
    }

    public static int sumByValue(int value, Roll roll) {
        int sum = 0;
        if (roll.getOne() == value) sum += value;
        if (roll.getTwo() == value) sum += value;
        if (roll.getThree() == value) sum += value;
        if (roll.getFour() == value) sum += value;
        if (roll.getFive() == value) sum += value;
        return sum;
    }
}
