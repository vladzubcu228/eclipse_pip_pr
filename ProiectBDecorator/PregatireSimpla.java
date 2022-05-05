package ProiectBDecorator;

public class PregatireSimpla implements Pregatire
{

public double getPret(int q){

return q;
}

public int getOre(int o) {
		return o;
	}

	public String getProbleme() {
		return "Contine Probleme de calcul ";
	}
 public String print() {
		return this.getProbleme()+"   ";
	}
}
