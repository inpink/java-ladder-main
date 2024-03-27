package ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final RowGenerator rowGenerator;
    private final List<Row> graph;

    public Ladder(int userLength, Height height, RowGenerator rowGenerator) {
        this.rowGenerator = rowGenerator;
        this.graph = initGraph(userLength, height);
    }

    private List<Row> initGraph(int userLength, Height height) {
        return IntStream.range(0, height.getHeight())
                .mapToObj(index -> new Row(userLength, rowGenerator))
                .toList();
    }

    public int getRowSize() {
        return graph.size();
    }

    public Line getCell(int x, int y) {
        return graph.get(x).getCellLine(y);
    }
}
