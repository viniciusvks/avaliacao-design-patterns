package br.org.fundatec.lp3.designpatterns;

public enum TipoPersonagem {

	ELFO(1, new Elfo()),
	ORC(2, new Orc());

	private int opcao;
	private Personagem personagem;

	TipoPersonagem(int opcao, Personagem personagem) {
		this.opcao = opcao;
		this.personagem = personagem;
	}

	public int getOpcao() {
		return this.opcao;
	}
	
	public Personagem getPersonagem() {
		return personagem;
	}
	
	public static Personagem comOpcao(int opcao) {
		
		TipoPersonagem[] personagens = values();
		
		for(TipoPersonagem tipoPersonagem : personagens) {
		
			if(tipoPersonagem.getOpcao() == opcao) {
				return tipoPersonagem.getPersonagem();
			}
			
		}
		
		return null;
		
	}

}
