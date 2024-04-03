package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Row> rows;

    public Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public static Ladder createRandomLadder(int userSize,
                                            Height height,
                                            RowGenerator rowGenerator) {
        List<Row> rows = new ArrayList<>();

        for(int i = 0; i < height.getValue(); i++) {
            int lineSize = calculateSequentialSize(userSize);
            Row row = Row.createRandomRow(rowGenerator, lineSize);
            rows.add(row);
        }
        return new Ladder(rows);
    }

    private static int calculateSequentialSize(int userSize) {
        return userSize - 1;
    }

    public int getRowSize() {
        return rows.size();
    }

    public Line getLine(int rowIndex, int lineIndex) {
        return rows.get(rowIndex).getLine(lineIndex);
    }

    public List<Row> getRows() {
        return rows;
    }
}
