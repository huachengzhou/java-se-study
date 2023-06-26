package com.study.design.pattern.state;

/**
 * @author noatn
 * @description
 * @date 2023-06-26
 */
public class BotContext {

    private State state = new DisconnectedState();

    public String chat(String input) {
        if ("hello".equalsIgnoreCase(input)) {
            // 收到hello切换到在线状态:
            state = new ConnectedState();
            return state.init();
        } else if ("bye".equalsIgnoreCase(input)) {
            //  收到bye切换到离线状态:
            state = new DisconnectedState();
            return state.init();
        }
        return state.reply(input);
    }

}
