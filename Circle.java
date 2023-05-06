// Circle
import java.lang.Math;
import java.util.ArrayList;
public class Circle implements Shape {
    public double radius;
    public double x;
    public double y;   
    public Circle(double radius, double x, double y){
        this.radius = radius;
        this.x = x;
        this.y= y;
    }
    @Override
    public double area() {
        return (Math.PI*(this.radius*this.radius));
    }

    @Override
    public double perimeter() {
        return (Math.PI*(this.radius+this.radius));
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
    }
    public double getRadius(){
        return this.radius;
    }
    public void setRadius(double rad){
        this.radius = rad;
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
    @Override
    public String toString(){
        return "Circle Info: \nCentroid Coordinate: ("+this.x + ","+this.y+")" + "\nRadius length: " + this.radius;
    }   
}