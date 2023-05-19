package fp.test;

import java.time.LocalDate;

import java.util.List;
import fp.carta.*;
import fp.cartas.*;
import fp.common.NombreDefensaAtaque;
import fp.factoria.FactoriaCartasYugiho;
import fp.utiles.valores;
import fp.yugiho.CartasYugiho;

public class TestCarta {
	public static void main(String[] args) {
		List<CartasYugiho> carta= FactoriaCartasYugiho.FactoriaCartas.leeCartas("./data/Yu-Gi-Oh-Normal_MonstersCSVTipoLista2.csv");
		Cartas cartita = FactoriaCartasYugiho.FactoriaCartas.leerCarta("./data/Yu-Gi-Oh-Normal_MonstersCSVTipoLista2.csv");
		Carta e1=new Carta("juan",20,10);
		Carta e2=new Carta(carta,"paco",40,10);
		
		System.out.println(cartita);
		System.out.println("AAAAAAAAAAAAAAAA");
		
		System.out.println(e2.existeCartaConSubtipo("Water"));
		System.out.println(e2.existeCartaConAtaque(1000));
		System.out.println(e2.NumeroCartasMismoNivel(2));
		System.out.println(e2.CartasFiltradasPorNivelyDefensa(3,1800));
		System.out.println(e2.filtradoAtaqueMaximo("Acrobat Monkey"));
		System.out.println(e2.CartaPorNivelOrdenando(3));
		System.out.println(e2.CartaPorAtributo("Water"));
		System.out.println(e2.CartaPorNivelMaximoAtaque(2));
		System.out.println(e2.masAtaqueSegunNivel(3));
		System.out.println(e2.DefensaMasAltaPorAtributo());
		System.out.println(e2.getPromedioDefensaPorAtaque(1000));
		System.out.println(e2.existeCartaConAtaque(1000));
		System.out.println(e2.AverageDefensaPorTipo("Water"));
		System.out.println(e2.SumaAtaquesPorTipo("Water"));
		
		
		
												
		
				
		
		
		
			
			

		}
		
		
		
		
		
	}


