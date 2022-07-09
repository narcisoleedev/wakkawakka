package elements;

import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;


public class PacDots extends ElementGivePoint implements Serializable {
    
	//Atribui atributos dos pacdots.
    public PacDots(String imageName) {
        super(imageName);
        this.numberPoints = 10;
    }

    
    
}
