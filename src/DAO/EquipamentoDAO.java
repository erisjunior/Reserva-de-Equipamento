package DAO;

import MODELO.Professor;
import MODELO.Classificacao;
import MODELO.Equipamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAO  extends ExecuteSQL{

    public EquipamentoDAO(Connection con) {
        super(con);
    }
    
    
public  String Inserir_Equipamento(Equipamento a){

String sql = "INSERT INTO classificacao VALUES (0,?,?)";
try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ps.setString(1,a.getNome());
    ps.setInt(2,a.getimage());
    
    if(ps.executeUpdate() > 0){
        return "Inserido com sucesso";
    }else{
        return "Erro ao Insessir";
                    }
    }catch(SQLException e){
        return e.getMessage();
    }
}

    
    
    

public List<Equipamento>  Listarequipamento(){
    
    String sql = "SELECT idequipamento,nome,image FROM equipamento";
    List<Equipamento> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Equipamento a = new Equipamento();
            a.setCodigo(rs.getInt(1));
            a.setNome(rs.getString(2));
             a.setimage(rs.getInt(3));
                lista.add(a);
            }
        return lista;
    }else{
        return null;
        }
    
    }catch( SQLException e){
        return null;
    }
    
}
     
   public List<Equipamento> Pesquisar_Nome_Equipamennto( String nome){
   String sql = "SELECT idequipamento,nome,image FROM equipamento WHERE nome LIKE '%"+nome+"%'";
   List<Equipamento> lista = new ArrayList<>();
   
    try{
        
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Equipamento a = new Equipamento();
            a.setCodigo(rs.getInt(1));
            a.setNome(rs.getString(2));
            a.setimage(rs.getInt(3));
               lista.add(a);
            }
        return lista;
    }else{
       
        return null;
        }
    
    }catch( SQLException e){
        return null;
    }
    
   }
   
   public List<Equipamento> Pesquisar_Cod_Equipamento( String cod){
   String sql = "SELECT * FROM Equipamento WHERE idequipamento LIKE '%"+cod+"%'";
   List<Equipamento> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Equipamento a = new Equipamento();
            a.setCodigo(rs.getInt(1));
            a.setNome(rs.getString(2));
            a.setimage(rs.getInt(3));
               lista.add(a);
            }
        return lista;
    }else{
        return null;
        }
    
    }catch( SQLException e){
        return null;
    }
    
   }
   
    
    public boolean Testar_Equipamento(int cod){
    boolean Resultado = false;
    try{
    String sql  = "SELECT * FROM equipamento WHERE idequipamento = "+cod+"";
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet  rs = ps.executeQuery();

if( rs!= null){
        while(rs.next()){
        Resultado = true;
        }
    }
    }catch(SQLException ex){
    ex.getMessage();
    }
        return Resultado;
    }

    public List<Equipamento> CapturarEquipamento(int cod){
    String sql = "SELECT *  FROM equipamento WHERE idequipamento = "+cod+"";
    List<Equipamento> lista = new ArrayList<>();
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    if( rs!= null){
    while(rs.next()){
    Equipamento a = new Equipamento();
    a.setCodigo(rs.getInt(1));
    a.setNome(rs.getString(2));
    a.setimage(rs.getInt(3));
    lista.add(a);

    }
    return lista;

    }else{
        return null;
    }
    }catch( SQLException ex ){
    return null;
    }

    }
    
    
    public String Alterar_Equipamento( Equipamento a){
    String sql = "UPDATE equipamento SET nome = ? , image = ?  WHERE idequipamento = ? ";
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
  
    ps.setString(1,a.getNome());
    ps.setInt(2,a.getPreco());
    ps.setInt(3,a.getCodigo());
    
         if(ps.executeUpdate() > 0){
        return "Atualizado com sucesso";}else{ return "Erro ao Atualizar";}
    }catch(SQLException e){
    return e.getMessage();
    }
    
    }

   public List<Equipamento> ListarComboEquipamento(){
   String sql = "SELECT nome FROM equipamento ORDER BY nome";
   List<Equipamento> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
   Equipamento a = new Equipamento();
   a.setNome(rs.getString(1));
   lista.add(a);
   }
   return lista;
   }else{
   
   return null;}
   
   }catch(Exception e){
   return null;}
       
   }
   
   
   public List<Equipamento> ConsultaCodigoEquipamento( String nome){
   String sql = "SELECT idEquipamento FROM equipamento WHERE nome = '"+ nome +"'";
   List<Equipamento> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
   Equipamento a = new Equipamento();
   a.setCodigo(rs.getInt(1));
   lista.add(a);
   }
   return lista;
   }else{
   
   return null;}
   
   }catch( Exception ex){
   return null;
   }
   }
   
   public String Excluir_Equipamento(Equipamento a){
   String sql = "DELETE FROM equipamento WHERE idequipamento = ? AND nome = ?";
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ps.setInt(1, a.getCodigo());
   ps.setString(2,a.getNome());
   
   if(ps.executeUpdate() > 0){
   return "Excluido com Sucesso";
   
   }else{
   
   return "Erro ao Excluir";}
   
   }catch( SQLException e){
   return e.getMessage();
   }
   
   }
   
   
   public List<Equipamento> ProximoEquipamento(){
   String sql = "SELECT MAX(idequipamento) FROM `equipamento`";
   List<Equipamento> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
   Equipamento a = new Equipamento();
   a.setFutCod(rs.getInt(1));
   lista.add(a);
   }
   return lista;
   }else{
   
   return null;}
   
   }catch(Exception e){
   return null;}
       
   }
   

}
