### Inner Classes Notes
En función de como y dónde esté definida la clase interna distinguimos cuatro tipos se situaciones que se pueden presentar:
        1. Clases internas estándares
        2. Clases internas locales a método
        3. Clases anónimas
        4. Clases internas estáticas.

##### Clases Internas Estándares
Esta situación se da cuando tenemos una clase no estática defiida en el inteior de otra clase, como un miembro de la misma:
```java
class Externa {
    class Interna {
    }
    .
    .
}
```
##### Instanciación de la clase interna
La instanciación de la clase externa se realiza de la forma estándar. Sin embargo, para crear una instancia de la clase interna, dado que está es un miembro no estático de la esterna, __será necesario disponer previamente de una instancia de la clase externa__.
Suponiendo que _ex_ es una variable que contiene una referencia a la clase externa, la creación de una instancia de la clase interna seguirá la siguiente sintaxis:
```java
Externa.Interna in = ex.new Interna();
```
Observese la utilización del operador _new_ precedido del punto y la referencia a la instancia de la clase externa.
_Ver Ejemplo:_ 
    
```java 
	public class Externa {
		String s ="Mio";
		//Definición de la clase interna
		class Interna {
			public void muestra () {
				System.out.println("Objeto interno "+s);
			}
		}
	}		
	public class Principal {
		public static void main(String[] args) {
			Externa ex = new Externa();
			//Aprenernos esta sintaxis de new
			Externa.Interna in = ex.new Interna();
			in.muestra();
		}
	}
```

Como se desprende del ejemplo anterior, __una clase interna tiene acceso al resto de los miembros de la clase externa.__

En el caso de crear el objeto interno desde algún método de la propia clase externa, se puede utilizar la forma normal de crear objetos java:
```java
public class Externa {
    void imprime () {
        //dado que la ejecución de este método sólo
        //será posible se se dispone de una
        //instancia de Externa, se puede utilizar:
        Interna min = new Interna()
        min.muestra();
    }
    class Interna {
        public void muestra() {
            System.out.println("Objeto interno ");
        }
    }
}
```
##### Utilización de _this_
Dentro de la clase interna, la palabra _this_ hace referencia a la instancia en ejecución de la clase interna. 
Si desde el interior de la clase interna quiere hacerse referencia a la instancia de la clase externa deberá utilizarse la expresión:
```java
    Clase_externa.this
```
_Ver Ejemplo:_
```java
    public class Principal {
	
		public static void main(String[] args) {
			Externa ex = new Externa();
			Externa.Interna in = ex.new Interna();
			in.imprime();
		}

	}

	class Externa {
	    public void muestraext() {
	        System.out.println("Objeto externo ");
	    }
	    class Interna {
	        public void muestrain() {
	            System.out.println("Objeto interno ");
	        }
	         public void imprime() {
	            this.muestrain();
	            Externa.this.muestraext();
	         }
	    }
	}
```

##### Modificadores para una clase interna Standard
Una clase interna es un miembro más de la clase, por tanto, en su definición se pueden utilizar los siguientes modificadores:
*   final
*   abstract
*   strictfp
*   static 
*   private
*   protected
*   public
*   
##### Clases internas locales a método
Esta situación se corresponde al caso de dos clases anidadas en donde la clase interna esta definida en el interior de un método de la clase externa:
```java
    class Externa {
        void metodo() {
            class Interna {
            }
        }
    }
```

##### Instanciación de la clase interna local a método
Una clase interna definida en el interior de un método de otra clase __solamente podrá ser intanciada en el interior de dicho método__ despues de la declaración de la clase interna.

_Ver Ejemplo:_

```java
	public class Principal {
		public static void main(String[] args) {
			Externa ex = new Externa();
			ex.proceso();
		}
	}

	class Externa {
		void proceso () {
			class Interna {
				void muestra() {
					 System.out.println("Local a método ");
				}
			}
			//Sólo podrá instanciarse en el interior
			//de proceso() a partir de aquí
			Interna in = new Interna();
			in.muestra();
		}
	}
```

Existe otra restricción importante en el uso de este tipo de clases. Se trata del hecho de que __una clase local a método no puede acceder a las variables locales definidas en dicho método,__ salvo que estas estén definidas como _final_(constantes)-
_Ver Ejemplo:_ 
    
```java
		public class Externa {
	
			String s ="Mio";
			
			void proceso () {
				/*final*/ int p=6;
				class Interna {
					void muestra() {
						//la siguiente instrucción es correcta
						System.out.println("Local a  Método "+s);
						//la siguiente instrucción no compilará
						//porque una clase dentro de un método
						//no tiene acceso a las variables locales
						//a menos que la cambiemos a final
						//y sea una constante
						//si descomentamos el final de la varianle p
						//este cpodigo si compilará.
						System.out.println(p);
					}
				}
				Interna in = new Interna();
				in.muestra();
			}
		}
```

##### Modificadores para una clase interna local a método
Dado ye una clase definida dentro de un método es un elemento local a éste, únicamente podrán utilizarse en su definición  los modifciadores:
* abstract
* final

##### Clases Anónimas
Una clase anónima es una clase sin nombre, definida en la misma línea de código donde se crea el objeto de la clase. Esta operación se lleva a cabo en el interior de un método de otra clase, por ello la clase anónima es considerada como una clase interna anidada.

##### Definición de una Clase Anónima
Una clase anónima siempre ___debe ser una subclase de otra clase existente o bien debe implementar alguna interfaz.__ La sintaxis para la definición una clase de éste tipo será:
```java
Superclase var = new Superclase () {
    //definición de la clase anónima
};
```
Dónde var será la variable que almacene la instancia de la clase anónima. que será una subclase de Superclase.
Como se puede observar, la definición de la clase anónima y la creación de una instancia de la misma representan acciones inseparables que se realizán en la misma línea de código.

_Ver Ejemplo:_ 

```java
	class Operaciones {
		public void imprimir () {
			System.out.println("Imprimir Original");
		}
	}
	
	class Externa {
		Operaciones op = new Operaciones() {
			//Definición de la clase anónima
			public void imprimir () {
				System.out.println("Imprimir Anónimo");
			}
		}; // la línea de definición de la clase y
		//creación del objeto termina con ;
		
		void proceso () {
			//llama al método imprimir del objeto
			//de la clase anónima
			op.imprimir();
		}
	}
	
	public class Principal {
		public static void main(String[] args) {
			// Intanciación normal de la
			//clase externa
			Externa ex = new Externa();
			ex.proceso();
		}
	}
```

De este ejemplo se deducen dos cosas importantes, en primer lugar la variable _op_ contiene una instancia del objeto de la clase anónima, no de la clase Operaciones. En segundo lugar, dado que la definición de la clase anónima se lleva acabo en una línea de código, esta debe terminar con ;. En este sentido, hay que fijarse bien en el código de las preguntas de examen, pues podemos encontrarnos con definiciones de las clases anónimas donde falte el ";", lo que supone directamente un error de compilación.

Como ya se ha indicado antes, también se puede definir una clase anónima a partir de una interfaz:
```java
class Externa {
    Runnable rn = new Runnable () {
        public void run() {
            System.out.println("run anónimo");
        }
    };
}
```
La variable _rn_ contendrá el objeto de la clase anónima.

Como se estudió en el capítulo dedicado a la programación orientada a objetos, una instancia de la clase anónima solamente podrá ser utilizada para acceder a aquellos métodos de la clase que hayan __heredado, sobreescrito o implementado.__

Por ejemplo, si la clase anónima anterior tuviera algún método propio, éste no podría ser invocado con la variable _rn_:

```java
class Externa {
    Runnable rn = new Runnable () {
        public void run() {
            System.out.println("run anónimo");
        }
        public void propio () {}
    };
    
    void proceso() {
        rn.run(); // correcto
        //la siguiente instrucción provoca
        //un error de compilación
        rn.propio();
    }
}
```
##### Clase anónima como argumento de método
Aún se puede producir una situación mas extraña, se trata de la posiblidad de definir la clase anónima como argumento de la llamada a un método:
```java
class Externa {
        void proceso() {
            OtraClase o = new OtraClase();
            o.metodo( new Operaciones () {
                public void imprime () {
                    System.out.println("anónimo");
                }
            }); 
        }
    }
```
##### Clases internas estáticas
Un último caso especial de clases anidadas es aquél en el que la clase interna resulta ser un dato miembro estático:
```java
    class Externa {
        static class Interna {
            //Código clase Interna
        }
        ..
    }
```
Como sucede con los métodos, __las clases internas definidas como estáticas no pueden acceder a las variables y métodos no estáticos de la clase externa.__

##### Intanciación de clase insterna estática
Para crear una instancia de una clase estática interna desde el exterior de la clase externa se utilia la expresión:
```java
    Externa.Interna variable = new Externa.Interna();
```

Veamos un ejemplo. Dadas ñas siguientes clases:
```java
    public class Externa {
        static class Interna {
            public void muestra () {
                System.out.println("Texto estático");
            }
        }
    }
```
Para crear un objeto de la clase Interna y llamar a su método _muestra()_ se procedería:
```java
    class Prueba {
        public static void main (String args[]) {
            //instanciación de la clase estática
            Externa.Interna ej = new Externa.Interna();
            ej.muestra(); //llamada al método de la
                         //clase estática.
        }
    }
```
Una clase estática interna puede tener métodos no estáticos.


