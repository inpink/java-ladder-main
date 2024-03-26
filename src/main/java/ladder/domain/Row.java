package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private final List<Boolean> cells = new ArrayList<>();

    public Row(int userLength) {
        addCells(userLength);
    }

    private void addCells(int userLength) {
        for (int i = 0; i < userLength-1; i++) {
            cells.add(false);
        }
    }

    public int getCellSize() {
        return cells.size();
    }
}
