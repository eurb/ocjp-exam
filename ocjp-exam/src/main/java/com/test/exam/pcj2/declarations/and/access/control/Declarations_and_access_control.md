### Delcaración Inicialización Y Ámbito

##### Declaración de una clase
Cuando se declará una clase hay que recordar las siguientes reglas:
*   Solamente puede haber una clase pública por archivo de código fuente .java.
*   El nombre de un archivo .java debe coincidir con él de la clase pública. si no hay clases declaradas como _public_ en el archivo, éste se puede llamar de cualquier forma.

##### Modificadores
En cuanto a los modifcadores que pueden utilizarse a la hora de definir una clase, tenemos:
*   __De acceso:__ _public_ y acceso por defecto. Como sabemos, este último tiene lugar cuando no se emplea ningún modificador explicitamente.
*   __Estático:__ _static._ Este modifcador __solo puede ser utilizado si se trata de una clase interna.__
*   __Otros:__ _final, abstract, strictfp._ Se pueden combinar entre sí. con la excepción de _final_ y _abstract_ que no pueden aplicarse en la misma clase.

El truco aqui es aprenderse que _static_ es solo para clases internas, y que _final_ y _asbtract_ no pueden ir juntos ya que son conceptos opuestos, uno es para la herencia (_asbtract_) y el otro es para que no puedan heredar (_final_). Y el último es memorizar la palabra reservada _strictfp_ y que se puede usar al declarar una clase.

##### Sentencias _import_ y _package_
Sobre el uso de estas sentencias hay que recordar que:
*   Si las clases del archivo .java pertenecen a un paquete, la sentencia _package_ debe ser la primera línea del archivo.
*   La sentencia _import_ puede utilizarse para importar una clase:
    ```java
    import paquete.clase;
    ```
    o todas las clases de un paquete:
     ```java
    import paquete.*;
    ```
* La importación de los elementos estáticos de una clase uiliza la sintaxis:
  ```java
    import static paquete.clase.*;
    ```
Con respecto a este punto, hay que prestar atención a los bloques de código que aparecen en el examen, pues podemos encontrar situaciones como ésta:

```java
    import java.util.Vector.*;
    class Ejemplo {
        Vector v;//error de compilación
    }
```
El problema que se evidencia en el código anterior, es que el simbolo "*" (comodín) se debe de utilizar para hacer referencia a todas las clases de un determinado paquete, por lo que debe de estar precedido por un nombre del paquete y no de una clase. En este ejemplo se producirá un error de compilación en la declaración en la declaración de la variable _v_, ya que el compilador intentará localizar la clase Vector en el paquete __java.util.Vector__ y no en java.util que es donde realemnte está.

Asi pues si lo que se desea es importar el paquete _util_ completo debería haberse utilizado:
```java
    import java.util.*;
```

Si solo desea importar la clase Vector, basta con:
```java
    import java.util.Vector;
```

Debemos prestar atención también a los códigos donde aparezca la sentencia _package_, en este sentido, cuidado con instrucciones como las siguientes:

```java
    import java.util.*;
    package mipaquete;
    class MiClase {
        //Código aqui
    }
```

El código anterior no compilará, pues la sentencia _packeage_ no puede aparecer después del _import_.

##### Declaración de una interfaz

De cara a las interfaces que puedan aparecer definidas en las mismas preguntas del examen, hay que recordar las siguientes reglas sobre su declaración:
*   Todos los métodos definidos en la interfaz son implicitamente _public_ y _asbtract_, auqnue no lleven esos modificadores.
*   Los métodos en una interfaz __no pueden ser estáticos__
*   Una interfaz no puede incluir variables de instancia, por lo que toda la variable declarada en una interfaz deberá tener asignado un valor (constante). De hecho, toda variable definida en una interfaz es implicitamente _public, static y final_, aunque no se indiquen explicitamente estos modificadores.
*   Una interfaz puede heredar una o varias interfaces, pero no puede implementar nada. La siguiente declaraión de interfaz es incorrecta:
    ```java
        //Error de compilación
        public interface InterfazA
                    implements InterfazB { }
    ```
    Lo correcto sería: 
     ```java
        //Error de compilación
        public interface InterfazA extends InterfazB { }
    ```
* El uso del modificador _abstract_ en la declaración de una interfaz es redundante, pero no incorrecto. La siguiente declaración es válida:
    ```java
        public abstract interface InterfazA  { }
    ```
##### Declaración de una Enumeración
Reapecto a la declaración de una enumeración debemos tener en cuenta lo siguiente:
*   Las enumeraciones se declararán:
    ```java
        enum Nombre_enumeracion {
            VALOR1. VALOR2, . . . }
    ```
*   Pueden esrar declaradas como dato miembro de la clase o como elemento independiente, __nunca pueden declararse en el interior de un método.__

###### Modifciadores
Sobre los modifciadores válidos para la declración de una enumeración se pueden utilizar los siguientes:
*   __De aceeso:__ Siguiendo las mismas reglas que en la declaración de una clase, pueden utilizarse los modificadores de acceso _public_ y _default_.
*   __Otros:__ Toda enumeración es implicistamente estática- aunque explícitamente sólo se admite el modificador _static_ cuando la enumeración está declarada dato dato miebro de la clase.

#### Más sobre Enumeaciones
Por ejemplo podemos declarar la siguiente enumeración Direccones para reemplazar por ejemplo una clase que usarpa variables contantes (public static final int NORTE=0), en vez de eso definimos la siguiente enumeración:
 ```java
        enum Direcciones {NORTE, SUR, ESTE, OESTE }
```
Veamos un ejemplo de como usar la enumeración Direcciones con las siguienres clases:
 ```java
        public class Barco {
            private Direcciones orientacion;
            public void setOrientacion(Direcciones s){
                orientacion=s;
            }
            public Direcciones getOrientacion() {
                return orientacion;
            }
        }
        
        public class Navegacion {
            public static void main (String args[]) {
                Barco b = new Barco();
                //establecimiento de la orientación a
                //partir de los valores de la enumeración
                b.setOrientacion(Direcciones.OESTE);
            }
        }
```
Al declararse el paramétro _orientacion_ como tipo _Direcciones_, el compilador solo admitirá que se le asignen los valores definidos en dicha enumeración, haciendo más seguro el código.

#### Clases de Enumeración
Una enumeración es un tipo especial de clase, clase que hereda _java.lang.Enum_. A diferencia de las clases estándares, una enumeración no permite el uso del operador _new_ para la creación de objetos. Cada uno de los valores de la enumeración representa uno de los posibles objetos de la clase. asi pues, estos serán creados de forma implicita.
Además de los métodos herdados de _Enum_, todas las enumeraciones dispones del método estático _values()_ ue devuelve un array con todos los objetos (valores de la enumeracion).
El siguiente método muestra en patanlla todos los valores de la enumeración Direcciones definida anteriormente.

```java
        public void muestraValores() {
            for(Direcciones dir: Direcciones.values()) {
                System.out.println(dir);
            }
        }
```
Otra diferencia entre los objetos de las clases estándares y los objetos enumerados, está en que estos últimos pueden ser utilizados en expresiones de comparación de igualdad mediante el signo _==_ y como valores de una instrucción _switch_.
```java
            for(Direcciones dir: Direcciones.values()) {
               if(dir==Direcciones.SUR || dir==Direcciones.NORTE) {
                    System.out.println("Rumbo Erroneo");
               }
               else {
                    System.out.println("Rumbo Correcto");
               }
            }
```
#### Constructores y métodos de una enumeración
Como ya hemos visto una enumeación es como una clase, lo que significa que tambien puede definir contructores y métodos. Tanto unos como otros siempre deben estar declarados después de la lista de valores de la enumeración.

Para crear un contructor usamos la misma sintaxis que la de las clases estandares:
```java
        Nombre_enumeracion (lista_parametros){
        //TODO
        }
```

Cuando una enumeración dispone de constructores con parámetros , los valores de los argumentos de llamada deben estar especificados en cada uno de los valores de la enumeración:
```java
       enum Direcciones {
            NORTE(4), SUR(2), ESTE(2), OESTE(3)
            int distancia;
            Direcciones(int d) {
                distancia=d;
            }
       }
```
Los valores de _distancia_ se suminstran al constrcutor de Direcciones cuando se hace referencia a los distintos objetos del enumerado: NORTE, SUR etc.

Los métodos también se definen como en las clases por ejemplo:
```java
       enum Direcciones {
            NORTE(4), SUR(2), ESTE(2), OESTE(3)
            int distancia;
            Direcciones(int d) {
                distancia=d;
            }
            int getDistancia () {
                return distancia;
            }
       }
```
El siguiente programa nos muestra un ejemplo del uso de la enumeracion Direcciones con todas las caracteristicas menciaonadas en el apartado anterior:
```java
      public class Navegacion {
            public static void main (String args[]) {
                Barco b = new Barco();
                Direcciones d;
                b.setOrientacion(Direcciones.OESTE);
                d=b.getOrientacion();
                System.out.println("Distancia recorrida: "+ d.getDsitancia());
            }
        }
```
