package ifpr.paranavai.jogo.modelo;

import javax.swing.ImageIcon;

public class Tiro extends ElementoGrafico {
    private static int VELOCIDADE = 4;

    public Tiro(int personagemX, int personagemY) {
        this.carregar();
        this.setPosX(personagemX);
        this.setPosY(personagemY - (this.getAlturaImg() / 2));
    }

    public void carregar(){
        ImageIcon referencia = new ImageIcon("recursos\\blaster1.png");
        this.setImagem(referencia.getImage());
        this.setLarguraImg(this.getImagem().getWidth(null));
        this.setAlturaImg(this.getImagem().getHeight(null));
    }

    public void atualizar(){
        this.setPosX(this.getPosX() + VELOCIDADE);
    }

    public Tiro get(int i){
        return null;
    }
    
}
