import dao.generic.jdbc.dao.ClienteDAO;
import dao.generic.jdbc.dao.IClienteDAO;
import domain.Cliente;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ClienteTest {
    private IClienteDAO clienteDAO;

    @Test
    public void cadastrarTest() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Guilherme");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDAO.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel = clienteDAO.excluir(clienteBD);
        assertTrue(countDel == 1);
    }
}

    /**
     *
     * @Test
     *     public void buscarTest() throws Exception {
     *         clienteDAO = new ClienteDAO();
     *
     *         Cliente cliente = new Cliente();
     *         cliente.setCodigo("10");
     *         cliente.setNome("Guilherme");
     *         Integer countCad = clienteDAO.cadastrar(cliente);
     *         assertTrue(countCad == 1);
     *
     *         Cliente clienteBD = clienteDAO.buscar("10");
     *         assertNotNull(clienteBD);
     *         assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
     *         assertEquals(cliente.getNome(), clienteBD.getNome());
     *
     *         Integer countDel = clienteDAO.excluir(clienteBD);
     *         assertTrue(countDel == 1);
     *     }
     *     @Test
     *     public void excluirTest() throws Exception {
     *         clienteDAO = new ClienteDAO();
     *
     *         Cliente cliente = new Cliente();
     *         cliente.setCodigo("10");
     *         cliente.setNome("Guilherme");
     *         Integer countCad = clienteDAO.cadastrar(cliente);
     *         assertTrue(countCad == 1);
     *
     *         Cliente clienteBD = clienteDAO.buscar("10");
     *         assertNotNull(clienteBD);
     *         assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
     *         assertEquals(cliente.getNome(), clienteBD.getNome());
     *
     *         Integer countDel = clienteDAO.excluir(clienteBD);
     *         assertTrue(countDel == 1);
     *     }
     *     @Test
     *     public void buscarTodosTest() throws Exception {
     *         clienteDAO = new ClienteDAO();
     *
     *         Cliente cliente = new Cliente();
     *         cliente.setCodigo("10");
     *         cliente.setNome("Guilherme");
     *         Integer countCad = clienteDAO.cadastrar(cliente);
     *         assertTrue(countCad == 1);
     *
     *         Cliente clientes = new Cliente();
     *         clientes.setCodigo("20");
     *         clientes.setNome("Teste");
     *         Integer countCad2 = clienteDAO.cadastrar(clientes);
     *         assertTrue(countCad2 == 1);
     *
     *         List<Cliente> list = clienteDAO.buscarTodos();
     *         assertNotNull(list);
     *         assertEquals(2, list.size());
     *
     *         int countDel = 0;
     *         for (Cliente cli : list) {
     *             clienteDAO.excluir(cli);
     *             countDel++;
     *         }
     *         assertEquals(list.size(), countDel);
     *
     *         list = clienteDAO.buscarTodos();
     *         assertEquals(list.size(), 0);
     *     }
     *     @Test
     *     public void atualizarTest() throws Exception {
     *         clienteDAO = new ClienteDAO();
     *
     *         Cliente cliente = new Cliente();
     *         cliente.setCodigo("10");
     *         cliente.setNome("Guilherme");
     *         Integer countCad = clienteDAO.cadastrar(cliente);
     *         assertTrue(countCad == 1);
     *
     *         Cliente clienteBD = clienteDAO.buscar("10");
     *         assertNotNull(clienteBD);
     *         assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
     *         assertEquals(cliente.getNome(), clienteBD.getNome());
     *
     *         clienteBD.setCodigo("20");
     *         clienteBD.setNome("Teste");
     *         Integer countUpdate = clienteDAO.atualizar(clienteBD);
     *         assertTrue(countUpdate == 1);
     *
     *         Cliente clienteBD1 = clienteDAO.buscar("10");
     *         assertNotNull(clienteBD1);
     *
     *         Cliente clienteBD2 = clienteDAO.buscar("20");
     *         assertNotNull(clienteBD2);
     *         assertEquals(clienteBD.getId(), clienteBD2.getId());
     *         assertEquals(clienteBD.getCodigo(), clienteBD2.getCodigo());
     *         assertEquals(clienteBD.getNome(), clienteBD2.getNome());
     *
     *         List<Cliente> list = clienteDAO.buscarTodos();
     *         for (Cliente cli : list) {
     *             clienteDAO.excluir(cli);
     *         }
     *     }
     */
}
