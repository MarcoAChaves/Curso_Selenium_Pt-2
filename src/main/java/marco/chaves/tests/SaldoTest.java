package marco.chaves.tests;

import marco.chaves.core.BaseTest;
import marco.chaves.page.HomePage;
import marco.chaves.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class SaldoTest extends BaseTest {
    HomePage page = new HomePage();
    MenuPage menu = new MenuPage();

    @Test
    public void testSaldoConta(){
        menu.acessarTelaPrincipal();
        Assert.assertEquals("534.00", page.obterSaldoConta("Conta para saldo"));
    }
}
