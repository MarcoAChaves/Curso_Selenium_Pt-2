package marco.chaves.tests;

import marco.chaves.core.BaseTest;
import marco.chaves.page.ContasPage;
import marco.chaves.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class ContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void testInserirConta() {
        menuPage.acessarTelaInserirConta();

        contasPage.setNome("Conta do Teste");
        contasPage.salvar();

        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
    }
}
