package elements;

import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;

public class ElementGivePoint extends Element implements Serializable {
    protected  int numberPoints=0;
    
    //Pega o valor de pontos.
	public int getNumberPoints(){
		return numberPoints;
	}

    //Elemento dá ponto.
    public ElementGivePoint(String imageName) {
        super(imageName);
        this.isMortal = true;        
    }

    @Override
    //Desenha o elemento na tela.
    public void autoDraw(Graphics g) {
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());
    }
    
}
