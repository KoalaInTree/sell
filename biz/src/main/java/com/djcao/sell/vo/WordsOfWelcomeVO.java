package com.djcao.sell.vo;

import java.util.Date;

import com.djcao.sell.help.CustomDoubleSerialize;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8:00")
    private Date showTime;

    private double price;
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
    @JsonSerialize(using = CustomDoubleSerialize.class)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
