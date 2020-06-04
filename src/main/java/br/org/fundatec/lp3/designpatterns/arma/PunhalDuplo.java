package br.org.fundatec.lp3.designpatterns.arma;

import br.org.fundatec.lp3.designpatterns.TipoArma;

public class PunhalDuplo implements Arma {

	@Override
	public TipoArma getTipoArma() {
		return TipoArma.PUNHALDUPLO;
	}

	@Override
	public Integer getDano() {
		return 25;
	}

	public String toString() {
		return "Punhal Duplo";
	}

}
