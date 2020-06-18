

public class test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		test a = new test();
		System.out.println(a.getTruc());
		a.setTruc(Truc.Est);
		System.out.println(a.getTruc());
		a.nextTruc();
		System.out.println(a.getTruc());
		a.nextTruc();
		System.out.println(a.getTruc());
		a.nextTruc();
		System.out.println(a.getTruc());
		
		
	}
	
	
	enum Truc { 
		North, Est, South, West;
		private static Truc[] vals = values();
		public Truc next() {
			return vals[(this.ordinal() + 1) % vals.length];
			}
		}
	
	private Truc truc;

	
	public test() {
		this.setTruc(Truc.North);
	}
	
	public void nextTruc() {
		this.truc = truc.next();
	}
	
	
	public Truc getTruc() {
		return truc;
	}

	public void setTruc(Truc truc) {
		this.truc = truc;
	}

}
