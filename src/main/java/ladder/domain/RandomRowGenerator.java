package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomRowGenerator implements RowGenerator {

    @Override
    public Row generate(int size) {
        List<Line> lines = new ArrayList<>();
        addFirstLine(lines);

        for (int index = 1; index < size; index++) {
            Line line = Line.createRandomLine();
            Line beforeLine = lines.get(index - 1);

            addNotDuplicatedLine(line, beforeLine, lines);
        }
        return new Row(lines);
    }

    private void addFirstLine(List<Line> row) {
        Line line = Line.createRandomLine();
        row.add(line);
    }

    private void addNotDuplicatedLine(Line line, Line beforeLine, List<Line> lines) {
        if (beforeLine.isExistent()) {
            lines.add(Line.createNonExistentLine());
            return;
        }

        lines.add(line);
    }
}
