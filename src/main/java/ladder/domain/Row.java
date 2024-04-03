package ladder.domain;

import java.util.List;

public class Row {
    private final List<Line> lines;

    public Row(List<Line> lines) {
        this.lines = lines;
    }

    public static Row createRandomRow(RowGenerator rowGenerator, int size) {
        return rowGenerator.generate(size);
    }

    public int getRowSize() {
        return lines.size();
    }

    public Line getLine(int index) {
        return lines.get(index);
    }

    public List<Line> getLines() {
        return lines;
    }
}
