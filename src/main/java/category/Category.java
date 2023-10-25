package category;

import roll.Roll;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Category {
    CHANCE {
        @Override
        public int compute(Roll roll) {
            return roll.getDiceOne() + roll.getDiceTwo() + roll.getDiceThree() + roll.getDiceFour() + roll.getDiceFive();
        }
    },
    YATZY {
        @Override
        public int compute(Roll roll) {
            return groupByValues(roll).values().stream().anyMatch(e -> e == 5) ? 50 : 0;
        }
    },
    PAIR {
        @Override
        public int compute(Roll roll) {
            return groupByValues(roll).entrySet()
                .stream()
                .filter(e -> e.getValue() >= 2)
                .mapToInt(e -> e.getKey()*2)
                .max()
                .orElse(0);
        }
    },
    TWO_PAIRS {
        @Override
        public int compute(Roll roll) {
            var data =  groupByValues(roll)
                .entrySet()
                .stream()
                .filter(e -> e.getValue() >= 2)
                .collect(Collectors.toList());

            return data.size() == 2 ? data.stream().mapToInt(e -> e.getKey()*2).sum() : 0;

        }
    },
    THREE_OF_A_KIND {
        @Override
        public int compute(Roll roll) {
            return xOfAKind(3, roll);
        }
    },
    FOUR_OF_A_KIND {
        @Override
        public int compute(Roll roll) {
            return xOfAKind(4, roll);
        }
    },
    SMALL_STRAIGHT {
        @Override
        public int compute(Roll roll) {
            return groupByValues(roll).values().stream().allMatch(v -> v == 1) ? 15 : 0;
        }
    },
    LARGE_STRAIGHT {
        @Override
        public int compute(Roll roll) {
            return groupByValues(roll).values().stream().allMatch(v -> v == 1) ? 20 : 0;
        }
    },
    FULL_HOUSE {
        @Override
        public int compute(Roll roll) {
            AtomicInteger twoPosition = new AtomicInteger();
            AtomicInteger threePosition = new AtomicInteger();

            groupByValues(roll).forEach((k, v) -> {
                if (v == 2) {
                    twoPosition.set(k);
                }

                if (v == 3) {
                    threePosition.set(k);
                }
            });

            return twoPosition.get() != 0 && threePosition.get() != 0 ? twoPosition.get() * 2 + threePosition.get() * 3 : 0;
        }
    },

    ONES {
        @Override
        public int compute(Roll roll) {
            return sumByValue(1, roll);
        }
    },
    TWOS {
        @Override
        public int compute(Roll roll) {
            return sumByValue(2, roll);
        }
    },
    THREES {
        @Override
        public int compute(Roll roll) {
            return sumByValue(3, roll);
        }
    },
    FOURS {
        @Override
        public int compute(Roll roll) {
            return sumByValue(4, roll);
        }
    },
    FIVES {
        @Override
        public int compute(Roll roll) {
            return sumByValue(5, roll);
        }
    },
    SIXES {
        @Override
        public int compute(Roll roll) {
            return sumByValue(6, roll);
        }
    };

    public abstract int compute(Roll roll);

    private static int xOfAKind(int x, Roll roll) {
        return  groupByValues(roll)
            .entrySet()
            .stream()
            .filter(e -> e.getValue() >= x)
            .mapToInt(e -> e.getKey()*x)
            .sum();
    }

    private static Map<Integer, Integer> groupByValues(Roll roll) {
        Map<Integer, Integer> groupedValues = new HashMap<>();
        Stream.of(
            roll.getDiceOne(),
            roll.getDiceTwo(),
            roll.getDiceThree(),
            roll.getDiceFour(),
            roll.getDiceFive()
        ).forEach(
            d -> groupedValues.compute(d, (k, v) -> v == null ? 1 : v+1)
        );

        return groupedValues;
    }

    private static int sumByValue(int value, Roll roll) {
        int sum = 0;
        if (roll.getDiceOne() == value) sum += value;
        if (roll.getDiceTwo() == value) sum += value;
        if (roll.getDiceThree() == value) sum += value;
        if (roll.getDiceFour() == value) sum += value;
        if (roll.getDiceFive() == value) sum += value;
        return sum;
    }
}
