package br.com.alura.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.models.dto.Pessoa;

class ObjectToJsonTest {

    @Test
    void shouldTransformToJson() {

        Pessoa pessoa = new Pessoa("Bruno", "123.456.789-00", "Rua 1", "1234-5678");

        ObjectToJson objectToJson = new ObjectToJson();

        String json = objectToJson.transform(pessoa);

        System.out.println(json);

        Assertions.assertInstanceOf(String.class, json);
    }

}
