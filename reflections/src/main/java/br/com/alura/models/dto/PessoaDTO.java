package br.com.alura.models.dto;

public class PessoaDTO {

    public PessoaDTO(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    private String nome;
    private String cpf;
}
