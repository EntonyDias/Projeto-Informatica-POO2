/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Pedido;

public class PedidoController {
    
    public List<Pedido> listarpedidos() {
        String sql = "SELECT *  from tbpedido ";

        List<Pedido> listaPedidos = new ArrayList<>();

//cria um gerenciador de conexão
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //criar as variaveis vazias antes do try para preenchelas depois

        //ele é usado para complementar a pesquisa caso use uma variavel (os "?")
        PreparedStatement comando = null;

        //ele e o resultado do comando sql usado so quando precisa pegar algo do resultado como um select
        ResultSet resultado = null;

        try {
            //prepara a String sql e tranforma em um comando sql pra o uso, tambem é usado para alterar  o comando quando ha variaveis
            comando = gerenciador.prepararComando(sql);

            //atribuindo coisas nas variaveis

//isso vai executar o comando e guardar na variavel resultado
            resultado = comando.executeQuery();
            //resultado.next() vai passar para a proxima linha no resultado do sql e ele tambem retorna true se tiver outra linha para ser passada e false se nao tiver
            while (resultado.next()) {

                //cria um pedidopara preche-lo
                Pedido ped = new Pedido();

//adicionando os atributos para o pedario
ped.setPkpedido(resultado.getInt("pkpedido"));
        

               
                

//adicionando o ped na lista
                listaPedidos.add(ped);

            }
    
//ele mostra o erro em um JOptinPane se algo der errado no sql
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

            //esse finally sempre  vai ser executado no final mesmo se der errado 
        } finally {
            // ele fecha a conexao com o sql
            gerenciador.fecharConexao(comando, resultado);
        }
        return listaPedidos;
    }
    
    
    
    
    
    
    
     public boolean deletarPedido(int id) {
        String sql = "DELETE FROM tbpedido WHERE pkpedido = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, id);

            comando.executeUpdate();

            return true;

        } catch (SQLException ex) {
            //mostra o erro
            JOptionPane.showMessageDialog(null, "erro ao excluir " + ex);
        } finally {
            //fecha conxao
            gerenciador.fecharConexao(comando);
        }
        return false;
    }
}

