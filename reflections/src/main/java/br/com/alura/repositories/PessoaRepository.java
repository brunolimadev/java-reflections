package br.com.alura.repositories;

import br.com.alura.models.dto.Pessoa;

public class PessoaRepository {

    public Pessoa list() {
        return new Pessoa("Fulano", "123.456.789-00", "Rua dos bobos", "1234-5678");
    }

}
