package elements;

import utils.Drawing;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;

public class Clovis extends Ghost  {
     
	public Clovis(String imageName) {
	      super(imageName);
	}

    @Override
    public void autoDraw(Graphics g){
        
        if(!this.isMortal){
            followPacman();
        }
        else{
            escapePacman();
        }
        
        	

        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());

    }


}
