import java.util.*;
import static java.util.stream.Collectors.*;

class Solution {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
            .collect(
                groupingBy(
                    p -> p[1],
                    mapping(p -> p[0], counting())
                )
            )
            .values()
            .stream()
            .reduce(1L, (acc, cur) -> acc * (cur + 1))
            .intValue() - 1;
    }
}