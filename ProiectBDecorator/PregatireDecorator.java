package ProiectBDecorator;

public abstract class PregatireDecorator implements Pregatire{

	private Pregatire preg;
	
	public PregatireDecorator(Pregatire p) {
		preg=p;
	}
	
	public String print()
	{
		
		return this.getProbleme()+"   ";
	}
	
	
	public String getProbleme() {
		return preg.getProbleme();
	}

	
	public double getPrice(int q) {
		return preg.getPret(q);
	}

	
	public int getOre(int o) {
		return preg.getOre(o);
	}
}
	


