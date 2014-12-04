package eksam_Martin_mõek;

public class Pood {
	
	private static int avamisAeg;
	private static int sulgemisAeg;
	private static int külastus;
	
	public void Aeg() {
		this.setAvamisAeg(9);
		this.setSulgemisAeg(21);
		
		
	}

	public static int getAvamisAeg() {
		return avamisAeg;
	}

	public void setAvamisAeg(int avamisAeg) {
		this.avamisAeg = avamisAeg;
	}

	public static int getSulgemisAeg() {
		return sulgemisAeg;
	}

	public void setSulgemisAeg(int sulgemisAeg) {
		this.sulgemisAeg = sulgemisAeg;
	}

	public static int getKülastus() {
		return külastus;
	}

	public static void setKülastus(int külastus) {
		Pood.külastus = külastus;
	}
	
	

	
}