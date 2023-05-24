package ifpr.paranavai.jogo.principal;

import javax.swing.JFrame;
import ifpr.paranavai.jogo.modelo.*;

public class Principal extends JFrame {

    public Principal(){
        Fase fase = new Fase(); // cria uma fase
        super.add(fase); // adiciona a fase ao JFrame
        super.setTitle("Sapce Invaders - Duba Version"); // título da janela
        super.setSize(1024,728); // tamanho da janela
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ação ao fechar
        super.setLocationRelativeTo(null); // centraliza a janela
        super.setResizable(true); // permite redimensionar a janela
        super.setVisible(true); // torna a janela visível
         
    }

    public static void main(String[] args) {
        new Principal();
        
    }

    
}
