package com.lotushint.boot.json;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/14 14:06
 * @package com.lotushint.boot.json
 * @description
 */
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *使用@JsonComponent注释会自动被注册到Jackson中.
 **/
@Slf4j
@JsonComponent
public class CustomJackson {

    /**
     * 自定义序列化器,格式化数值
     */
    public static class MySerializer extends JsonSerializer<Double> {

        private DecimalFormat df = new DecimalFormat("##.00");

        /**
         * 序列化操作,继承JsonSerializer，重写Serialize函数
         * @param value
         * @param jsonGenerator
         * @param serializerProvider
         * @throws IOException
         */
        @Override
        public void serialize(Double value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(df.format(value));
        }
    }

    /**
     * 自定义反序列化器,格式化时间
     */
    public static class MyDeserializer extends JsonDeserializer<Date> {

        private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        @Override
        public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            Date date = null;
            try {
                date = sdf.parse(jsonParser.getText());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date;
        }
    }

}