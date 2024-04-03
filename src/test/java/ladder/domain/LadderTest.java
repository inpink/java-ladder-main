package ladder.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    public void 사다리_폭은_사용자수_빼기_1이다(int userSize) {
        // Given
        Ladder ladder = Ladder.createRandomLadder(
                userSize,
                new Height(1),
                new RandomRowGenerator());
        // When

        // Then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(ladder).isNotNull();
            softly.assertThat(ladder.getRows()).allMatch(row -> row.getRowSize() == userSize - 1);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void 사다리는_높이_수만큼_행을_가진다(int height) {
        // Given
        Ladder ladder = Ladder.createRandomLadder(
                1,
                new Height(height),
                new RandomRowGenerator());

        // When

        // Then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(ladder).isNotNull();
            softly.assertThat(ladder.getRowSize()).isEqualTo(height);
        });
    }
}
