package br.com.contmatic.empresa;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class Email.
 */
public class Email {

	/** The endereco email. */
	private String enderecoEmail;

	/**
	 * Gets the endereco email.
	 *
	 * @return the endereco email
	 */
	public String getEnderecoEmail() {
		return enderecoEmail;
	}

	/**
	 * Sets the endereco email.
	 *
	 * @param enderecoEmail
	 *            the new endereco email
	 */
	public void setEnderecoEmail(String enderecoEmail) {
		checkArgument(isNotEmpty(enderecoEmail));
		int contArroba = 0;
		for (int i = 0; i < enderecoEmail.length(); i++) {
			if (enderecoEmail.charAt(i) == '@') {
				contArroba++;
			}
		}
		checkArgument(contArroba == 1, "Email contém mais de 1 arroba ");
		checkArgument(enderecoEmail.matches(RegexCampos.EMAILFORMATO),
				"Email não pode começar ou terminar com @ ou ponto");
		this.enderecoEmail = enderecoEmail;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.enderecoEmail).toHashCode();
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
		Email other = (Email) obj;

		return new EqualsBuilder().append(this.enderecoEmail, other.enderecoEmail).isEquals();

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