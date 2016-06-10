package engine.physics;

public class Vector {
	
	private double xComp;
	private double yComp;
	
	public Vector(double x, double y){
		this.xComp = x;
		this.yComp = y;
	}
	
	public double getMagnitude(){
		return Math.sqrt(Math.pow(xComp, 2) + Math.pow(yComp, 2));
	}
	
	public double dotProduct(Vector other){
		return this.xComp * other.xComp + this.yComp * other.yComp;
	}

	public double getxComp() {
		return xComp;
	}

	public double getyComp() {
		return yComp;
	}
	
	public Vector scalarMultiply(double scalar){
		return new Vector(this.xComp * scalar, this.yComp * scalar);
	}
	
	public Vector getOppositeVector(){
		return new Vector(-this.xComp, -this.yComp);
	}
	
	public Vector normalize(){
		return new Vector(this.xComp / this.getMagnitude(), this.yComp / this.getMagnitude());
	}
	
	public String toString(){
		return "Vector[x="+getxComp()+",y="+getyComp()+"]";
	}
	
}
