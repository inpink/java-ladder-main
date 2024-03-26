package ladder.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @ParameterizedTest
    @ValueSource(strings = {"A", "AB", "ABC", "ABCD", "ABCDE"})
    public void 유효한_길이의_사용자_이름을_가진다(String name) {
        // Given
        User user = new User(name);

        // When

        // Then
        SoftAssertions.assertSoftly(softly -> {
            assertThat(user).isNotNull();
            assertThat(user.getName()).isEqualTo(name);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "ABCDEF", "ABCDEFG"})
    public void 사용자_이름_길이가_범위를_벗어나면_안된다(String name) {
        Assertions.assertThatThrownBy(() -> {
            new User(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
