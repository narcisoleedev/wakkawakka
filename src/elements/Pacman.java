package elements;

import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;


public class Pacman extends ElementMove implements Serializable {
    
    private int score=0;
    private int remainingScore=0;
    private int numberLifes=1;
    private int numberDotstoEat=0;
    private int numberGhosttoEat=4;
    private long startTimePower=0;
    
    //Seta atributos do pacman.
    public Pacman(String imageName) {
        super(imageName);
        this.isMortal = true;
        
    }
    
	//Pega os pontos.
    public int getScore(){
    	return this.score;
    }
    //Pega os pontos restantes.
    public int getRemainingScore(){
    	return this.remainingScore;
    }
	//Quantidade de vidas do pacman.
	public int getLifes() {
		return this.numberLifes;
	}
	//Pega os numeros de pacdots para comer.
	public int getNumberDotstoEat() {
		return this.numberDotstoEat;
	}
	//Pega o tempo de inicio do powerpellet buff.
	public long getStartTimePower() {
		return this.startTimePower;
	}
	//Seta o tempo de inicio do powerpellet buff.
	public void setStartTimePower(long start){
		this.startTimePower=start;
	}
	//Pega a pontuação restante.
	public void setRemainingScore(int remainingScore){
		this.remainingScore=remainingScore;
	}
	//Seta a quantidade de vidas.
	public void setNumberLifes(int numberLifes){
		this.numberLifes=numberLifes;
	}
	//Adiciona vidas ao pacman.
	public void addLife(){
		this.numberLifes++;
	}
	

	
	//Adiciona pacdots para comer.
	public void addNumberDotstoEat() {
		this.numberDotstoEat++;
	}
	//Diminui o número de pacdots para comer.
	public void minusNumberDotstoEat() {
		this.numberDotstoEat--;
	}
	//Diminui o número de fantasmas para comer.
	public void minusNumberGhotstoEat() {
		this.numberGhosttoEat--;
	}
	
	public void addScore(int i) {
		score=score+i;
	}
	
	public void addRemainingScore(int i) {
		this.remainingScore=this.remainingScore+i;
	}
    
    @Override
    public void autoDraw(Graphics g){
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());
    }

	public int getNumberGhosttoEat() {
		return numberGhosttoEat;
	}


}
