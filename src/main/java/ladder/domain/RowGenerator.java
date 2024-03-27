package ladder.domain;

import java.util.List;

public interface RowGenerator {
     List<Line> generate(int size);
}
