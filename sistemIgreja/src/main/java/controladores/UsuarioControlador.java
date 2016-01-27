/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import util.DAOImpl;
import util.Util;


public class UsuarioControlador implements Serializable {

    private final DAOImpl<Usuario> dao;

    public UsuarioControlador() {
        this.dao = new DAOImpl<>(Util.pegarSessao(), Usuario.class);
    }

    public boolean excluir(Usuario usuario) {
        boolean ok;
        try {
            this.dao.excluir(usuario);
            Util.criarAviso("usuario excluido com sucesso");
            ok = true;
        } catch (Exception e) {
            Util.criarAvisoErro("erro");
            ok = false;
        }
        return ok;
    }

    public List<Usuario> listar(String hql) {
        return this.dao.listar(hql);
    }

    public Usuario carregar(String hql) {
        return this.dao.carregar(hql);
    }

}
