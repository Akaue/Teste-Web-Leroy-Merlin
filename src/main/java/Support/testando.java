package Support;

class SimpleStaticExample {

	char ch = 'f';

	// This is a static method
//	public static void myMethod()
//    {
//        System.out.println("myMethod");
//    }
// 
	// This is a non static method
	public void myMethod() {
		System.out.println("myMethod");
	}

	public static void main(String[] args) {

		// chamada do metodo nao statico
		SimpleStaticExample aka = new SimpleStaticExample();
		aka.myMethod();

		// Chamada do metodo statico
		/*
		 * You can see that we are calling this method without creating any object.
		 */
//		myMethod();

		// m�todo de STATIC n�o precisa instanciar a classe para ser chamado
		// m�todo n�o ESTATICO precisa instanciar a classe para chamar o m�todo

		
	}
}
