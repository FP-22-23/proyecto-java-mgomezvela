package fp.test;

import java.time.LocalDate;

import fp.cartas.*;
import fp.common.NombreDefensaAtaque;
import fp.utiles.valores;
import fp.yugiho.CartasYugiho;

public class TestCartasYugiho {
	public static void main(String[] args) {
		//creo un tipo carta generico para hacer el testeo del primero constructor
		CartasYugiho CY=new CartasYugiho("Name","Attributes","Subtypes",1,2,3,false,LocalDate.of(1987,12,19),valores.juan,new NombreDefensaAtaque("Name",2,3));
		System.out.println(CY.toString());
		CY.getAttack();
		CY.Rating();
		CY.NombreAtaque();
		CY.getProductoAtaqueyDefensa();
		CY.setName("New Name");
		CY.setAttack(4);
		System.out.println(CY.toString());
		//uso del segundo constructor
		CartasYugiho CY2=new CartasYugiho("Name",1,2,3);
		System.out.println(CY2.toString());
		CartasYugiho CY3=new CartasYugiho("Acrobat Monkey",3,1000,1800);
		System.out.println(CY3.equals(CY2));

		//System.out.println(getCartasConMejorAtaque());
	}

}
