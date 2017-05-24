package br.com.contmatic.empresa;

import static br.com.contmatic.empresa.TelefoneType.CELULAR;
import static br.com.contmatic.empresa.TelefoneType.FIXO;
import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Telefone {

	private Integer ddd;
	private String numero;
	private TelefoneType tipo;

	public Telefone() {
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer dd) {
		checkArgument(dd > 10 && dd < 100, "DDD valor incorreto");
		this.ddd = dd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		checkArgument(isNotEmpty(numero), "Número nulo ou vazio");
		checkArgument(numero.length() == CELULAR.getTamanho() || numero.length() == FIXO.getTamanho(),
				"Número digitos inválido");
		checkArgument(numero.matches(RegexCampos.TELEFONEFORMATO), "Campo só deve conter números");
		this.numero = numero;
	}

	public TelefoneType getTipo() {
		return tipo;
	}

	public void setTipo(TelefoneType tipo) {
		checkArgument(tipo.equals(CELULAR) || tipo.equals(FIXO), "Tipo incorreto");
		this.tipo = tipo;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Telefone)) {
			return false;
		}
		Telefone other = (Telefone) obj;

		return new EqualsBuilder().append(this.ddd, other.ddd).append(this.numero, other.numero)
				.append(this.tipo, other.tipo).isEquals();

	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.ddd).append(this.numero).append(this.tipo).toHashCode();
	}

	@Override
	public String toString() {
		new MultilineRecursiveToStringStyle();
		return ToStringBuilder.reflectionToString(this, MultilineRecursiveToStringStyle.SHORT_PREFIX_STYLE);

	}
}
