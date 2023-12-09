import dao.generic.jdbc.dao.ClienteDAO;
import dao.generic.jdbc.dao.IClienteDAO;
import dao.generic.jdbc.dao.IProdutoDAO;
import dao.generic.jdbc.dao.ProdutoDAO;
import domain.Cliente;
import domain.Produto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ProdutoTest {
        private IProdutoDAO produtoDAO;
        @Test
        public void cadastrarTest() throws Exception {
            produtoDAO = new ProdutoDAO();

            Produto produto = new Produto();
            produto.setCodigo("11");
            produto.setNome("TV");
            Integer countCad = produtoDAO.cadastrar(produto);
            assertTrue(countCad == 1);

            Produto produtoBD = produtoDAO.buscar("11");
            assertNotNull(produtoBD);
            assertEquals(produto.getCodigo(), produtoBD.getCodigo());
            assertEquals(produto.getNome(), produtoBD.getNome());

            Integer countDel = produtoDAO.excluir(produtoBD);
            assertTrue(countDel == 1);
        }
        @Test
        public void buscarTest() throws Exception {
            produtoDAO = new ProdutoDAO();

            Produto produto = new Produto();
            produto.setCodigo("12");
            produto.setNome("PC");
            Integer countCad = produtoDAO.cadastrar(produto);
            assertTrue(countCad == 1);

            Produto produtoBD = produtoDAO.buscar("12");
            assertNotNull(produtoBD);
            assertEquals(produto.getCodigo(), produtoBD.getCodigo());
            assertEquals(produto.getNome(), produtoBD.getNome());

            Integer countDel = produtoDAO.excluir(produtoBD);
            assertTrue(countDel == 1);
        }
        @Test
        public void excluirTest() throws Exception {
            produtoDAO = new ProdutoDAO();

            Produto produto = new Produto();
            produto.setCodigo("13");
            produto.setNome("Celular");
            Integer countCad = produtoDAO.cadastrar(produto);
            assertTrue(countCad == 1);

            Produto produtoBD = produtoDAO.buscar("13");
            assertNotNull(produtoBD);
            assertEquals(produto.getCodigo(), produtoBD.getCodigo());
            assertEquals(produto.getNome(), produtoBD.getNome());

            Integer countDel = produtoDAO.excluir(produtoBD);
            assertTrue(countDel == 1);
        }
        @Test
        public void atualizarTest() throws Exception {
            produtoDAO = new ProdutoDAO();

            Produto produto = new Produto();
            produto.setCodigo("14");
            produto.setNome("Celular");
            Integer countCad = produtoDAO.cadastrar(produto);
            assertTrue(countCad == 1);

            Produto produtoBD = produtoDAO.buscar("14");
            assertNotNull(produtoBD);
            assertEquals(produto.getCodigo(), produtoBD.getCodigo());
            assertEquals(produto.getNome(), produtoBD.getNome());

            produtoBD.setCodigo("14");
            produtoBD.setNome("Celular");
            Integer countUpdate = produtoDAO.atualizar(produtoBD);
            assertTrue(countUpdate == 1);

            Produto produtoBD1 = produtoDAO.buscar("14");
            assertNull(produtoBD1);

            Produto produtoBD2 = produtoDAO.buscar("15");
            assertNotNull(produtoBD2);
            assertEquals(produtoBD.getId(), produtoBD2.getId());
            assertEquals(produtoBD.getCodigo(), produtoBD2.getCodigo());
            assertEquals(produtoBD.getNome(), produtoBD2.getNome());

            List<Produto> list = produtoDAO.buscarTodos();
            for (Produto prod : list) {
                produtoDAO.excluir(prod);
            }
        }
        @Test
        public void buscarTodosTest() throws Exception {
            produtoDAO = new ProdutoDAO();
            Produto produto = new Produto();
            produto.setCodigo("16");
            produto.setNome("TV");
            Integer countCad = produtoDAO.cadastrar(produto);
            assertTrue(countCad == 1);

            Produto produtos = new Produto();
            produtos.setCodigo("16");
            produtos.setNome("TV");
            Integer countCad2 = produtoDAO.cadastrar(produtos);
            assertTrue(countCad2 == 1);

            List<Produto> list = produtoDAO.buscarTodos();
            assertNotNull(list);
            assertEquals(2, list.size());

            int countDel = 0;
            for (Produto prod : list) {
                produtoDAO.excluir(prod);
                countDel++;
            }
            assertEquals(list.size(), countDel);

            list = produtoDAO.buscarTodos();
            assertEquals(list.size(), 0);
        }
    }
