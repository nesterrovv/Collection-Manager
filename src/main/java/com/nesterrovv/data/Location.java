package com.nesterrovv.data;

import java.io.Serializable;
import java.util.Objects;

public class Location
        implements Serializable, Comparable<Location> {

    private double x;
    private float y;
    private String name; // cannot be null

    public Location() {}

    public Location(double x, float y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (Double.compare(location.x, x) != 0) return false;
        if (Float.compare(location.y, y) != 0) return false;
        return Objects.equals(name, location.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (y != 0.0f ? Float.floatToIntBits(y) : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                '}';
    }


    public int compareTo(Location another) {
        if (Math.pow(this.x, 2) + Math.pow(this.y, 2) - Math.pow(another.x, 2) + Math.pow(another.y, 2) > 0) {
            return 1;
        } else if (Math.pow(this.x, 2) + Math.pow(this.y, 2) - Math.pow(another.x, 2) + Math.pow(another.y, 2) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

}