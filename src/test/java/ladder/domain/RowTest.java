package ladder.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    public void 셀의_라인이_서로_겹치지_않는다(int userSize) {
        // Given
        Row row = Row.createRandomRow(new RandomRowGenerator(), userSize);

        // When

        // Then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(row).isNotNull();
            assertThat(row.getLines()).doesNotContainSubsequence(
                    Line.createExistentLine(),
                    Line.createExistentLine());
        });
    }
}
