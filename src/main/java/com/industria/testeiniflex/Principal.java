package com.industria.testeiniflex;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {

  private static List<Funcionario> funcionarios = new ArrayList<Funcionario>();

  public static void main(String[] args) {

    inserirFuncionarios();

    removerJoao();

    System.out.println("--------------------");

    imprimirFuncionarios();

    aumentarSalarios();

    System.out.println("--------------------");

    imprimirFuncionariosAgrupados();

    System.out.println("--------------------");

    imprimirFuncionariosPorMesEspecifico();

    System.out.println("--------------------");

    imprimirFuncionarioComMaiorIdade();

    System.out.println("--------------------");

    imprimirFuncionariosEmOrdemAlfabetica();

    System.out.println("--------------------");

    imprimirTotalSalarios();
  }

  /**
   * 3.1 - Cria e insere todos os funcionários.
   */
  public static void inserirFuncionarios() {
    Funcionario maria = new Funcionario("Maria", LocalDate.of(2000, 10, 18),
        BigDecimal.valueOf(2009.44), "Operador");
    Principal.funcionarios.add(maria);

    Funcionario joao =
        new Funcionario("João", LocalDate.of(1990, 5, 12), BigDecimal.valueOf(2284.38), "Operador");
    Principal.funcionarios.add(joao);

    Funcionario caio = new Funcionario("Caio", LocalDate.of(1961, 5, 2),
        BigDecimal.valueOf(9836.14), "Coordenador");
    Principal.funcionarios.add(caio);

    Funcionario miguel = new Funcionario("Miguel", LocalDate.of(1988, 10, 14),
        BigDecimal.valueOf(19119.88), "Diretor");
    Principal.funcionarios.add(miguel);

    Funcionario alice = new Funcionario("Alice", LocalDate.of(1995, 1, 5),
        BigDecimal.valueOf(2234.68), "Recepcionista");
    Principal.funcionarios.add(alice);

    Funcionario heitor = new Funcionario("Heitor", LocalDate.of(1999, 11, 19),
        BigDecimal.valueOf(1582.72), "Operador");
    Principal.funcionarios.add(heitor);

    Funcionario arthur = new Funcionario("Arthur", LocalDate.of(1993, 3, 31),
        BigDecimal.valueOf(4071.84), "Contador");
    Principal.funcionarios.add(arthur);

    Funcionario laura =
        new Funcionario("Laura", LocalDate.of(1994, 7, 8), BigDecimal.valueOf(2009.44), "Gerente");
    Principal.funcionarios.add(laura);

    Funcionario heloisa = new Funcionario("Heloísa", LocalDate.of(2003, 5, 24),
        BigDecimal.valueOf(1606.85), "Eletricista");
    Principal.funcionarios.add(heloisa);

    Funcionario helena =
        new Funcionario("Helena", LocalDate.of(1996, 9, 2), BigDecimal.valueOf(2009.44), "Gerente");
    Principal.funcionarios.add(helena);

  }

  /**
   * 3.2 - Remove o funcionário João da lista de funcionários.
   */
  public static void removerJoao() {
    Principal.funcionarios = Principal.funcionarios.stream()
        .filter(funcionario -> !funcionario.getNome().equals("João")).collect(Collectors.toList());
  }

  /**
   * 3.3 - Imprime todos os funcionários com os atributos dataNascimento e salario formatados.
   */
  public static void imprimirFuncionarios() {
    for (Funcionario funcionario : Principal.funcionarios) {
      System.out.println(funcionario.toString());
    }
  }

  /**
   * 3.4 - Aumenta o salário de todos os funcionários em 10%.
   */
  public static void aumentarSalarios() {
    funcionarios.forEach(funcionario -> funcionario
        .setSalario(funcionario.getSalario().multiply(BigDecimal.valueOf(1.1))));
  }

  /**
   * 3.5 - Agrupa funcionários por função.
   */
  public static Map<String, List<Funcionario>> agruparFuncionarios() {
    Map<String, List<Funcionario>> funcionariosMap =
        Principal.funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

    return funcionariosMap;
  }

  /**
   * 3.6 - Imprime funcionários agrupados por função.
   */
  public static void imprimirFuncionariosAgrupados() {
    Map<String, List<Funcionario>> funcionariosMap = Principal.agruparFuncionarios();

    funcionariosMap.forEach((key, value) -> System.out.println(key + ": " + value));
  }

  /**
   * 3.7 - Imprime funcionários que nasceram nos meses 10 ou 12.
   */
  public static void imprimirFuncionariosPorMesEspecifico() {
    for (Funcionario funcionario : Principal.funcionarios) {
      int mesDeNascimento = funcionario.getDataNascimento().getMonthValue();

      if (mesDeNascimento == 10 || mesDeNascimento == 12) {
        System.out.println(funcionario.toString());
      }
    }
  }

  /**
   * 3.8 - Imprime funcionario com maior idade.
   */
  public static void imprimirFuncionarioComMaiorIdade() {
    Funcionario funcionarioMaisVelho = Principal.funcionarios.stream()
        .reduce((a, b) -> a.getDataNascimento().isBefore(b.getDataNascimento()) ? a : b).get();

    System.out.println("Nome: " + funcionarioMaisVelho.getNome() + ", Idade: "
        + Period.between(funcionarioMaisVelho.getDataNascimento(), LocalDate.now()).getYears()
        + ", Data Nascimento: " + funcionarioMaisVelho.getDataNascimento()
            .format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
  }

  /**
   * 3.9 - Imprime funcionários em ordem alfabética.
   */
  public static void imprimirFuncionariosEmOrdemAlfabetica() {
    List<Funcionario> funcionariosOrdenados = Principal.funcionarios.stream()
        .sorted((a, b) -> a.getNome().compareTo(b.getNome())).collect(Collectors.toList());

    for (Funcionario funcionario : funcionariosOrdenados) {
      System.out.println(funcionario.toString());
    }
  }

  /**
   * 3.10 - Imprime o total dos salários de todos os funcionários.
   */
  public static void imprimirTotalSalarios() {
    BigDecimal total = Principal.funcionarios.stream().map(Funcionario::getSalario)
        .reduce((a, b) -> a.add(b)).get();

    System.out.println("Total dos salários: " + new DecimalFormat("#,##0.000").format(total));
  }

  /**
   * 3.11 - Imprime quantos salarios mínimos ganha cada funcionário.
   */
  public static void imprimirSalariosMinimosPorFuncionario() {
    Map<String, BigDecimal> funcionariosMap = Principal.funcionarios.stream()
        .collect(Collectors.toMap(Funcionario::getNome, Funcionario::getSalariosMinimos));

    funcionariosMap.forEach((key, value) -> System.out.println(key + " " + value));
  }

}
