package com.djcao.sell.jvm;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/2/10
 */
public class OutClass {
    private String name;
    private int id;
    private String address;

    public class InnerClass {

        public void fun() {
            System.out.println(OutClass.this.id + "--id");
            System.out.println(OutClass.this.name + "--name");
            System.out.println(OutClass.this.address + "--address");
        }
    }
}
