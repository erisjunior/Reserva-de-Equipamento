package DAO;

import MODELO.Professor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class ProfessorDAO  extends ExecuteSQL{

    public ProfessorDAO(Connection con) {
        super(con);
    }

   
    

    

public  String Inserir_Categoria (Professor a){

String sql = "INSERT INTO categoria VALUES (0,?)";
try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ps.setString(1,a.getNome());
    
    if(ps.executeUpdate() > 0){
        return "Inserido com sucesso";
    }else{
        return "Erro ao Insessir";
                    }
    }catch(SQLException e){
        return e.getMessage();
    }
}

    
    
    

public List<Professor>  ListarCategoria(){
    
    String sql = "SELECT idcategoria,nome FROM categoria";
    List<Professor> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Professor a = new Professor();
            a.setCodigo(rs.getInt(1));
            a.setNome(rs.getString(2));
                
            }
        return (List<Professor>) lista;
    }else{
        return null;
        }
    
    }catch( SQLException e){
        return null;
    }
    
}
     
   public List<Professor> Pesquisar_Nome_Professor( String nome){
   String sql = "SELECT * FROM categoria WHERE nome LIKE '%"+nome+"%'";
   List<Professor> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Professor a = new Professor();
            a.setCodigo(rs.getInt(1));
            a.setNome(rs.getString(2));
            
            
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
   
     
   public List<Professor> Pesquisar_Cod_Professor( String cod){
   String sql = "SELECT * FROM categoria WHERE idcategoria LIKE '%"+cod+"%'";
   List<Professor> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Professor a = new Professor();
            a.setCodigo(rs.getInt(1));
            a.setNome(rs.getString(2));
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
    
    public boolean Testar_Professor(int cod){
    boolean Resultado = false;
    try{
    String sql  = "SELECT * FROM Professor WHERE idfuncionario = "+cod+"";
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

    public List<Professor> CapturarProfessor(int cod){
    String sql = "SELECT *  FROM Professor WHERE nome = "+cod+"";
    List<Professor> lista = new ArrayList<>();
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    if( rs!= null){
    while(rs.next()){
    Professor a = new Professor();
    a.setCodigo(rs.getInt(1));
    a.setNome(rs.getString(2));
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
    
    public String Alterar_Professor( Professor a){
    String sql = "UPDATE categoria SET nome = ?   WHERE nome = ? ";
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    
    ps.setString(1, a.getNome());
    ps.setInt(2, a.getCodigo());
        if(ps.executeUpdate() > 0){
        return "Atualizado com sucesso";}else{ return "Erro ao Atualizar";}
    }catch(SQLException e){
    return e.getMessage();
    }
    
    }

   public List<Professor> ListarComboProfessor(){
   String sql = "SELECT nome FROM Professor ORDER BY nome";
   List<Professor> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
   Professor a = new Professor();
   a.setNome(rs.getString(1));
   lista.add(a);
   }
   return lista;
   }else{
   
   return null;}
   
   }catch(Exception e){
   return null;}
       
   }
   
   
   public List<Professor> ConsultaCodigoProfessor( String nome){
   String sql = "SELECT idcategoria FROM Professor WHERE nome = '"+ nome +"'";
   List<Professor> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
   Professor a = new Professor();
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
   
   public String Excluir_Funcionario(Professor a){
   String sql = "DELETE FROM professor WHERE idfuncionario = ? AND nome = ?";
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
   
   
   
   public List<Professor> ProximoProfessor(){
   String sql = "SELECT MAX(idcategoria) FROM `Professor`";
   List<Professor> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
   Professor a = new Professor();
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
