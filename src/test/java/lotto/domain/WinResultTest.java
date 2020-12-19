package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinResultTest {
    @Test
    @DisplayName("3000원으로 3등하나 당첨시 수익률 1.66")
    void yield_test() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Stream.of(1, 2, 4, 6, 9, 10).map(LottoNumber::new).collect(Collectors.toList())),
                new Lotto(Stream.of(7, 11, 14, 15, 35, 38).map(LottoNumber::new).collect(Collectors.toList())),
                new Lotto(Stream.of(3, 4, 9, 11, 24, 43).map(LottoNumber::new).collect(Collectors.toList()))
        );
        String winNumbers = "1, 2, 5, 10, 34, 43";
        WinResult result = new WinResult(lottos, winNumbers, 3000);
        assertThat(result.getYield()).isEqualTo("1.66");
    }
}