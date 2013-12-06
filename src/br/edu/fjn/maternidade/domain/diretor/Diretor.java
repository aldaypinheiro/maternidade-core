package br.edu.fjn.maternidade.domain.diretor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import br.edu.fjn.maternidade.domain.EntidadeMaternidade;
import br.edu.fjn.maternidade.domain.hospital.Funcionario;
import br.edu.fjn.maternidade.domain.pessoafisica.PessoaFisica;

@Entity(name = "tb_diretor")
public class Diretor implements Funcionario,EntidadeMaternidade<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diretor_sequence")
	@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "diretor_sequence", sequenceName = "diretor_sequence")
	private Integer id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false, name = "id_pessoa_fisica")
	private PessoaFisica pessoaFisica;
	@Column(name = "id_usuario", nullable = false, unique = true)
	private Integer idUsuario;

	protected Diretor() {
		
	}
	
	public Diretor(PessoaFisica pessoaFisica, Integer idUsuario) {
		this.pessoaFisica = pessoaFisica;
		this.idUsuario = idUsuario;
	}
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	@Override
	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	@Override
	public Integer getIdUsuario() {
		return idUsuario;
	}

	@Override
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result
				+ ((pessoaFisica == null) ? 0 : pessoaFisica.hashCode());
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
		Diretor other = (Diretor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (pessoaFisica == null) {
			if (other.pessoaFisica != null)
				return false;
		} else if (!pessoaFisica.equals(other.pessoaFisica))
			return false;
		return true;
	}
	
}
