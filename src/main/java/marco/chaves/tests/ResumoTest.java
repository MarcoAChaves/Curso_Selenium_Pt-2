package marco.chaves.tests;

import marco.chaves.core.BaseTest;
import marco.chaves.core.DriverFactory;
import marco.chaves.page.MenuPage;
import marco.chaves.page.ResumoPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResumoTest extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private ResumoPage resumoPage = new ResumoPage();

    @Test
    public void test1_ExcluirMovimentacao() {
        menuPage.acessarTelaResumo();
        resumoPage.excluirMovimentacao();

        Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
    }

    @Test
    public void test2_ResumoMensal(){
        menuPage.acessarTelaResumo();
        Assert.assertEquals("Seu Barriga - Extrato",
                DriverFactory.getDriver().getTitle());

        resumoPage.selecionarAno("2016");
        resumoPage.buscar();

        List<WebElement> elementosEncontrados =
                DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
        Assert.assertEquals(0, elementosEncontrados.size());
    }
}
