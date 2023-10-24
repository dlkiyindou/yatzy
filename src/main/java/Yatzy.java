import roll.Roll;

public class Yatzy {

    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        return Category.CHANCE.compute(new Roll(d1, d2, d3, d4, d5));
    }

    public static int yatzy(int d1, int d2, int d3, int d4, int d5) {
        return Category.YATZY.compute(new Roll(d1, d2, d3, d4, d5));
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        return Category.ONES.compute(new Roll(d1, d2, d3, d4, d5));
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        return Category.TWOS.compute(new Roll(d1, d2, d3, d4, d5));
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        return Category.THREES.compute(new Roll(d1, d2, d3, d4, d5));
    }

    public static int fours(int d1, int d2, int d3, int d4, int d5) {
        return Category.FOURS.compute(new Roll(d1, d2, d3, d4, d5));
    }

    public static int fives(int d1, int d2, int d3, int d4, int d5) {
        return Category.FIVES.compute(new Roll(d1, d2, d3, d4, d5));
    }

    public static int sixes(int d1, int d2, int d3, int d4, int d5) {
        return Category.SIXES.compute(new Roll(d1, d2, d3, d4, d5));
    }

    public static int pair(int d1, int d2, int d3, int d4, int d5) {
        return Category.PAIR.compute(new Roll(d1, d2, d3, d4, d5));
    }

    public static int twoPairs(int d1, int d2, int d3, int d4, int d5) {
        return Category.TWO_PAIRS.compute(new Roll(d1, d2, d3, d4, d5));
    }

    public static int threeOfAKind(int d1, int d2, int d3, int d4, int d5) {
        return Category.THREE_OF_A_KIND.compute(new Roll(d1, d2, d3, d4, d5));
    }

    public static int fourOfAKind(int d1, int d2, int d3, int d4, int d5) {
        return Category.FOUR_OF_A_KIND.compute(new Roll(d1, d2, d3, d4, d5));
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        return Category.SMALL_STRAIGHT.compute(new Roll(d1, d2, d3, d4, d5));
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        return Category.LARGE_STRAIGHT.compute(new Roll(d1, d2, d3, d4, d5));
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        return Category.FULL_HOUSE.compute(new Roll(d1, d2, d3, d4, d5));
    }
}

