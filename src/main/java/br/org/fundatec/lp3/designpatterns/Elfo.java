package br.org.fundatec.lp3.designpatterns;

import java.util.List;

public class Elfo extends Personagem {

	@Override
	protected void inicializaPersonagem() {
		
		armasDisponiveis.add(TipoArma.ARCOEFLECHA);
		armasDisponiveis.add(TipoArma.PUNHAL);
		armasDisponiveis.add(TipoArma.PUNHALDUPLO);
		armasDisponiveis.add(TipoArma.ESPADA);
		
		armaFactory = new ArmaElfoFactory();
		
	}
	
	@Override
	public TipoPersonagem getTipoPersonagem() {
		return TipoPersonagem.ELFO;
	}

	@Override
	public List<TipoArma> tiposDeArmaDisponiveis() {
		return armasDisponiveis;
	}

}
