package fp.cartas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.utiles.Checkers;
import fp.yugiho.CartasYugiho;

public class Cartas {
	
	private List<CartasYugiho> card;
	private String Name;
	private Integer Defense;
	private Integer Attack;
		
	
	public Cartas(String Name,Integer Defense,Integer Attack) {
		//this.card= new ArrayList<CartasYugiho>();
		this.Name=Name;
		this.Defense=Defense;
		this.Attack=Attack;
		
	}
	
	public Cartas(List<CartasYugiho> card ,String Name,Integer Defense,Integer Attack) {
		this.card= card;
		this.Name=Name;
		this.Defense=Defense;
		this.Attack=Attack;
		Checkers.check("ataque y defensa por debajo de 10000",Defense<10000 && Attack < 10000  );
	}
	public Cartas(Collection<CartasYugiho> card){
		this.card= new ArrayList<CartasYugiho>(card);
}
	
	public Cartas(Stream<CartasYugiho> card) {
		this.card= card.collect(Collectors.toList());	
	}
	
	public Integer getNumeroCartas() {
		return card.size();
	}
	public void agregarCarta(CartasYugiho c) {
		card.add(c);	
	}
	public void eliminarCarta(CartasYugiho c) {
		card.remove(c);
	}
	public void añadircoleccion(Collection<CartasYugiho> c) {
		card.addAll(c);
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(card);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cartas other = (Cartas) obj;
		return Objects.equals(card, other.card);
	}

	public Double getPromedioNivelDeCartas() {
	//PROMEDIO DE CARTAS QUE TIENEN NIVEL MAYOR QUE DOS
		Double res = 0.0;
		Double suma =0.0;
		Integer cont = 0;
		for ( CartasYugiho c : card) {
			if (c.getLevel() > 0) {
				suma+= c.getLevel(); 
				cont++;
			}else {
					cont++;
				}
			}
		if (cont>0) {
			res = suma/cont;	
		}
		return res;
	}

	//funcion con existe / para todo.
	public String getCartasConDefensaN(Integer n){
		String res = "";
		//Integer cont= 0;
		for (CartasYugiho c : card) {
			Integer Defensa = c.getDefense();
			if(Defensa.equals(n)) {
				res = c.getName() ; //+ cont.toString()
			}
			else {
				res = "no hay carta cuya defensa sea N";
			}
		}
		return res;
	}
		
		public String getCartasConAtaqueN(Integer n){
			String res = "";
			//Integer cont= 0;
			for (CartasYugiho c : card) {
				Integer Ataque = c.getAttack();
				if(Ataque.equals(n)) {
					res = c.getName() ; //+ cont.toString()
				}
				else {
					res = "no hay carta cuyo ataque sea N";
				}
			}
			return res;
		
	}
	
	public Boolean existeCartaConAtaque(Integer ataque) {
    	Boolean res=false;
    	for (CartasYugiho c: card) {
    		if (c.getAttack().equals(ataque))
    			res=true;
    	}
    	return res;
    }
	
	public Boolean existeCartaConDefensa(Integer defensa) {
    	Boolean res=false;
    	for (CartasYugiho c: card) {
    		if (c.getDefense().equals(defensa))
    			res=true;
    	}
    	return res;
    }
	
	public Boolean existeCartaConSubtipo(String patata) {
    	Boolean res=false;
    	for (CartasYugiho c: card) {
    		if (c.getAttributes().equals(patata))
    			res=true;
    	}
    	return res;
    }
	
	// funcion con contador y suma 
	
	public boolean True() {
		return true;
	}
	
	public String getPorcentajeHumanosPorNivel(Integer Level) {
		Long cuenta = 0L;
		Double res = 0.0;
		String msj = "";
		String sol="";
		
		for (CartasYugiho c : card) {
			if (c.getEsHumano().equals(True()) && c.getLevel().equals(Level)) {
				cuenta++;
			}
		}
		if (cuenta>0) {
			res = 100.* cuenta/getNumeroCartas();
			sol= res.toString();
		} else {
			msj = "no hay cartas humanas";
			sol = msj;
		}
		return sol;
	}
	
	@Override
	public String toString() {
		return "Cartas [card=" + card + ", Name=" + Name + ", Defense=" + Defense + ", Attack=" + Attack + "]";
	}

	public Double mediaAtaque(){
    	Double res=0.0;
    	for (CartasYugiho e: card) {
    		res=res+e.getAttack();
}
    	return res/card.size();
    }
	
	public Double mediaDefensa(){
    	Double res=0.0;
    	for (CartasYugiho e: card) {
    		res=res+e.getDefense();
}
    	return res/card.size();
    }
	
	//filtrado 
	
//public List<String> getNMejoresCartasPorNivel(Integer Level , Integer n){ 
	//		
	//Predicate<CartasYugiho> filtro = c->c.getLevel() == Level && c.getLevel()!= null;
	//Map<String, Integer> da = getTotalDefensaAtaque(filtro);
	////Comparator<String> c = Comparator.comparing(carta->da.get(carta));
	//List<String> cartas = new ArrayList<String>(da.keySet());
	//Collections.sort(cartas, c);
	//return new ArrayList<String>(cartas.subList(0, n));		
		
		
	//}

public List<String> filtraSubtipos(String x){
	List<String> res=new ArrayList<String>();
	for (CartasYugiho e: card) {
		if (e.getSubTypes().equals(x))
			res.add(x);
	}
	return res;
}
		
	
		
	/**
	 * @param filtro Predicado para filtrar las partidas que se van a contar
	 * @return Un Map que asocia los ids de los usuarios con el número de victorias
	 * que tras filtrar con el predicado dado como parámetro
	 */
	public Map<String, Integer> getTotalDefensaAtaque(Boolean filtro) {
		Map<String, Integer> res = new HashMap<String,Integer>();
		boolean aux = true;
		for (CartasYugiho c: card) {
			if (filtro = aux)
					 {
				String clave = c.getName();
				if (res.containsKey(clave)) {
					res.put(clave, c.getAttack()+c.getDefense());
				}else {
					res.put(clave, c.getAttack()+c.getDefense());
				}
			}
		}
		return res;		
	}
	//Un método de agrupación que devuelva un Map en el que las claves sean una propiedad del 
	//tipo base, y los valores una colección (List, Set, SortedSet) de objetos del tipo base.
	
	public Map<Integer, List<String>> getCartasPorNivel(Integer Level){ 
		Predicate<CartasYugiho> filtro = c->c.getLevel() < 0 && c.getLevel()!= null;
		Map<Integer, List<String>> CartasPorNivel = new HashMap<Integer,List<String>>();
		for(CartasYugiho c: card) {
			if(filtro.test(c)
					) {
				Integer clave = Level;
				if(CartasPorNivel.containsKey(clave)) { 
					CartasPorNivel.put(Level,aux(Level));
				}else {
					CartasPorNivel.put(Level, null);
	
				}
					
		}}
		return CartasPorNivel;
	}
		public List<String> aux(Integer Level) {	
			List<String> cartas = new ArrayList<>();
			for (CartasYugiho x : card) {
				if(x.getLevel() == Level ) {
					cartas.add(x.getName());
				}else {
						cartas.add("no hay cartas de este nivel");

					}
				
				}
			return cartas;
			}
	

	// funcion con Un método de acumulación que devuelva un Map en el que las claves sean 
	//una propiedad del tipo base, y los valores el conteo o la suma de los objetos del tipo 
	//base almacenados en el contenedor que tienen como valor esa propiedad
	
public Map<String, Integer> getCartasConMejorAtaque(Integer Attack){
			Integer contador= 0;
			Predicate<CartasYugiho> filtro = c->c.getAttack() > Attack && c.getAttack()!= 0;
			Map<String,Integer> CartasMejorAtaque = new HashMap<String, Integer>();
			for(CartasYugiho c : card) {
				if(filtro.test(c)) {
					contador++;
					String clave = c.getName();
					if(CartasMejorAtaque.containsKey(clave)) {
						CartasMejorAtaque.put(clave, contador);
					}else {
						CartasMejorAtaque.put(clave, 1);
					}
				}
			}
			return CartasMejorAtaque;
		}
		
public Double getPromedioDefensaPorAtaque(Integer a) {
	return card.stream().filter(p -> p.getAttack().equals(a))
			.mapToInt(p -> p.getDefense()/getNumeroCartas())
			.average()
			.orElse(0);
	
}

//public Map<Object, Long> contarCartasHumanasPorAtaqueYDefensa(Integer def, Integer ataq) {
	//Predicate<CartasYugiho> filtro = p -> p.getAttack().equals(ataq) 
		//	   && p.getDefense().equals(def) && p.getEsHumano().equals(ataq);
	//return card.stream()
		//	.filter(filtro)
			//.collect(Collectors.groupingBy(p -> p.getAttack().equals(ataq) && p.getDefense().equals(def), 
				//							Collectors.counting()));
//}









}
	
	

	
	
	
