package br.org.fundatec.lp3.designpatterns.arma;

import br.org.fundatec.lp3.designpatterns.TipoArma;

public class EspadaElfo implements Arma {

	@Override
	public TipoArma getTipoArma() {
		return TipoArma.ESPADA;
	}

	@Override
	public Integer getDano() {
		return 25;
	}

	public String toString() {
		return "Espada Elfo";
	}

}
