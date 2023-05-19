package fp.test;

import java.time.LocalDate;
import java.util.List;

import fp.cartas.*;
import fp.common.NombreDefensaAtaque;
import fp.factoria.FactoriaCartasYugiho;
import fp.utiles.valores;
import fp.yugiho.CartasYugiho;

public class TestCartas {
	public static void main(String[] args) {
		List<CartasYugiho> cartas= FactoriaCartasYugiho.FactoriaCartas.leeCartas("./data/Yu-Gi-Oh-Normal_MonstersCSVTipoLista2.csv");
		Cartas e1=new Cartas("juan",20,10);
		Cartas e2=new Cartas(cartas,"paco",40,10);
		
			System.out.println("To Strings");
			System.out.println(e1.toString());
			System.out.println(e2.toString());
			System.out.println("Get para e2");
			System.out.println(e2.getPorcentajeHumanosPorNivel(100));
			System.out.println(e2.getNumeroCartas());
			System.out.println(e2.getPromedioNivelDeCartas());
			System.out.println(e2.getCartasConAtaqueN(1));
			System.out.println(e2.getCartasConMejorAtaque(1));
			System.out.println(e2.filtraSubtipos("water"));
			for (CartasYugiho c: cartas) {
			System.out.println(e2.getTotalDefensaAtaque(c.getAttack() > 0 ));
			}
			System.out.println(e2.mediaAtaque());
			//System.out.println(contarCartasHumanasPorAtaqueYDefensa(100,100));
			System.out.println(cartas);
			
			

		}
		
		
		
		
		
	}


