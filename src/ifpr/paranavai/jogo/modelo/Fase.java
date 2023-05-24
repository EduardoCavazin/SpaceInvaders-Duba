package ifpr.paranavai.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fase extends JPanel {
    
    private Image imgFundo; // imagem de fundo da fase
    private Personagem personagem; // personagem da fase

    public Fase(){
        ImageIcon carregando = new ImageIcon("recursos\\spcbg.jpg");
        this.imgFundo = carregando.getImage();

        this.personagem = new Personagem();
        this.personagem.carregar();
    }

    public void paint(Graphics g){
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(this.imgFundo, 0, 0, null);
        graficos.drawImage(this.personagem.getImagem(), this.personagem.getPosEmX(), this.personagem.getPosEmY(), null);
        g.dispose();
    }

}
