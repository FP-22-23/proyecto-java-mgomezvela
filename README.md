# proyecto-java-mgomezvela
proyecto-java-mgomezvela created by GitHub Classroom
# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2021/22)
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
* **valores**: es un enumerado , con tres valores que son juan , luis y paco , los cuales seran los users de nuestro juego
corresponde con el primer o segundo movimiento, sino que son las salidas y sus distintas variantes, por ejemplo, ```Queen's Pawn Game: Mason Attack```.
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
corresponde con el primer o segundo movimiento, sino que son las salidas y sus distintas variantes, por ejemplo, ```Queen's Pawn Game: Mason Attack```.
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

#### Tipos auxiliares-carta
Representa el nombre defensa y ataque.

