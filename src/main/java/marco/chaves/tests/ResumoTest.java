package marco.chaves.tests;

import marco.chaves.core.BaseTest;
import marco.chaves.page.MenuPage;
import marco.chaves.page.ResumoPage;
import org.junit.Assert;
import org.junit.Test;

public class ResumoTest extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private ResumoPage resumoPage = new ResumoPage();

    @Test
    public void testExcluirMovimentacao(){
        menuPage.acessarTelaResumo();
        resumoPage.excluirMovimentacao();

        Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
    }
}
