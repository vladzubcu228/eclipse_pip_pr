package ProiectBDecorator;

public class PregatireFinaluri extends PregatireDecorator{

	public PregatireFinaluri(Pregatire p) {
		super(p);
		
	}

	public String getProbleme() {
		return super.getProbleme()+"plus Finaluri Teoretice";
	};
	
	public double getPret(int q) {
		double pret=0;
                if(q==1)
		pret=50;
		if(q==2)
		pret=100;
		if(q==3)
		pret=150;
		
		return pret;
	};
	
	public int getOre(int o) {
		return super.getOre(o);
		
	}

	
	public String print() {
		
		return super.print();
	};

}

