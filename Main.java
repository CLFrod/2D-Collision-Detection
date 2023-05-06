// Main Class, and Test code below
// Code Could be cleaner, but lots of Ctrl c + ctrl v was used in the effort to finish it faster
public class Main {
    /**
     * This method tests if two circles are overlapping.
     * @param a
     * @param b
     * @return True if the two shapes are overlapping, false if otherwise.
     */
    public static boolean overlap(Circle a, Circle b){
        // distance from one circle centroid to another
        double d = Math.sqrt(Math.pow(b.y-a.y,2)+Math.pow(a.x-b.x,2));
        // logic if the distance is lesser than both radii added then they're overlapping
        if(d < (a.radius + b.radius)){
            return true;
        }
        else{
            return false;
        }
    } // Circle to Circle

    /**
     * This method tests if a triangle and a circle are overlapping.
     * @param ak
     * @param bk
     * @return True if the two shapes are overlapping, false if otherwise.
     */
    public static boolean overlap(Triangle ak, Circle bk){
        // measuring distance from all points to circle center
        double dTTop = Math.sqrt(Math.pow(bk.y-ak.topY,2)+Math.pow(ak.topX-bk.x,2));
        double dTBotL = Math.sqrt(Math.pow(bk.y-ak.lY,2)+Math.pow(ak.lX-bk.x,2));
        double dTBotR = Math.sqrt(Math.pow(bk.y-ak.rY,2)+Math.pow(ak.rX-bk.x,2));
        if (dTTop < bk.radius || dTBotR < bk.radius || dTBotL < bk.radius){
            return true;
        } // Base case if the distance from one of the three points to the center of the circle is less than the radius of the circle

        double[] pointsTX = {ak.topX,ak.rX,ak.lX};
        double[] pointsTY = {ak.topY,ak.rY,ak.lY};

        // Vector from circle to triangle centroid
        double tToCX = bk.x - ak.x;
        double tToCY = bk.y - ak.y;

        Double nMax = Double.NEGATIVE_INFINITY; 
        // Normalizing the vector from the circle center to triangle centroid
        double normal = Math.pow(tToCX, 2) + Math.pow(tToCY, 2);
        double magnitude = Math.sqrt(normal);  
        double tToCXN = tToCX/magnitude; 
        double tToCYN = tToCY/magnitude;
        for(int i = 0; i<pointsTX.length; i++){ // Iterating and prejecting through the points 
            double vx = pointsTX[i] - ak.x;  // subtracting the value of each point by its centroid
            double vy = pointsTY[i] - ak.y;  // creating new vectors
            double projx = (vx * tToCXN) + (vy * tToCYN); // creating the projection from the normalised vectors
            if (nMax < projx) nMax = projx; // nMax will always be leser than projx, so it can take one a new value.
            // once iterated nMax should be the smallest projected vector from the triangle to the circle
        }
        // if the magnitude of the normalized vector subtracted by the smallest projected value minus the radius of the circle is > 0 then they're not colliding
        if (magnitude - nMax - bk.radius > 0 && magnitude > 0){
            return false;
        }
        else{ // Otherwise they are colliding
           return true;
        }
        // THE PROCESS FOR EVERY OTHER POLYGON TO CIRCLE COLLISION TEST IS THE SAME
    }   // Triangle to Circle

    /**
     * This method tests if a Square and a Circle are overlapping.
     * @param a
     * @param b
     * @return True if the two shapes are overlapping, false if otherwise.
     */
    public static boolean overlap(Square a , Circle b){
        // measuring distance from all points to circle center
        double dSTopL = Math.sqrt(Math.pow(b.y-a.topLeftY,2)+Math.pow(a.topLeftX-b.x,2));
        double dSTopR = Math.sqrt(Math.pow(b.y-a.topRightY,2)+Math.pow(a.topRightX-b.x,2));
        double dSBotL = Math.sqrt(Math.pow(b.y-a.botLeftY,2)+Math.pow(a.botLeftX-b.x,2));
        double dSBotR =Math.sqrt(Math.pow(b.y-a.botRightY,2)+Math.pow(a.botRightX-b.x,2));
        // logic to tell if the distance from the points are closer to center than radius size
        if (dSBotL < b.radius || dSTopL < b.radius || dSBotR < b.radius || dSTopR < b.radius){
            return true;
        }
        double[] pointSX = {a.topRightX,a.botRightX,a.botLeftX,a.topLeftX}; 
        double[] pointSY = {a.topRightY,a.botRightY,a.botLeftY,a.topLeftY};

        double tToCX = b.x - a.x;
        double tToCY = b.y - a.y;
        Double nMax = Double.NEGATIVE_INFINITY;
        // Normalizing the vector from the circle center to square centroid
        double normal = Math.pow(tToCX, 2) + Math.pow(tToCY, 2);
        double magnitude = Math.sqrt(normal);  
        double tToCXN = tToCX/magnitude;
        double tToCYN = tToCY/magnitude;
        for(int i = 0;i<pointSX.length;i++){
            double vx = pointSX[i] - a.x;
            double vy = pointSY[i] - a.y;
            double projx = (vx * tToCXN) + (vy * tToCYN);
            if (nMax < projx) nMax = projx;
            
        }
        if (magnitude - nMax - b.radius > 0 && magnitude > 0){
            return false;
        }
        else{
           return true;
        }

    } // Square to Circle

    /**
     * This method tests if a Pentagon and a Circle are overlapping.
     * @param a
     * @param b
     * @return True if the two shapes are overlapping, false if otherwise.
     */
    public static boolean overlap(Pentagon a, Circle b){
        // measuring distance from all points to circle center
        double dTop = Math.sqrt(Math.pow(b.y - a.topY,2)+Math.pow(a.topX-b.x,2));
        double dleft = Math.sqrt(Math.pow(b.y-a.leftY,2)+Math.pow(a.leftX-b.x,2));
        double dright = Math.sqrt(Math.pow(b.y-a.rightY,2)+Math.pow(a.rightX-b.x,2));
        double dBL = Math.sqrt(Math.pow(b.y-a.bLY,2)+Math.pow(a.bLX-b.x,2));
        double dBR = Math.sqrt(Math.pow(b.y-a.bRY,2)+Math.pow(a.bRX-b.x,2));
        // logic to tell if the distance from the points are closer to center than radius size
        if (dTop < b.radius || dleft < b.radius || dright < b.radius || dBL < b.radius || dBR < b.radius){
            return true;
        }
        double[] pointPBX = {a.topX,a.rightX,a.bRX,a.bLX,a.leftX};
        double[] pointPBY = {a.topX,a.rightY,a.bRY,a.bLY,a.leftY};
        double tToCX = b.x - a.x;
        double tToCY = b.y - a.y;
        Double nMax = Double.NEGATIVE_INFINITY;
        double normal = Math.pow(tToCX, 2) + Math.pow(tToCY, 2);
        double magnitude = Math.sqrt(normal);  
        double tToCXN = tToCX/magnitude;
        double tToCYN = tToCY/magnitude;
        for(int i = 0;i<pointPBX.length;i++){
            double vx = pointPBX[i] - a.x;
            double vy = pointPBY[i] - a.y;
            double projx = (vx * tToCXN) + (vy * tToCYN);
            if (nMax < projx) nMax = projx;
            
        }
        if (magnitude - nMax - b.radius > 0 && magnitude > 0){
            return false;
        }
        else{
           return true;
        }
    } // Pentagon to Circle
    
    /**
     * This method tests if a Triangle and a Square are overlapping.
     * @param a
     * @param b
     * @return True if the two shapes are overlapping, false if otherwise.
     */
    public static boolean overlap(Triangle a, Square b){
        // initializing vectors
        // from bottom right to top point
        double e1x= a.topX - a.rX;
        double e1y = a.topY - a.rY;

        // from bottom right to the left point
        double e2x = a.lX - a.rX;
        double e2y = a.lY - a.rY;

        // from left point to top
        double e3x = a.topX - a.lX;
        double e3y = a.topY - a.lY;

        // All perpendicular vectors for Triangle A
        double e1px = -e1y;
        double e1py = e1x;
        double e2px = -e2y;
        double e2py = e2x;
        double e3px = -e3y;
        double e3py = e3x;

        
        // Square B setup
        double e1sx = b.botRightX - b.topRightX;
        double e1sy = b.botRightY - b.topRightY;

        double e2sx = b.botLeftX - b.botRightX;
        double e2sy = b.botLeftY - b.botRightY;

        double e3sx = b.topLeftX - b.botLeftX;
        double e3sy = b.topLeftY - b.botLeftY;

        double e4sx = b.topRightX - b.topLeftX;
        double e4sy = b.topRightY - b.topLeftY;
        // All perpendicular vectors for Square B
        double e1pSx = -e1sy;
        double e1pSy = e1sx;
        double e2pSx = -e2sy;
        double e2pSy = e2sx;
        double e3pSx = -e3sy;
        double e3pSy = e3sx;
        double e4pSx = -e4sy;
        double e4pSy = e4sx;
        // arrays for points + perp edge vectors
        double[] pointsTX = {a.topX,a.rX,a.lX};
        double[] pointsTY = {a.topY,a.rY,a.lY};
        double[] pointSX = {b.topRightX,b.botRightX,b.botLeftX,b.topLeftX}; 
        double[] pointSY = {b.topRightY,b.botRightY,b.botLeftY,b.topLeftY};
        double[] perpendicularLinesX = {e1px,e2px,e3px,e1pSx,e2pSx,e3pSx,e4pSx};
        double[] perpendicularLinesY = {e1py,e2py,e3py,e1pSy,e2pSy,e3pSy,e4pSy};



        // projection time:
        for(int i = 0; i < perpendicularLinesX.length;i++){
            Double amin = null;
            Double amax = null;
            Double bmin = null;
            Double bmax = null;
            for(int k = 0;k<pointsTX.length;k++){
                double projP = (pointsTX[k] * perpendicularLinesX[i]) + (pointsTY[k] * perpendicularLinesY[i]); 
                if (amax == null || projP > amax){
                    amax = projP;
                }
                if (amin == null || amin > projP){
                    amin = projP;
                }
            }
            for(int l = 0; l<pointSX.length;l++){
                double projb = ((pointSX[l]*perpendicularLinesX[i])+(pointSY[l]*perpendicularLinesY[i]));
                if(bmax == null||projb > bmax){
                    bmax = projb;
                }
                if(bmin == null || bmin > projb){
                    bmin = projb;
                }
            }
            if((amin < bmax && amin > bmin)||(bmin < amax && bmin > amin)){
                continue;
            }
            else{
                return false;
            }
        }
       return true;
    }// Triangle to square

    /**
     * This method tests if a Triangle and a Pentagon are overlapping.
     * @param a
     * @param b
     * @return True if the two shapes are overlapping, false if otherwise.
     */
    public static boolean overlap(Triangle a, Pentagon b){
        // Triangle A
        // Edge Vectors
        // from bottom right to top point
        double e1x= a.topX - a.rX;
        double e1y = a.topY - a.rY;
 
        // from bottom right to the left point
        double e2x = a.lX - a.rX;
        double e2y = a.lY - a.rY;
 
        // from left point to top
        double e3x = a.topX - a.lX;
        double e3y = a.topY - a.lY;
 
        // All perpendicular vectors for Triangle A
        double e1px = -e1y;
        double e1py = e1x;
        double e2px = -e2y;
        double e2py = e2x;
        double e3px = -e3y;
        double e3py = e3x;

        // Pentagon B
        // Edge Vectors
        double e1Px = b.rightX - b.topX;
        double e1Py = b.rightY - b.topY;

        double e2Px = b.bRX - b.rightX;
        double e2Py = b.bRY -b.rightY;

        double e3Px = b.bLX - b.bRX;
        double e3Py = b.bLY - b.bRY;

        double e4Px = b.leftX - b.bLX;
        double e4Py = b.leftY -b.bLY;

        double e5Px = b.topX-b.leftX;
        double e5Py = b.topY-b.leftY;
        // Edge Vectors Perpendicular
        double e1pbx = -e1Py;
        double e1pby = e1Px;
        double e2pbx = -e2Py;
        double e2pby = e2Px;
        double e3pbx = -e3Py;
        double e3pby = e3Px;
        double e4pbx = -e4Py;
        double e4pby = e4Px;
        double e5pbx = -e5Py;
        double e5pby = e5Px;


        double[] pointPBX = {b.topX,b.rightX,b.bRX,b.bLX,b.leftX};
        double[] pointPBY = {b.topX,b.rightY,b.bRY,b.bLY,b.leftY};
        double[] pointsTX = {a.topX,a.rX,a.lX};
        double[] pointsTY = {a.topY,a.rY,a.lY};
        double[] perpendicularLinesX = {e1px,e2px,e3px,e1pbx,e2pbx,e3pbx,e4pbx,e5pbx};
        double[] perpendicularLinesY = {e1py,e2py,e3py,e1pby,e2pby,e3pby,e4pby,e5pby};

        for(int i = 0; i < perpendicularLinesX.length;i++){
            Double amin = null;
            Double amax = null;
            Double bmin = null;
            Double bmax = null;
            for(int k = 0;k<pointsTX.length;k++){
                double projP = (pointsTX[k] * perpendicularLinesX[i]) + (pointsTY[k] * perpendicularLinesY[i]); 
                if (amax == null || projP > amax){
                    amax = projP;
                }
                if (amin == null || amin > projP){
                    amin = projP;
                }
            }
            for(int l = 0; l<pointPBX.length;l++){
                double projb = ((pointPBX[l]*perpendicularLinesX[i])+(pointPBY[l]*perpendicularLinesY[i]));
                if(bmax == null||projb > bmax){
                    bmax = projb;
                }
                if(bmin ==null || bmin > projb){
                    bmin = projb;
                }
            }
            if((amin < bmax && amin > bmin)||(bmin < amax && bmin > amin)){
                continue;
            }
           else{
                return false;
            }
        }
        return true;
    } // Triangle to Pentagon

    /**
     * This method tests if two Triangles are overlapping.
     * @param a
     * @param b
     * @return True if the two shapes are overlapping, false if otherwise.
     */
    public static boolean overlap(Triangle a, Triangle b){
        // Triangle A
        // from bottom right to top point
        double e1x= a.topX - a.rX;
        double e1y = a.topY - a.rY;
 
        // from bottom right to the left point
        double e2x = a.lX - a.rX;
        double e2y = a.lY - a.rY;
 
        // from left point to top
        double e3x = a.topX - a.lX;
        double e3y = a.topY - a.lY;
 
        // All perpendicular vectors for Triangle A
        double e1px = -e1y;
        double e1py = e1x;
        double e2px = -e2y;
        double e2py = e2x;
        double e3px = -e3y;
        double e3py = e3x;


        // Triangle B
        // from bottom right to top point
        double e1bx= b.topX - b.rX;
        double e1by = b.topY - b.rY;
 
        // from bottom right to the left point
        double e2bx = b.lX - b.rX;
        double e2by = b.lY - b.rY;
 
        // from left point to top
        double e3bx = b.topX - b.lX;
        double e3by = b.topY - b.lY;
 
        // All perpendicular vectors for Triangle A
        double e1pbx = -e1by;
        double e1pby = e1bx;
        double e2pbx = -e2by;
        double e2pby = e2bx;
        double e3pbx = -e3by;
        double e3pby = e3bx; 



        double[] pointsTX = {a.topX,a.rX,a.lX};
        double[] pointsTY = {a.topY,a.rY,a.lY};
        double[] pointsTBX = {b.topX,b.rX,b.lX};
        double[] pointsTBY = {b.topY,b.rY,b.lY};
        double[] perpendicularLinesX = {e1px,e2px,e3px,e1pbx,e2pbx,e3pbx};
        double[] perpendicularLinesY = {e1py,e2py,e3py,e1pby,e2pby,e3pby};
        // Projection + conditionals
        for(int i = 0; i < perpendicularLinesX.length;i++){
            Double amin = null;
            Double amax = null;
            Double bmin = null;
            Double bmax = null;
            for(int k = 0;k<pointsTX.length;k++){
                double projP = (pointsTX[k] * perpendicularLinesX[i]) + (pointsTY[k] * perpendicularLinesY[i]); 
                if (amax == null || projP > amax){
                    amax = projP;
                }
                if (amin == null || amin > projP){
                    amin = projP;
                }
            }
            for(int l = 0; l<pointsTBX.length;l++){
                double projb = ((pointsTBX[l]*perpendicularLinesX[i])+(pointsTBY[l]*perpendicularLinesY[i]));
                if(bmax == null||projb > bmax){
                    bmax = projb;
                }
                if(bmin ==null || bmin > projb){
                    bmin = projb;
                }
            }
            if((amin < bmax && amin > bmin)||(bmin < amax && bmin > amin)){
                continue;
            }
           else{
                return false;
            }
        }

       return true;
    } // Triangle to triangle complete

     /**
     * This method tests if two Squares are overlapping.
     * @param a
     * @param b
     * @return True if the two shapes are overlapping, false if otherwise.
     */
    public static boolean overlap(Square a, Square b){
        // Square A
        double e1sax = a.botRightX - a.topRightX;
        double e1say = a.botRightY - a.topRightY;

        double e2sax = a.botLeftX - a.botRightX;
        double e2say = a.botLeftY - a.botRightY;

        double e3sax = a.topLeftX - a.botLeftX;
        double e3say = a.topLeftY - a.botLeftY;

        double e4sax = a.topRightX - a.topLeftX;
        double e4say = a.topRightY - a.topLeftY;
        // Square A perp vectors
        double e1paSx = -e1say;
        double e1paSy = e1sax;
        double e2paSx = -e2say;
        double e2paSy = e2sax;
        double e3paSx = -e3say;
        double e3paSy = e3sax;
        double e4paSx = -e4say;
        double e4paSy = e4sax;

        // Square B setup
        double e1sx = b.botRightX - b.topRightX;
        double e1sy = b.botRightY - b.topRightY;

        double e2sx = b.botLeftX - b.botRightX;
        double e2sy = b.botLeftY - b.botRightY;

        double e3sx = b.topLeftX - b.botLeftX;
        double e3sy = b.topLeftY - b.botLeftY;

        double e4sx = b.topRightX - b.topLeftX;
        double e4sy = b.topRightY - b.topLeftY;


        // All perpendicular vectors for Square B
        double e1pSx = -e1sy;
        double e1pSy = e1sx;
        double e2pSx = -e2sy;
        double e2pSy = e2sx;
        double e3pSx = -e3sy;
        double e3pSy = e3sx;
        double e4pSx = -e4sy;
        double e4pSy = e4sx;

        // arrays for points + perpendicular vectors
        double[] pointSAX = {a.topRightX,a.botRightX,a.botLeftX,a.topLeftX};
        double[] pointSAY = {a.topRightY,a.botRightY,a.botLeftY,a.topLeftY};
        double[] pointSX = {b.topRightX,b.botRightX,b.botLeftX,b.topLeftX}; 
        double[] pointSY = {b.topRightY,b.botRightY,b.botLeftY,b.topLeftY};
        double[] perpendicularLinesX = {e1paSx,e2paSx,e3paSx,e4paSx,e1pSx,e2pSx,e3pSx,e4pSx};
        double[] perpendicularLinesY = {e1paSy,e2paSy,e3paSy,e4paSy,e1pSy,e2pSy,e3pSy,e4pSy};

         // projection time babyyyy: + logic
         for(int i = 0; i < perpendicularLinesX.length;i++){
            Double amin = null;
            Double amax = null;
            Double bmin = null;
            Double bmax = null;
            for(int k = 0;k<pointSAX.length;k++){
                double projP = (pointSAX[k] * perpendicularLinesX[i]) + (pointSAY[k] * perpendicularLinesY[i]); // Creating projected vectors 
                if (amax == null || projP > amax){ // the initial values can't be zero, thus I chose null, 
                    amax = projP; // iterating and finding max and min projected points onto the vectors
                }
                if (amin == null || amin > projP){
                    amin = projP; 
                }
            }
            for(int l = 0; l<pointSX.length;l++){ // Same thing as above but for other shapes
                double projb = ((pointSX[l]*perpendicularLinesX[i])+(pointSY[l]*perpendicularLinesY[i]));
                if(bmax == null||projb > bmax){
                    bmax = projb;
                }
                if(bmin ==null || bmin > projb){
                    bmin = projb;
                }
            }
            if((amin < bmax && amin > bmin)||(bmin < amax && bmin > amin)){ // checking all projections for a space between them
                continue; // continue the iteration if so
            }
           else{ // otherwise if they are not touching 
                return false; // returns false
            }
        }
       return true; // return true if there is somewhere they are colliding 
    }// Square to Square

     /**
     * This method tests if a Square and a Pentagon are overlapping.
     * @param a
     * @param b
     * @return True if the two shapes are overlapping, false if otherwise.
     */
    public static boolean overlap(Square a, Pentagon b){
        // Square A
        double e1sax = a.botRightX - a.topRightX;
        double e1say = a.botRightY - a.topRightY;

        double e2sax = a.botLeftX - a.botRightX;
        double e2say = a.botLeftY - a.botRightY;

        double e3sax = a.topLeftX - a.botLeftX;
        double e3say = a.topLeftY - a.botLeftY;

        double e4sax = a.topRightX - a.topLeftX;
        double e4say = a.topRightY - a.topLeftY;
        // Square A perpendicular vectors
        double e1paSx = -e1say;
        double e1paSy = e1sax;
        double e2paSx = -e2say;
        double e2paSy = e2sax;
        double e3paSx = -e3say;
        double e3paSy = e3sax;
        double e4paSx = -e4say;
        double e4paSy = e4sax;

        // Pentagon B 
        // Edge Vectors
        double e1Px = b.rightX - b.topX;
        double e1Py = b.rightY - b.topY;

        double e2Px = b.bRX - b.rightX;
        double e2Py = b.bRY -b.rightY;

        double e3Px = b.bLX - b.bRX;
        double e3Py = b.bLY - b.bRY;

        double e4Px = b.leftX - b.bLX;
        double e4Py = b.leftY -b.bLY;

        double e5Px = b.topX-b.leftX;
        double e5Py = b.topY-b.leftY;
        // Edge Vectors  Perpendicular
        double e1pbx = -e1Py;
        double e1pby = e1Px;
        double e2pbx = -e2Py;
        double e2pby = e2Px;
        double e3pbx = -e3Py;
        double e3pby = e3Px;
        double e4pbx = -e4Py;
        double e4pby = e4Px;
        double e5pbx = -e5Py;
        double e5pby = e5Px;


        // Creating arrays to make it easier to loop through
        double[] pointSAX = {a.topRightX,a.botRightX,a.botLeftX,a.topLeftX};
        double[] pointSAY = {a.topRightY,a.botRightY,a.botLeftY,a.topLeftY};
        double[] pointPBX = {b.topX,b.rightX,b.bRX,b.bLX,b.leftX};
        double[] pointPBY = {b.topX,b.rightY,b.bRY,b.bLY,b.leftY};
        double[] perpendicularLinesX = {e1paSx,e2paSx,e3paSx,e4paSx,e1pbx,e2pbx,e3pbx,e4pbx,e5pbx};
        double[] perpendicularLinesY = {e1paSy,e2paSy,e3paSy,e4paSy,e1pby,e2pby,e3pby,e4pby,e5pby};

        // projection time once again + logic
        for(int i = 0; i < perpendicularLinesX.length;i++){
            Double amin = null;
            Double amax = null;
            Double bmin = null;
            Double bmax = null;
            for(int k = 0;k<pointSAX.length;k++){
                double projP = (pointSAX[k] * perpendicularLinesX[i]) + (pointSAY[k] * perpendicularLinesY[i]); 
                if (amax == null || projP > amax){
                    amax = projP;
                }
                if (amin == null || amin > projP){
                    amin = projP;
                }
            }
            for(int l = 0; l<pointPBX.length;l++){
                double projb = ((pointPBX[l]*perpendicularLinesX[i])+(pointPBY[l]*perpendicularLinesY[i]));
                if(bmax == null||projb > bmax){
                    bmax = projb;
                }
                if(bmin ==null || bmin > projb){
                    bmin = projb;
                }
            }
            if((amin < bmax && amin > bmin)||(bmin < amax && bmin > amin)){
                continue;
            }
           else{
                return false;
            }
        }
        return true;
    } // Square to Pentagon
    
     /**
     * This method tests if two Pentagons are overlapping.
     * @param a
     * @param b
     * @return True if the two shapes are overlapping, false if otherwise.
     */
    public static boolean overlap(Pentagon a, Pentagon b){
        // Pentagon A
        // Edge Vectors
        double e1PAx = a.rightX - a.topX;
        double e1PAy = a.rightY - a.topY;

        double e2PAx = a.bRX - a.rightX;
        double e2PAy = a.bRY -a.rightY;

        double e3PAx = a.bLX - a.bRX;
        double e3PAy = a.bLY - a.bRY;

        double e4PAx = a.leftX - a.bLX;
        double e4PAy = a.leftY - a.bLY;

        double e5PAx = a.topX - a.leftX;
        double e5PAy = a.topY - a.leftY;
        
        // Edge Vectors Perpendicular
        double e1pax = -e1PAy;
        double e1pay = e1PAx;
        double e2pax = -e2PAy;
        double e2pay = e2PAx;
        double e3pax = -e3PAy;
        double e3pay = e3PAx;
        double e4pax = -e4PAy;
        double e4pay = e4PAx;
        double e5pax = -e5PAy;
        double e5pay = e5PAx;

        // Pentagon B 
        // Edge Vectors
        double e1Px = b.rightX - b.topX;
        double e1Py = b.rightY - b.topY;

        double e2Px = b.bRX - b.rightX;
        double e2Py = b.bRY - b.rightY;

        double e3Px = b.bLX - b.bRX;
        double e3Py = b.bLY - b.bRY;

        double e4Px = b.leftX - b.bLX;
        double e4Py = b.leftY - b.bLY;

        double e5Px = b.topX- b.leftX;
        double e5Py = b.topY- b.leftY;
        // Edge Vectors Perpendicular
        double e1pbx = -e1Py;
        double e1pby = e1Px;
        double e2pbx = -e2Py;
        double e2pby = e2Px;
        double e3pbx = -e3Py;
        double e3pby = e3Px;
        double e4pbx = -e4Py;
        double e4pby = e4Px;
        double e5pbx = -e5Py;
        double e5pby = e5Px;
        // Points + vectors
        double[] pointPAX = {a.topX,a.rightX,a.bRX,a.bLX,a.leftX};
        double[] pointPAY = {a.topX,a.rightY,a.bRY,a.bLY,a.leftY};
        double[] pointPBX = {b.topX,b.rightX,b.bRX,b.bLX,b.leftX};
        double[] pointPBY = {b.topX,b.rightY,b.bRY,b.bLY,b.leftY};
        double[] perpendicularLinesX = {e1pax,e2pax,e3pax,e4pax,e5pax,e1pbx,e2pbx,e3pbx,e4pbx,e5pbx};
        double[] perpendicularLinesY = {e1pay,e2pay,e3pay,e4pay,e5pay,e1pby,e2pby,e3pby,e4pby,e5pby};

        // projection time once again
        for(int i = 0; i < perpendicularLinesX.length;i++){
            Double amin = null;
            Double amax = null;
            Double bmin = null;
            Double bmax = null;
            for(int k = 0;k<pointPAX.length;k++){
                double projP = (pointPAX[k] * perpendicularLinesX[i]) + (pointPAY[k] * perpendicularLinesY[i]); 
                if (amax == null || projP > amax){
                    amax = projP;
                }
                if (amin == null || amin > projP){
                    amin = projP;
                }
            }
            for(int l = 0; l<pointPBX.length;l++){
                double projb = ((pointPBX[l]*perpendicularLinesX[i])+(pointPBY[l]*perpendicularLinesY[i]));
                if(bmax == null||projb > bmax){
                    bmax = projb;
                }
                if(bmin == null || bmin > projb){
                    bmin = projb;
                }
            }
            if((amin < bmax && amin > bmin)||(bmin < amax && bmin > amin)){
                continue;
            }
           else{
                return false;
            }
        }

        return true;
    } // Pentagon to Pentagon done

    public static void main(String[] args) {
        // Test some of it out!!
        // I'm quite sure it all works correctly!
        Pentagon o = new Pentagon(5, 3, 2);
        Pentagon o2 = new Pentagon(3, 0, 2);
        Square b = new Square(2, 5, 5);
        Square b1 = new Square(3, 5, 5);
        Circle z = new Circle(0.69, 3, 4);
        Circle q = new Circle(1, 3, 5);
        Triangle r = new Triangle(2, 5, 5);
        System.out.println(overlap(o, z));
        System.out.println(overlap(o, o2));
        System.out.println(o.area());
        System.out.println(o2.perimeter());
        System.out.println(overlap(r,q));
        System.out.println(b.area());
        System.out.println(r);
        System.out.println(overlap(r, q));
        System.out.println("Moving Triangle r by (X+5, Y+5)!");
        r.move(5, 5);
        System.out.println(overlap(r,q));
        System.out.println(overlap(b1, b));
    }
}
