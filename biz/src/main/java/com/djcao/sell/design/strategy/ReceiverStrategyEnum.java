package com.djcao.sell.design.strategy;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-09-07
 */
public enum  ReceiverStrategyEnum {
    NORMAL("1","normal"),
    DISCOUNT("2","discount"),
    MONEYRETUREN("3","money-return")
    ;

    private String code;
    private String desc;

    ReceiverStrategyEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public static void printStrategy(){
        System.out.println("有以下几种收银方式:\r\n");
        for (ReceiverStrategyEnum strategyEnum : ReceiverStrategyEnum.values()){
            System.out.printf("第%s种方式是:%s\r\n",strategyEnum.getCode(),strategyEnum.getDesc());
        }
    }
}
