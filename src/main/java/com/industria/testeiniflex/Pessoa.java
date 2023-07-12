package com.industria.testeiniflex;

import java.time.LocalDate;

public class Pessoa {

  private String nome;

  private LocalDate dataNascimento;

  /**
   * Construtor padrão.
   */
  public Pessoa() {}

  /**
   * Construtor com argumentos.
   * 
   * @param nome : Nome da pessoa.
   * @param dataNascimento : Data de nascimento da pessoa.
   */
  public Pessoa(String nome, LocalDate dataNascimento) {
    this.nome = nome;
    this.dataNascimento = dataNascimento;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

}
