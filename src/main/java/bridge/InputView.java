package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String readline = Console.readLine();
        isNumeric(readline);
        isRange(Integer.parseInt(readline));
        return Integer.parseInt(readline);
    }

    private void isRange(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 3에서 20까지의 숫자를 입력해 주시기 바랍니다.");
        }
    }

    private void isNumeric(String readline) {
        if (!Pattern.matches("^[1-9]\\d*$", readline)) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자가 아닙니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public BridgeLocation readMoving() {
        String readline = Console.readLine();
        if(!("U".equals(readline) || "D".equals(readline))) {
            throw new IllegalArgumentException();
        }
        return BridgeLocation.createLocation(readline);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

}
