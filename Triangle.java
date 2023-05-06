// Triangle
import java.util.ArrayList;
public class Triangle implements Shape{
    public double sideLength;
    public double x;
    public double y;
    public double topX; // top right x
    public double topY; // top right y 

    public double lX; // bottom left x
    public double lY; // bottom left y

    public double rX; // bottom right x
    public double rY; // bottom right y
    public Triangle(double sideLength, double x, double y){
        this.sideLength = sideLength;
        this.x = x;
        this.y = y;
        

        // Setting all the points needed for the triangle using the side length and some trig
        this.topX = this.x;
        this.topY = this.y + ((Math.sqrt(3)/3)*this.sideLength);
        this.lX = this.x - (this.sideLength/2);
        this.lY = this.y - ((Math.sqrt(3)/6)*sideLength);
        this.rX = this.x + (this.sideLength/2);
        this.rY = this.lY;
    }

    @Override
    public double area() {
        return (Math.sqrt(3)/4)*(Math.pow(sideLength, 2));
    }

    @Override
    public double perimeter() {
        return sideLength*3;
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
        this.topX = this.x;
        this.topY = this.y + ((Math.sqrt(3)/3)*this.sideLength);
        this.lX = this.x - (this.sideLength/2);
        this.lY = this.y - ((Math.sqrt(3)/6)*sideLength);
        this.rX = this.x + (this.sideLength/2);
        this.rY = this.lY;
    }
    /**
     * This method returns an array list of size two,
     * the first entry being the x value of the centroid,
     * and the second entry being the y value.
     * @return centroid coordinates
     */
    public ArrayList<Double> getCenter(){
        ArrayList<Double> a = new ArrayList<>();
        a.add(this.x);
        a.add(this.y);
        return a;
    }
    /**
     * This method allows one to change the centroid's
     * coordinates to inputted values sX and sY.
     * @param sX
     * @param sY
     */
    public void setCenter(double sX, double sY){
        this.x = sX;
        this.y = sY;
    }
    /**
     * This method allows one to set the side length.
     * @param length
     */
    public void setSideLength(double length){
        this.sideLength = length;
    }
    /**
     * This method returns the side length of the triangle.
     * @return
     */
    public double getSideLength(){
        return this.sideLength;
    }
    @Override
    public String toString(){
        return "Triangle Info: \nCentroid Coordinate: ("+this.x + ","+this.y+")" + "\nSide length: " + this.sideLength;
    }    
}
