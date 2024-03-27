package ladder.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static ladder.domain.Line.EXIST;
import static ladder.domain.Line.NOT_EXIST;

public class RowGeneratorTest {

    private final RowGenerator rowGenerator = new SequenceRowGenerator();

    static class SequenceRowGenerator implements RowGenerator {

        @Override
        public List<Line> generate(int size) {
            return IntStream.range(0, size)
                    .mapToObj(index -> Line.getLine(index % 2 == 0))
                    .toList();
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void 행은_사이즈_개수만큼_생성된다(int size) {
        // Given

        // When
        List<Line> result = rowGenerator.generate(size);

        // Then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(result).isNotNull();
            softly.assertThat(result.size()).isEqualTo(size);
        });
    }

    static Stream<Arguments> provideRowsForTest() {
        return Stream.of(
                Arguments.of(3, List.of(EXIST, NOT_EXIST, EXIST)),
                Arguments.of(4, List.of(EXIST, NOT_EXIST, EXIST, NOT_EXIST))
        );
    }

    @ParameterizedTest
    @MethodSource("provideRowsForTest")
    public void 행은_순차적인_라인값을_가진다(int size, List<Line> row) {
        // Given

        // When
        List<Line> result = rowGenerator.generate(size);

        // Then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(result).isNotNull();
            softly.assertThat(result).isEqualTo(row);
        });
    }
}
