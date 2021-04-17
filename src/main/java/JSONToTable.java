import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class JSONToTable {
    TableModel dataModel = new AbstractTableModel() {
        public int getColumnCount() {
            return 10;
        }
        public int getRowCount() {
            return 10;
        }
        public Object getValueAt(int row, int col) {
            return new Integer(row * col);
        }
    };
    JTable table = new JTable(dataModel);
        return table;
}