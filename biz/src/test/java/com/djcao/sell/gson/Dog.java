package com.djcao.sell.gson;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/10/11
 */
@NoArgsConstructor
@Data
public class Dog {
    /**
     * name : Rufus
     * breed : labrador
     * count : 1
     * twoFeet : false
     */

    private String name;
    private String breed;
    private int count;
    private boolean twoFeet;
}
