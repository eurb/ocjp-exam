package com.test.exam.pcj2.inner.classes.This;

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
