package com.study.design.pattern.template_pattern.v1;

/**
 * @author noatn
 * @description
 * @date 2023-06-26
 */
public class CaffeineBeverageClient {
    /**
     * 执行
     */
    public void execute(){
        CaffeineBeverage tea = new Tea() ;
        tea.prepareRecipe();

        CaffeineBeverage coffee = new Coffee() ;
        coffee.prepareRecipe();
    }
}
