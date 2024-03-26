package ladder.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


public class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    public void 사다리는_높이_수만큼_행을_가진다(int height) {
        // Given
        Ladder ladder = new Ladder(1,height);

        // When

        // Then
        SoftAssertions.assertSoftly(softly -> {
            assertThat(ladder).isNotNull();
            assertThat(ladder.getRowSize()).isEqualTo(height);
        });
    }
}
