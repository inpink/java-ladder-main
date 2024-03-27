package ladder.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RowGeneratorTest {

    private final RowGenerator rowGenerator = new SequenceRowGenerator();

    static class SequenceRowGenerator implements RowGenerator {

        @Override
        public List<Boolean> generate(int size) {
            return IntStream.range(0, size)
                    .mapToObj(index -> index % 2 == 0)
                    .toList();
        }
    }

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

    static Stream<Arguments> provideRowsForTest() {
        return Stream.of(
                Arguments.of(3, List.of(true, false, true)),
                Arguments.of(4, List.of(true, false, true, false))
        );
    }

    @ParameterizedTest
    @MethodSource("provideRowsForTest")
    public void 행은_순차적인_불린값을_가진다(int size, List<Boolean> row) {
        // Given

        // When
        List<Boolean> result = rowGenerator.generate(size);

        // Then
        SoftAssertions.assertSoftly(softly -> {
            assertThat(result).isNotNull();
            assertThat(result).isEqualTo(row);
        });
    }
}
