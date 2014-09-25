import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

Bacteria [] colony;
 public void setup()   
 {     
 	size(300,300);
 	//initialize bacteria variables here   
 	colony = new Bacteria[20 ];
 	for (int i = 0; i < colony.length; i++)
 	{
 		colony[i] = new Bacteria(150,150);
 	}
 }   
 public void draw()   
 {   
 	background(255,255,255);
 	//move and show the bacteria   
 	for (int i = 0; i < colony.length; i++)
 	{
 		colony[i].show();
 		colony[i].move(); 	
 		colony[i].mousePressed();
 	}
 } 
 class Bacteria    
 {  
 	int myColor;   
 	int germX; 
 	int germY;
 	int dir;
 	int dir2;
 	Bacteria(int x, int y)
 	{
 		int myColor = (int)(Math.random()*255);
 		germX = x;
 		germY = y; 
 		dir = 5;
 		dir2 = 2;	
 	}
 	public void show()
 	{
 		int myColor = (int)(Math.random()*255);
 		int siz = (int)(Math.random()*18)-9;
 		for (int i = 0; i<colony.length; i++)
 		{
 			fill(myColor,myColor,myColor,25);
 			ellipse(germX,germY,siz,siz);
 		}
 		//if(mousePressed)
 	}
 	public void move() 
 	{
 		
 		germX = germX + (int)(Math.random()*dir)-dir2;
 		germY = germY + (int)(Math.random()*dir)-dir2;
 	}
 	public void mousePressed()
 	{
 	noStroke();
 	fill(0,255,0);
 	ellipse(mouseX,mouseY,10,10);
 	if(mouseX>200&&mouseY>200)
 			{
 				germX = germX+1;
 				germY = germY+1;
 				if(mouseX<germX)
 					{
 						germX=germX-=1;
 					}
 					else
 					{	
 						germX=germX+=1;
 					}
 				if(mouseY<germY)
 					{
 						germY=germY-=1;
 					}
 					else
 					{
 						germY=germY+=1;
 					}
 			}
 					
 		else if(mouseX<200&&mouseY>200)
 			{
 				germX = germX-=1;
 				germY = germY+=1;
 				if(mouseX>germX)
 					{
 						germX=germX+=1;
 					}
 					else
 					{	
 						germX=germX-=1;
 					}
 				if(mouseY>germY)
 					{
 						germY=germY+=1;
 					}
 					else
 					{
 						germY=germY-=1;
 					}
 			}
 		else if(mouseX>200&&mouseY<200)
 			{
 				germX = germX+=1;
 				germY = germY-=1;
 				if(mouseX<germX)
 					{
 						germX=germX-=1;
 					}
 					else
 					{	
 						germX=germX+=1;
 					}
 				if(mouseY<germY)
 					{
 						germY=germY-=1;
 					}
 					else
 					{
 						germY=germY+=1;
 					}
 			}
 		else if(mouseX<200&&mouseY<200)
 			{
 				germX = germX-=1;
 				germY = germY-=1;
 				if(mouseX<germX)
 					{
 						germX=germX-=1;
 					}
 					else
 					{	
 						germX=germX+=1;
 					}
 				if(mouseY<germY)
 					{
 						germY=germY-=1;
 					}
 					else
 					{
 						germY=germY+=1;
 					}
 			}
 		//germX = germX+=1;
	}
 }


    
 
//Math.random()*255,Math.random()*255,Math.random()*255
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
