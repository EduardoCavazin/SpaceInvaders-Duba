package ifpr.paranavai.jogo.modelo;

import java.awt.Rectangle;
import java.awt.Image;

public abstract class ElementoGrafico {
    private int posX;
    private int posY;
    private Image imagem;
    private int larguraImg;
    private int alturaImg;
    private boolean visivel = true;

    public Rectangle getRectangle() {
        return new Rectangle(this.posX, this.posY, this.getImagem().getWidth(null), this.getImagem().getHeight(null));
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

    public boolean isVisivel() {
        return this.visivel;
    }

    public boolean getVisivel() {
        return this.visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }

}