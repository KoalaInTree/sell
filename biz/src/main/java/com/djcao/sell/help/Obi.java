package com.djcao.sell.help;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/11/8
 */
@Accessors(chain = true)
@Data
public class Obi {
    private int categoryId =45;
    private int parentId = 0;
    private String title =  "语言";
    private int level = 1;
    private int count = 19;
    private int status = 0;
}
