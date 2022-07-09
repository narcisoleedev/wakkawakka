package elements;

import utils.Consts;
import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;


public class Wall extends BackgroundElement implements Serializable{
    
    //Pega a imagem do muro.
    public Wall(String imageName) {
        super(imageName);
        this.isTransposable = false;
    }
    //Desenha o muro.
    public void autoDraw(Graphics g) {
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());

    }    
}
