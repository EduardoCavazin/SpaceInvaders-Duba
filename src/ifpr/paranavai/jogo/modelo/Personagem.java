package ifpr.paranavai.jogo.modelo;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Personagem {

    private int posEmX; // posição em X
    private int posEmY; // posição em Y
    private int deslocEmX; // deslocamento em X
    private int deslocEmY; // deslocamento em Y
    private Image imagem; // imagem do personagem
    private int larguraImg; // largura da imagem 
    private int alturaImg; // altura da imagem

    public Personagem() {
        this.posEmX = 150;
        this.posEmY = 200;

    }

    public void carregar(){
        ImageIcon carregando = new ImageIcon("recursos\\jogador.png");
        this.imagem = carregando.getImage();
        this.larguraImg = this.imagem.getWidth(null);
        this.alturaImg = this.imagem.getHeight(null);
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

    public int getDeslocEmX() {
        return this.deslocEmX;
    }

    public void setDeslocEmX(int deslocEmX) {
        this.deslocEmX = deslocEmX;
    }

    public int getDeslocEmY() {
        return this.deslocEmY;
    }

    public void setDeslocEmY(int deslocEmY) {
        this.deslocEmY = deslocEmY;
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
