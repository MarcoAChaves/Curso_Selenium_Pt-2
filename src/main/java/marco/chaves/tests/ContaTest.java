package marco.chaves.tests;

import marco.chaves.core.BaseTest;
import marco.chaves.page.ContasPage;
import marco.chaves.page.MenuPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void test1_InserirConta() {
        menuPage.acessarTelaInserirConta();

        contasPage.setNome("Conta do Teste");
        contasPage.salvar();

        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void test2_AlterarConta() {
        menuPage.acessarTelaListaConta();

        contasPage.clicarAlterarConta("Conta do Teste");

        contasPage.setNome("Conta de Teste alterada");
        contasPage.salvar();

        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void test3_InserirContaComMesmoNome() {
        menuPage.acessarTelaInserirConta();

        contasPage.setNome("Conta de Teste alterada");
        contasPage.salvar();

        Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
    }

}
