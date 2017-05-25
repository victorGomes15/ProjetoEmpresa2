package br.com.contmatic.empresa;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.DateTime;

// TODO: Auto-generated Javadoc
/**
 * The Class Empresa.
 */
public class Empresa {

	/** The cnpj. */
	private String cnpj;

	/** The razao social. */
	private String razaoSocial;

	/** The endereco. */
	private Set<Endereco> endereco;

	/** The telefone. */
	private Set<Telefone> telefone;

	/** The dono. */
	private String dono;

	/** The email. */
	private Email email;

	/** The inscricao estadual. */
	private String inscricaoEstadual;

	/** The nome empresa. */
	private String nomeEmpresa;

	/** The data criacao. */
	private DateTime dataCriacao;

	/**
	 * Instantiates a new empresa.
	 */
	public Empresa() {
	}

	/**
	 * Gets the cnpj.
	 *
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * Sets the cnpj.
	 *
	 * @param cnpj
	 *            the new cnpj
	 */
	public void setCnpj(String cnpj) {
		checkArgument(isNotEmpty(cnpj) && cnpj.matches(RegexCampos.CNPJFORMATO), "CNPJ incorreto");
		this.cnpj = cnpj;
	}

	/**
	 * Gets the razao social.
	 *
	 * @return the razao social
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * Sets the razao social.
	 *
	 * @param razaoSocial
	 *            the new razao social
	 */
	public void setRazaoSocial(String razaoSocial) {
		checkArgument(isNotEmpty(razaoSocial) && razaoSocial.matches(RegexCampos.RAZAOSOCIALFORMATO),
				"Razão social invalida, não pode ser nula ou vazia");
		this.razaoSocial = razaoSocial;
	}

	/**
	 * Gets the endereco.
	 *
	 * @return the endereco
	 */
	public Set<Endereco> getEndereco() {
		return endereco;
	}

	/**
	 * Gets the telefone.
	 *
	 * @return the telefone
	 */
	public Set<Telefone> getTelefone() {
		return telefone;
	}

	/**
	 * Sets the telefone.
	 *
	 * @param telefone
	 *            the new telefone
	 */
	public void setTelefone(Set<Telefone> telefone) {
		this.telefone = telefone;
	}

	public void setEndereco(Set<Endereco> endereco) {
		this.endereco = endereco;
	}

	/**
	 * Gets the dono.
	 *
	 * @return the dono
	 */
	public String getDono() {
		return dono;
	}

	/**
	 * Sets the dono.
	 *
	 * @param dono
	 *            the new dono
	 */
	public void setDono(String dono) {
		checkArgument(isNotEmpty(dono) && dono.matches(RegexCampos.DONOFORMATO),
				"Nome não pode ser nulo, vazio ou conter números");
		this.dono = dono;
	}

	/**
	 * Gets the data criacao.
	 *
	 * @return the data criacao
	 */
	public DateTime getDataCriacao() {
		return dataCriacao;
	}

	/**
	 * Sets the data criacao.
	 *
	 * @param dataCriacao
	 *            the new data criacao
	 */
	public void setDataCriacao(DateTime dataCriacao) {
		DateTime dataAtual = DateTime.now();
		checkArgument(dataCriacao.isAfterNow() || dataCriacao.equals(dataAtual),
				"Data deve ser a partir da data atual");
		this.dataCriacao = dataCriacao;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public Email getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the new email
	 */
	public void setEmail(Email email) {
		this.email = email;
	}

	/**
	 * Gets the inscricao estadual.
	 *
	 * @return the inscricao estadual
	 */
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	/**
	 * Sets the inscricao estadual.
	 *
	 * @param inscricaoEstadual
	 *            the new inscricao estadual
	 */
	public void setInscricaoEstadual(String inscricaoEstadual) {
		checkArgument(isNotEmpty(inscricaoEstadual) && inscricaoEstadual.matches(RegexCampos.INSCRICAOESTADUALFORMATO),
				"Inscrição estadual invalida");
		this.inscricaoEstadual = inscricaoEstadual;
	}

	/**
	 * Gets the nome empresa.
	 *
	 * @return the nome empresa
	 */
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	/**
	 * Sets the nome empresa.
	 *
	 * @param nomeEmpresa
	 *            the new nome empresa
	 */
	public void setNomeEmpresa(String nomeEmpresa) {
		checkArgument(isNotEmpty(nomeEmpresa), "Nome não pode ser nulo ou vazio");
		this.nomeEmpresa = nomeEmpresa;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.cnpj).hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Empresa)) {
			return false;
		}
		Empresa other = (Empresa) obj;
		return new EqualsBuilder().append(this.cnpj, other.cnpj).isEquals();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, new MultilineRecursiveToStringStyle());
	}

}
