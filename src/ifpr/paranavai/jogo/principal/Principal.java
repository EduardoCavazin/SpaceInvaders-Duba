package ifpr.paranavai.jogo.principal;

import javax.swing.JFrame;
import ifpr.paranavai.jogo.modelo.*;

public class Principal extends JFrame {

    public Principal(){
        add(new FaseUm());
        setTitle("Space Invaders");
        setSize(Fase.LARGURA_TELA, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Principal();
        
    }

    
}
