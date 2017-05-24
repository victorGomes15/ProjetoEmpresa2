package br.com.contmatic.empresa;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class Endereco.
 *
 * @author victor.silva
 */
public class Endereco {

	/** The rua. */
	private String rua;

	/** The numero. */
	private Integer numero;

	/** The complemento. */
	private Integer complemento;

	/** The estado. */
	private Estado estado;

	/** The tipo endereco. */
	private EnderecoType tipoEndereco;

	/**
	 * Gets the rua.
	 *
	 * @return the rua
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * Sets the rua.
	 *
	 * @param rua
	 *            the new rua
	 */
	public void setRua(String rua) {
		checkArgument(isNotEmpty(rua) && rua.length() >= 4, "Rua não pode ser vazia e maior que 3 caracteres");
		checkArgument(rua.matches(RegexCampos.RUAFORMATO), "Rua não pode conter caracteres especiais");
		this.rua = rua;
	}

	/**
	 * Gets the numero.
	 *
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * Sets the numero.
	 *
	 * @param numero
	 *            the new numero
	 */
	public void setNumero(Integer numero) {
		checkArgument(numero > 0, "Número deve ser maior que 0");
		this.numero = numero;
	}

	/**
	 * Gets the tipo endereco.
	 *
	 * @return the tipo endereco
	 */
	public EnderecoType getTipoEndereco() {
		return tipoEndereco;
	}

	/**
	 * Sets the tipo endereco.
	 *
	 * @param tipoEndereco
	 *            the new tipo endereco
	 */
	public void setTipoEndereco(EnderecoType tipoEndereco) {
		checkArgument(tipoEndereco.equals(EnderecoType.COMERCIAL.getDescricao())
				|| tipoEndereco.equals(EnderecoType.FISCAL.getDescricao()), "Tipo incorreto");
		this.tipoEndereco = tipoEndereco;
	}

	/**
	 * Gets the complemento.
	 *
	 * @return the complemento
	 */
	public Integer getComplemento() {
		return complemento;
	}

	/**
	 * Sets the complemento.
	 *
	 * @param complemento
	 *            the new complemento
	 */
	public void setComplemento(Integer complemento) {
		checkArgument(complemento >= 0, "Complemento não pode ser menor que 0");
		this.complemento = complemento;
	}

	/**
	 * Gets the estado.
	 *
	 * @return the estado
	 */
	public Estado getEstado() {
		return estado;
	}

	/**
	 * Sets the estado.
	 *
	 * @param estado
	 *            the new estado
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.rua).append(this.numero).append(this.estado).append(this.complemento)
				.hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Endereco)) {
			return false;
		}
		Endereco other = (Endereco) obj;

		return new EqualsBuilder().append(this.rua, other.rua).append(this.numero, other.numero)
				.append(this.complemento, this.complemento).append(this.estado, other.estado).isEquals();
	}

}
