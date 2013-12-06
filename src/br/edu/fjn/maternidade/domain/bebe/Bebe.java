package br.edu.fjn.maternidade.domain.bebe;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.fjn.maternidade.domain.EntidadeMaternidade;
import br.edu.fjn.maternidade.domain.parto.Parto;
import br.edu.fjn.maternidade.domain.pessoafisica.PessoaFisica;
import br.edu.fjn.maternidade.domain.pessoafisica.Sexo;

@Entity(name = "tb_bebe")
public class Bebe implements EntidadeMaternidade<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bebe_sequence")
	@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "bebe_sequence", sequenceName = "bebe_sequence")
	private Integer id;
	@Column(nullable = false)
	private String nome;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Calendar nascimento;
	@Column(nullable = false)
	private Double peso;
	@Column(nullable = false)
	private Integer altura;
	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private Sexo sexo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false, name = "id_parto")
	private Parto parto;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false, name = "id_genitor_1")
	private PessoaFisica genitor1;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_genitor_2")
	private PessoaFisica genitor2;

	protected Bebe() {

	}

	public Bebe(String nome, Calendar nascimento, Double peso, Integer altura,
			Sexo sexo, Parto parto, PessoaFisica genitor) {
		this.nome = nome;
		this.nascimento = nascimento;
		this.peso = peso;
		this.altura = altura;
		this.sexo = sexo;
		this.parto = parto;
		this.genitor1 = genitor;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Parto getParto() {
		return parto;
	}

	public void setParto(Parto parto) {
		this.parto = parto;
	}

	public PessoaFisica getGenitor1() {
		return genitor1;
	}

	public void setGenitor1(PessoaFisica genitor1) {
		this.genitor1 = genitor1;
	}

	public PessoaFisica getGenitor2() {
		return genitor2;
	}

	public void setGenitor2(PessoaFisica genitor2) {
		this.genitor2 = genitor2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((altura == null) ? 0 : altura.hashCode());
		result = prime * result
				+ ((genitor1 == null) ? 0 : genitor1.hashCode());
		result = prime * result
				+ ((genitor2 == null) ? 0 : genitor2.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((nascimento == null) ? 0 : nascimento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((parto == null) ? 0 : parto.hashCode());
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bebe other = (Bebe) obj;
		if (altura == null) {
			if (other.altura != null)
				return false;
		} else if (!altura.equals(other.altura))
			return false;
		if (genitor1 == null) {
			if (other.genitor1 != null)
				return false;
		} else if (!genitor1.equals(other.genitor1))
			return false;
		if (genitor2 == null) {
			if (other.genitor2 != null)
				return false;
		} else if (!genitor2.equals(other.genitor2))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nascimento == null) {
			if (other.nascimento != null)
				return false;
		} else if (!nascimento.equals(other.nascimento))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (parto == null) {
			if (other.parto != null)
				return false;
		} else if (!parto.equals(other.parto))
			return false;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		if (sexo != other.sexo)
			return false;
		return true;
	}

}
