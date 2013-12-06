package br.edu.fjn.maternidade.domain.equipemedica;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import br.edu.fjn.maternidade.domain.EntidadeMaternidade;
import br.edu.fjn.maternidade.domain.enfermeiro.Enfermeiro;
import br.edu.fjn.maternidade.domain.medico.Medico;

@Entity(name = "tb_equipe_medica")
public class EquipeMedica implements EntidadeMaternidade<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipemedica_sequence")
	@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "equipemedica_sequence", sequenceName = "equipemedica_sequence")
	private Integer id;
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Enfermeiro> enfermeiros = new HashSet<Enfermeiro>(2);
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Medico> medicos = new HashSet<Medico>(3);

	protected EquipeMedica() {

	}

	public EquipeMedica(Set<Enfermeiro> enfermeiros, Set<Medico> medicos) {
		this.enfermeiros = enfermeiros;
		this.medicos = medicos;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Enfermeiro> getEnfermeiros() {
		return enfermeiros;
	}

	public void setEnfermeiros(Set<Enfermeiro> enfermeiros) {
		this.enfermeiros = enfermeiros;
	}

	public Set<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(Set<Medico> medicos) {
		this.medicos = medicos;
	}

	public void adicionaEnfermeiro(Enfermeiro enfermeiro) {
		this.enfermeiros.add(enfermeiro);
	}

	public void adicionaMedico(Medico medico) {
		this.medicos.add(medico);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((enfermeiros == null) ? 0 : enfermeiros.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((medicos == null) ? 0 : medicos.hashCode());
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
		EquipeMedica other = (EquipeMedica) obj;
		if (enfermeiros == null) {
			if (other.enfermeiros != null)
				return false;
		} else if (!enfermeiros.equals(other.enfermeiros))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (medicos == null) {
			if (other.medicos != null)
				return false;
		} else if (!medicos.equals(other.medicos))
			return false;
		return true;
	}

}
