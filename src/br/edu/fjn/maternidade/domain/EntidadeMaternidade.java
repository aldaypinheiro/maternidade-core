package br.edu.fjn.maternidade.domain;

import java.io.Serializable;

public interface EntidadeMaternidade<T> extends Serializable {

	T getId();

	void setId(T id);

}
