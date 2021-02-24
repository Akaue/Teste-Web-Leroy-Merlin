package Pages;

class asdds {

	public void prog1(String nome) {
		System.out.println("program1: " + nome);
	}

	public void prog2() {
		System.out.println("program2");
	}

	public static void main(String[] args) {

		asdds programa1 = new asdds();
		programa1.prog1("akaue");
		programa1.prog1("dios");

		int age = 10;

		if (age == 12) {
			System.out.println("de menor");
		} else if (age < 18) {
			System.out.println("adolescente");
		} else if (age > 18) {
			System.out.println("adulto");
		}

	}

}
