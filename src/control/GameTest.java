package control;

import org.junit.Test;
import static org.junit.Assert.*;

import java.beans.Transient;

public class GameTest{
    @Test 
    public void testMain(){
        if(Main.initialScreen!=null){
            fail("Tela inicial iniciada antes.");
        }
        if(Main.gamePacMan!=null){
            fail("Jogo iniciado antes.");
        }
        assertTrue("Nivel diferente de 1.", Main.level==1);
        assertTrue("Erro no load do jogo.", Main.openSavedGame==false);
    }

    @Test
    public void testInitialScreen(){
        InitialScreen is = new InitialScreen();
        if(is==null){
            fail("Erro na tela inicial.");
        }
    }

    @Test
    public void testGameScreen(){
        GameScreen gs = new GameScreen();
        if(gs==null){
            fail("Erro ao carregar tela de jogo.");
        }
        assertTrue("Nome do arquivo errado.", gs.fileName=="jogo.ser");
    }
}
