/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testeswing.tabela;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rafael
 */
public class TesteTableModel extends AbstractTableModel {

    private int size;

    public TesteTableModel(int size) {
        this.size = size;
    }

    public TesteTableModel() {
    }

    

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;

        super.fireTableChanged(new TableModelEvent(this));
    }

    public int getRowCount() {
        return this.getSize();
    }

    public int getColumnCount() {
        return this.getSize();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return rowIndex + columnIndex;
    }

}
