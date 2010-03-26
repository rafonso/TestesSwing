/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testeswing.tabela;

import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author rafael
 */
public class TableNumber extends JTable {

    public TableNumber(int size) {
        super(new TesteTableModel(size));

        super.setTableHeader(null);
        super.setFont(new java.awt.Font("Monospaced", 0, 11));
        super.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Largura das Colunas
        int colunas = super.getColumnCount();
        for (int col = 0; col < colunas; col++) {
            TableColumn coluna = super.getColumnModel().getColumn(col);
            coluna.setPreferredWidth(30);
            coluna.setMinWidth(30);
        }
    }

}
