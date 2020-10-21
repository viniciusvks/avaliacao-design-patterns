package br.org.fundatec.lp3.designpatterns;

import br.org.fundatec.lp3.designpatterns.arma.Arma;
import br.org.fundatec.lp3.designpatterns.arma.EspadaOrc;
import br.org.fundatec.lp3.designpatterns.arma.Machado;
import br.org.fundatec.lp3.designpatterns.arma.Martelo;
import br.org.fundatec.lp3.designpatterns.arma.PunhalOrc;

public class ArmaOrcFactory implements ArmaFactory {

	@Override
	public Arma criarArma(TipoArma tipoArma) {
		
		switch(tipoArma) {
		
			case MACHADO:
				return new Machado();
			case MARTELO:
				return new Martelo();
			case PUNHAL:
				return new PunhalOrc();
			case ESPADA:
				return new EspadaOrc();
			default:
				return null;
		
		}
		
	}

}
