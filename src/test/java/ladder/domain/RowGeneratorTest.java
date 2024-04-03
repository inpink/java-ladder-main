package ladder.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

public class RowGeneratorTest {
    private final RowGenerator rowGenerator = new RandomRowGenerator();

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void 행은_사이즈_개수만큼_생성된다(int rowSize) {
        // Given

        // When
        Row result = rowGenerator.generate(rowSize);

        // Then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(result).isNotNull();
            softly.assertThat(result.getRowSize()).isEqualTo(rowSize);
        });
    }
}
