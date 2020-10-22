package br.org.fundatec.lp3.designpatterns;

import java.util.List;

public class Orc extends Personagem {
	
	@Override
	protected void inicializaPersonagem() {
		
		armasDisponiveis.add(TipoArma.MACHADO);
		armasDisponiveis.add(TipoArma.MARTELO);
		armasDisponiveis.add(TipoArma.PUNHAL);
		armasDisponiveis.add(TipoArma.ESPADA);
		
		armaFactory = new ArmaOrcFactory();
		
	}

	@Override
	public TipoPersonagem getTipoPersonagem() {
		return TipoPersonagem.ORC;
	}

	@Override
	public List<TipoArma> tiposDeArmaDisponiveis() {
		return armasDisponiveis;
	}

}
