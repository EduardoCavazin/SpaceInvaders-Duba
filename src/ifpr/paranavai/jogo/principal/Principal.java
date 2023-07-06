package ifpr.paranavai.jogo.principal;

import javax.swing.JFrame;
import ifpr.paranavai.jogo.modelo.*;

public class Principal extends JFrame {

    public Principal(){
        FaseUm fase = new FaseUm();
        super.add(fase);
        super.setTitle("Duba Invaders");
        super.setSize(1024, 728);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setResizable(true);
        super.setVisible(true);
    }

    public static void main(String[] args) {
        new Principal();
        
    }

    
}
