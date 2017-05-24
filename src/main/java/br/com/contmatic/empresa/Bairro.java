package br.com.contmatic.empresa;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;

// TODO: Auto-generated Javadoc
/**
 * The Class Bairro.
 */
public class Bairro {

	/** The codigo. */
	private Integer codigo;

	/** The nome bairro. */
	private String nomeBairro;

	/** The cep. */
	private String cep;

	/**
	 * Gets the codigo.
	 *
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Sets the codigo.
	 *
	 * @param codigo
	 *            the new codigo
	 */
	public void setCodigo(int codigo) {
		checkArgument(codigo > 0, "Código inserido menor ou igual a 0");
		this.codigo = codigo;
	}

	/**
	 * Gets the nome bairro.
	 *
	 * @return the nome bairro
	 */
	public String getNomeBairro() {
		return nomeBairro;
	}

	/**
	 * Sets the nome bairro.
	 *
	 * @param nomeBairro
	 *            the new nome bairro
	 */
	public void setNomeBairro(String nomeBairro) {
		checkArgument(isNotEmpty(nomeBairro) && nomeBairro.length() > 3, "Nome de bairro incorreto");
		this.nomeBairro = nomeBairro;
	}

	/**
	 * Gets the cep.
	 *
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * Sets the cep.
	 *
	 * @param cep
	 *            the new cep
	 */
	public void setCep(String cep) {
		checkArgument(isNotEmpty(cep) && cep.matches(RegexCampos.CEPFORMATO), "Cep inváldo");
		this.cep = cep;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Email)) {
			return false;
		}
		Bairro other = (Bairro) obj;

		return new EqualsBuilder().append(this.codigo, other.codigo).isEquals();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.codigo).toHashCode();
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
