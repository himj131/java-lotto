package lotto.domain;

import java.util.Map;

public class WinResult {
    private int purchasedMoney;
    private final Lottos purchasedLotto;
    private final Lotto winNumbers;
    private final LottoNumber bonusNumber;
    private final Map<WinType, Integer> winResultMap;
    private final WinningResultReader winningResultReader = new WinningResultReader();

    public WinResult(int purchasedMoney, Lottos purchasedLotto, Lotto winNumbers, LottoNumber bonusNumber) {
        this.purchasedMoney = purchasedMoney;
        this.purchasedLotto = purchasedLotto;
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
        this.winResultMap = getWinResultMap();
    }

    public Map<WinType, Integer> getResults() {
        winResultMap.remove(WinType.NO_MATCH);
        return winResultMap;
    }

    public String getYeild() {
        return YieldCalculator.calculateYield(purchasedMoney, winResultMap);
    }

    private Map<WinType, Integer> getWinResultMap() {
        return winningResultReader.getWinningResult(purchasedLotto, winNumbers, bonusNumber);
    }
}
