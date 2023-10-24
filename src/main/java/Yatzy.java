import category.Category;
import roll.Roll;

/**
 * {@code @Deprecated} : use category.Category
 */
@Deprecated
public class Yatzy {

    public static int chance(Roll roll) {
        return Category.CHANCE.compute(roll);
    }

    public static int yatzy(Roll roll) {
        return Category.YATZY.compute(roll);
    }

    public static int ones(Roll roll) {
        return Category.ONES.compute(roll);
    }

    public static int twos(Roll roll) {
        return Category.TWOS.compute(roll);
    }

    public static int threes(Roll roll) {
        return Category.THREES.compute(roll);
    }

    public static int fours(Roll roll) {
        return Category.FOURS.compute(roll);
    }

    public static int fives(Roll roll) {
        return Category.FIVES.compute(roll);
    }

    public static int sixes(Roll roll) {
        return Category.SIXES.compute(roll);
    }

    public static int pair(Roll roll) {
        return Category.PAIR.compute(roll);
    }

    public static int twoPairs(Roll roll) {
        return Category.TWO_PAIRS.compute(roll);
    }

    public static int threeOfAKind(Roll roll) {
        return Category.THREE_OF_A_KIND.compute(roll);
    }

    public static int fourOfAKind(Roll roll) {
        return Category.FOUR_OF_A_KIND.compute(roll);
    }

    public static int smallStraight(Roll roll) {
        return Category.SMALL_STRAIGHT.compute(roll);
    }

    public static int largeStraight(Roll roll) {
        return Category.LARGE_STRAIGHT.compute(roll);
    }

    public static int fullHouse(Roll roll) {
        return Category.FULL_HOUSE.compute(roll);
    }
}

