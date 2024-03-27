package ladder.domain;


import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import static ladder.domain.Line.EXIST;
import static ladder.domain.Line.NOT_EXIST;

public class RandomRowGenerator implements RowGenerator {
    private final SecureRandom random = new SecureRandom();

    @Override
    public List<Line> generate(int size) {
        List<Line> row = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            Boolean randomValue = random.nextBoolean();
            Line cell = Line.getLine(randomValue);

            if (cell == EXIST
                    && !row.isEmpty()
                    && row.get(i - 1) == EXIST) {
                row.add(NOT_EXIST);
                continue;
            }

            row.add(cell);
        }

        return row;
    }
}
