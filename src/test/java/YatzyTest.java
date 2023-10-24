import org.junit.jupiter.api.Test;
import roll.Roll;

import static org.junit.jupiter.api.Assertions.*;

public class YatzyTest {

    @Test
    public void test_chance() {
        assertEquals(15, Yatzy.chance(new Roll(2,3,4,5,1)));
        assertEquals(16, Yatzy.chance(new Roll(3,3,4,5,1)));
        assertEquals(14, Yatzy.chance(new Roll(1,1,3,3,6)));
        assertEquals(21, Yatzy.chance(new Roll(4,5,5,6,1)));
    }

    @Test public void test_yatzy() {
        assertEquals(50, Yatzy.yatzy(new Roll(4,4,4,4,4)));
        assertEquals(50, Yatzy.yatzy(new Roll(6,6,6,6,6)));
        assertEquals(0, Yatzy.yatzy(new Roll(6,6,6,6,3)));
        assertEquals(50, Yatzy.yatzy(new Roll(1,1,1,1,1)));
        assertEquals(0, Yatzy.yatzy(new Roll(1,1,1,2,1)));
    }

    @Test public void test_ones() {
        assertEquals(1, Yatzy.ones(new Roll(1,2,3,4,5)));
        assertEquals(2, Yatzy.ones(new Roll(1,2,1,4,5)));
        assertEquals(0, Yatzy.ones(new Roll(6,2,2,4,5)));
        assertEquals(4, Yatzy.ones(new Roll(1,2,1,1,1)));
        assertEquals(0, Yatzy.ones(new Roll(3,3,3,4,5)));
    }

    @Test
    public void test_twos() {
        assertEquals(4, Yatzy.twos(new Roll(1,2,3,2,6)));
        assertEquals(10, Yatzy.twos(new Roll(2,2,2,2,2)));
        assertEquals(4, Yatzy.twos(new Roll(2,3,2,5,1)));
    }

    @Test
    public void test_threes() {
        assertEquals(6, Yatzy.threes(new Roll(1,2,3,2,3)));
        assertEquals(12, Yatzy.threes(new Roll(2,3,3,3,3)));
    }

    @Test
    public void test_fours() {
        assertEquals(12, Yatzy.fours(new Roll(4,4,4,5,5)));
        assertEquals(8, Yatzy.fours(new Roll(4,4,5,5,5)));
        assertEquals(4, Yatzy.fours(new Roll(4,5,5,5,5)));
        assertEquals(8, Yatzy.fours(new Roll(1,1,2,4,4)));
    }

    @Test
    public void test_fives() {
        assertEquals(10, Yatzy.fives(new Roll(4,4,4,5,5)));
        assertEquals(15, Yatzy.fives(new Roll(4,4,5,5,5)));
        assertEquals(20, Yatzy.fives(new Roll(4,5,5,5,5)));
    }

    @Test
    public void test_sixes() {
        assertEquals(0, Yatzy.sixes(new Roll(4,4,4,5,5)));
        assertEquals(6, Yatzy.sixes(new Roll(4,4,6,5,5)));
        assertEquals(18, Yatzy.sixes(new Roll(6,5,6,6,5)));
    }

    @Test
    public void test_onePair() {
        assertEquals(6, Yatzy.pair(new Roll(3,4,3,5,6)));
        assertEquals(10, Yatzy.pair(new Roll(5,3,3,3,5)));
        assertEquals(12, Yatzy.pair(new Roll(5,3,6,6,5)));
        assertEquals(0, Yatzy.pair(new Roll(1,2,3,4,5)));
        assertEquals(8, Yatzy.pair(new Roll(3,3,3,4,4)));
        assertEquals(12, Yatzy.pair(new Roll(1,1,6,2,6)));
        assertEquals(6, Yatzy.pair(new Roll(3,3,3,4,1)));
        assertEquals(6, Yatzy.pair(new Roll(3,3,3,3,1)));
    }

    @Test
    public void test_twoPairs() {
        assertEquals(16, Yatzy.twoPairs(new Roll(3,3,5,4,5)));
        assertEquals(16, Yatzy.twoPairs(new Roll(3,3,5,5,5)));
        assertEquals(8, Yatzy.twoPairs(new Roll(1,1,2,3,3)));
        assertEquals(0, Yatzy.twoPairs(new Roll(1,1,2,3,4)));
        assertEquals(6, Yatzy.twoPairs(new Roll(1,1,2,2,2)));
        assertEquals(0, Yatzy.twoPairs(new Roll(3,3,3,3,1)));
    }

    @Test
    public void test_threeOfKind() {
        assertEquals(9, Yatzy.threeOfAKind(new Roll(3,3,3,4,5)));
        assertEquals(15, Yatzy.threeOfAKind(new Roll(5,3,5,4,5)));
        assertEquals(9, Yatzy.threeOfAKind(new Roll(3,3,3,3,5)));
        assertEquals(9, Yatzy.threeOfAKind(new Roll(3,3,3,3,3)));
        assertEquals(9, Yatzy.threeOfAKind(new Roll(3,3,3,4,5)));
        assertEquals(0, Yatzy.threeOfAKind(new Roll(3,3,4,5,6)));
        assertEquals(9, Yatzy.threeOfAKind(new Roll(3,3,3,3,1)));
    }

    @Test
    public void test_fourOfKind() {
        assertEquals(12, Yatzy.fourOfAKind(new Roll(3,3,3,3,5)));
        assertEquals(20, Yatzy.fourOfAKind(new Roll(5,5,5,4,5)));
        assertEquals(8, Yatzy.fourOfAKind(new Roll(2,2,2,2,5)));
        assertEquals(0, Yatzy.fourOfAKind(new Roll(2,2,2,5,5)));
        assertEquals(8, Yatzy.fourOfAKind(new Roll(2,2,2,2,2)));
    }

    @Test
    public void test_smallStraight() {
        assertEquals(15, Yatzy.smallStraight(new Roll(1,2,3,4,5)));
        assertEquals(15, Yatzy.smallStraight(new Roll(2,3,4,5,1)));
        assertEquals(0, Yatzy.smallStraight(new Roll(1,2,2,4,5)));

    }

    @Test
    public void test_largeStraight() {
        assertEquals(20, Yatzy.largeStraight(new Roll(6,2,3,4,5)));
        assertEquals(20, Yatzy.largeStraight(new Roll(2,3,4,5,6)));
        assertEquals(0, Yatzy.largeStraight(new Roll(1,2,2,4,5)));
        assertEquals(20, Yatzy.largeStraight(new Roll(2,3,4,5,6)));
    }

    @Test
    public void test_fullHouse() {
        assertEquals(18, Yatzy.fullHouse(new Roll(6,2,2,2,6)));
        assertEquals(0, Yatzy.fullHouse(new Roll(2,3,4,5,6)));
        assertEquals(8, Yatzy.fullHouse(new Roll(1,1,2,2,2)));
        assertEquals(0, Yatzy.fullHouse(new Roll(2,2,3,3,4)));
        assertEquals(0, Yatzy.fullHouse(new Roll(4,4,4,4,4)));
    }
}
