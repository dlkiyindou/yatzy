package roll;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
public class Roll {
    private Integer one;
    private Integer two;
    private Integer three;
    private Integer four;
    private Integer five;
}
