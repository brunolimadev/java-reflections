package br.com.alura.utils;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.models.dto.Pessoa;
import br.com.alura.models.dto.PessoaDTO;

class TransformatorTest {

    Pessoa pessoa = new Pessoa("João", "123.456.789-00", "Rua 1", "1234-5678");

    @Test
    void shouldTransform() throws ClassNotFoundException, InstantiationException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, IllegalAccessException {

        Transformator transformator = new Transformator();

        PessoaDTO pessoaDTO = transformator.transform(pessoa);

        Assertions.assertInstanceOf(PessoaDTO.class, pessoaDTO);
        Assertions.assertEquals(pessoaDTO.getNome(), pessoaDTO.getNome());
        Assertions.assertEquals(pessoaDTO.getCpf(), pessoaDTO.getCpf());
    }

    @Test
    void shouldNotTransform() throws ClassNotFoundException, InstantiationException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, IllegalAccessException {

        Transformator transformator = new Transformator();

        Assertions.assertThrows(ClassNotFoundException.class, () -> {
            transformator.transform(new Object());
        });
    }

    @Test
    void shouldTransformWhenSomeFieldIsNull()
            throws ClassNotFoundException, InstantiationException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, IllegalAccessException {

        pessoa = new Pessoa("João", null, null, "1234-5678");

        Transformator transformator = new Transformator();

        PessoaDTO pessoaDTO = transformator.transform(pessoa);

        Assertions.assertEquals(pessoaDTO.getNome(), pessoaDTO.getNome());
        Assertions.assertNull(pessoaDTO.getCpf());
    }

}
