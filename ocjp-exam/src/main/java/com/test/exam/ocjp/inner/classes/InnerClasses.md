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

##### Anonymous Inner Classes
The exam is littered with anonymous inner class code: you might see it on questions about threads, wrappers, overriding, garbage collection, and... well, you get the idea.

##### Plain-Old Anonymous Inner Classes, Flavor One
Check out the following legal-but-strange-the-first-time-you-see-it code:

```java
 class Popcorn {
   public void pop() {
     System.out.println("popcorn");
   }
 }
 class Food {
   Popcorn p = new Popcorn() {
     public void pop() {
       System.out.println("anonymous popcorn");
     }
   };
 }
```
Let's look at what's in the preceding code:
* We define two classes, Popcorn and Food.
* Popcorn has one method, pop().
* Food has one instance variable, declared as type Popcorn. That's it for Food. Food has no methods.

And here's the big thing to get

The Popcorn reference variable refers not to an instance of Popcorn, but to an instance of an anonymous (unnamed) subclass of Popcorn.

Let's look at just the anonymous class code:

```java

2.   Popcorn p = new Popcorn() {
3.     public void pop() {
4.       System.out.println("anonymous popcorn");
5.     }
6.   };

```

__Line 2__ Line 2 starts out as an instance variable declaration of type Popcorn. But instead of looking like this:
```java
  Popcorn p = new Popcorn(); // notice the semicolon at the end
```
there's a curly brace at the end of line 2, where a semicolon would normally be.

```java
  Popcorn p = new Popcorn() { // a curly brace, not a semicolon
```
You can read line 2 as saying,

Declare a reference variable, p, of type Popcorn. Then declare a new class that has no name, but that is a subclass of Popcorn. And here's the curly brace that opens the class definition…

__Line 3__ Line 3, then, is actually the first statement within the new class definition. And what is it doing? Overriding the pop() method of the superclass Popcorn. This is the whole point of making an anonymous inner class—to override one or more methods of the superclass! (Or to implement methods of an interface, but we'll save that for a little later.)

__Line 4__ Line 4 is the first (and in this case only) statement within the overriding pop() method. Nothing special there.

__Line 5__ Line 5 is the closing curly brace of the pop() method. Nothing special.

__Line 6__ Here's where you have to pay attention: line 6 includes a curly brace closing off the anonymous class definition (it's the companion brace to the one on line 2), but there's more! Line 6 also has the semicolon that ends the statement started on line 2—the statement where it all began—the statement declaring and initializing the Popcorn reference variable. And what you're left with is a Popcorn reference to a brand-new instance of a brand-new, just-in-time, anonymous (no name) subclass of Popcorn.

![Imgur](https://i.imgur.com/hdoWrli.jpg)

Polymorphism is in play when anonymous inner classes are involved. Remember that, as in the preceding Popcorn example, we're using a superclass reference variable type to refer to a subclass object. What are the implications? You can only call methods on an anonymous inner class reference that are defined in the reference variable type! This is no different from any other polymorphic references, for example,

```java
  class Horse extends Animal{
    void buck() { }
  }
  
  class Animal {
    void eat() { }
  }
  
  class Test {
     public static void main (String[] args) {
        Animal h = new Horse();
        h.eat(); // Legal, class Animal has an eat() method
        h.buck(); // Not legal! Class Animal doesn't have buck()
     }
  }
```
So on the exam, you must be able to spot an anonymous inner class that—
rather than overriding a method of the superclass—defines its own new method. The method definition isn't the problem, though; the real issue is how do you invoke that new method? The reference variable type (the superclass) won't know anything about that new method (defined in the anonymous subclass), so the compiler will complain if you try to invoke any method on an anonymous inner class reference that is not in the superclass class definition.
Check out the following, illegal code:

```java
  class Popcorn {
     public void pop() {
       System.out.println("popcorn");
     }
  }
  class Food {
    Popcorn p = new Popcorn() {
      public void sizzle() {
         System.out.println("anonymous sizzling popcorn");
      }
      public void pop() {
         System.out.println("anonymous popcorn");
      } 
    };
    
    public void popIt() {
       p.pop(); // OK, Popcorn has a pop() method
       p.sizzle(); // Not Legal! Popcorn does not have sizzle()
    }
 }
```
which is the compiler's way of saying, "I can't find method sizzle() in class Popcorn," followed by, "Get a clue."


##### Plain-Old Anonymous Inner Classes, Flavor Two
The only difference between flavor one and flavor two is that flavor one creates an anonymous subclass of the specified class type, whereas flavor two creates an anonymous implementer of the specified interface type. In the previous examples, we defined a new anonymous subclass of type Popcorn as follows:
```java
  Popcorn p = new Popcorn() {
```

But if Popcorn were an interface type instead of a class type, then the new anonymous class would be an implementer of the interface rather than a subclass of the class. Look at the following example:

```java
   interface Cookable {
      public void cook();
   }
   class Food {
      Cookable c = new Cookable() {
         public void cook() {
             System.out.println("anonymous cookable implementer");
         }
      };
   }
```

The preceding code, like the Popcorn example, still creates an instance of an anonymous inner class, but this time the new just-in-time class is an implementer of the Cookable interface. And note that this is the only time you will ever see the syntax

```java
  new Cookable()
```

where Cookable is an interface rather than a nonabstract class type. Because think about it, you can't instantiate an interface, yet that's what the code looks like it's doing. But of course it's not instantiating a Cookable object, it's creating an instance of a new, anonymous, implementer of Cookable. You can read this line:

```java
     Cookable c = new Cookable() {
```

as, "Declare a reference variable of type Cookable that, obviously, will refer to an object from a class that implements the Cookable interface. But, oh yes, we don't yet have a class that implements Cookable, so we're going to make one right here, right now. We don't need a name for the class, but it will be a class that implements Cookable, and this curly brace starts the definition of the new implementing class."

One more thing to keep in mind about anonymous interface implementers—they can implement only one interface. There simply isn't any mechanism to say that your anonymous inner class is going to implement multiple interfaces. In fact, an anonymous inner class can't even extend a class and implement an interface at the same time. The inner class has to choose either to be a subclass of a named class— and not directly implement any interfaces at all—or to implement a single interface. By directly, we mean actually using the keyword implements as part of the class declaration. If the anonymous inner class is a subclass of a class type, it automatically becomes an implementer of any interfaces implemented by the superclass.

![Imgur](https://i.imgur.com/QxKbBOi.jpg)

##### Argument-Defined Anonymous Inner Classes
You simply define an anonymous inner class, right inside the argument. That's right, just where you least expect to find a class. And here's what it looks like:
```java
1. class MyWonderfulClass {
2.   void go() {
3.     Bar b = new Bar();
4.     b.doStuff(new Foo() {
5.       public void foof() {
6.         System.out.println("foofy");
7.       } // end foof method
8.     }); // end inner class def, arg, and b.doStuff stmt.
9.    } // end go()
10. } // end class
11.
12. interface Foo {
13.   void foof();
14. }
15. class Bar {
16.   void doStuff(Foo f) { }
17. }
```

All the action starts on line 4. We're calling doStuff() on a Bar object, but the method takes an instance that IS-A Foo, where Foo is an interface. So we must make both an implementation class and an instance of that class, all right here in the argument to doStuff(). So that's what we do. We write
```java
   new Foo() {
```

to start the new class definition for the anonymous class that implements the Foo interface. Foo has a single method to implement, foof(), so on lines 5, 6, and 7 we implement the foof() method. Then on line 8—whoa!—more strange syntax appears. The first curly brace closes off the new anonymous class definition. But don't forget that this all happened as part of a method argument, so the close parenthesis, ), finishes off the method invocation, and then we must still end the statement that began on line 4, so we end with a semicolon. Study this syntax! You will see anonymous inner classes on the exam, and you'll have to be very, very picky about the way they're closed. If they're argument local, they end like this:

});


but if they're just plain-old anonymous classes, then they end like this:

};

Regardless, the syntax is not what you use in virtually any other part of Java, so be careful. Any question from any part of the exam might involve anonymous inner classes as part of the code.

##### Static Nested Classes

It is simply a non-inner (also called "top-level") class scoped within another. So with static classes it's really more about name-space resolution than about an implicit relationship between the two classes.

A static nested class is simply a class that's a static member of the enclosing class:
```java
  class BigOuter {
     static class Nested { }
  }
```

The class itself isn't really "static"; there's no such thing as a static class. The static modifier in this case says that the nested class is a static member of the outer class. That means it can be accessed, as with other static members, without having an instance of the outer class.

##### Instantiating and Using Static Nested Classes
You use standard syntax to access a static nested class from its enclosing class. The syntax for instantiating a static nested class from a non-enclosing class is a little different from a normal inner class, and looks like this:
```java
  class BigOuter {
    static class Nest {void go() { System.out.println("hi"); } }
  }
  class Broom {
    static class B2 {void goB2() { System.out.println("hi 2"); } }
    public static void main(String[] args) {
      BigOuter.Nest n = new BigOuter.Nest(); // both class names
      n.go();
      B2 b2 = new B2(); // access the enclosed class
      b2.goB2();
    }
  }
```

Which produces
hi
hi 2

##### Watch exam
Just as a static method does not have access to the instance variables and nonstatic methods of the class, a static nested class does not have access to the instance variables and nonstatic methods of the outer class. Look for static nested classes with code that behaves like a nonstatic (regular inner) class.
