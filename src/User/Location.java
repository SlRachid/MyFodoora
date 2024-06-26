package User;

public class Location implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6942164591492276184L;
	double x ;
	double y ;

	public Location(double x,double y) {
		this.x = x ;
		this.y = y ;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	@Override
	public String toString(){
		return("[x = " + x + ", y = " + y +"]");
	}
}
