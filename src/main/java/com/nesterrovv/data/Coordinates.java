package com.nesterrovv.data;

import java.io.Serializable;

public class Coordinates
        implements Serializable, Comparable<Coordinates> {

    private double x; // max value is 690
    private int y;

    public Coordinates() {}

    public Coordinates(double x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (Double.compare(that.x, x) != 0) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int compareTo(Coordinates another) {
        if (Math.pow(this.x, 2) + Math.pow(this.y, 2) - Math.pow(another.x, 2) + Math.pow(another.y, 2) > 0) {
            return 1;
        } else if (Math.pow(this.x, 2) + Math.pow(this.y, 2) - Math.pow(another.x, 2) + Math.pow(another.y, 2) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

}