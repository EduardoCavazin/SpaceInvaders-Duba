package ifpr.paranavai.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fase extends JPanel implements KeyListener, ActionListener {
    
    private Image imgFundo; // imagem de fundo da fase
    private Personagem personagem; // personagem da fase
    private Timer timer; // timer da fase

        private static final int DESLOCAMENTO = 3; // deslocamento do personagem
        private static final int DELAY = 5; // delay do personagem
        private static final int LARGURA_JANELA = 728; // largura da janela

    public Fase(){
        this.setFocusable(true); // Permite o foco
        this.setDoubleBuffered(true); // Otimização do buffer

        ImageIcon carregando = new ImageIcon("recursos\\spcbg.jpg");
        this.imgFundo = carregando.getImage();

        this.personagem = new Personagem(DESLOCAMENTO);
        this.personagem.carregar();
        this.addKeyListener(this); // adiciona o listener do teclado

        this.timer = new Timer(DELAY, this); // cria o timer
        this.timer.start(); // inicia o timer
    }

    public void paint(Graphics g){
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(this.imgFundo, 0, 0, null);
        graficos.drawImage(this.personagem.getImagem(), this.personagem.getPosEmX(), this.personagem.getPosEmY(), null);
        
        ArrayList<Tiro> tiros = personagem.getTiros();
        for(Tiro tiro : tiros){
            tiro.carregar();
            graficos.drawImage(tiro.getImagem(), tiro.getPosX(), tiro.getPosY(),null);
        }

        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            personagem.atirar();
        }else{
            personagem.mover(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.personagem.parar(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.personagem.atualizar();

        ArrayList<Tiro> tiros = personagem.getTiros();
        for(Tiro tiro: tiros){
            if(tiro.getPosY() > LARGURA_JANELA){
                //tiros.remove(tiro);
            }else{
                tiro.atualizar();
            }
        }
        this.repaint();
    }

}
