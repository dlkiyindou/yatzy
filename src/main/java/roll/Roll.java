package roll;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
public class Roll {
    private Integer diceOne;
    private Integer diceTwo;
    private Integer diceThree;
    private Integer diceFour;
    private Integer diceFive;
}
