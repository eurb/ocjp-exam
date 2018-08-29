### Inner Classes Notes
You define an inner class within the curly braces of the outer class:
 ```java
    class MyOuter {
        class MyInner { }
    }
```
And if you compile it,
```java
    %javac MyOuter.java
```
you'll end up with two class files:
```java
    MyOuter.class
    MyOuter$MyInner.class
```
The _only way you can access the inner class is through a live instance of the outer class!_. In other words, only at runtime when there's already an instance of the outer class to tie the inner class instance to. for example:
```java
    class MyOuter {
        private int x = 7;
        // inner class definition
        class MyInner {
            public void seeOuter() {
                System.out.println("Outer x is " + x);
            }
        } // close inner class definition
    } // close outer class
```
The preceding code is perfectly legal. Notice that the inner class is indeed accessing a private member of the outer class. That's fine, because the inner class is also a member of the outer class. So just as any member of the outer class (say, an instance method) can access any other member of the outer class, private or not, the inner class—also a member—can do the same.

##### Instantiating an Inner Class
To create an instance of an inner class, _you must have an instance of the outer class to tie to the inner class_. There are no exceptions to this rule: an inner class instance can never stand alone without a direct relationship to an instance of the outer class.

```java
    class MyOuter {
        private int x = 7;
        public void makeInner() {
            MyInner in = new MyInner(); // make an inner instance
            in.seeOuter();
        }
        class MyInner {
            public void seeOuter() {
                System.out.println("Outer x is " + x);
            }
        }
    }
```
You can see in the preceding code that the MyOuter code treats MyInner just as though MyInner were any other accessible class. But the only reason this syntax works is because the outer class instance method code is doing the instantiating. In other words, there's already an instance of the outer class—the instance running the makeInner() method.

##### Creating an Inner Class Object from Outside the Outer Class Instance Code
If we want to create an instance of the inner class, we must have an instance of the outer class. You already know that, but think about the implications…it means that, without a reference to an instance of the outer class, you can't instantiate the inner class from a static method of the outer class (because, don't forget, in static code there is no this reference), or from any other code in any other class. Inner class instances are always handed an implicit reference to the outer class. The compiler takes care of it, so you'll never see anything but the end result—the ability of the inner class to access members of the outer class. The code to make an instance from anywhere outside nonstatic code of the outer class is simple, but you must __memorize this for the exam!__:
```java
    public static void main(String[] args) {
        MyOuter mo = new MyOuter(); // gotta get an instance!
        MyOuter.MyInner inner = mo.new MyInner();
        inner.seeOuter();
    }
```
The preceding code is the same regardless of whether the main() method is within the MyOuter class or some other class (assuming the other class has access to MyOuter, and since MyOuter has default access, that means the code must be in a class within the same package as MyOuter).
If you're into one-liners, you can do it like this:
```java
   public static void main(String[] args) {
        MyOuter.MyInner inner = new MyOuter().new MyInner();
        inner.seeOuter();
    }
```
You can think of this as though you're invoking a method on the outer instance, but the method happens to be a special inner class instantiation method, and it's invoked using the keyword new. Instantiating an inner class is the only scenario in which you'll invoke new on an instance as opposed to invoking new to construct an instance.

But what if the inner class code wants an explicit reference to the outer class instance that the inner instance is tied to? In other words, how do you reference the "outer this"?
```java
    class MyOuter {
        private int x = 7;
        public void makeInner() {
            MyInner in = new MyInner();
            in.seeOuter();
        }
        class MyInner {
            public void seeOuter() {
                System.out.println("Outer x is " + x);
                System.out.println("Inner class ref is " + this);
                System.out.println("Outer class ref is " + MyOuter.this);
            }
        }
        public static void main (String[] args) {
            MyOuter.MyInner inner = new MyOuter().new MyInner();
            inner.seeOuter();
        }
    }
```
Con esta sintaxis del ejemplo podemos usar _this_ para referirnos ya se a la clase interna o a la clase externa como se muestra en el método _setOuter()_.

So the rules for an inner class referencing itself or the outer instance are as follows:
1. To reference the inner class instance itself, from within the inner class code, use this.
2. To reference the "outer this" (the outer class instance) from within the inner class code, use NameOfOuterClass.this (example, MyOuter.this).

##### Method-Local Inner Classes
A regular inner class is scoped inside another class's curly braces, but outside any method code (in other words, at the same level that an instance variable is declared). But you can also define an inner class within a method:
```java
    class MyOuter2 {
        private String x = "Outer2";
        void doStuff() {
            class MyInner {
                public void seeOuter() {
                    System.out.println("Outer x is " + x);
                } // close inner class method
            } // close inner class definition
        } // close outer class method doStuff()
    } // close outer class
```
The preceding code declares a class, MyOuter2, with one method, doStuff(). But inside doStuff(), another class, MyInner, is declared, and it has a method of its own, seeOuter().
Just because you declared the class doesn't mean you created an instance of it. So to use the inner class you must make an instance of it somewhere within the method but below the inner class definition (or the compiler won't be able to find the inner class). The following legal code shows how to instantiate and use a method-local inner class:
```java
    class MyOuter2 {
        private String x = "Outer2";
        void doStuff() {
            class MyInner {
                public void seeOuter() {
                    System.out.println("Outer x is " + x);
                } // close inner class method
            } // close inner class definition
            MyInner mi = new MyInner(); // This line must come
            // after the class
            mi.seeOuter();
        } // close outer class method doStuff()
    } // close outer class
```
A method-local inner class can be instantiated only within the method where the inner class is defined. In other words, no other code running in any other method—inside or outside the outer class—can ever instantiate the method-local inner class. Like regular inner class objects, the method-local inner class object shares a special relationship with the enclosing (outer) class object, and can access its private (or
any other) members. However, the inner class object cannot use the local variables
of the method the inner class is in.
However, the inner class object cannot use the local variables
of the method the inner class is in:
```java
    class MyOuter2 {
        private String x = "Outer2";
        void doStuff() {
            String z = "local variable";
            class MyInner {
                public void seeOuter() {
                    System.out.println("Outer x is " + x);
                    System.out.println("Local variable z is " + z); // Won't Compile!
                } // close inner class method
            } // close inner class definition
        } // close outer class method doStuff()
    } // close outer class
```
Compiling the preceding code really upsets the compiler:
```java
    MyOuter2.java:8: local variable z is accessed from within inner class;
    needs to be declared final
    System.out.println("Local variable z is " + z);
                                                ^
```
Marking the local variable z as final fixes the problem:
```java
    final String z = "local variable"; // Now inner object can use it
```
Para usar una variable local dentro de una clase interna que este dentro de un método como el ejemplo de arriba, debemos de marcar la varibale como final (quedaría como constante) de lo contrario nos marcará error de compulación.

And just a reminder about modifiers within a method: the same rules apply to method-local inner classes as to local variable declarations. You can't, for example, mark a method-local inner class public, private, protected, static, transient, and the like. For the purpose of the exam, the only modifiers you can apply to a method-local inner class are abstract and final, but as always, never both at the same time.

##### exam watch
Remember that a local class declared in a static method has access to only static members of the enclosing class, since there is no associated instance of the enclosing class. If you're in a static method there is no this, so an inner class in a static method is subject to the same restrictions as the static method. In other words, no access to instance variables.
