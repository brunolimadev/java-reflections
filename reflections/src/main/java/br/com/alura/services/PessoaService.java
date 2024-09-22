package br.com.alura.services;

import br.com.alura.models.dto.Pessoa;
import br.com.alura.models.dto.PessoaDTO;
import br.com.alura.repositories.PessoaRepository;

public class PessoaService {

    public PessoaDTO list() {

        Pessoa pessoa = new PessoaRepository().list();
        PessoaDTO pessoaDTO = new PessoaDTO(pessoa.getNome(), pessoa.getCpf());
        return pessoaDTO;
    }

}
