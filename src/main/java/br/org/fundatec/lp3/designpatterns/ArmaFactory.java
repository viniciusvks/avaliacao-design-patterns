package br.org.fundatec.lp3.designpatterns;

import br.org.fundatec.lp3.designpatterns.arma.Arma;

public interface ArmaFactory {

	public Arma criarArma(TipoArma tipoArma);
	
}
