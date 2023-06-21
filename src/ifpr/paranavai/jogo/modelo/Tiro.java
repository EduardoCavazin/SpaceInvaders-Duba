package ifpr.paranavai.jogo.modelo;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Tiro {
    private int posX; // posição em X
    private int posY; // posição em Y
    private Image imagem; // imagem do tiro
    private int larguraImg; // largura da imagem
    private int alturaImg; // altura da imagem
    
    private static int VELOCIDADE = 5;


    public Tiro(int posEmX, int posEmY) {
        this.posX = posEmX;
        this.posY = posEmY;
    }
    
    public void carregar(){
        ImageIcon carregando = new ImageIcon("recursos\\blaster1.png");
        this.imagem = carregando.getImage();
        this.larguraImg = this.imagem.getWidth(null);
        this.alturaImg = this.imagem.getHeight(null);
    }

    public void atualizar(){
        this.posX = this.posX + VELOCIDADE;
    }


    public int getPosX() {
        return this.posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
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
