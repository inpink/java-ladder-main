package ladder.domain;

import ladder.domain.RowGeneratorTest.SequenceRowGenerator;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void 사다리는_높이_수만큼_행을_가진다(int height) {
        // Given
        Ladder ladder = new Ladder(1, new Height(height), new SequenceRowGenerator());

        // When

        // Then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(ladder).isNotNull();
            softly.assertThat(ladder.getRowSize()).isEqualTo(height);
        });
    }
}
