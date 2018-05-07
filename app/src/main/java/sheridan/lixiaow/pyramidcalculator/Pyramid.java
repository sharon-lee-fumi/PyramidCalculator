package sheridan.lixiaow.pyramidcalculator;

import java.io.Serializable;

/**
 * Created by Sharon on 3/12/2018.
 */

public class Pyramid implements Serializable{

    private int baseN;
    private double baseSide;
    private double height;

    public Pyramid(){ }

    public int getBaseN()
    {
        return baseN;
    }

    public void setBaseN(int baseN) throws IllegalArgumentException
    {
        if (baseN > 2)
        {
            this.baseN = baseN;
        }
        else
        {
            throw new IllegalArgumentException("Number of sides must be more than two");
        }
    }

    public double getBaseSide()
    {
        return baseSide;
    }

    public void setBaseSide(double baseSide) throws IllegalArgumentException
    {
        if (baseSide > 0)
        {
            this.baseSide = baseSide;
        }
        else
        {
            throw new IllegalArgumentException("Side length must be positive");
        }
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height) throws IllegalArgumentException
    {
        if (height > 0)
        {
            this.height = height;
        }
        else
        {
            throw new IllegalArgumentException("Height must be positive");
        }
    }

    public double getBaseArea()
    {
        double baseArea = this.baseN * Math.pow(this.baseSide, 2) / (4 * Math.tan(Math.PI / this.baseN));
        return baseArea;
    }

    public double getVolume()
    {
        double volumn = getBaseArea() * this.height / 3;
        return volumn;
    }
}
