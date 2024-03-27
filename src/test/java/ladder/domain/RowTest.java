package ladder.domain;

import ladder.domain.RowGeneratorTest.SequenceRowGenerator;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static ladder.domain.Line.EXIST;
import static ladder.domain.Line.NOT_EXIST;

public class RowTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    public void 사다리_폭은_사용자수_빼기_1이다(int userLength) {
        // Given
        Row row = new Row(userLength, new SequenceRowGenerator());

        // When

        // Then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(row).isNotNull();
            softly.assertThat(row.getCellSize()).isEqualTo(userLength - 1);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    public void 셀의_라인이_서로_겹치지_않는다(int userLength) {
        // Given
        Row row = new Row(userLength, new RandomRowGenerator());

        // When

        // Then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(row).isNotNull();
            IntStream.range(0, userLength - 1)
                    .filter(index -> row.getCellLine(index) == EXIST && index > 0)
                    .forEach(index -> softly.assertThat(row.getCellLine(index-1)).isEqualTo(NOT_EXIST));
        });
    }
}
