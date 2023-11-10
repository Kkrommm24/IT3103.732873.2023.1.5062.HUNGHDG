package Lab02.src.hunghdg5062;

public class Aims {

	public static void main(String[] args) {
//		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Title Only");
//		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Category", "Title", 19.99f);
//		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Director", "Category", "Title", 14.99f);
//		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Title", "Category", "Director", 120, 24.99f);
		
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Toger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		anOrder.removeDigitalVideoDisc(dvd3);
		
		System.out.println("Total Cost is: ");
		System.out.println(anOrder.totalCost());
	}

}
