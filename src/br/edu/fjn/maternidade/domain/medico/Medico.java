package br.edu.fjn.maternidade.domain.medico;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import br.edu.fjn.maternidade.domain.EntidadeMaternidade;
import br.edu.fjn.maternidade.domain.especialidade.Especialidade;
import br.edu.fjn.maternidade.domain.pessoafisica.PessoaFisica;

@Entity(name = "tb_medico")
public class Medico implements EntidadeMaternidade<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medico_sequence")
	@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "medico_sequence", sequenceName = "medico_sequence")
	private Integer id;
	private String crm;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false, name = "id_pessoa_fisica")
	private PessoaFisica pessoaFisica;
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Especialidade> especialidades = new HashSet<Especialidade>();
	
	protected Medico() {
		
	}
	
	public Medico(String crm, PessoaFisica pessoaFisica) {
		this.crm = crm;
		this.pessoaFisica = pessoaFisica;
	}
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public Set<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Set<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}
	
	public void adicionaEspecialidade(Especialidade especialidade) {
		this.especialidades.add(especialidade);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crm == null) ? 0 : crm.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Medico other = (Medico) obj;
		if (crm == null) {
			if (other.crm != null)
				return false;
		} else if (!crm.equals(other.crm))
			return false;
		if (especialidades == null) {
			if (other.especialidades != null)
				return false;
		} else if (!especialidades.equals(other.especialidades))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pessoaFisica == null) {
			if (other.pessoaFisica != null)
				return false;
		} else if (!pessoaFisica.equals(other.pessoaFisica))
			return false;
		return true;
	}

}
