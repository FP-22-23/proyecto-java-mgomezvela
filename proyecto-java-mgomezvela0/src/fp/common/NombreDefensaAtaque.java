package fp.common;

public record NombreDefensaAtaque(String Name,Integer Attack,Integer Defense) {
	public static NombreDefensaAtaque of(String[] s) {
		return new NombreDefensaAtaque(s[0],Integer.valueOf(s[1]),Integer.valueOf(s[2]));
		
	}
	public String getCadenaFormato() {
		return "La carta "+ Name + " tiene las estadisticas pincipales de: "
				+ "defensa-"+ Defense+ " y ataque-"+Attack;
	}
	public String toString() {
		return "Carta[getName()="+Name()+",getTitulos()="+Defense()+",getAttack()="+Attack()+"]";
	}
	
	
}
