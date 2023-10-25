package category;

import org.junit.jupiter.api.Test;
import roll.Roll;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryTest {

    @Test
    public void test_chance() {
        assertEquals(15, Category.CHANCE.compute(new Roll(2,3,4,5,1)));
        assertEquals(16, Category.CHANCE.compute(new Roll(3,3,4,5,1)));
        assertEquals(14, Category.CHANCE.compute(new Roll(1,1,3,3,6)));
        assertEquals(21, Category.CHANCE.compute(new Roll(4,5,5,6,1)));
    }

    @Test public void test_yatzy() {
        assertEquals(50, Category.YATZY.compute(new Roll(4,4,4,4,4)));
        assertEquals(50, Category.YATZY.compute(new Roll(6,6,6,6,6)));
        assertEquals(0, Category.YATZY.compute(new Roll(6,6,6,6,3)));
        assertEquals(50, Category.YATZY.compute(new Roll(1,1,1,1,1)));
        assertEquals(0, Category.YATZY.compute(new Roll(1,1,1,2,1)));
    }

    @Test public void test_ones() {
        assertEquals(1, Category.ONES.compute(new Roll(1,2,3,4,5)));
        assertEquals(2, Category.ONES.compute(new Roll(1,2,1,4,5)));
        assertEquals(0, Category.ONES.compute(new Roll(6,2,2,4,5)));
        assertEquals(4, Category.ONES.compute(new Roll(1,2,1,1,1)));
        assertEquals(0, Category.ONES.compute(new Roll(3,3,3,4,5)));
    }

    @Test
    public void test_twos() {
        assertEquals(4, Category.TWOS.compute(new Roll(1,2,3,2,6)));
        assertEquals(10, Category.TWOS.compute(new Roll(2,2,2,2,2)));
        assertEquals(4, Category.TWOS.compute(new Roll(2,3,2,5,1)));
    }

    @Test
    public void test_threes() {
        assertEquals(6, Category.THREES.compute(new Roll(1,2,3,2,3)));
        assertEquals(12, Category.THREES.compute(new Roll(2,3,3,3,3)));
    }

    @Test
    public void test_fours() {
        assertEquals(12, Category.FOURS.compute(new Roll(4,4,4,5,5)));
        assertEquals(8, Category.FOURS.compute(new Roll(4,4,5,5,5)));
        assertEquals(4, Category.FOURS.compute(new Roll(4,5,5,5,5)));
        assertEquals(8, Category.FOURS.compute(new Roll(1,1,2,4,4)));
    }

    @Test
    public void test_fives() {
        assertEquals(10, Category.FIVES.compute(new Roll(4,4,4,5,5)));
        assertEquals(15, Category.FIVES.compute(new Roll(4,4,5,5,5)));
        assertEquals(20, Category.FIVES.compute(new Roll(4,5,5,5,5)));
    }

    @Test
    public void test_sixes() {
        assertEquals(0, Category.SIXES.compute(new Roll(4,4,4,5,5)));
        assertEquals(6, Category.SIXES.compute(new Roll(4,4,6,5,5)));
        assertEquals(18, Category.SIXES.compute(new Roll(6,5,6,6,5)));
    }

    @Test
    public void test_onePair() {
        assertEquals(6, Category.PAIR.compute(new Roll(3,4,3,5,6)));
        assertEquals(10, Category.PAIR.compute(new Roll(5,3,3,3,5)));
        assertEquals(12, Category.PAIR.compute(new Roll(5,3,6,6,5)));
        assertEquals(0, Category.PAIR.compute(new Roll(1,2,3,4,5)));
        assertEquals(8, Category.PAIR.compute(new Roll(3,3,3,4,4)));
        assertEquals(12, Category.PAIR.compute(new Roll(1,1,6,2,6)));
        assertEquals(6, Category.PAIR.compute(new Roll(3,3,3,4,1)));
        assertEquals(6, Category.PAIR.compute(new Roll(3,3,3,3,1)));
    }

    @Test
    public void test_twoPairs() {
        assertEquals(16, Category.TWO_PAIRS.compute(new Roll(3,3,5,4,5)));
        assertEquals(16, Category.TWO_PAIRS.compute(new Roll(3,3,5,5,5)));
        assertEquals(8, Category.TWO_PAIRS.compute(new Roll(1,1,2,3,3)));
        assertEquals(0, Category.TWO_PAIRS.compute(new Roll(1,1,2,3,4)));
        assertEquals(6, Category.TWO_PAIRS.compute(new Roll(1,1,2,2,2)));
        assertEquals(0, Category.TWO_PAIRS.compute(new Roll(3,3,3,3,1)));
    }

    @Test
    public void test_threeOfKind() {
        assertEquals(9, Category.THREE_OF_A_KIND.compute(new Roll(3,3,3,4,5)));
        assertEquals(15, Category.THREE_OF_A_KIND.compute(new Roll(5,3,5,4,5)));
        assertEquals(9, Category.THREE_OF_A_KIND.compute(new Roll(3,3,3,3,5)));
        assertEquals(9, Category.THREE_OF_A_KIND.compute(new Roll(3,3,3,3,3)));
        assertEquals(9, Category.THREE_OF_A_KIND.compute(new Roll(3,3,3,4,5)));
        assertEquals(0, Category.THREE_OF_A_KIND.compute(new Roll(3,3,4,5,6)));
        assertEquals(9, Category.THREE_OF_A_KIND.compute(new Roll(3,3,3,3,1)));
    }

    @Test
    public void test_fourOfKind() {
        assertEquals(12, Category.FOUR_OF_A_KIND.compute(new Roll(3,3,3,3,5)));
        assertEquals(20, Category.FOUR_OF_A_KIND.compute(new Roll(5,5,5,4,5)));
        assertEquals(8, Category.FOUR_OF_A_KIND.compute(new Roll(2,2,2,2,5)));
        assertEquals(0, Category.FOUR_OF_A_KIND.compute(new Roll(2,2,2,5,5)));
        assertEquals(8, Category.FOUR_OF_A_KIND.compute(new Roll(2,2,2,2,2)));
    }

    @Test
    public void test_smallStraight() {
        assertEquals(15, Category.SMALL_STRAIGHT.compute(new Roll(1,2,3,4,5)));
        assertEquals(15, Category.SMALL_STRAIGHT.compute(new Roll(2,3,4,5,1)));
        assertEquals(0, Category.SMALL_STRAIGHT.compute(new Roll(1,2,2,4,5)));
    }

    @Test
    public void test_largeStraight() {
        assertEquals(20, Category.LARGE_STRAIGHT.compute(new Roll(6,2,3,4,5)));
        assertEquals(20, Category.LARGE_STRAIGHT.compute(new Roll(2,3,4,5,6)));
        assertEquals(0, Category.LARGE_STRAIGHT.compute(new Roll(1,2,2,4,5)));
        assertEquals(20, Category.LARGE_STRAIGHT.compute(new Roll(2,3,4,5,6)));
    }

    @Test
    public void test_fullHouse() {
        assertEquals(18, Category.FULL_HOUSE.compute(new Roll(6,2,2,2,6)));
        assertEquals(0, Category.FULL_HOUSE.compute(new Roll(2,3,4,5,6)));
        assertEquals(8, Category.FULL_HOUSE.compute(new Roll(1,1,2,2,2)));
        assertEquals(0, Category.FULL_HOUSE.compute(new Roll(2,2,3,3,4)));
        assertEquals(0, Category.FULL_HOUSE.compute(new Roll(4,4,4,4,4)));
    }
}
