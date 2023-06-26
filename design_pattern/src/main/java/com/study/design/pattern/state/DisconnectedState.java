package com.study.design.pattern.state;

/**
 * @author noatn
 * @description 对于未连线状态，我们收到消息也不回复
 * @date 2023-06-26
 */
public class DisconnectedState implements State {
    /**
     * 初始化 行为
     *
     * @return
     */
    @Override
    public String init() {
        return "Bye!";
    }

    /**
     * 应答 行为
     *
     * @param input
     * @return
     */
    @Override
    public String reply(String input) {
        return "";
    }
}
