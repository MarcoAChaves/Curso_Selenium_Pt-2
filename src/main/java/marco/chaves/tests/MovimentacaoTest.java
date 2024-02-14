package marco.chaves.tests;

import marco.chaves.core.BaseTest;
import marco.chaves.page.MenuPage;
import marco.chaves.page.MovimentacaoPage;
import org.junit.Assert;
import org.junit.Test;

public class MovimentacaoTest extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private MovimentacaoPage movPage = new MovimentacaoPage();

    @Test
    public void testInserirMovimentacao(){
        menuPage.acessarTelaInserirMovimentacao();

        movPage.setDataMovimentacao("01/09/2017");
        movPage.setDataPagamento("02/09/2017");
        movPage.setDescricao("Movimentação do Teste");
        movPage.setInteressado("Interessado");
        movPage.setValor("500");
        movPage.setConta("Conta do Teste alterada");
        movPage.setStatusPago();
        movPage.salvar();

        Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());


    }
}
