import category.Category;
import org.junit.jupiter.api.Test;
import player.Player;
import roll.Roll;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @Test
    public void test_chance() {
        assertEquals(15, Yatzy.chance(2,3,4,5,1));
        assertEquals(16, Yatzy.chance(3,3,4,5,1));
    }

    @Test public void test_yatzy() {
        assertEquals(50, Yatzy.yatzy(4,4,4,4,4));
        assertEquals(50, Yatzy.yatzy(6,6,6,6,6));
        assertEquals(0, Yatzy.yatzy(6,6,6,6,3));
    }

    @Test public void test_ones() {
        assertEquals(1, Yatzy.ones(1,2,3,4,5));
        assertEquals(2, Yatzy.ones(1,2,1,4,5));
        assertEquals(0, Yatzy.ones(6,2,2,4,5));
        assertEquals(4, Yatzy.ones(1,2,1,1,1));
    }

    @Test
    public void test_twos() {
        assertEquals(4, Yatzy.twos(1,2,3,2,6));
        assertEquals(10, Yatzy.twos(2,2,2,2,2));
    }

    @Test
    public void test_threes() {
        assertEquals(6, Yatzy.threes(1,2,3,2,3));
        assertEquals(12, Yatzy.threes(2,3,3,3,3));
    }

    @Test
    public void test_fours()
    {
        assertEquals(12, Yatzy.fours(4,4,4,5,5));
        assertEquals(8, Yatzy.fours(4,4,5,5,5));
        assertEquals(4, Yatzy.fours(4,5,5,5,5));
    }

    @Test
    public void test_fives() {
        assertEquals(10, Yatzy.fives(4,4,4,5,5));
        assertEquals(15, Yatzy.fives(4,4,5,5,5));
        assertEquals(20, Yatzy.fives(4,5,5,5,5));
    }

    @Test
    public void test_sixes() {
        assertEquals(0, Yatzy.sixes(4,4,4,5,5));
        assertEquals(6, Yatzy.sixes(4,4,6,5,5));
        assertEquals(18, Yatzy.sixes(6,5,6,6,5));
    }

    @Test
    public void test_onePair() {
        assertEquals(6, Yatzy.pair(3,4,3,5,6));
        assertEquals(10, Yatzy.pair(5,3,3,3,5));
        assertEquals(12, Yatzy.pair(5,3,6,6,5));
    }

    @Test
    public void test_twoPairs() {
        assertEquals(16, Yatzy.twoPairs(3,3,5,4,5));
        assertEquals(16, Yatzy.twoPairs(3,3,5,5,5));

    }

    @Test
    public void test_threeOfKind()
    {
        assertEquals(9, Yatzy.threeOfAKind(3,3,3,4,5));
        assertEquals(15, Yatzy.threeOfAKind(5,3,5,4,5));
        assertEquals(9, Yatzy.threeOfAKind(3,3,3,3,5));
        assertEquals(9, Yatzy.threeOfAKind(3,3,3,3,3));
    }

    @Test
    public void test_fourOfKind() {
        assertEquals(12, Yatzy.fourOfAKind(3,3,3,3,5));
        assertEquals(20, Yatzy.fourOfAKind(5,5,5,4,5));
    }

    @Test
    public void test_smallStraight() {
        assertEquals(15, Yatzy.smallStraight(1,2,3,4,5));
        assertEquals(15, Yatzy.smallStraight(2,3,4,5,1));
        assertEquals(0, Yatzy.smallStraight(1,2,2,4,5));
    }

    @Test
    public void test_largeStraight() {
        assertEquals(20, Yatzy.largeStraight(6,2,3,4,5));
        assertEquals(20, Yatzy.largeStraight(2,3,4,5,6));
        assertEquals(0, Yatzy.largeStraight(1,2,2,4,5));
    }

    @Test
    public void test_fullHouse() {
        assertEquals(18, Yatzy.fullHouse(6,2,2,2,6));
        assertEquals(0, Yatzy.fullHouse(2,3,4,5,6));
    }

    @Test
    public void test_play() {
        Player player = Player.builder().build();
        Roll rollFullHouse = new Roll(6,2,2,2,6); // 18
        Roll rollLargeStraight = new Roll(6,2,3,4,5); // 20
        Roll rollSmallStraight = new Roll(1,2,2,4,5); // 0

        player.handleRoll(Category.FULL_HOUSE, rollFullHouse);
        player.handleRoll(Category.LARGE_STRAIGHT, rollLargeStraight);
        player.handleRoll(Category.SMALL_STRAIGHT, rollSmallStraight);

        assertEquals(38, player.getScore());
    }
}
