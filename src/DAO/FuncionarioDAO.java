
package DAO;

import java.sql.*;
import MODELO.Funcionario;
import java.util.ArrayList;
import java.util.List;

 
public class FuncionarioDAO extends ExecuteSQL{

    public FuncionarioDAO(Connection con){
        super(con);
    }
    
    public boolean Logar(String login, String senha){
        boolean finalResult = false;
        
        String consulta = "SELECT login,senha "
                + "FROM funcionario WHERE "
                + "login = '"+login+"' AND "
                + "senha = '"+senha+"'";
        
        try {
            PreparedStatement ps = 
            getCon().prepareStatement(consulta);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Funcionario a = new Funcionario();
                    a.setLogin(rs.getString(1));
                    a.setSenha(rs.getString(2));
                    finalResult = true;
                }
            }
            
        } catch (SQLException ex) {
           ex.getMessage();
        }
    return finalResult;
    }

    
    
public  String Inserir_Funcionario(Funcionario a){

String sql = "INSERT INTO funcionario VALUES (0,?,?,?)";
try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ps.setString(1,a.getNome());
    ps.setString(2,a.getLogin());
     ps.setString(3,a.getSenha());
    
    if(ps.executeUpdate() > 0){
        return "Inserido com sucesso";
    }else{
        return "Erro ao Insessir";
                    }
    }catch(SQLException e){
        return e.getMessage();
    }
}
    
    

public List<Funcionario>  ListarFuncionario(){
    
    String sql = "SELECT idfuncionario,nome,login FROM funcionario";
    List<Funcionario> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
           Funcionario a = new Funcionario();
            a.setCod(rs.getInt(1));
            a.setNome(rs.getString(2));
            a.setLogin(rs.getString(3));
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

 
   public List<Funcionario> Pesquisar_Nome_Funcionario( String nome){
   String sql = "SELECT idfuncionario,nome,login FROM funcionario WHERE nome LIKE '%"+nome+"%'";
   List<Funcionario> lista = new ArrayList<>();
   
    try{
        
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Funcionario a = new Funcionario();
             a.setCod(rs.getInt(1));
            a.setNome(rs.getString(2));
             a.setLogin(rs.getString(3));
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
    
   
   
   public List<Funcionario> Pesquisar_Cod_Funcionario( String cod){
   String sql = "SELECT idfuncionario,nome,login FROM funcionario WHERE idFuncionario LIKE '%"+cod+"%'";
   List<Funcionario> lista = new ArrayList<>();
   
    try{
        
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Funcionario a = new Funcionario();
             a.setCod(rs.getInt(1));
            a.setNome(rs.getString(2));
             a.setLogin(rs.getString(3));
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

    
    public boolean Testar_Funcionario(int cod){
    boolean Resultado = false;
    try{
    String sql  = "SELECT * FROM funcionario WHERE idfuncionario = "+cod+"";
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
    
    public List<Funcionario> CapturarFuncionario (int cod){
    String sql = "SELECT *  FROM funcionario WHERE idfuncionario = "+cod+"";
    List<Funcionario> lista = new ArrayList<>();
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    if( rs!= null){
    while(rs.next()){
    Funcionario a = new Funcionario();
    a.setCod(rs.getInt(1));
    a.setNome(rs.getString(2));
    a.setLogin(rs.getString(3));
    a.setSenha(rs.getString(4));
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
    
    
    public String Alterar_Funcionario( Funcionario a){
    String sql = "UPDATE funcionario SET nome = ? , login = ? , senha = ? WHERE idfuncionario = ? ";
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
  
    ps.setString(1,a.getNome());
    ps.setString(2,a.getLogin());
    ps.setString(3,a.getSenha());
    ps.setInt(4,a.getCod());
    
         if(ps.executeUpdate() > 0){
        return "Atualizado com sucesso";}else{ return "Erro ao Atualizar";}
    }catch(SQLException e){
    return e.getMessage();
    }
    
    }
    
    
    
   public List<Funcionario> ListarComboFuncionario(){
   String sql = "SELECT nome FROM funcionario ORDER BY nome";
   List<Funcionario> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
   Funcionario a = new Funcionario();
   a.setNome(rs.getString(1));
   lista.add(a);
   }
   return lista;
   }else{
   
   return null;}
   
   }catch(Exception e){
   return null;}
       
   }
   
   
   public List<Funcionario> ConsultaCodigoFuncionario( String nome){
   String sql = "SELECT idfuncionario FROM Funcionario WHERE nome = '"+ nome +"'";
   List<Funcionario> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
   Funcionario a = new Funcionario();
   a.setCod(rs.getInt(1));
   lista.add(a);
   }
   return lista;
   }else{
   
   return null;}
   
   }catch( Exception ex){
   return null;
   }
   }
   
   
   public String Excluir_Funcionario(Funcionario a){
   String sql = "DELETE FROM funcionario WHERE idfuncionario = ? AND nome = ?";
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ps.setInt(1, a.getCod());
   ps.setString(2,a.getNome());
   
   if(ps.executeUpdate() > 0){
   return "Excluido com Sucesso";
   
   }else{
   
   return "Erro ao Excluir";}
   
   }catch( SQLException e){
   return e.getMessage();
   }
   
   }


   
   public List<Funcionario> ProximoFuncionario(){
   String sql = "SELECT MAX(idfuncionario) FROM `funcionario`";
   List<Funcionario> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
  Funcionario a = new  Funcionario();
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

