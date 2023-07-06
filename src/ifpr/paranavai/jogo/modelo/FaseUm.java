package ifpr.paranavai.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class FaseUm extends Fase {

    private Personagem personagem;
    private Timer timer;
    private boolean podeAtirar = true;
    private int temporizador = 0;
    private boolean emJogo = true;
    private ArrayList<Inimigo> inimigos;

    private static final int LARGURA_TELA = 800;
    private int QTD_INIMIGOS = 10;

    public FaseUm(){
        super();
        ImageIcon referencia = new ImageIcon("recursos\\spcbg.png");
        this.fundo = referencia.getImage();
        personagem = new Personagem();
        personagem.carregar();
        this.inicializarInimigos();
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paint(Graphics g){
        Graphics2D graficos = (Graphics2D) g;

        if(emJogo){
            graficos.drawImage(fundo, 0, 0, null);
            graficos.drawImage(personagem.getImagem(), personagem.getPosX(), personagem.getPosY(), this);
            ArrayList<Tiro> tiros = personagem.getTiros();
            ArrayList<Especial> especiais = personagem.getEspecial();
            
            for(Tiro tiro : tiros){
                tiro.carregar();
                graficos.drawImage(tiro.getImagem(), tiro.getPosX(), tiro.getPosY(), this);
            }

            for(Especial espeical : especiais){
                espeical.carregar();
                graficos.drawImage(espeical.getImagem(), espeical.getPosX(), espeical.getPosY(), this);
            }

            for(Inimigo inimigo : inimigos){
                inimigo.carregar();
                graficos.drawImage(inimigo.getImagem(), inimigo.getPosX(), inimigo.getPosY(), this);
            }
        }else{
            ImageIcon fimJogo = new ImageIcon("recursos\\game-over.png");
            graficos.drawImage(fimJogo.getImage(), 0, 0, null);
        }

        graficos.dispose();
    }

    @Override
    public void inicializarInimigos(){
        inimigos = new ArrayList<Inimigo>();

        for(int i = 0; i < QTD_INIMIGOS; i++){
            int x = (int) (Math.random() * 800 + 1024);
            int y = (int) (Math.random() * 650 + 30);
            inimigos.add(new Inimigo(x, y));
        }
    }

    @Override
    public void verificarColisoes() {
        Rectangle formaPersonagem = personagem.getRectangle();

        for(int i = 0; i < this.inimigos.size(); i++){
            Inimigo inimigo = inimigos.get(i);
            Rectangle formaInimigo = inimigo.getRectangle();

            if(formaInimigo.intersects(formaPersonagem)){
                personagem.setVisivel(false);
                inimigo.setVisivel(false);
                emJogo = false;
            }

            ArrayList<Tiro> tiros = personagem.getTiros();
            for(int j = 0; j < tiros.size(); j++){
                Tiro tiro = tiros.get(j);
                Rectangle formaTiro = tiro.getRectangle();

                if(formaTiro.intersects(formaInimigo)){
                    inimigo.setVisivel(false);
                    tiro.setVisivel(false);
                }
            }

            ArrayList<Especial> especiais = personagem.getEspecial();
            for(int k = 0; k < especiais.size(); k++){
                Especial especial = especiais.get(k);
                Rectangle formaEspecial = especial.getRectangle();

                if(formaEspecial.intersects(formaInimigo)){
                    inimigo.setVisivel(false);
                    especial.setVisivel(false);
                }
            }
        }
    }

    @Override // Ignorarei o método 'keyTyped'
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            emJogo = true;
            personagem.setVisivel(true);
            this.inicializarInimigos();
        }

        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }

        if(e.getKeyCode() == KeyEvent.VK_SPACE && podeAtirar){
            if(podeAtirar){
                personagem.disparaTiro();
                podeAtirar = false;
            }else{
                personagem.mover(e);
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_Q && podeAtirar && temporizador >= 500){
            if(podeAtirar){
                personagem.disparaEspec();
                podeAtirar = false;
                temporizador = 0;
            }else{
                personagem.mover(e);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            podeAtirar = true;
        }else{
            personagem.parar(e);
        }

        if(e.getKeyCode() == KeyEvent.VK_Q){
            podeAtirar = true;
        }else{
            personagem.parar(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        temporizador++;
        personagem.atirar();

        ArrayList<Tiro> tiros = personagem.getTiros();
        for(int i = tiros.size() - 1; i >= 0; i--){
            Tiro tiro = tiros.get(i);
            if(tiro.getPosX() > LARGURA_TELA || !tiro.getVisivel()){
                tiros.remove(tiro);
            }else{
                tiro.atualizar();
            }
        }

        ArrayList<Especial> especiais = personagem.getEspecial();
        for(int i = especiais.size() - 1; i >= 0; i--){
            Especial especial = especiais.get(i);
            if(especial.getPosX() > LARGURA_TELA || !especial.getVisivel()){
                especiais.remove(especial);
            }else{
                especial.atualizar();
            }
        }

        for(int i = 0; i < inimigos.size(); i++){
            Inimigo inimigo = this.inimigos.get(i);
            if(inimigo.getPosX() < 0 || !inimigo.getVisivel()){
                this.inimigos.remove(inimigo);
                int x = (int) (Math.random() * 800 + 1024);
                int y = (int) (Math.random() * 650 + 30);
                this.inimigos.add(new Inimigo(x, y));
            }else{
                inimigo.atualizar();
            }
        }

        this.verificarColisoes();
        repaint();
    }

}
