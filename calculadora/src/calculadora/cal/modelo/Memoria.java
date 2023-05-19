package calculadora.cal.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
	
	private enum TipoComando {
		ZERAR, NUMERO, DIV, MULT, SUB, SOMA, IGUAL, VIRGULA;
	}
	
	private final  List<MemoriaObservador> observadores = new ArrayList<>();
	
	private final static Memoria instancia = new Memoria();
	
	private  String textoAtual = "";
	
	private Memoria() {
		
	}
	
	public static Memoria getInstancia() {
		return instancia;
	}
	
	public void adicionarObservadores(MemoriaObservador observador) {
		observadores.add(observador);
	}
	
	public String getTextoAtual() {
		return textoAtual.isEmpty() ? "0" : textoAtual;
	}
	
	public  void processarComando(String valor) {
		
		TipoComando tipoComando = detectarTipoComando(valor);
		
		System.out.println(tipoComando);
		if("AC".equals(valor)) {
			textoAtual = "";
		} else {
			textoAtual += valor;
		}
		observadores.forEach(o -> o.valorAlterado(getTextoAtual()));
	}

	private TipoComando detectarTipoComando(String valor) {
		if(textoAtual.isEmpty() && valor.equals("0")) {
			return null;
		}
		
		try {
			Integer.parseInt(valor);
			return TipoComando.NUMERO;
		} catch (NumberFormatException e) {
			//Quando o valor não for um int
			if("AC".equals(valor)) {
				return TipoComando.ZERAR;
			} else if("/".equals(valor)) {
				return TipoComando.DIV;
			} else if("*".equals(valor)) {
				return TipoComando.MULT;
			} else if("-".equals(valor)) {
				return TipoComando.SUB;
			} else if("=".equals(valor)) {
				return TipoComando.IGUAL;
			} else if(",".equals(valor)) {
				return TipoComando.VIRGULA;
			} else if("+".equals(valor)) {
				return TipoComando.SOMA;
			}
		}
		
		
		return null;
	}
}
	







