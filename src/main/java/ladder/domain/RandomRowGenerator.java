package ladder.domain;


import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import static ladder.domain.Line.EXIST;
import static ladder.domain.Line.NOT_EXIST;

public class RandomRowGenerator implements RowGenerator {
    private final SecureRandom random = new SecureRandom();

    @Override
    public List<Boolean> generate(int size) {
        return IntStream.range(0,size)
                .mapToObj(index -> random.nextBoolean())
                .toList();
    public List<Line> generate(int size) {
        List<Line> row = new ArrayList<>();
        return row;
    }
}
