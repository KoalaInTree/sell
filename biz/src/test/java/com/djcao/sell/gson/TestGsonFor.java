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
public class TestGsonFor {

    /**
     * animals : {"dog":[{"name":"Rufus","breed":"labrador","count":1,"twoFeet":false},{"name":"Marty",
     * "breed":"whippet","count":1,"twoFeet":false}],"cat":{"name":"Matilda"}}
     */

    private Animals animals;
}
