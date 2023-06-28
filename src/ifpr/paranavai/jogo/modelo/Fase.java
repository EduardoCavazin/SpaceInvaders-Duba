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

import ifpr.paranavai.jogo.modelo.inimigo.Inimigo;
import ifpr.paranavai.jogo.modelo.jogador.Especial;
import ifpr.paranavai.jogo.modelo.jogador.Personagem;
import ifpr.paranavai.jogo.modelo.jogador.Tiro;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fase extends JPanel implements KeyListener, ActionListener {
    
    private Image imgFundo; // imagem de fundo da fase
    private Personagem personagem; // personagem da fase
    private ArrayList<Inimigo> inimigos; // inimigos da fase
    private Timer timer; // timer da fase
    private int temporizador = 0; // temporizador do especial

    private static final int DESLOCAMENTO = 3; // deslocamento do personagem
    private static final int DELAY = 5; // delay do personagem
    private static final int LARGURA_JANELA = 728; // largura da janela
    private boolean podeAtirar = true; // permite atirar
    private static final int QTD_INIMIGOS = 40;

    public Fase(){
        this.setFocusable(true); // Permite o foco
        this.setDoubleBuffered(true); // Otimização do buffer

        ImageIcon carregando = new ImageIcon("recursos\\spcbg.jpg");
        this.imgFundo = carregando.getImage();

        this.personagem = new Personagem(DESLOCAMENTO);
        this.personagem.carregar();
        
        this.gerarInimigos();

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

        ArrayList<Especial> especiais = personagem.getEspecial();
        for(Especial especial : especiais){
            especial.carregar();
            graficos.drawImage(especial.getImagem(), especial.getEspecialPosX(), especial.getEspecialPosY(),null);
        }

        for(Inimigo inimigo : inimigos){
            inimigo.carregar();
            graficos.drawImage(inimigo.getImagem(), inimigo.getPosEmX(), inimigo.getPosEmY(), null);
        }

        g.dispose();
    }

    public void gerarInimigos(){
        inimigos = new ArrayList<Inimigo>();

        for(int i = 0; i < QTD_INIMIGOS; i++){
            int x = (int) (Math.random() * 6000 + 1024);
            int y = (int) (Math.random() * 728 + 30);
            
            Inimigo inimigo = new Inimigo(x, y);
            inimigo.carregar();
            inimigos.add(inimigo);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE && podeAtirar){
            personagem.atirar();
            podeAtirar = false;
        }else{
            personagem.mover(e);
        }

        if(e.getKeyCode() == KeyEvent.VK_Q && podeAtirar && temporizador > 100){
            personagem.atiraEspecial();
            temporizador = 0;
            podeAtirar = false;
        }else{
            personagem.mover(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            podeAtirar = true;
        }
        
        this.personagem.parar(e);

        if(e.getKeyCode() == KeyEvent.VK_Q){
            podeAtirar = true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        temporizador++;
        this.personagem.atualizar();

        ArrayList<Tiro> tiros = personagem.getTiros();
        for(int i = 0; i < tiros.size(); i++){
            if(tiros.get(i).getPosY() > LARGURA_JANELA){
                tiros.remove(i);
            }else{
                tiros.get(i).atualizar();
            }
        }

        ArrayList<Especial> especiais = personagem.getEspecial();
        for(int i = 0; i < especiais.size(); i++){
            if(especiais.get(i).getEspecialPosY() > LARGURA_JANELA){
                especiais.remove(i);
            }else{
                especiais.get(i).atualizar();
            }
        }

        for(int i = 0; i < inimigos.size(); i++){
            if(inimigos.get(i).getPosEmX() < 0){
                inimigos.remove(i);
            }else{
                inimigos.get(i).atualizar();
            }
        }

        this.repaint();
    }

}
