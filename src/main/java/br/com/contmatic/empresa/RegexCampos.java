package br.com.contmatic.empresa;

public final class RegexCampos {

	public final static String CEPFORMATO = "\\d{8}";
	public final static String EMAILFORMATO = ".+@.+\\.[a-z]+";
	public final static String CNPJFORMATO = "\\d{14}";
	public final static String RUAFORMATO = "[a-zA-Z\\+\\s_\\d]+";
	public final static String TELEFONEFORMATO = "[0-9]{8,9}";
	public final static String UFFORMATO = "[a-zA-Z]{2}";
	public final static String RAZAOSOCIALFORMATO = "[A-Za-z0-9]{1,30}";
	public final static String INSCRICAOESTADUALFORMATO = "[0-9]{13}";
	public final static String DONOFORMATO = "^[A-Za-z]{4,50}";
}
