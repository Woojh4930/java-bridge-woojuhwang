package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void createBridgeGame() {
        bridgeGame = new BridgeGame(List.of("U", "D", "D"));
    }

    @DisplayName("올바른 다리를 건넌 경우 true 반환")
    @Test
    void moveCorrectBridge() {
        List<BridgeLocation> result = List.of(BridgeLocation.UP_TRUE);
        assertThat(bridgeGame.move("U")).isEqualTo(result);
    }

    @DisplayName("올바른 다리가 아닌 경우 false 반환")
    @Test
    void moveIncorrectBridge() {
        List<BridgeLocation> result = List.of(BridgeLocation.DOWN_FALSE);
        assertThat(bridgeGame.move("D")).isEqualTo(result);
    }

    @DisplayName("재시작을 한 경우 true 반환")
    @Test
    void retry() {
        assertThat(bridgeGame.retry("R")).isTrue();
    }

    @DisplayName("그만두기로 한 경우 false 반환")
    @Test
    void quit() {
        assertThat(bridgeGame.retry("Q")).isFalse();
    }


}
