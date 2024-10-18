package org.centrale.objet.WoE;

public class TestPoint2D {
    public static void main(String[] args) {
        Point2D p1 = new Point2D(2, 3);
        Point2D p2 = new Point2D(5, 7);

        System.out.println("Point p1 : " + p1);
        System.out.println("Point p2 : " + p2);

        double distance = p1.distanceTo(p2);
        System.out.println("Distance entre p1 et p2 : " + distance);

        p1.setCoordinates(5, 7);
        System.out.println("Nouvelles coordonnées de p1 : " + p1);

        boolean areEqual = p1.equals(p2);
        System.out.println("p1 et p2 sont-ils égaux ? " + areEqual);
    }
}