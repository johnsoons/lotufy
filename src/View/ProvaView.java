package View;

import DAO.ProvaDAO;
import Model.Prova;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 * @author Rosicléia Frasson
 */
public class ProvaView extends JFrame {
    JPanel painelFundo;
    JTable tabela;
    JScrollPane barraRolagem;
    

    public ProvaView() {
        super ();
    }
    
    public void criaJanela() throws ClassNotFoundException, SQLException{
        String[] colunas = { "*", "Data", "Professor", "Matéria" };
        ArrayList<Prova> provas = ProvaDAO.getAll();
        DefaultTableModel tabelaM = new DefaultTableModel(colunas, 0);
        for (int i = 0; i < provas.size(); i++) {
            
            String dataP = provas.get(i).getDate();
            Object[] dados = {i+1, dataP, "Vinicius Rosalen da Silva", "Programaçãp Orientada a Objectos"};
            tabelaM.addRow(dados);
        }
        
        JTable table = new JTable(tabelaM);
        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
            }
        });
        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1, 1));
        barraRolagem = new JScrollPane(table);
        painelFundo.add(barraRolagem); 
        
        getContentPane().add(painelFundo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ProvaView lc = new ProvaView();
        lc.criaJanela();
    }
}