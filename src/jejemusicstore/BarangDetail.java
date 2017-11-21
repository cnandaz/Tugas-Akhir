/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jejemusicstore;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author JEJE
 */
public class BarangDetail {
    private final StringProperty Kode_Barang;
    private final StringProperty Nama_Barang;
    private final StringProperty Kategori;
    private final StringProperty Jenis;
    private final StringProperty Harga;
    
    public BarangDetail(String kode_barang, String nama_barang, String kategori, String jenis, String harga){
        this.Kode_Barang = new SimpleStringProperty(kode_barang);
        this.Nama_Barang = new SimpleStringProperty(nama_barang);
        this.Kategori = new SimpleStringProperty(kategori);
        this.Jenis = new SimpleStringProperty(jenis);
        this.Harga = new SimpleStringProperty(harga); 
    }
    
    public String getKode_Barang(){
        return Kode_Barang.get();
    }
    
    public String getNama_Barang(){
        return Nama_Barang.get();
    }
    
    public String getKategori(){
        return Kategori.get();
    }
    
    public String getJenis(){
        return Jenis.get();
    }
    
    public String getHarga(){
        return Harga.get();
    }
    
    
    
    public void setKode_Barang(String value){
        Kode_Barang.set(value);
    }
    
    public void setNama_Barang(String value){
        Nama_Barang.set(value);
    }
    
    public void setKategori(String value){
        Kategori.set(value);
    }
    
    public void setJenis(String value){
        Jenis.set(value);
    }
    
    public void setHarga(String value){
        Harga.set(value);
    }
    
    
    
    public StringProperty kode_barangProperty(){
        return Kode_Barang;
    }
    
    public StringProperty nama_barangProperty(){
        return Nama_Barang;
    }
    
    public StringProperty kategoriProperty(){
        return Kategori;
    }
    
    public StringProperty jenisProperty(){
        return Jenis;
    }
    
    public StringProperty hargaProperty(){
        return Harga;
    }
    
}
