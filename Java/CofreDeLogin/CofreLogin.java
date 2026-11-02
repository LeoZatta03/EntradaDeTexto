import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class CofreLogin extends JFrame {

    //1. Declaramos os componentes que vamos usar
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JCheckBox chkMostrarSenha;
    private JButton btnEntrar;
    private JButton btnLimpar;
    private JLabel lblStatus;

    public CofreLogin() {
        //2. Configura janela
        super("Cofre Secreto - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //3. Cria barra de menus
        JMenuBar barra = new JMenuBar();
        JMenu menuOpcoes = new JMenu("Opções");
        JMenuItem itemSobre = new JMenuItem("Sobre");
        JMenuItem itemSair = new JMenuItem("Sair");

        //Eventos dos menus com JOptionPane
        itemSobre.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    this,
                    "Projeto Cofre de Login\nFeito com JavaSwing para iniciantes",
                    "Sobre",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        itemSair.addActionListener(e -> {
            int resposta = JOptionPane.showConfirmDialog(
                    this,
                    "Deseja realmente sair?",
                    "Sair?",
                    JOptionPane.YES_NO_OPTION
            );
            if (resposta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        menuOpcoes.add(itemSobre);
        menuOpcoes.addSeparator();
        menuOpcoes.add(itemSair);
        setJMenuBar(barra);

        //4. Cria os componentes
        txtUsuario = new JTextField(15);
        txtSenha = new JPasswordField(15);
        chkMostrarSenha = new JCheckBox("Mostrar Senha");
        btnEntrar = new JButton("Entrar");
        btnLimpar = new JButton("Limpar");
        lblStatus = new JLabel("Informe seus dados para acessar o cofre");

        //5. Organiza os componentes em painéis com layouts
        //Painel central: grid com 3 linhas 2 colunas
        JPanel painelFormulario = new JPanel(new GridLayout(3, 2, 8, 8));
        painelFormulario.add(new JLabel("Usuário:"));
        painelFormulario.add(txtUsuario);
        painelFormulario.add(new JLabel("Senha:"));
        painelFormulario.add(txtSenha);
        painelFormulario.add(new JLabel("Opção:"));
        painelFormulario.add(chkMostrarSenha);

        //Painel dos botões: flow layout - em fila
        JPanel painelBotoes = new JPanel(new FlowLayout());
        painelBotoes.add(btnEntrar);
        painelBotoes.add(btnLimpar);

        //Adiciona tudo no JFRAME principal
        setLayout(new BorderLayout(10, 10));
        add(painelFormulario, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
        add(lblStatus, BorderLayout.NORTH);

        //6. Ações dos botões e checkbox
        chkMostrarSenha.addActionListener(e -> {
            //Se marcado mostra os caracteres
            if (chkMostrarSenha.isSelected()) {
                txtSenha.setEchoChar((char) 0);
            } else {
                txtSenha.setEchoChar('-');
            }
        });

        btnEntrar.addActionListener(e -> {
            String user = txtUsuario.getText().trim();
            String pass = new String(txtSenha.getPassword());

            //Validação simples
            if(user.isEmpty() || pass.isEmpty()){
                JOptionPane.showMessageDialog(
                        this,
                        "Preencha o usuário e senha!",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE
                );
            } else if (user.equals("admin") && pass.equals("1234")){
                JOptionPane.showMessageDialog(
                        this,
                        "Acesso Concedido! Bem vindo ao confre secreto",
                        "Sucesso!",
                        JOptionPane.INFORMATION_MESSAGE
                );
                lblStatus.setText("Status: Logado como " + user);
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Usuário ou senha inválidos!",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        btnLimpar.addActionListener(e -> {
            txtUsuario.setText("");
            txtSenha.setText("");
            chkMostrarSenha.setSelected(false);
            txtSenha.setEchoChar('-');
            lblStatus.setText("Campos limpos com sucesso");
            txtUsuario.requestFocus();
        });
    }

    // 7. Método Main
    public static void main(String[] args){
        SwingUtilities.invokeLater(() ->{
            new CofreLogin().setVisible(true);
        });
    }



}
