// Square
import java.util.ArrayList;
public class Square implements Shape {
    public double sideLength;
    public double x;
    public double y;
    public double topLeftX;
    public double topLeftY;
    public double topRightX;
    public double topRightY;
    public double botLeftX;
    public double botLeftY;
    public double botRightX;
    public double botRightY;

    public Square(double sideLength, double x, double y){
        this.sideLength = sideLength;
        this.x = x;
        this.y = y;
        // Top left point
        this.topLeftX = x - (sideLength/2);
        this.topLeftY = y + (sideLength/2);

        // top right point
        this.topRightX = x + (sideLength/2);
        this.topRightY = topLeftY;

        // bottom left point
        this.botLeftX = topLeftX;
        this.botLeftY = y - (sideLength/2);

        // bottom right point
        this.botRightX = topRightX;
        this.botRightY = botLeftY;
    }

    @Override
    public double area() {
        return Math.pow(sideLength, 2);
    }

    @Override
    public double perimeter() {
        return sideLength*4;
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

        this.topLeftX = x - (sideLength/2);
        this.topLeftY = y + (sideLength/2);

        // top right point
        this.topRightX = x + (sideLength/2);
        this.topRightY = topLeftY;

        // bottom left point
        this.botLeftX = topLeftX;
        this.botLeftY = y - (sideLength/2);

        // bottom right point
        this.botRightX = topRightX;
        this.botRightY = botLeftY;

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
    }
    public void setSideLength(double length){
        this.sideLength = length;
    }
    public double getSideLength(){
        return this.sideLength;
    }
    @Override
    public String toString(){
        return "Square Info: \nCentroid Coordinate: ("+this.x + ","+this.y+")" + "\nSide length: " + this.sideLength;
    }
    
}
