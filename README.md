# proyecto-java-mgomezvela
proyecto-java-mgomezvela created by GitHub Classroom
# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2022/23)
Autor/a: Miguel Gómez Vela   uvus:miggomvel


## Estructura de las carpetas del proyecto

* **/src**: Directorio con el código fuente.
  * **fp.common**: Paquete que contiene los tipos del proyecto.
  * **fp.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.utiles**:  Paquete que contiene las clases de utilidad.
  * **fp.yugiho** : Paquete que contiene las clases y tipos del proyecto 
* **/data**: Contiene el dataset del proyecto.
    * **YU-GI.OH-Normal_Monsters.csv**: Archivo csv que contiene datos de diferentes Cartas Yugioh.
    
## Estructura del *dataset*

El dataset original YU-GI.OH-Normal_Monsters Dataset se puede obtener de la URL http://kaggle.com/rushikeshhiray/yugioh-normal-monster-cards. Originalmente tiene 6 columnas y cada fila contiene datos sobre una carta del juego. El dataset usado en este proyecto tiene 10 columna de las cuales usamos 9, 6 se han tomado del dataset original, y 4, la fecha, el boolean y un enum, se han generado de manera externa. A continuación se describen las 10 columnas del dataset:

* **Name**: de tipo String,  indica el nombre de la carta
* **Attributes**: de tipo String, indica los atributos de la carta.
* **Subtypes**: de tipo String, indica el subtipo de la carta.
* **Level**: de tipo Integer, Indica el nivel de la carta.
* **Attack**: de tipo Integer, Indica los puntos de ataque de la carta.
* **Defense**: de tipo Integer, Indica los puntos de defensa de la carta
* **EsHumano**: de tipo Boolean, de manera aleatoria dice si es o no humano. True-False
* **FechaCarta**: de tipo LocalDate,de manera aleatoria genera una fecha.
* **valores**: es un enumerado , con tres valores que son juan , luis y paco , los cuales seran los users de nuestro juego.

* **NombreDefensaAtaque** : tipo que hemos implementado manuelmente que es un record que devuelve el nombre, la defensa y el ataque de la carta
* **NombreAtaque** : al necesitar un tipo lista, este es una lista a la que se le añade el nombre y ataque de la carta.

** Propiedades **:
* **Name**: de tipo String,  indica el nombre de la carta
* **Attributes**: de tipo String, indica los atributos de la carta.
* **Subtypes**: de tipo String, indica el subtipo de la carta.
* **Level**: de tipo Integer, Indica el nivel de la carta.
* **Attack**: de tipo Integer, Indica los puntos de ataque de la carta.
* **Defense**: de tipo Integer, Indica los puntos de defensa de la carta
* **EsHumano**: de tipo Boolean, de manera aleatoria dice si es o no humano. True-False
* **FechaCarta**: de tipo LocalDate,de manera aleatoria genera una fecha.
* **valores**: es un enumerado , con tres valores que son juan , luis y paco , los cuales seran los users de nuestro juego

* **NombreDefensaAtaque** : tipo que hemos implementado manuelmente que es un record que devuelve el nombre, la defensa y el ataque de la carta
* **NombreAtaque** : al necesitar un tipo lista, este es una lista a la que se le añade el nombre y ataque de la carta.

**Constructores**: 

- C1: Tiene un parámetro por cada propiedad básica del tipo.
- C2: C2: Recibe nombre,nivel , ataque y defensa. El resto de propiedades toman el valor null o vacio.
**Restricciones**:
 
- R1: El ataque no puede ser menor que cero , es decir tiene que ser positivo, ni mayor de 10000"
- R2: La defensa no puede ser menor que cero , es decir tiene que ser positiva, ni mayor de 10000"
- R3: el atributo y el subtipo no pueden ser iguales, puesto que seria redundante
***Criterio de igualdad**: Dos cartas son iguales si todas sus propiedades básicas son iguales.

**Criterio de igualdad**: Dos cartas son iguales si tienen las mismas propiedades

**Criterio de ordenación**: Las cartas se ordenan en base a Attack, Attributes, Defense, EsHumano, FechaCarta, Level, Name, SubTypes, valores

#### Tipos auxiliares-carta: NombreDefensaAtaque
Es un record que representa el nombre defensa y ataque de la carta en cuestión.

Factoría - FactoriaPartidas
Clase de factoría para construir objetos de tipo Partidas.

leerCartas(String fichero):Crea una lista de tipo CartasYugiho a partir de la información recogida en el archivo csv, y se añaden las lineas de este eliminando la primera.
parsearCartasYugiho(String linea): se recorren las lineas del fichero dandole a cada propiedad basica su tipo para poder parsearlo y devolviendo un tipo CartasYugiho.
Más abajo tenemos todas las clases auxiliares utilizadas para parsear las propiedades

Clase contenedora de los objetos de tipo Cartas.

Propiedades:

card, de tipo List<CartasYugiho>, consultable. Lista de CartasYugiho.
Name, de tipo String , consultable. Nombre de la carta.
Defensa, de tipo Integer, consultable. Valor de la defensa de la carta.
Ataque, de tipo Integer, consultable. Valor del ataque de la carta.
Constructores:

C1: Constructor por defecto. Creal un objeto de tipo Cartas sin ninguna partida almacenada.
C2: Constructor por defecto. Creal un objeto de tipo Cartas con la lista cartas implementada.
C3: Constructor con un parámetro de tipo Collection<CartasYugiho>. Crea un objeto de tipo CartasYugiho con las cartas incluidas en la colección dada como parámetro.
C4: Constructor con un parámetro de tipo Stream<CartasYugiho>. Crea un objeto de tipo CartasYugiho con las cartas incluidas en el Stream dado
Criterio de igualdad: Dos partidas son iguales si lo son sus propiedades cartas.

Otras operaciones:

public void agregarCarta(CartasYugiho c): Añade una carta al objeto.
public void eliminarCarta(CartasYugiho c): Elimina una carta al objeto.
public void añadircoleccion(Collection<CartasYugiho> c): Añade una coleccion al objeto.
public Double getPromedioNivelDeCartas(): Devuelve el promedio de nivel de todas las cartas.
public String getCartasConDefensaN(Integer n): devuelve el nombre de las cartas con defensa = n.
public String getCartasConAtaqueN(Integer n): devuelve el nombre de las cartas con ataque = n.
public Boolean existeCartaConAtaque(Integer ataque): te devuelve si existe o no una carta con dicho ataque.
public Boolean existeCartaConDefensa(Integer ataque): te devuelve si existe o no una carta con dicha defensa.
public Double getPorcentajeHumanosPorNivel(Integer Level): introduciendo un nivel level , te devuelve el porcentaje de las cartas con dicho nivel cuyo valor esHumano es true. Si no hay devuelve no hay cartas humanas.
public Double mediaAtaque(): devuelve la media de ataque.
public Double mediaDefensa(): devuelve la media de defensa.
public List<String> filtraSubtipos(String x): devuelve las cartas filtradas por su subtipo.
private Map<String, Integer> getTotalDefensaAtaque(Predicate<CartasYugiho> filtro): asocia el nombre de la carta con su defensa y ataque.
public Map<Integer, List<String>> getCartasPorNivel(Integer Level): devuelve un mapa con las cartas y su nivel.
public Map<String, Integer> getCartasConMejorAtaque(Integer Attack): devuelve el nombre de la carta con el ataque que hayamos introducido.
 
 public List<String> getCartasConDefensaN(Integer n) :devuelve mediante streams las cartas que tengan n defensa
 
 public String seleccionaMejorCarta() : devuelve mediante streams las cartas que tengan mejor ataque
 
 public Boolean existeCartaConSubtipo(String patata) : devuelve mediante streams un booleano de si existe dicha carta
 
 existeCartaConAtaque y existeCartaConDefensa funcionan de la misma manera
 
 public Long NumeroCartasMismoNivel(Integer n) : mediante streams devuelve el numero de cartas con el mismo nivel
 
 public Integer SumaAtaquesPorTipo(String patata) : mediante streams devuelve la suma de los ataques de x tipo
 
 public Double AverageDefensaPorTipo(String patata) : devuelve mediante streams el average de la defensa de x tipo 
 
 public List<String> CartasFiltradasPorNivelyDefensa(Integer n, Integer D): en base a un nivel y una defensa , usando streams te devuelve las cartas que pasen el filtro
 
 public Integer filtradoAtaqueMaximo(String x): mediante streams devuelve las cartas con el valor maximo
 
 public List<String> CartaPorNivelOrdenando(Integer l): devuelve mediante streams una lista de las cartas de dicho nivel
 
 public List<String> CartaPorAtributo(String a) : usando el collector.mapping como se nos pide , devuelve una lista de las cartas por x atributo
 
 public Map<Object, Object> CartaPorNivelMaximoAtaque(Integer l):te devuelve la carta cuyo nivel sea igual a l y su ataque sea el maximo
 
 tiene un metodo auxiliar llamado ayuda que te devuelve el ataque maximo de dicha carta
 
 public SortedMap<Object, Object> masAtaqueSegunNivel(Integer n): te devuelve un mapa con el mayor ataque respecto a cada nivel.
 
 public Map<String, Integer> DefensaMasAltaPorAtributo(): te devuelve la mayor defensa en base a su atributo.
 
 
 
 
 
 
 
 
 
 
 
 
 


