package com.study.design.pattern.state;

/**
 * @author noatn
 * @description 聊天机器人，它有两个状态
 * @date 2023-06-26
 */
public interface State {

    /**
     * 初始化 行为
     * @return
     */
    public String init();

    /**
     * 应答 行为
     * @param input
     * @return
     */
    public String reply(String input) ;

}
