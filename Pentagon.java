// Pentagon Class
import java.lang.Math;
import java.util.ArrayList;
public class Pentagon implements Shape {
    public double sideLength;
    public double x;
    public double y;
    public double r;
    public double topX;
    public double topY;
    public double leftX; // leftmost point x value
    public double leftY; // left most point y value
    public double rightX; // rightmost point x value
    public double rightY; // rightmost y value
    public double bLX; // bottom left point X value
    public double bLY; // bottom left Y value
    public double bRX; // bottom right x
    public double bRY; // bottom right y
    public Pentagon(double sideLength, double x, double y){
        this.sideLength = sideLength;
        this.x = x;
        this.y = y;

        // the four variables z,c,k,h are the rearranged formula to get the radius from the area of the pentagon
        double z = (this.area()*4);
        double c = (5+Math.sqrt(5))/2;
        double k = Math.sqrt(c);
        double h = k*5;
        this.r = Math.sqrt(z/h); // this is the radius of the pentagon from the midpoint

        // These four variables below are used to calculate the points based off the radius
        double cons = this.r*Math.cos(0.314159);
        double sons = this.r*Math.sin(0.314159);
        double cons2 = this.r*Math.cos(0.942478);
        double sons2 = this.r*Math.sin(-0.942478); 
        this.topX = this.x;
        this.topY = this.r + this.y;
        this.rightX = (cons)+this.x;
        this.rightY = (sons)+this.y;
        this.leftX = this.x - (cons);
        this.leftY = this.rightY;
        this.bLX = this.x - cons2;
        this.bLY = this.y + sons2;
        this.bRX = (x+cons2);
        this.bRY = this.bLY;
    }

    @Override
    public double area() {
        return (0.25*(Math.sqrt(5*(5+(2*Math.sqrt(5))))))*(Math.pow(this.sideLength, 2));
    }

    @Override
    public double perimeter() {
        return sideLength*5;
    }
    /**
     * This method moves a shape to another location
     * in relation to its center, by adding the params offsetX and offsetY to its
     * center coordinate.
     * @param offsetX
     * @param offsetY
     */
    public void move(double offsetX, double offsetY){
        this.x = this.x + offsetX;
        this.y = this.y + offsetX;
        double z = (this.area()*4);
        double c = (5+Math.sqrt(5))/2;
        double k = Math.sqrt(c);
        double h = k*5;
        this.r = Math.sqrt(z/h); // this is the radius of the pentagon from the midpoint

        // These four variables below are used to calculate the points based off the radius
        double cons = this.r*Math.cos(0.314159);
        double sons = this.r*Math.sin(0.314159);
        double cons2 = this.r*Math.cos(0.942478);
        double sons2 = this.r*Math.sin(-0.942478); 
        this.topX = this.x;
        this.topY = this.r + this.y;
        this.rightX = (cons)+this.x;
        this.rightY = (sons)+this.y;
        this.leftX = this.x - (cons);
        this.leftY = this.rightY;
        this.bLX = this.x - cons2;
        this.bLY = this.y + sons2;
        this.bRX = (x+cons2);
        this.bRY = this.bLY;
    }
    public ArrayList<Double> getCenter(){
        ArrayList<Double> a = new ArrayList<>();
        a.add(this.x);
        a.add(this.y);
        return a;
    }
    public void setCenter(double sX, double sY){
        this.x = sX;
        this.y = sY;
        double z = (this.area()*4);
        double c = (5+Math.sqrt(5))/2;
        double k = Math.sqrt(c);
        double h = k*5;
        this.r = Math.sqrt(z/h); // this is the radius of the pentagon from the midpoint

        // These four variables below are used to calculate the points based off the radius
        double cons = this.r*Math.cos(0.314159);
        double sons = this.r*Math.sin(0.314159);
        double cons2 = this.r*Math.cos(0.942478);
        double sons2 = this.r*Math.sin(-0.942478); 
        this.topX = this.x;
        this.topY = this.r + this.y;
        this.rightX = (cons)+this.x;
        this.rightY = (sons)+this.y;
        this.leftX = this.x - (cons);
        this.leftY = this.rightY;
        this.bLX = this.x - cons2;
        this.bLY = this.y + sons2;
        this.bRX = (x+cons2);
        this.bRY = this.bLY;
    }
    public void setSideLength(double length){
        this.sideLength = length;
        double z = (this.area()*4);
        double c = (5+Math.sqrt(5))/2;
        double k = Math.sqrt(c);
        double h = k*5;
        this.r = Math.sqrt(z/h); // this is the radius of the pentagon from the midpoint

        // These four variables below are used to calculate the points based off the radius
        double cons = this.r*Math.cos(0.314159);
        double sons = this.r*Math.sin(0.314159);
        double cons2 = this.r*Math.cos(0.942478);
        double sons2 = this.r*Math.sin(-0.942478); 
        this.topX = this.x;
        this.topY = this.r + this.y;
        this.rightX = (cons)+this.x;
        this.rightY = (sons)+this.y;
        this.leftX = this.x - (cons);
        this.leftY = this.rightY;
        this.bLX = this.x - cons2;
        this.bLY = this.y + sons2;
        this.bRX = (x+cons2);
        this.bRY = this.bLY;
    }
    public double getSideLength(){
        return this.sideLength;
    }
    @Override
    public String toString(){
        return "Pentagon Info: \nCentroid Coordinate: ("+this.x + ","+this.y+")" + "\nSide length: " + this.sideLength;
    }   
}
