package fp.carta;

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
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import fp.utiles.Checkers;
import fp.yugiho.CartasYugiho;

public class Carta {
	
	private List<CartasYugiho> card;
	private String Name;
	private Integer Defense;
	private Integer Attack;
		
	
	public Carta(String Name,Integer Defense,Integer Attack) {
		//this.card= new ArrayList<CartasYugiho>();
		this.Name=Name;
		this.Defense=Defense;
		this.Attack=Attack;
		
	}
	
	public List<CartasYugiho> getCard() {
		return card;
	}

	public void setCard(List<CartasYugiho> card) {
		this.card = card;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Integer getDefense() {
		return Defense;
	}

	public void setDefense(Integer defense) {
		Defense = defense;
	}

	public Integer getAttack() {
		return Attack;
	}

	public void setAttack(Integer attack) {
		Attack = attack;
	}

	public Carta(List<CartasYugiho> card ,String Name,Integer Defense,Integer Attack) {
		this.card= card;
		this.Name=Name;
		this.Defense=Defense;
		this.Attack=Attack;
		Checkers.check("ataque y defensa por debajo de 10000",Defense<10000 && Attack < 10000  );
	}
	
	public Carta(Stream<CartasYugiho> card) {
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
		Carta other = (Carta) obj;
		return Objects.equals(card, other.card);
	}

	
	//funcion con existe / para todo.
	public List<String> getCartasConDefensaN(Integer n){
		
		return card.stream().filter(p -> p.getDefense().equals(n)).
				map(p -> p.getName())
				.collect(Collectors.toList());
		
		//Comparator<Carta> cartas = (x,y)-> x.getAttack().compareTo(y.getAttack());
			//	Collections.sort(card,cartas);
	}
		
		
		//public Map<List<String>, Long> getCartasConAtaqueN(Integer n){
			//Predicate<CartasYugiho> pred = p-> p.getAttack().equals(n);
			//return card.stream().filter(pred).collect(Collectors.groupingBy(card::getName,Collectors.collectingAndThen(Collectors.toList(), lista -> seleccionaMejorCarta)));
				
				
				
			
		
		public String seleccionaMejorCarta(Integer n) {
			return card.stream().sorted(Comparator.comparing(x -> x.getAttack()))
			.map(x -> x.getName())
			.findFirst()
			.get();
		}
			
		//A escoger uno de los dos siguientes: 
		//existe / para todo (el mismo implementado en la entrega 2, pero con streams).
		public Boolean existeCartaConSubtipo(String patata) {
	    	return card.stream().anyMatch(x-> x.getAttributes().equals(patata));
	    }
	
	public Boolean existeCartaConAtaque(Integer ataque) {
		Predicate<CartasYugiho> pred = p-> p.getAttack().equals(ataque);
		return card.stream().anyMatch(pred);
    }
	
	public Boolean existeCartaConDefensa(Integer defensa) {
		Predicate<CartasYugiho> pred = p-> p.getDefense().equals(defensa);
		return card.stream().anyMatch(pred);
	}
	
	// A escoger uno de los tres siguientes: 
	//contador/suma/media (el mismo implementado en la entrega 2, pero con streams). 
	
	public Long NumeroCartasMismoNivel(Integer n) {
		return card.stream().filter(x -> x.getLevel().equals(n)).collect(Collectors.counting());
	}
	
	public Integer SumaAtaquesPorTipo(String patata) {
		return card.stream().filter(x -> x.getAttributes().equals(patata)).mapToInt(x -> x.getAttack()).sum();
	}
	public Double AverageDefensaPorTipo(String patata) {
		return card.stream().filter(x -> x.getAttributes().equals(patata)).mapToInt(x -> x.getDefense()).average().orElse(0.);
	}
	
	//public  Map<String, Long> getPorcentajeHumanosPorNivelStream(Integer Level) {
		//Predicate<CartasYugiho> pred = p-> p.getLevel().equals(Level) && p.getEsHumano().equals(true);
		//return card.stream().filter(pred).collect(Collectors.groupingBy(p -> p.getName(),Collectors.counting()));
		
				
		
	

	//
	
	//Una selección con filtrado (la misma implementada en la entrega 2, pero con streams).

	public List<String> CartasFiltradasPorNivelyDefensa(Integer n, Integer D) {
		return card.stream().filter(x-> x.getLevel().equals(n) && x.getDefense().equals(D)).map(x-> x.getName()).collect(Collectors.toList());
	}
		
		
	//
	
	//Un máximo/mínimo con filtrado.
	public Integer filtradoAtaqueMaximo(String x) {
		return card.stream().filter(y-> y.getName().equals(x)).mapToInt(y-> y.getAttack()).max().orElse(0);
	}

	//
	
	//Una selección, con filtrado y ordenación.
				
	public List<String> CartaPorNivelOrdenando(Integer l){
		return card.stream().filter(x -> x.getLevel().equals(l)).map(x -> x.getName())
				.collect(Collectors.toList());
	}
	
	
	//Un método en cuya implementación se use, o bien el Collector collectingAndThen, o bien el Collector mapping.
	
	public List<String> CartaPorAtributo(String a){
		return card.stream().filter(x-> x.getAttributes().equals(a)).collect(Collectors.mapping(x-> x.getName(),Collectors.toList()));
	}
	
	//Un método que devuelva un Map en el que las claves sean un atributo o una función sobre un atributo, y los valores son máximos/mínimos de los elementos que tienen ese valor.
	
	public Map<Object, Object> CartaPorNivelMaximoAtaque(Integer l){
		return card.stream()
				.filter(x -> x.getLevel().equals(l))
				.collect(Collectors.toMap(x-> x.getName(),x -> ayudita(x.getName())));			
	}
	
	public Integer ayudita(String x) {
		return card.stream().filter(y-> y.getName().equals(x)).mapToInt(y-> y.getAttack()).max().orElse(0);
	}
	
	//Un método que devuelva un SortedMap en el que las claves sean un atributo o una 
	//función sobre un atributo, y los valores sean listas con los n mejores o peores 
	//elementos que comparten el valor de ese atributo (o función sobre el atributo).
	
	public SortedMap<Object, Object> masAtaqueSegunNivel(Integer n){
        Comparator<CartasYugiho> c = Comparator.comparing(e->e.getLevel());
        
        return card.stream()
                .collect(Collectors.groupingBy(
                        x -> x.getName(),
                        TreeMap::new,
                        Collectors.toList()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        v->v.getValue()
                        .stream()
                        .sorted(c.reversed())
                        .limit(n)
                        .collect(Collectors.toList()),
                        (a,b)->a,TreeMap::new));
	}

	//Un método que calcule un Map y devuelva la clave
	//con el valor asociado (mayor o menor) de todo el Map.
	
	public Map<String, Integer> DefensaMasAltaPorAtributo(){
        return card.stream()
                .collect(Collectors.groupingBy(
                        j->j.getAttributes(),
                        Collectors.collectingAndThen(
                                Collectors.maxBy(
                                        Comparator.comparingInt(e->e.getDefense())),
                                e->e.get().getDefense())));
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
	


	
		
	
	

	

	
		
public Double getPromedioDefensaPorAtaque(Integer a) {
	return card.stream().filter(p -> p.getAttack().equals(a))
			.mapToInt(p -> p.getDefense()/getNumeroCartas())
			.average()
			.orElse(0);
	
}









}
	
	

	
	
	
