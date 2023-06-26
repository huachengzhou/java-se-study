package com.study.design.pattern.state;

import java.util.Scanner;

/**
 * @author noatn
 * @description
 * @date 2023-06-26
 */
public class BotContextDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BotContext bot = new BotContext();
        for (; ; ) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String output = bot.chat(input);
            System.out.println(output.isEmpty() ? "(no reply)" : "< " + output);
        }
    }
}
