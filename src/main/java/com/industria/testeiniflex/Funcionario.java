package com.industria.testeiniflex;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa {

  private BigDecimal salario;

  private String funcao;

  /**
   * Construtor padrão.
   */
  public Funcionario() {
    super();
  }

  /**
   * Construtor com argumentos.
   * 
   * @param nome : Nome do funcionário.
   * @param dataNascimento : Data de nascimento do funcionário.
   * @param salario : Salário do funcionário.
   * @param funcao : Função do funcionário.
   */
  public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
    super();
    this.setNome(nome);
    this.setDataNascimento(dataNascimento);
    this.salario = salario;
    this.funcao = funcao;
  }

  public BigDecimal getSalario() {
    return salario;
  }

  public BigDecimal getSalariosMinimos() {
    return this.getSalario().divide(BigDecimal.valueOf(1212));
  }

  public void setSalario(BigDecimal salario) {
    this.salario = salario;
  }

  public String getFuncao() {
    return funcao;
  }

  public void setFuncao(String funcao) {
    this.funcao = funcao;
  }

  public String toString() {
    return "Nome: " + this.getNome() + ", Data Nascimento: "
        + this.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")) + ", Salário: "
        + new DecimalFormat("#,##0.00").format(this.getSalario()) + ", Função: " + this.getFuncao();
  }

}
