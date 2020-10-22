package br.org.fundatec.lp3.designpatterns.factory;
import br.org.fundatec.lp3.designpatterns.Elfo;
import br.org.fundatec.lp3.designpatterns.Jogo;
import br.org.fundatec.lp3.designpatterns.Orc;
import br.org.fundatec.lp3.designpatterns.Personagem;
import br.org.fundatec.lp3.designpatterns.arma.ArcoEFlecha;
import br.org.fundatec.lp3.designpatterns.arma.Arma;
import br.org.fundatec.lp3.designpatterns.arma.EspadaElfo;
import br.org.fundatec.lp3.designpatterns.arma.EspadaOrc;
import br.org.fundatec.lp3.designpatterns.arma.Machado;
import br.org.fundatec.lp3.designpatterns.arma.Martelo;
import br.org.fundatec.lp3.designpatterns.arma.PunhalDuplo;
import br.org.fundatec.lp3.designpatterns.arma.PunhalElfo;
import br.org.fundatec.lp3.designpatterns.arma.PunhalOrc;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class AppTest 
{
	
	private static List<Personagem> todosOsElfosPossiveis;
	private static List<Personagem> todosOsOrcsPossiveis;
	
	@BeforeClass
	public static void init() {
		todosOsElfosPossiveis = montaTodosOsElfos();	    
	    todosOsOrcsPossiveis = montaTodosOsOrcs();
	}

    @Test
    public void testeElfoContraOrc()
    {
	    testaPersonagens(todosOsElfosPossiveis, todosOsOrcsPossiveis);
    }
    
    @Test
    public void testeOrcContraElfo() {
	    testaPersonagens(todosOsOrcsPossiveis, todosOsElfosPossiveis);
    }
    
    @Test
    public void testeElfoContraElfo() {
	    testaPersonagens(todosOsElfosPossiveis, todosOsElfosPossiveis);
    }
    
    @Test
    public void testeOrcContraOrc() {
	    testaPersonagens(todosOsOrcsPossiveis, todosOsOrcsPossiveis);
    }
    
    public void testaPersonagens(List<Personagem> todosOsPersonagens1Possiveis, List<Personagem> todosOsPersonagens2Possiveis) {
    	
    	Jogo jogo = new Jogo();
	    
	    for(Personagem personagem1 : todosOsPersonagens1Possiveis) {
	    	
	    	for(Personagem personagem2 : todosOsPersonagens2Possiveis) {
	    		
	    		String resultado = jogo.executar(personagem1, personagem2);
	    		
	    		Personagem vencedor;
	    		Personagem perdedor;
	    		
	    		if(personagem1.getVida() > 0) {
	    			vencedor = personagem1;
	    			perdedor = personagem2;
	    		} else {
	    			vencedor = personagem2;
	    			perdedor = personagem1;
	    		}
	    					
	    		String resultadoEsperado = vencedor.getTipoPersonagem().name() + " venceu!";
	    		
	    		assertEquals(0, perdedor.getVida());
	    		assertEquals(resultadoEsperado, resultado);
	    		
	    	}
	    	
	    }
    	
    }
    
	private static List<Personagem> montaTodosOsOrcs() {
		
		List<Arma> armasOrc = new ArrayList<>();
		
	    armasOrc.add(new Machado());
	    armasOrc.add(new Martelo());
	    armasOrc.add(new PunhalOrc());
	    armasOrc.add(new EspadaOrc());
	    
    	List<Personagem> todosOsOrcsPossiveis = new ArrayList<>();
    	
    	for(Arma primeiraArma : armasOrc) {

    		for(Arma segundaArma : armasOrc) {
    		
    			Orc orc = new Orc();
    			orc.setPrimeiraArma(primeiraArma);
    			orc.setSegundaArma(segundaArma);
    			todosOsOrcsPossiveis.add(orc);

    		}
	    	
    	}
		return todosOsOrcsPossiveis;
	}
    
    private static List<Personagem> montaTodosOsElfos() {
    	
    	List<Arma> armasElfo = new ArrayList<>();
    	armasElfo.add(new ArcoEFlecha());
    	armasElfo.add(new EspadaElfo());
    	armasElfo.add(new PunhalElfo());
    	armasElfo.add(new PunhalDuplo());
    	
    	List<Personagem> todosOsElfosPossiveis = new ArrayList<>();
    	
    	for(Arma primeiraArma : armasElfo) {

    		for(Arma segundaArma : armasElfo) {
    		
    			Elfo elfo = new Elfo();
    			elfo.setPrimeiraArma(primeiraArma);
    			elfo.setSegundaArma(segundaArma);
    			todosOsElfosPossiveis.add(elfo);

    		}
	    	
    	}
    	
    	return todosOsElfosPossiveis;
    	
    }
}
