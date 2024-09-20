/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet;


public class Point2D {
    private int x;
    private int y;
    public Point2D(){
        this.x=0;
        this.y=0;
    }
    public Point2D(int x, int y){
        this.x=x;
        this.y=y;
    }
    public Point2D(Point2D p){
        this.x=p.x;
        this.y=p.y;
    }
    public String toString(){
        return "["+x+";"+y+"]";
        
    }
    public void translate(int deltax, int deltay){
        this.x += deltax;
        this.y+= deltay; 
    }
    public void modifier(int xx, int yy){
        this.x= xx;
        this.y=yy;
    }
    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }
    public void setx(int xx){
        this.x=xx;    
    }
    public void sety(int yy){
        this.y=yy;
    }
    
}