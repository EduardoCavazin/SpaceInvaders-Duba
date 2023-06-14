package ifpr.paranavai.jogo.modelo;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;

public class Personagem {

    private int posEmX; // posição em X
    private int posEmY; // posição em Y
    private int deslocEmX; // deslocamento em X
    private int deslocEmY; // deslocamento em Y
    private Image imagem; // imagem do personagem
    private int larguraImg; // largura da imagem 
    private int alturaImg; // altura da imagem
    private int velocidadeDeslocamento; // velocidade de deslocamento

    private static final int POSICAO_INICIAL_X = 150;
    private static final int POSICAO_INICIAL_Y = 200;


    public Personagem(int velocidadeDeslocamento) {
        this.posEmX = POSICAO_INICIAL_X;
        this.posEmY = POSICAO_INICIAL_Y;
        this.velocidadeDeslocamento = velocidadeDeslocamento;

    }

    public void carregar(){
        ImageIcon carregando = new ImageIcon("recursos\\jogador.png");
        this.imagem = carregando.getImage();
        this.larguraImg = this.imagem.getWidth(null);
        this.alturaImg = this.imagem.getHeight(null);
    }

    public void atualizar(){
        this.posEmX += this.deslocEmX;
        this.posEmY += this.deslocEmY;
    }

    public void mover(KeyEvent tecla){
        int codigo = tecla.getKeyCode();

        switch(codigo){
            case KeyEvent.VK_UP:
                this.deslocEmY = -this.velocidadeDeslocamento;
                break;
            case KeyEvent.VK_DOWN:
                this.deslocEmY = this.velocidadeDeslocamento;
                break;
            case KeyEvent.VK_LEFT:
                this.deslocEmX = -this.velocidadeDeslocamento;
                break;
            case KeyEvent.VK_RIGHT:
                this.deslocEmX = this.velocidadeDeslocamento;
                break;

            case KeyEvent.VK_W:
                this.deslocEmY = -this.velocidadeDeslocamento;
                break;
            case KeyEvent.VK_S:
                this.deslocEmY = this.velocidadeDeslocamento;
                break;
            case KeyEvent.VK_A:
                this.deslocEmX = -this.velocidadeDeslocamento;
                break;
            case KeyEvent.VK_D:
                this.deslocEmX = this.velocidadeDeslocamento;
                break;
        }
    }

    public void parar(KeyEvent tecla){
        int codigo = tecla.getKeyCode();

        switch(codigo){
            case KeyEvent.VK_UP:
                this.deslocEmY = 0;
                break;
            case KeyEvent.VK_DOWN:
                this.deslocEmY = 0;
                break;
            case KeyEvent.VK_LEFT:
                this.deslocEmX = 0;
                break;
            case KeyEvent.VK_RIGHT:
                this.deslocEmX = 0;
                break;
            
            case KeyEvent.VK_W:
                this.deslocEmY = 0;
                break;
            case KeyEvent.VK_S:
                this.deslocEmY = 0;
                break;
            case KeyEvent.VK_A:
                this.deslocEmX = 0;
                break;
            case KeyEvent.VK_D:
                this.deslocEmX = 0;
                break;
        }
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
