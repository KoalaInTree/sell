package com.djcao.sell.help;

import java.io.IOException;
import java.text.DecimalFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/11/2
 */
public class CustomDoubleSerialize extends JsonSerializer<Double> {
    private DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    @Override
    public void serialize(Double aDouble, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
        throws IOException, JsonProcessingException {
        jsonGenerator.writeString(this.decimalFormat.format(aDouble));
    }
}
