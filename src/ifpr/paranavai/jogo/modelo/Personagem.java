package ifpr.paranavai.jogo.modelo;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Personagem extends ElementoGrafico {

    private int deslocX;
    private int deslocY;
    private ArrayList<Tiro> tiros;
    private ArrayList<Especial> especial;
    
    private static final int DESLOCAMENTO = 5;
    private static final int POS_INICIAL_X = 150;
    private static final int POS_INICIAL_Y = 350;

    public Personagem(){
        this.tiros = new ArrayList<Tiro>();
        this.especial = new ArrayList<Especial>();
        this.deslocX = 0;
        this.deslocY = 0;
        setPosX(POS_INICIAL_X);
        setPosY(POS_INICIAL_Y);
    }

    public void atualizar(){
        this.setPosX(this.getPosX() + this.getDeslocX());
        this.setPosY(this.getPosY() + this.getDeslocY());
    }

    public void carregar(){
        ImageIcon referencia = new ImageIcon("C:\\Users\\Duba\\Desktop\\Testes\\POO\\Jogo\\Recursos\\jogador.png");
        this.setImagem(referencia.getImage());
        this.setLarguraImg(this.getImagem().getWidth(null));
        this.setAlturaImg(this.getImagem().getHeight(null));
        setPosX(POS_INICIAL_X);
        setPosY(POS_INICIAL_Y);
    }

    public void atirar(){
        int frenteNave = this. getPosX() + this.getLarguraImg();
        int meioNave = this.getPosY() + (this.getAlturaImg() / 2);
        
        Tiro tiro = new Tiro(frenteNave, meioNave);
        this.tiros.add(tiro);
    }

    public void especialTiro(){
        int frenteNave = this. getPosX() + this.getLarguraImg();
        int meioNave = this.getPosY() + (this.getAlturaImg() / 2);
        
        Especial especial = new Especial(frenteNave, meioNave);
        this.especial.add(especial);
    }

    public void disparaTiro(){
        atirar();
    }

    public void disparaEspec(){
        especialTiro();
    }

    public void mover(KeyEvent tecla){
        int codigo = tecla.getKeyCode();

        switch(codigo){
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                this.deslocY = -DESLOCAMENTO;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                this.deslocY = DESLOCAMENTO;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                this.deslocX = -DESLOCAMENTO;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                this.deslocX = DESLOCAMENTO;
                break;
            default:
                break;
        }
    }

    public void parar(KeyEvent tecla){
        int codigo = tecla.getKeyCode();

        switch(codigo){
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                this.deslocY = 0;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                this.deslocY = 0;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                this.deslocX = 0;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                this.deslocX = 0;
                break;
            default:
                break;
        }
    }

    public Rectangle getBounds(){
        return new Rectangle(this.getPosX(), this.getPosY(), this.getLarguraImg(), this.getAlturaImg());
    }

    public void setVisivel(boolean b){
    }

    public int getDeslocX() {
        return this.deslocX;
    }

    public void setDeslocX(int deslocX) {
        this.deslocX = deslocX;
    }

    public int getDeslocY() {
        return this.deslocY;
    }

    public void setDeslocY(int deslocY) {
        this.deslocY = deslocY;
    }

    public ArrayList<Tiro> getTiros() {
        return this.tiros;
    }

    public void setTiros(ArrayList<Tiro> tiros) {
        this.tiros = new ArrayList<Tiro>();
        this.tiros = tiros;
    }

    public ArrayList<Especial> getEspecial() {
        return this.especial;
    }

    public void setEspecial(ArrayList<Especial> especial) {
        this.especial = new ArrayList<Especial>();
        this.especial = especial;
    }

}
