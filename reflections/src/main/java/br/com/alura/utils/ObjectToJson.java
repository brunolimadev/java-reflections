package br.com.alura.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.HashMap;
import java.util.Map;

public class ObjectToJson {

    public String transform(Object object) {

        ObjectMapper objectMapper = new ObjectMapper();

        String result = "";

        // configurar o mapper para identar o json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        Map<String, Object> mapper = new HashMap<>();

        Class<?> clazz = object.getClass();

        for (var field : clazz.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                mapper.put(field.getName(), field.get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        try {
            result = objectMapper.writeValueAsString(mapper);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return result;
    }

}
