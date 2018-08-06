package com.djcao.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-08-05
 */
@Data
public class WordsOfWelcomeVO {

    @JsonProperty("word")
    private String words;

    @JsonProperty("CODE")
    private int code;

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
