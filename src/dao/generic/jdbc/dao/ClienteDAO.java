package dao.generic.jdbc.dao;

import dao.generic.jdbc.ConnectionFactory;
import domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO {
    @Override
    public Integer cadastrar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlInsert();
            stm = connection.prepareStatement(sql);
            adicionarParametrosInsert(stm, cliente);
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }
    @Override
    public Integer atualizar(Cliente cliente) throws Exception {
            Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlUpdate();
            stm = connection.prepareStatement(sql);
            adicionarParametrosUpdate(stm, cliente);
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }
    @Override
    public Cliente buscar(String codigo) throws Exception {
            Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Cliente cliente = null;
            try {
                connection = ConnectionFactory.getConnection();
                String sql = getSqlSelect();
                stm = connection.prepareStatement(sql);
                adicionarParametrosSelect(stm, codigo);
                rs = stm.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String cd = rs.getString("codigo");
                cliente.setId(id);
                cliente.setNome(nome);
                cliente.setCodigo(cd);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
        return cliente;
    }
    @Override
    public List<Cliente> buscarTodos() throws Exception {
            Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Cliente> list = new ArrayList<>();
        Cliente cliente = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlSelectAll();
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String cd = rs.getString("codigo");
                cliente.setId(id);
                cliente.setNome(nome);
                cliente.setCodigo(cd);
                list.add(cliente);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
        return list;
    }
    @Override
    public Integer excluir(Cliente cliente) throws Exception {
            Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlDelete();
            stm = connection.prepareStatement(sql);
            adicionarParametrosDelete(stm, cliente);
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    private void adicionarParametrosDelete(PreparedStatement stm, Cliente cliente) throws SQLException{
        stm.setString(1, cliente.getCodigo());
    }

    private String getSqlDelete() {
        StringBuilder sb = new StringBuilder();
        sb.append("delete from tb_cliente_2 ");
        sb.append("where codigo = ?");
        return sb.toString();
    }
    private void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    private void adicionarParametrosInsert(PreparedStatement stm, Cliente cliente) throws SQLException {
        stm.setString(1, cliente.getCodigo());
        stm.setString(2, cliente.getNome());
    }

    private String getSqlInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into tb_cliente_2 (id, codigo, nome)  ");
        sb.append("values (nextval('sq_cliente_2'), ?, ?)");
        return sb.toString();
    }
    private void adicionarParametrosUpdate(PreparedStatement stm, Cliente cliente) throws SQLException{
        stm.setString(1, cliente.getCodigo());
        stm.setString(2, cliente.getNome());
        stm.setLong(3, cliente.getId());
    }

    private String getSqlUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("update tb_cliente_2  ");
        sb.append("set nome = ?, codigo = ? ");
        sb.append("where id = ?");
        return sb.toString();
    }
    private void adicionarParametrosSelect(PreparedStatement stm, String codigo) throws SQLException {
        stm.setString(1, codigo);
    }

    private String getSqlSelect() {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from tb_cliente_2 ");
        sb.append("where codigo = ?");
        return sb.toString();
    }
    private String getSqlSelectAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from tb_cliente_2 ");
        return sb.toString();
    }
}
