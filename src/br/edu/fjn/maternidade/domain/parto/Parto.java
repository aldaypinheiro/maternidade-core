package br.edu.fjn.maternidade.domain.parto;

import java.util.Calendar;
import java.util.Date;

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
import br.edu.fjn.maternidade.domain.equipemedica.EquipeMedica;

@Entity(name = "tb_parto")
public class Parto implements EntidadeMaternidade<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parto_sequence")
	@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "parto_sequence", sequenceName = "parto_sequence")
	private Integer id;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_parto")
	private Calendar data;
	@Temporal(TemporalType.TIME)
	@Column(name = "hora_parto")
	private Date hora;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false, name = "id_equipe_medica")
	private EquipeMedica equipeMedica;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tipo_parto")
	private TipoParto tipoParto;
	
	protected Parto() {
		
	}
	
	public Parto(Calendar data, Date hora, EquipeMedica equipeMedica, TipoParto tipoParto) {
		this.data = data;
		this.hora = hora;
		this.equipeMedica = equipeMedica;
		this.tipoParto = tipoParto;
	}
	
	@Override
	public Integer getId() {
		return id;
	}
	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public EquipeMedica getEquipeMedica() {
		return equipeMedica;
	}

	public void setEquipeMedica(EquipeMedica equipeMedica) {
		this.equipeMedica = equipeMedica;
	}

	public TipoParto getTipoParto() {
		return tipoParto;
	}

	public void setTipoParto(TipoParto tipoParto) {
		this.tipoParto = tipoParto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((equipeMedica == null) ? 0 : equipeMedica.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((tipoParto == null) ? 0 : tipoParto.hashCode());
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
		Parto other = (Parto) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (equipeMedica == null) {
			if (other.equipeMedica != null)
				return false;
		} else if (!equipeMedica.equals(other.equipeMedica))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tipoParto != other.tipoParto)
			return false;
		return true;
	}
	
}
