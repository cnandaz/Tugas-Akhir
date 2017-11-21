/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jejemusicstore;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JEJE
 */
public class tableModelStore extends AbstractTableModel {
    List<m_store> lt;

    public tableModelStore(List<m_store> lt) {
        this.lt = lt;
    }

    @Override
    public int getRowCount() {
        return lt.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode_Barang";
            case 1:
                return "Nama_Barang";
            case 2:
                return "Kategori";
            case 3:
                return "Jenis";
            case 4:
                return "Harga";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return lt.get(row).getkode();
            case 1:
                return lt.get(row).getnama();
            case 2:
                return lt.get(row).getkategori();
            case 3:
                return lt.get(row).getjenis();
            case 4:
                return lt.get(row).getharga();
            default:
                return null;
        }
    }
}
