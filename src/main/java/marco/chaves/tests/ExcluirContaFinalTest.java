package marco.chaves.tests;

import marco.chaves.core.BaseTest;
import marco.chaves.page.ContasPage;
import marco.chaves.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class ExcluirContaFinalTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void testExcluirContaFinal() {
        menuPage.acessarTelaListaConta();
        contasPage.clicarExcluirConta("Conta de Teste alterada");
        Assert.assertEquals("Conta removida com sucesso!", contasPage.obterMensagemSucesso());
    }
}
