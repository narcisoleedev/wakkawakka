package elements;

import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;

public class Strawberry extends ElementGivePoint implements Serializable{
	private long startTime=0;
	//Seta a imagem, pontos e tempo do jogo.
	public Strawberry(String imageName) {
        super(imageName);
        this.numberPoints=300;
        this.startTime=System.currentTimeMillis();
    }
	//Pega o tempo de início do jogo.
	public long getStartTime() {
		return this.startTime;
	}
	
	//Seta o tempo de início.
	public void setStartTime(long start){
		this.startTime=start;
	}

}
