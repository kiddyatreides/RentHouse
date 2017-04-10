/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Kid
 */
public class RentHouseModel {
    Koneksi Koneksi = new Koneksi();
    private String username,id,idtipe,idroom;
    private String password;
    private String idcustomer,nama,cardtype,cardnumber,phonenumber,address,birthdate;
    private int price;
    private String status;
    
    public void setID(String id){
        this.id = id;
    }
    public String getID(){
        return this.id;
    }
     public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
     public void setIDRoom(String idroom){
        this.idroom = idroom;
    }
    public String getIDRoom(){
        return this.idroom;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setIDCustomer(String idcustomer){
        this.idcustomer = idcustomer;
    }
    public String getIDCustomer(){
        return this.idcustomer;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getNama(){
        return this.nama;
    }
    public void setCardType(String cardtype){
        this.cardtype = cardtype;
    }
    public String getCardType(){
        return this.cardtype;
    }
    public void setCardNumber(String cardnumber){
        this.cardnumber = cardnumber;
    }
    public String getCardNumber(){
        return this.cardnumber;
    }
    public void setPhoneNumber(String phonenumber){
        this.phonenumber = phonenumber;
    }
    public String getPhoneNumber(){
        return this.phonenumber;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }
    public void setBirthdate(String birthdate){
        this.birthdate = birthdate;
    }
    public String getBirthdate(){
        return this.birthdate;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return this.price;
    }
    public void setIDTipe(String idtipe){
        this.idtipe = idtipe;
    }
    public String getIDTipe(){
        return this.idtipe;
    }
    
     public ArrayList validate()
    {
        boolean status = false;
        ArrayList data = new ArrayList();
        ResultSet rs;
        Connection con = Koneksi.getConnection();
        try
        {
            
             String sql = "select id_admin,nama from admin where username = ? and password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, this.username);
            ps.setString(2, this.password);
            rs = ps.executeQuery();
            
            
            if(rs.next())
            {
                this.setIDCustomer(rs.getString(1));
                this.setNama(rs.getString(2));
                
                // using getter method too add value in arraylist
                data.add(this.getIDCustomer());
                data.add(this.getNama());
                status = true;
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return data;
    }
     
     public int saveCustomer()
    {
        try 
        {
            Connection con = Koneksi.getConnection();
            String sql = "Insert into customer (id_customer,nama,birthdate,address,phonenumber,card_type,card_number) values (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, this.idcustomer);
            ps.setString(2, this.nama);
            ps.setString(3, this.birthdate);
            ps.setString(4, this.address);
            ps.setString(5, this.phonenumber);
            ps.setString(6, this.cardtype);
            ps.setString(7, this.cardnumber);
            
            int res = ps.executeUpdate();
            return res;
            
        } 
        catch (Exception e) 
        {
            System.err.println("Error server store "+ e);
            return 0;
        }
    }
     
      public ResultSet findCustomer(String id) {
        try 
        {
            Connection con = Koneksi.getConnection();
            String sql = "select * from customer where id_customer = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
      
      public int updateCustomer()
    {
        try 
        {
            Connection con = Koneksi.getConnection();
            String sql = "update customer set nama = ?, address = ?, phonenumber = ?, card_type = ?, card_number = ? where id_customer =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(6, this.idcustomer);
            ps.setString(1, this.nama);
            ps.setString(2, this.address);
            ps.setString(3, this.phonenumber);
            ps.setString(4, this.cardtype);
            ps.setString(5, this.cardnumber);
            int res = ps.executeUpdate();
            return res;
            
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return 0;
        }
    }
      
      public int saveRoomType()
    {
        try 
        {
            Connection con = Koneksi.getConnection();
            String sql = "Insert into room_type values (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, this.idcustomer);
            ps.setString(2, this.nama);
            
            int res = ps.executeUpdate();
            return res;
            
        } 
        catch (Exception e) 
        {
            System.err.println("Error server store "+ e);
            return 0;
        }
    }
      
      public ResultSet findRoomType(String id) {
        try 
        {
            Connection con = Koneksi.getConnection();
            String sql = "select * from room_type where id_room_type = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
      
      public int updateRoomType()
    {
        try 
        {
            Connection con = Koneksi.getConnection();
            String sql = "update room_type set name = ? where id_room_type =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(2, this.idcustomer);
            ps.setString(1, this.nama);
            int res = ps.executeUpdate();
            return res;
            
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return 0;
        }
    }
      
       public int saveRoom()
    {
        try 
        {
            Connection con = Koneksi.getConnection();
            String sql = "insert into room (id_room,id_room_type,name,price,status) values (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, this.idroom);
            ps.setString(2, this.idtipe);
            ps.setString(3, this.nama);
            ps.setInt(4, this.price);
            ps.setString(5, "Available");
            
            int res = ps.executeUpdate();
            return res;
            
        } 
        catch (Exception e) 
        {
            System.err.println("Error server store "+ e);
            return 0;
        }
    }
      
      public ResultSet findRoom(String id) {
        try 
        {
            Connection con = Koneksi.getConnection();
            String sql = "select * from room where id_room = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
      
      public int updateRoom()
    {
        try 
        {
            Connection con = Koneksi.getConnection();
            String sql = "update room set name = ?,price = ?,id_room_type = ?, status = ? where id_room =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(5, this.idroom);
            ps.setString(1, this.nama);
            ps.setInt(2, this.price);
            ps.setString(3, this.idtipe);
            ps.setString(4, this.status);
            
            int res = ps.executeUpdate();
            return res;
            
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return 0;
        }
    }
      
       public ArrayList getCategoryIDCombo()
    {
        try
        {
            ResultSet rs;
            Connection con = Koneksi.getConnection();
            Statement stmt = con.createStatement();
            String str = "select * From room_type  ";
            
            rs = stmt.executeQuery(str);
            ArrayList data_client = new ArrayList();
            
            while (rs.next()) {
                this.setIDTipe(rs.getString(1));
                this.setNama(rs.getString(2));
                data_client.add(this.getIDTipe());
                data_client.add(this.getNama());
            }

            return data_client;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
       
        public ArrayList getRoomAvailable()
    {
        try
        {
            ResultSet rs;
            Connection con = Koneksi.getConnection();
            Statement stmt = con.createStatement();
            String str = "select id_room,name From room where status = 'Available'  ";
            
            rs = stmt.executeQuery(str);
            ArrayList data_client = new ArrayList();
            
            while (rs.next()) {
                this.setIDTipe(rs.getString(1));
                this.setNama(rs.getString(2));
                data_client.add(this.getIDTipe());
                data_client.add(this.getNama());
            }

            return data_client;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
        
        public ArrayList getCustomerCombo()
    {
        try
        {
            ResultSet rs;
            Connection con = Koneksi.getConnection();
            Statement stmt = con.createStatement();
            String str = "select id_customer,nama From customer";
            
            rs = stmt.executeQuery(str);
            ArrayList data_client = new ArrayList();
            
            while (rs.next()) {
                this.setIDCustomer(rs.getString(1));
                this.setNama(rs.getString(2));
                data_client.add(this.getIDCustomer());
                data_client.add(this.getNama());
            }

            return data_client;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
        
    public int RentIn()
    {
        try 
        {
            Connection con = Koneksi.getConnection();
            String sql = "Insert into transactionn (id_transaction,id_customer,id_room) values (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, this.id);
            ps.setString(2, this.idcustomer);
            ps.setString(3, this.idroom);
            
            int res = ps.executeUpdate();
            return res;
            
        } 
        catch (Exception e) 
        {
            System.err.println("SALAH DISINI");
            System.err.println("Error server store "+ e);
            return 0;
        }
    }
    
    public ResultSet findRentOut(String id) {
        try 
        {
            Connection con = Koneksi.getConnection();
            String sql = "select a.id_transaction,a.id_room,a.id_customer,b.name as room,c.nama as customer,a.datein,a.dateout,a.status from transactionn a inner join room b on b.id_room = a.id_room inner join customer c on c.id_customer = a.id_customer where a.id_transaction = ? AND a.status = 'Rent In' order by id_transaction asc";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
    
    public int RentOut()
    {
        try 
        {
            Connection con = Koneksi.getConnection();
            String sql = "update transactionn set status = 'Rent Out', dateout = getdate() where id_transaction = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, this.id);
            
            System.out.println("SAMPE SINI1");
            
            int res = ps.executeUpdate();
            System.out.println(String.valueOf(res));
            
            System.out.println("SAMPE SINI2");
            return res;
            
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return 0;
        }
    }
    
    public ArrayList getTransaction()
    {
        try
        {
            ResultSet rs;
            Connection con = Koneksi.getConnection();
            Statement stmt = con.createStatement();
            String str = "select id_transaction,id_room from transactionn where status = 'Rent In'";
            
            rs = stmt.executeQuery(str);
            ArrayList data_client = new ArrayList();
            
            while (rs.next()) {
                this.setID(rs.getString(1));
                this.setIDRoom(rs.getString(1));
                
                data_client.add(this.getID());
                data_client.add(this.getIDRoom());
                
            }

            return data_client;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    public int saveMonthly()
    {
        try 
        {
            Connection con = Koneksi.getConnection();
            String sql = "insert into monthlypaid (id_monthlypaid,id_transaction,info) values (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, this.id);
            ps.setString(2, this.idroom);
            ps.setString(3, this.status);
            
            int res = ps.executeUpdate();
            return res;
            
        } 
        catch (Exception e) 
        {
            System.err.println("Error server store "+ e);
            return 0;
        }
    }
      
    
}
