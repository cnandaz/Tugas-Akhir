/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jejemusicstore;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import jejemusicstore.DBKonek;
import java.sql.Statement;

/**
 * FXML Controller class
 *
 * @author SuperJeje
 */
public class pembeliController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private RadioButton BCA;
    @FXML
    private RadioButton Mandiri;
    @FXML
    private RadioButton COD;
    @FXML
    private JFXTextField nama;
    @FXML
    private JFXTextField alamat;
    @FXML
    private JFXTextField notelp;
    @FXML
    private Button proses;
    @FXML
    private Button batal;
    @FXML
    private Button keluar;
    @FXML
    private Button load;
    private ObservableList<BarangDetail>data;
    private DBKonek dc;
    @FXML
    private TextArea ta1;
    @FXML
    private TableView<BarangDetail> tabeldaftar;
    @FXML
    private TableColumn<BarangDetail, String> kode_barangID;
    @FXML
    private TableColumn<BarangDetail, String> nama_barangID;
    @FXML
    private TableColumn<BarangDetail, String> kategoriID;
    @FXML
    private TableColumn<BarangDetail, String> jenisID;
    @FXML
    private TableColumn<BarangDetail, String> hargaID;

    @FXML
    private TextField txtkode;

    @FXML
    private TextField txtnama;

    @FXML
    private TextField txtkategori;

    @FXML
    private TextField txtjenis;

    @FXML
    private TextField txtharga;
    
    Connection conn;
    Statement stat;
    ResultSet rs;
    String sql;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DBKonek DB = new DBKonek();
        DB.connectdb();
        conn = DB.conn;
        stat = DB.pst; 
        
        tabeldaftar.setOnMousePressed(new EventHandler<MouseEvent>(){
       
        public void handle(MouseEvent event) {
        String kodebarang = tabeldaftar.getSelectionModel().getSelectedItem().getKode_Barang();
        String namabarang = tabeldaftar.getSelectionModel().getSelectedItem().getNama_Barang();
        String kategori = tabeldaftar.getSelectionModel().getSelectedItem().getKategori();
        String jenis = tabeldaftar.getSelectionModel().getSelectedItem().getJenis();
        String harga = tabeldaftar.getSelectionModel().getSelectedItem().getHarga();
        
        txtkode.setText(kodebarang);
        txtnama.setText(namabarang);
        txtkategori.setText(kategori);
        txtjenis.setText(jenis);
        txtharga.setText(harga);
        
        }
    });  
    } 
    
            
    @FXML
    private void proses(ActionEvent event) {
        if(nama.getText().equals("") || alamat.getText().equals("") || notelp.getText().equals("") || txtkode.getText().equals("") || txtnama.getText().equals("") || txtkategori.getText().equals("") || txtjenis.getText().equals("") || txtharga.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap Lengkapi Data Anda");
        }else{
        String ta11 = "";
        String Nama = nama.getText();
        String Kode = txtkode.getText();
        String Musik = txtnama.getText();
        String Ktgr = txtkategori.getText();
        String Jns = txtjenis.getText();
        String Harga = txtharga.getText();
        String Alamat = alamat.getText();
        int Notelp = Integer.parseInt(notelp.getText());
        
        if(BCA.isSelected()){
            ta1.setText("Nama Pembeli : "+Nama+"\nKode Alat Musik : "+Kode+"\nAlat Musik yang dipesan : "+Musik+"\nAlamat Rumah : "+Alamat+"\nKategori Musik : "+Ktgr+"\nJenis Pengiriman : "+Jns+"\nHarga Barang : Rp. "+Harga+"\nNo Telpon : "+Notelp+"\nMetode Pembayaran : BCA"+"\nPesanan "+Nama+" akan segera dikirim\nHarap segera selesaikan pembayaran");
        }
        else if(Mandiri.isSelected()){
            ta1.setText("Nama Pembeli : "+Nama+"\nKode Alat Musik : "+Kode+"\nAlat Musik yang dipesan : "+Musik+"\nAlamat Rumah : "+Alamat+"\nKategori Musik : "+Ktgr+"\nJenis Pengiriman : "+Jns+"\nHarga Barang : Rp. "+Harga+"\nNo Telpon : "+Notelp+"\nMetode Pembayaran : Mandiri"+"\nPesanan "+Nama+" akan segera dikirim\nHarap segera selesaikan pembayaran");
        }
        else if(COD.isSelected()){
            ta1.setText("Nama Pembeli : "+Nama+"\nKode Alat Musik : "+Kode+"\nAlat Musik yang dipesan : "+Musik+"\nAlamat Rumah : "+Alamat+"\nKategori Musik : "+Ktgr+"\nJenis Pengiriman : "+Jns+"\nHarga Barang : Rp. "+Harga+"\nNo Telpon : "+Notelp+"\nMetode Pembayaran : COD"+"\nPesanan "+Nama+" akan segera dikirim\nPembayaran dilakukan di Rumah Anda");
        }
        else{
                JOptionPane.showMessageDialog(null, "Harap Lengkapi Data Anda");
                ta11 = "";
            ta1.setText(ta11);        
        }
        }
        }
    
                
            
          
        
                
    @FXML
    void batal(ActionEvent event) {
        nama.setText("");
        txtkode.setText("");
        txtnama.setText("");
        txtkategori.setText("");
        txtjenis.setText("");
        txtharga.setText("");
        alamat.setText("");
        notelp.setText("");
        BCA.setSelected(false);
        Mandiri.setSelected(false);
        COD.setSelected(false);
        ta1.setText("");
    }
    @FXML
    private void load(ActionEvent event) {
        Connection conn;
        Statement stat;

        DBKonek DB = new DBKonek();
        DB.connectdb();
        conn = DB.conn;
        stat = (Statement) DB.pst;
        try{
            data = FXCollections.observableArrayList();
            
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM barang");
            while (rs.next()){
                data.add(new BarangDetail(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
        }catch(SQLException ex){
            System.err.println("Error"+ex);
        }
        
        kode_barangID.setCellValueFactory(new PropertyValueFactory<>("kode_barang"));
        nama_barangID.setCellValueFactory(new PropertyValueFactory<>("nama_barang"));
        kategoriID.setCellValueFactory(new PropertyValueFactory<>("kategori"));
        jenisID.setCellValueFactory(new PropertyValueFactory<>("jenis"));
        hargaID.setCellValueFactory(new PropertyValueFactory<>("harga"));
        
        tabeldaftar.setItems(null);
        tabeldaftar.setItems(data);
    }
    
 

    @FXML
    void keluar(ActionEvent event){
        try{
            //Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            //Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("adminpembeli.fxml"));
            Scene scene = new Scene (fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
            catch (IOException e){
            System.out.println("Failed to create Window." + e);
        }
    }

    
}
    

   

