/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author S.lucas
 */
public class Pedido {

    private int pkpedido;
    private int fkusuario;
    private int fkproduto;

    public Pedido(int pkpedido, int fkusuario, int fkproduto) {
        this.pkpedido = pkpedido;
        this.fkusuario = fkusuario;
        this.fkproduto = fkproduto;
    }

    public Pedido() {
    }

    public int getPkpedido() {
        return pkpedido;
    }

    public void setPkpedido(int pkpedido) {
        this.pkpedido = pkpedido;
    }

    public int getFkusuario() {
        return fkusuario;
    }

    public void setFkusuario(int fkusuario) {
        this.fkusuario = fkusuario;
    }

    public int getFkproduto() {
        return fkproduto;
    }

    public void setFkproduto(int fkproduto) {
        this.fkproduto = fkproduto;
    }
    

}
