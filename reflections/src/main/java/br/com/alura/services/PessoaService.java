package br.com.alura.services;

import java.lang.reflect.InvocationTargetException;

import br.com.alura.models.dto.Pessoa;
import br.com.alura.models.dto.PessoaDTO;
import br.com.alura.repositories.PessoaRepository;
import br.com.alura.utils.Transformator;

public class PessoaService {

    public PessoaDTO list() throws ClassNotFoundException, InstantiationException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, IllegalAccessException {

        Pessoa pessoa = new PessoaRepository().list();
        // PessoaDTO pessoaDTO = new PessoaDTO(pessoa.getNome(), pessoa.getCpf());
        PessoaDTO pessoaDTO = new Transformator().transform(pessoa);
        return pessoaDTO;
    }

}
