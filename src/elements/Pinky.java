package elements;

import utils.Drawing;
import utils.Position;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;
public class Pinky extends Ghost implements Serializable{
     
	//Pega a imagem do Pinky.
	public Pinky(String imageName) {
	      super(imageName);
	}
    @Override
	//Desenha o Pinky.
    public void autoDraw(Graphics g){
    	Pacman pacman=Drawing.getGameScreen().getPacman();
        Position posPacman=pacman.getPos();
        int movDirectionPacman=pacman.getMoveDirection();
		
		//NOTE: MUDANÇA DE MOVIMENTO PARALELO PRA PINKY
        if (movDirectionPacman==MOVE_LEFT ||movDirectionPacman==MOVE_RIGHT){
        	if(!this.isMortal){
        		followPacmanHorizontal(movDirectionPacman, posPacman);
        	}
        	else{
        		escapePacmanHorizontal(movDirectionPacman, posPacman);
        	}
        }
        else if(movDirectionPacman==MOVE_DOWN ||movDirectionPacman==MOVE_UP){
        	if (!this.isMortal) {
				followPacmanVertical(movDirectionPacman, posPacman);		
			} else {
				escapePacmanVertical(movDirectionPacman, posPacman);
			}

        }else {
			moveRandom();
		}
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());

    }



}
