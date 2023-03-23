package fp.yugiho;
import fp.common.*;
import java.util.*;

import java.time.LocalDate;

import fp.utiles.Checkers;
import fp.utiles.valores;
import fp.utiles.*;
public class CartasYugiho {
	
	private String Name;
	private String Attributes;
	private String SubTypes;
	private Integer Level;
	private Integer Attack;
	private Integer Defense;
	private Boolean EsHumano;
	private LocalDate FechaCarta;
	private valores valores;
	private NombreDefensaAtaque NombreDefensaAtaque;
	
	public CartasYugiho(String Name,String Attributes,String SubTypes,Integer Level,Integer Attack,Integer Defense,Boolean EsHumano,LocalDate FechaCarta,valores valores,NombreDefensaAtaque NombreDefensaAtaque) {
		this.Name=Name;
		this.Attributes=Attributes;
		Checkers.check("el atributo y el subtipo no pueden ser iguales, puesto que seria redundante",!Attributes.equals(SubTypes));		
		this.SubTypes=SubTypes;
		this.Level=Level;
		Checkers.check("El ataque no puede ser menor que cero , es decir tiene que ser positivo, ni mayor de 10000",Attack>0 && Attack<10000);
		this.Attack=Attack;
		Checkers.check("La defesa no puede ser menor que cero , es decir tiene que ser positiva, ni mayor de 10000",Defense>0 && Defense<10000);
		this.Defense= Defense;
		this.EsHumano=EsHumano;
		this.FechaCarta=FechaCarta;
		this.valores= valores;
		this.setNombreDefensaAtaque(NombreDefensaAtaque);
	}
	public CartasYugiho(String Name,Integer Level,Integer Attack,Integer Defense) {
		this.Name=Name;
		this.Attributes="";
		this.SubTypes="";
		this.Level=Level;
		Checkers.check("El ataque no puede ser menor que cero , es decir tiene que ser positivo, ni mayor de 10000",Attack>0 && Attack<10000);
		this.Attack=Attack;
		Checkers.check("La defesa no puede ser menor que cero , es decir tiene que ser positiva, ni mayor de 10000",Defense>0 && Defense<10000);
		this.Defense= Defense;
		this.EsHumano=null;
		this.FechaCarta=null;
		this.valores=null;
		
	}
	//Propiedad derivada
	public Integer getProductoAtaqueyDefensa() {
		return Attack+Defense;	
	}
	
	public Double Rating() {
		Double att=(double) Attack/100;
		Double def=(double) Defense/100;
		Double Rating=((att+def)*Level);
		return Rating;
	}
	//tipo lista necesario 
	public List<Object> NombreAtaque(){
		 List<Object> NombreAtaque = new ArrayList<>();
		 NombreAtaque.add(Name);
		 NombreAtaque.add(Attack);
		 return NombreAtaque;
		
}
	public valores getResultado() {
		valores res = valores.juan;
		if (Attack > Defense) {
			res=valores.luis;
		}
		else if(Attack < Defense){
			res=valores.paco;
		}
		return res;	
		}
	/*
	//propiedad auxiliar?
	public record DefensaAtaque(int Attack,int Defense ) {
		public static DefensaAtaque of(String[] s) {
			return new DefensaAtaque(Integer.valueOf(s[0]),Integer.valueOf(s[1]));
			
		}
	}
	*/
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAttributes() {
		return Attributes;
	}
	public void setAttributes(String attributes) {
		Attributes = attributes;
	}
	public String getSubTypes() {
		return SubTypes;
	}
	public void setSubTypes(String subTypes) {
		SubTypes = subTypes;
	}
	public Integer getLevel() {
		return Level;
	}
	public void setLevel(Integer level) {
		Level = level;
	}
	public Integer getAttack() {
		return Attack;
	}
	public void setAttack(Integer attack) {
		Attack = attack;
	}
	public Integer getDefense() {
		return Defense;
	}
	public void setDefense(Integer defense) {
		Defense = defense;
	}
	public Boolean getEsHumano() {
		return EsHumano;
	}
	public void setEsHumano(Boolean esHumano) {
		EsHumano = esHumano;
	}
	public LocalDate getFechaCarta() {
		return FechaCarta;
	}
	public void setFechaCarta(LocalDate fechaCarta) {
		FechaCarta = fechaCarta;
	}
	public valores getValores() {
		return valores;
	}
	public void setValores(valores valores) {
		this.valores = valores;
	}
	@Override
	public String toString() {
		return "CartasYugiho [Name=" + Name + ", Attributes=" + Attributes + ", SubTypes=" + SubTypes + ", Level="
				+ Level + ", Attack=" + Attack + ", Defense=" + Defense + ", EsHumano=" + EsHumano + ", FechaCarta="
				+ FechaCarta + ", valores=" + valores + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Attack, Attributes, Defense, EsHumano, FechaCarta, Level, Name, SubTypes, valores);
	}
	//
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartasYugiho other = (CartasYugiho) obj;
		return Objects.equals(Attack, other.Attack) && Objects.equals(Attributes, other.Attributes)
				&& Objects.equals(Defense, other.Defense) && Objects.equals(EsHumano, other.EsHumano)
				&& Objects.equals(FechaCarta, other.FechaCarta) && Objects.equals(Level, other.Level)
				&& Objects.equals(Name, other.Name) && Objects.equals(SubTypes, other.SubTypes)
				&& valores == other.valores;
	}
	public NombreDefensaAtaque getNombreDefensaAtaque() {
		return NombreDefensaAtaque;
	}
	public void setNombreDefensaAtaque(NombreDefensaAtaque nombreDefensaAtaque) {
		NombreDefensaAtaque = nombreDefensaAtaque;
	}
	
	
	}

