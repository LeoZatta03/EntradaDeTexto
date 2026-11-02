import javax.swing.*;
import java.awt.FlowLayout;

public class EntradaDeTexto {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            JFrame janela = new JFrame("Olá! Bem-vindo(a)!");
            janela.setSize(400,160);
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janela.setLocationRelativeTo(null);
            janela.setLayout(new FlowLayout(FlowLayout.CENTER, 10,20));

            //Componentes
            JLabel label = new JLabel ("Digite seu nome:");
            JTextField campoTexto = new JTextField(15); // largura 15 letras
            JButton botao = new JButton ("Dizer Olá");

            //Ação ao clicar no botão
            botao.addActionListener(e -> {
                //1. Pega o texto digitado e remove espaços inúteis nas pontas
                String nome = campoTexto.getText().trim();

                //2.Valida se o usuário não deixou em branco
                if(nome.isEmpty()){
                    JOptionPane.showMessageDialog(
                            janela,
                            "Por favor, digite um nome!",
                            "Aviso",
                            JOptionPane.WARNING_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            janela,
                            "Olá, " + nome + " Seja-bem vindo!",
                            "Boas vindas",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    campoTexto.setText(""); // Limpa o campo
                    campoTexto.requestFocus(); // devolve cursor piscando pra lá
                }
            });

            // Coloca tudo na janela
            janela.add(label);
            janela.add(campoTexto);
            janela.add(botao);

            janela.setVisible(true);
        });

    }
}
