package cn.pg.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author ：zhangfei
 * @date ：Created in 2021/2/1 4:45 下午
 */
public class JacksonUtils {

    private static ObjectMapper objectMapper=new ObjectMapper();

    public static String  toJson(Object object ) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    public static String  toPojo(String  jsonString , Type type) throws IOException {
        JavaType javaType= TypeFactory.defaultInstance().constructType(type);
        return objectMapper.readValue(jsonString,javaType);
    }
}
