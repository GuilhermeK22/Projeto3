import dao.generic.jdbc.dao.ClienteDAO;
import dao.generic.jdbc.dao.IClienteDAO;
import domain.Cliente;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteTest {
    @Test
    public void cadastrarTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Guilherme");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd ==1);

        Cliente clienteBD = dao.buscar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDe1 = dao.excluir(clienteBD);
        assertNotNull(qtdDe1);
    }
}
