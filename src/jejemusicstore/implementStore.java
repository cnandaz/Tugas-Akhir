/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jejemusicstore;
import java.util.List;
import jejemusicstore.m_store;
/**
 *
 * @author JEJE
 */
public interface implementStore {
    public void TampilData(m_store a);
    public void UbahData(m_store a);
    public void SimpanData(m_store a);
    public void HapusData(String kode);
    public List<m_store> getCariKategori(String kategori);
    public List<m_store> getAll();
    public String user = "";
}
