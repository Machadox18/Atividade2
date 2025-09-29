import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class NavegadorSimples extends JFrame {
    private JTextField enderecoTxt;
    private JEditorPane editorPagina;
    private JButton btnAbrir, btnFechar;

    public NavegadorSimples() {
        super("Navegador Simples");

        // Campo de texto para digitar a URL
        enderecoTxt = new JTextField("https://stackoverflow.com", 30);

        // Botões
        btnAbrir = new JButton("Abrir");
        btnFechar = new JButton("Fechar");

        // Editor de página
        editorPagina = new JEditorPane();
        editorPagina.setEditable(false); // não permite editar
        JScrollPane scroll = new JScrollPane(editorPagina);

        
        JPanel painelSuperior = new JPanel();
        painelSuperior.add(enderecoTxt);
        painelSuperior.add(btnAbrir);
        painelSuperior.add(btnFechar);


        btnAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    editorPagina.setPage(new URL(enderecoTxt.getText()));
                } catch (MalformedURLException ex) {
                    JOptionPane.showMessageDialog(null, "URL inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao carregar a página!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnFechar.addActionListener(e -> System.exit(0));


        add(painelSuperior, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);


        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NavegadorSimples::new);
    }
}
