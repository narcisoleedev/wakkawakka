package elements;

import utils.Consts;
import utils.Drawing;
import utils.Position;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

import javax.swing.ImageIcon;

public abstract class Ghost extends ElementMove implements Serializable {
    
    //Pega a imagem do fantasma.
    public Ghost(String imageName) {
        super(imageName);
    }
    
    abstract public void autoDraw(Graphics g);
    
	//Muda o fantasma para o estado mortal (quando ele fica azul).
    public void changeGhosttoBlue(String imageName) {
        this.isTransposable = true;
        this.isMortal = true;
        
        try {
            imageIcon = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + imageName);
            Image img = imageIcon.getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIZE, Consts.CELL_SIZE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIZE, Consts.CELL_SIZE, null);
            imageIcon = new ImageIcon(bi);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

	//Muda o fantasma para o estado normal.
    public void changeGhosttoNormal(String imageName) {
        this.isTransposable = true;
        this.isMortal = false;
        
        try {
            imageIcon = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + imageName);
            Image img = imageIcon.getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIZE, Consts.CELL_SIZE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIZE, Consts.CELL_SIZE, null);
            imageIcon = new ImageIcon(bi);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

	//Segue o Pacman.
    protected void followPacman() {
    	Pacman pacman=Drawing.getGameScreen().getPacman();
        Position posPacman=pacman.getPos();
        int movDirectionPacman=pacman.getMoveDirection();
        
        if (movDirectionPacman==MOVE_LEFT ||movDirectionPacman==MOVE_RIGHT){
        	followPacmanHorizontal(movDirectionPacman, posPacman);
        }
        else if(movDirectionPacman==MOVE_DOWN ||movDirectionPacman==MOVE_UP){
        	followPacmanVertical(movDirectionPacman, posPacman);
        }else{
			this.moveRandom();
		}
	}

	//Animação da morte do pacman.
    public void ghostDeathAnimation(String imageName) {
        try {
            imageIcon = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + imageName);
            Image img = imageIcon.getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIZE, Consts.CELL_SIZE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIZE, Consts.CELL_SIZE, null);
            imageIcon = new ImageIcon(bi);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
	//Segue o pacman na horizontal.
	protected void followPacmanHorizontal(int movDirectionPacman,Position posPacman) {
       	Random gerador = new Random();
    	if(gerador.nextInt(11)>8){
    		this.setMovDirection(gerador.nextInt(5));
    	}
    	else{
    		if (posPacman.getY()<this.getPos().getY()){
    			this.setMovDirection(Pacman.MOVE_LEFT);
    		}
    		else{
    			this.setMovDirection(Pacman.MOVE_RIGHT);	
    		} 
    	}
	}
	//Segue o pacman na vertical.
	protected void followPacmanVertical(int movDirectionPacman, Position posPacman) {
    	Random gerador = new Random();
    	if(gerador.nextInt(11)>8){
    		this.setMovDirection(gerador.nextInt(5));
    	}
    	else{
    		if (posPacman.getX()<this.getPos().getX()){
    			this.setMovDirection(Pacman.MOVE_UP);
    		}
    		else{
    			this.setMovDirection(Pacman.MOVE_DOWN);	
    		} 
    	}		
	} 
	
	//Foge do pacman.
    protected void escapePacman() {
    	Pacman pacman=Drawing.getGameScreen().getPacman();
        Position posPacman=pacman.getPos();
        int movDirectionPacman=pacman.getMoveDirection();
        
        if (movDirectionPacman==MOVE_LEFT ||movDirectionPacman==MOVE_RIGHT){
        	escapePacmanHorizontal(movDirectionPacman, posPacman);
        }
        else if(movDirectionPacman==MOVE_DOWN ||movDirectionPacman==MOVE_UP){
        	escapePacmanVertical(movDirectionPacman, posPacman);
        }else{
			this.moveRandom();
		}	
	}
    
    //Foge do pacman na horizontal.
	protected void escapePacmanHorizontal(int movDirectionPacman,Position posPacman) {
       	Random gerador = new Random();
    	if(gerador.nextInt(11)>8){
    		this.setMovDirection(gerador.nextInt(5));
    	}
    	else{
    		if (posPacman.getY()<this.getPos().getY()){
    			this.setMovDirection(Pacman.MOVE_RIGHT);
    		}
    		else{
    			this.setMovDirection(Pacman.MOVE_LEFT);	
    		} 
    	}
	}
	//Foge do pacman na vertical.
	protected void escapePacmanVertical(int movDirectionPacman, Position posPacman) {
    	Random gerador = new Random();
    	if(gerador.nextInt(11)>8){
    		this.setMovDirection(gerador.nextInt(5));
    	}
    	else{
    		if (posPacman.getX()<this.getPos().getX()){
    			this.setMovDirection(Pacman.MOVE_DOWN);
    		}
    		else{
    			this.setMovDirection(Pacman.MOVE_UP);	
    		} 
    	}		
	} 
	//Move randomicamente.
	protected void moveRandom() {
    	Random gerador = new Random();
    	this.setMovDirection(gerador.nextInt(5));		
	}
   
}
