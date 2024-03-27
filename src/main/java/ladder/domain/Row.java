package ladder.domain;

import java.util.List;

public class Row {
    private final RowGenerator rowGenerator;
    private final List<Boolean> cells;

    public Row(int userLength, RowGenerator rowGenerator) {
        this.rowGenerator = rowGenerator;
        cells = generateCells(userLength);
    }

    private List<Boolean> generateCells(int userLength) {
        return rowGenerator.generate(userLength-1);
    }

    public int getCellSize() {
        return cells.size();
    }
}
