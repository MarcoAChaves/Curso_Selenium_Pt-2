package marco.chaves.tests;

import marco.chaves.core.BaseTest;
import marco.chaves.page.ContasPage;
import marco.chaves.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class RemoverMovimentacaoContaTest extends BaseTest {
    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void testExcluirContaComMovimentacao() {
        menuPage.acessarTelaListaConta();
        contasPage.clicarExcluirConta("Conta de Teste alterada");
        Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
    }
}
