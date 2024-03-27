package ladder.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomRowGeneratorTest {
    private final RowGenerator rowGenerator = new RandomRowGenerator();

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void 행은_사이즈_개수만큼_생성된다(int size) {
        // Given

        // When
        List<Boolean> result = rowGenerator.generate(size);

        // Then
        SoftAssertions.assertSoftly(softly -> {
            assertThat(result).isNotNull();
            assertThat(result.size()).isEqualTo(size);
        });
    }
}
