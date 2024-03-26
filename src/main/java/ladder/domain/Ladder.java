package ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Row> graph;

    public Ladder(int userLength, int height) {
        this.graph = initGraph(userLength, height);
    }

    private List<Row> initGraph(int userLength, int height) {
        return IntStream.range(0, height)
                .mapToObj(index -> new Row(userLength))
                .toList();
    }

    public int getRowSize() {
        return graph.size();
    }
}
