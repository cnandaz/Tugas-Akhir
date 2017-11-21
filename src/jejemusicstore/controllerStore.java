/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jejemusicstore; 
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import jejemusicstore.daoStore;
import jejemusicstore.implementStore;
import jejemusicstore.m_store;
import jejemusicstore.home;
import jejemusicstore.tableModelStore;

/**
 *
 * @author Jeje
 */
public class controllerStore {
    home hm;
    implementStore impStore;
    List<m_store> lt;

    public controllerStore(home hm) {
        this.hm = hm;
        impStore = new daoStore();
        lt = impStore.getAll();
    }

    //mengkosongkan isian field     
    public void Reset() {
        hm.getTxtKode().setText("");
        hm.getTxtNama().setText("");
        hm.getTxtHarga().setText("");
        hm.getCbKategori().setSelectedItem(null);
        hm.getCbJenis().setSelectedItem(null);
    }      
    //menghapus data yang dipilih     
    public void Hapus() {
        if (hm.getTxtKode().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(hm, "Masukkan kode barang");
        } else {
            String kode = (hm.getTxtKode().getText());
            impStore.HapusData(kode);
            JOptionPane.showMessageDialog(hm, "Data berhasil dihapus");
        }
    }     
    //menyimpan data     
    public void SimpanData() {
        m_store store = new m_store();
        store.setkode(hm.getTxtKode().getText());
        store.setnama(hm.getTxtNama().getText());
        store.setharga(hm.getTxtHarga().getText());
        store.setkategori(hm.getCbKategori().getSelectedItem().toString());
        store.setjenis(hm.getCbJenis().getSelectedItem().toString());
        impStore.SimpanData(store);
    }     
    //mengubah data     
    public void Ubah() {
        m_store store = new m_store();
        store.setkode(hm.getTxtKode().getText());
        store.setnama(hm.getTxtNama().getText());
        store.setkategori(hm.getCbKategori().getSelectedItem().toString());
        store.setjenis(hm.getCbJenis().getSelectedItem().toString());
        store.setharga(hm.getTxtHarga().getText());
        impStore.UbahData(store);
    }
    public void isiTable() {
        lt = impStore.getAll();
        tableModelStore tmt = new tableModelStore(lt);
        hm.getTableData().setModel(tmt);
    }

    public void isiField(int row) {
        hm.getTxtKode().setText(lt.get(row).getkode().toString());
        hm.getTxtNama().setText(lt.get(row).getnama().toString());
        hm.getCbKategori().setSelectedItem(lt.get(row).getkategori().toString());
        hm.getCbJenis().setSelectedItem(lt.get(row).getjenis().toString());
        hm.getTxtHarga().setText(lt.get(row).getharga().toString());
    }

    public void CariKategori() {
        if (!hm.getCbCariKategori().getSelectedItem().toString().isEmpty()) {
            isiTableCariKategori();
        } else {
            JOptionPane.showMessageDialog(hm, "Silahkan Pilih Kategori");
        }
    }

    private void isiTableCariKategori() {
        String item = hm.getCbCariKategori().getSelectedItem().toString();
        lt = impStore.getCariKategori(item);
        tableModelStore tmt = new tableModelStore(lt);
        hm.getTableData().setModel(tmt);
    }
}
