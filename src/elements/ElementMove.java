package elements;

import utils.Drawing;
import utils.Position;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;

public abstract class ElementMove extends Element  implements Serializable {
    
    public static final int STOP = 0;
    public static final int MOVE_LEFT = 1;
    public static final int MOVE_RIGHT = 2;
    public static final int MOVE_UP = 3;
    public static final int MOVE_DOWN = 4;
    
    private int movDirection = STOP;
    
    //Pega a direção do movimento.
    public int getMoveDirection(){
    	return movDirection;
    }
    
    //Pega a imagem do elemento.
    public ElementMove(String imageName) {
        super(imageName);
    }
    
    abstract public void autoDraw(Graphics g);
    
    //Volta pra posição antes da ultima ação.
    public void backToLastPosition(){
        this.pos.comeBack();
    }
    
    //Seta a direção do movimento do elemento.
    public void setMovDirection(int direction) {
        movDirection = direction;
    }
    
    //Movimenta o elemento.
    public void move() {
        switch (movDirection) {
            case MOVE_LEFT:
                this.moveLeft();
                break;
            case MOVE_RIGHT:
                this.moveRight();
                break;
            case MOVE_UP:
                this.moveUp();
                break;
            case MOVE_DOWN:
                this.moveDown();
                break;
            default:
                break;
        }
    }
    //Move para cima.
    public boolean moveUp() {
        return this.pos.moveUp();
    }
    //Move para baixo.
    public boolean moveDown() {
        return this.pos.moveDown();
    }
    //Move para o lado direito.
    public boolean moveRight() {
        return this.pos.moveRight();
    }
    //Move para o lado esquerdo.
    public boolean moveLeft() {
        return this.pos.moveLeft();
    }


}
