package com.study.design.pattern.state;

/**
 * @author noatn
 * @description
 * @date 2023-06-26
 */
public class ConnectedState implements State {
    /**
     * 初始化 行为
     *
     * @return
     */
    @Override
    public String init() {
        return "Hello, I'm Bob.";
    }

    /**
     * 应答 行为
     *
     * @param input
     * @return
     */
    @Override
    public String reply(String input) {
        if (input.endsWith("?")) {
            return "Yes. " + input.substring(0, input.length() - 1) + "!";
        }
        if (input.endsWith(".")) {
            return input.substring(0, input.length() - 1) + "!";
        }
        return input.substring(0, input.length() - 1) + "?";
    }
}
