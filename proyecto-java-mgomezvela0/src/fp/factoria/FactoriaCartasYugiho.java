package fp.factoria;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;



import fp.carta.Carta;
import fp.cartas.Cartas;
import fp.common.NombreDefensaAtaque;
import fp.utiles.Checkers;
import fp.utiles.Ficheros;
import fp.utiles.valores;
import fp.yugiho.CartasYugiho;

public class FactoriaCartasYugiho {
	

	
	public class FactoriaCartas {
		
		public static List<CartasYugiho> leeCartas(String fichero){
	        List<CartasYugiho> res = new ArrayList<>();
	        Checkers.checkNoNull(fichero);
	        List<String> lineas = Ficheros.leeFichero("Error lectura", fichero);
	        lineas.remove(0);
	        for(String linea:lineas) {
	            CartasYugiho c= parsearCartasYugiho(linea);
	            res.add(c);
	        }
	        return res;
	    }
		
		
	private static CartasYugiho parsearCartasYugiho(String linea) {
		String[] trozos=linea.split(";");
		
		String Name=(trozos[0].trim());
		String Attributes=(trozos[1].trim());
		String SubTypes=(trozos[2].trim()); 
		Integer Level=parseaInt(trozos[3].trim()); 
		Integer Attack=parseaInt(trozos[4].trim()); 
		Integer Defense=parseaInt(trozos[5].trim()); 
		Boolean EsHumano=parseaBooleano(trozos[11].trim());
		//LocalDate FechaCarta=parseaFecha(trozos[12].trim());
		valores valores=fp.utiles.valores.valueOf(trozos[10].trim());
		
		return new CartasYugiho(Name, Attributes , SubTypes, Level , Attack,
				Defense, EsHumano , LocalDate.of(1987,12,19) , valores ,new NombreDefensaAtaque(Name,Attack,Defense));
	}
	
	private static List<String> parsLista(String s) {
        Checkers.checkNoNull(s);
        Checkers.check("",!s.isEmpty());
    	String[] trozos = s.split(";");
    	List<String> posiciones= new LinkedList<>();
    	for (String trozo:trozos) {
    		posiciones.add(trozo);
    		}
    	return posiciones;
	}
	

	private static Boolean parseaBooleano(String cadena) {
		Boolean res = null;
		cadena = cadena.toUpperCase();
		if (cadena.equals("true")) {
			res = true;
		}else {
			res = false;
		}
		return res;
	}
	
	private static Integer parseaInt(String s) {
        Integer res = null;
        if (s!=null && !s.isEmpty()) {
            res = Integer.parseInt(s);
        }
        else {
        	String x= "10";
        	res = Integer.parseInt(x);;
        }
        return res;
        
    }
	private static LocalDate parseaFecha(String s) {
        Checkers.checkNoNull(s);
        Checkers.check("",!s.isEmpty());
        LocalDate res = LocalDate.parse(s, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return res;
    }
	public static Cartas leerCarta(String nomfich) {
		Cartas res=null;
		int i=0;
		try {
			List<CartasYugiho>  cartitas=Files.lines(Paths.get(nomfich))
					.skip(1)
					.map(FactoriaCartas::parsearCartasYugiho)
					.collect(Collectors.toList());
			
			res= new Cartas(cartitas);
			
			} catch(IOException e) {
			System.out.println("Fichero no encontrado: "+nomfich);
			e.printStackTrace();
		}
	return res;
	}
	
	
	}
	
}