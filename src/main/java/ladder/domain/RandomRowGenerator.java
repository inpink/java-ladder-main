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

        for (int index = 0; index < size; index++) {
            Boolean randomValue = random.nextBoolean();
            Line cell = Line.getLine(randomValue);

            addNotDuplicatedCell(cell, row, index);
        }
        return row;
    }

    private static void addNotDuplicatedCell(Line cell,
                                             List<Line> row,
                                             int index) {
        if (cell == EXIST
                && !row.isEmpty()
                && row.get(index - 1) == EXIST) {
            row.add(NOT_EXIST);
            return;
        }

        row.add(cell);
    }
}
