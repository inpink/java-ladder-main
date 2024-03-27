package ladder.domain;


import java.security.SecureRandom;
import java.util.List;
import java.util.stream.IntStream;

public class RandomRowGenerator implements RowGenerator {
    private final SecureRandom random = new SecureRandom();

    @Override
    public List<Boolean> generate(int size) {
        return IntStream.range(0,size)
                .mapToObj(index -> random.nextBoolean())
                .toList();
    }
}
