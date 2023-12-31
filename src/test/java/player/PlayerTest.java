package player;

import category.Category;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import roll.Roll;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @SneakyThrows
    @Test
    public void test_play_best_category() {
        Player player = Player.builder().build();
        Roll rollFullHouse = new Roll(6,2,2,2,6); // 18
        Roll rollLargeStraight = new Roll(6,2,3,4,5); // 20
        Roll rollSmallStraight = new Roll(1,2,2,4,5); // 0

        player.handleRoll(Category.FULL_HOUSE, rollFullHouse);
        player.handleRoll(Category.LARGE_STRAIGHT, rollLargeStraight);
        player.handleRoll(Category.SMALL_STRAIGHT, rollSmallStraight);

        assertEquals(Category.LARGE_STRAIGHT, player.retrieveBestCategory());
        assertEquals(20, player.retrieveBestScore());
        assertEquals(38, player.retrieveGlobalScore());
    }

    @Test
    public void test_play_new_instance() {
        Player player = Player.builder().build();

        assertNull(player.retrieveBestCategory());
        assertEquals(0, player.retrieveBestScore());
    }

    @SneakyThrows
    @Test
    public void test_play_with_not_available_category() {
        Player player = Player.builder().build();
        Roll rollFullHouse = new Roll(6,2,2,2,6); // 18
        Roll rollLargeStraight = new Roll(6,2,3,4,5); // 20
        Roll rollSmallStraight = new Roll(1,2,2,4,5); // 0

        player.handleRoll(Category.FULL_HOUSE, rollFullHouse);
        player.handleRoll(Category.LARGE_STRAIGHT, rollLargeStraight);
        player.handleRoll(Category.SMALL_STRAIGHT, rollSmallStraight);

        assertEquals(38, player.retrieveGlobalScore());

        Exception thrown = assertThrows(
            Exception.class,
            () -> player.handleRoll(Category.FULL_HOUSE, new Roll(2,3,4,5,6))
        );

        assertEquals("Category FULL_HOUSE is not available",  thrown.getMessage());
    }
}
