package ifpr.paranavai.jogo.modelo.inimigo;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Inimigo {
    
    private int posEmX; // posição em X
    private int posEmY; // posição em Y
    private Image imagem; // imagem do personagem
    private int larguraImg; // largura da imagem 
    private int alturaImg; // altura da imagem

    private final static int VELOCIDADE = 2;



    public Inimigo(int xRandom, int yRandom) {
        this.posEmX = xRandom;
        this.posEmY = yRandom;
    }
    
    public void carregar() {
        ImageIcon carregando = new ImageIcon("recursos\\inibigo.png");
        this.imagem = carregando.getImage();
        this.alturaImg = this.imagem.getWidth(null);
        this.larguraImg = this.imagem.getHeight(null);
    }

    public void atualizar() {
        this.posEmX -= VELOCIDADE;
    }

    public int getPosEmX() {
        return this.posEmX;
    }

    public void setPosEmX(int posEmX) {
        this.posEmX = posEmX;
    }

    public int getPosEmY() {
        return this.posEmY;
    }

    public void setPosEmY(int posEmY) {
        this.posEmY = posEmY;
    }

    public Image getImagem() {
        return this.imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public int getLarguraImg() {
        return this.larguraImg;
    }

    public void setLarguraImg(int larguraImg) {
        this.larguraImg = larguraImg;
    }

    public int getAlturaImg() {
        return this.alturaImg;
    }

    public void setAlturaImg(int alturaImg) {
        this.alturaImg = alturaImg;
    }

}
