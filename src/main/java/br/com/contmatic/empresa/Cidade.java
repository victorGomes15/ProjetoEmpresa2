package br.com.contmatic.empresa;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class Cidade.
 */
public class Cidade {

	/** The codigo. */
	private Integer codigo;

	/** The nome. */
	private String nome;

	/** The bairro. */
	private Bairro bairro;

	/**
	 * Instantiates a new cidade.
	 */
	public Cidade() {
	}

	/**
	 * Gets the codigo.
	 *
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * Sets the codigo.
	 *
	 * @param codigo
	 *            the new codigo
	 */
	public void setCodigo(Integer codigo) {
		checkArgument(codigo > 0, "Código deve ser maior que 0");
		this.codigo = codigo;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome
	 *            the new nome
	 */
	public void setNome(String nome) {
		checkArgument(isNotEmpty(nome) && nome.length() > 2, "Nome da cidade invalido");
		this.nome = nome;
	}

	/**
	 * Gets the bairro.
	 *
	 * @return the bairro
	 */
	public Bairro getBairro() {
		return this.bairro;
	}

	/**
	 * Sets the bairro.
	 *
	 * @param bairro
	 *            the new bairro
	 */
	public void setBairro(Bairro bairro) {
		checkArgument(bairro != null, "Bairro nulo");
		checkArgument(!bairro.getNomeBairro().equals(null) && bairro.getCodigo() > 0,
				"Nome do bairro ou código invalido");
		this.bairro = bairro;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Cidade)) {
			return false;
		}
		Cidade other = (Cidade) obj;

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
