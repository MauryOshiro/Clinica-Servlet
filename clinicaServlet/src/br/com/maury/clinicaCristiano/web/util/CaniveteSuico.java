package br.com.maury.clinicaCristiano.web.util;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

public class CaniveteSuico {
	public static BigInteger converteCpfStringParaBigInteger(String cpfString) {
		// O métido relaceAll substitui todos os caracteres e símbolos por nada, ou seja remove.
		String cpfAux = cpfString.replaceAll("[^0-9]", "");
		BigInteger cpf = new BigInteger(cpfAux);
		return cpf;
	}

	public static String formataDataPadraoBrasileiro(LocalDate data) {
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = data.format(formatador);
		return dataFormatada;
	}

	public static Integer calculaIdade(LocalDate dataNascimento) {
		LocalDate hoje = LocalDate.now();
		formataDataPadraoBrasileiro(hoje);
		Period periodo = Period.between(dataNascimento, hoje);
		Integer idade = periodo.getYears();
		return idade;
	}

	public static LocalDate converteDataStringParaLocalDate(String d) {
		Integer dia = Integer.valueOf(d.substring(3, 5));
		Integer mes = Integer.valueOf(d.substring(0, 2));
		Integer ano = Integer.valueOf(d.substring(6, 10));
		LocalDate data = LocalDate.of(ano, mes, dia);
		return data;
	}

	public static Collection<Integer> arrayStringParaCollectionInteger(String[] arrayIdString) {
		Collection<Integer> colecaoInteiro = new ArrayList<>();
		for(String s : arrayIdString) {
			Integer i = Integer.valueOf(s);
			colecaoInteiro.add(i);
		}
		return colecaoInteiro;
	}
}
