package br.org.fundatec.lp3.designpatterns.arma;

import br.org.fundatec.lp3.designpatterns.TipoArma;

public class ArcoEFlecha implements Arma {

	@Override
	public TipoArma getTipoArma() {
		return TipoArma.ARCOEFLECHA;
	}

	@Override
	public Integer getDano() {
		return 10;
	}

	public String toString() {
		return "Arco e Flecha";
	}

}
