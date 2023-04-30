package scientific;

/*
    Class To Implement Scientific Calculator Functions
    Functions Avalilable: 
    arccos  -> cos inverse
    arcsin  -> sin inverse
    arctan  -> tan inverse
    cos    
    cube    
    cuberoot
    getEValue
    getInverse
    getPiValue
    ln      -> Natural Log Base e
    log     -> Log to base 10
    maximum -> Returns maximum of given element
    minimum -> Returns minimum of given element
    sin
    square
    squareroot
    tan
*/

public class Scientific {
    // Returns the sine of the given value
    public double sin(double val)
    {
        val = Math.toRadians(val);
        return Math.sin(val);
    }
    // Returns the cos of the given value
    public double cos(double val)
    {
        val = Math.toRadians(val);
        return Math.cos(val);
    }
    // Returns the tan of the given value
    public double tan(double val)
    {
        val = Math.toRadians(val);
        return Math.tan(val);
    }

    // Returns the sin inverse of the given values
    public double arcsin(double val)
    {
        val = Math.asin(val);
        val = Math.toDegrees(val);
        return val;
    }
    // Returns the cos inverse of the given value
    public double arccos(double val)
    {
        val = Math.acos(val);
        val = Math.toDegrees(val);
        return val;
    }
    // Returns the tan inverse of the given value
    public double arctan(double val)
    {
        val = Math.atan(val);
        val = Math.toDegrees(val);
        return val;
    }

    // Returns the square root of the given value
    public double sqRoot(double val)
    {
        return Math.sqrt(val);
    }
    // Returns the cube root of  the given value
    public double cubeRoot(double val)
    {
        return Math.cbrt(val);
    }
    // Returns the square of the given value
    public double square(double val)
    {
        return val*val;
    }
    // Returns the cube of the given value
    public double cube(double val)
    {
        return val*val*val;
    }
    // Returns the Natural Log of the given value (Base e)
    public double ln(double val)
    {
        return Math.log(val);
    }
    // Returns the log of the given value (Base 10)
    public double log(double val)
    {
        return Math.log10(val);
    }

    // Get the Maximum value in the given array
    public double maximum(double arr[])
    {
        double max = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }
        return max;
    }
    // Get the minimum value in the given array
    public double minimum(double arr[])
    {
        double min = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i] < min)
            {
                min = arr[i];
            }
        }
        return min;
    }

    // Returns value of PI
    public double getPiValue()
    {
        return Math.PI;
    }

    // Returns the value of e(euler's number)
    public double getEValue()
    {
        return Math.E;
    }

    // Returns the Inverse of the given number
    public double getInverse(double val)
    {
        return (1/val);
    }
}
