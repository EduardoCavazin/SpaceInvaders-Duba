package ifpr.paranavai.jogo.modelo.jogador;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Especial {
    private int especialPosX; // posição em X
    private int especialPosY; // posição em Y
    private Image imagem; // imagem do tiro
    private int larguraImg; // largura da imagem
    private int alturaImg; // altura da imagem
    
    private static int VELOCIDADE = 5;


    public Especial(int especialPosX, int especialPosY) {
        this.especialPosX = especialPosX;
        this.especialPosY = especialPosY;
    }

    public void carregar(){
        ImageIcon carregando = new ImageIcon("recursos\\bluetiro.png");
        this.imagem = carregando.getImage();
        this.larguraImg = this.imagem.getWidth(null);
        this.alturaImg = this.imagem.getHeight(null);
    }

    public void atualizar(){
        this.especialPosX = this.especialPosX + VELOCIDADE;
    }


    public int getEspecialPosX() {
        return this.especialPosX;
    }

    public void setEspecialPosX(int especialPosX) {
        this.especialPosX = especialPosX;
    }

    public int getEspecialPosY() {
        return this.especialPosY;
    }

    public void setEspecialPosY(int especialPosY) {
        this.especialPosY = especialPosY;
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
