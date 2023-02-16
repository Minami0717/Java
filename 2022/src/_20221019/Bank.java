package _20221019;

class Bank {
	double rate() {
		return 0.0;
	}
}

class BadBank extends Bank {

	@Override
	double rate() {
		return 10.0;
	}
	
}

class NormalBank extends Bank {

	@Override
	double rate() {
		return 5.0;
	}
	
}

class GoodBank extends Bank {

	@Override
	double rate() {
		return 3.0;
	}
	
}
