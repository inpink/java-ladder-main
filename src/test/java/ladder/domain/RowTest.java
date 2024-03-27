package ladder.domain;

import ladder.domain.RowGeneratorTest.SequenceRowGenerator;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    public void 사다리_폭은_사용자수_빼기_1이다(int userLength) {
        // Given
        Row row = new Row(userLength, new SequenceRowGenerator());

        // When

        // Then
        SoftAssertions.assertSoftly(softly -> {
            assertThat(row).isNotNull();
            assertThat(row.getCellSize()).isEqualTo(userLength - 1);
        });
    }
}
