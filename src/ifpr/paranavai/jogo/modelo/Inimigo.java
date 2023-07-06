package ifpr.paranavai.jogo.modelo;

import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class Inimigo extends ElementoGrafico{
    private boolean vivo;
    private int VELOCIDADE = 1;

    public Inimigo(int x, int y) {
        this.carregar();
        this.setPosX(x);
        this.setPosY(y);
        this.vivo = true;
        this.VELOCIDADE = 1;
    }

    public void carregar() {
        ImageIcon referencia = new ImageIcon("C:\\Users\\Duba\\Desktop\\Testes\\POO\\Jogo\\Recursos\\inibigo.png");
        this.setImagem(referencia.getImage());
        this.setLarguraImg(this.getImagem().getWidth(null));
        this.setAlturaImg(this.getImagem().getHeight(null));
    }

    public void atualizar() {
        if(!vivo){
            return;
        }else{
            this.setPosX(this.getPosX() - VELOCIDADE);
        }
    }

    public Rectangle getBounds(){
        return new Rectangle(this.getPosX(), this.getPosY(), this.getImagem().getWidth(null), this.getImagem().getHeight(null));
    }
    
    public boolean isVivo() {
        return this.vivo;
    }

    public boolean getVivo() {
        return this.vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public int getVELOCIDADE() {
        return this.VELOCIDADE;
    }

    public void setVELOCIDADE(int VELOCIDADE) {
        this.VELOCIDADE = VELOCIDADE;
    }

}