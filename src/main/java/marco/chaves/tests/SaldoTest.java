package marco.chaves.tests;

import marco.chaves.core.BaseTest;
import marco.chaves.page.HomePage;
import org.junit.Assert;
import org.junit.Test;

public class SaldoTest extends BaseTest {
    HomePage page = new HomePage();

    @Test
    public void testSaldoConta(){
        Assert.assertEquals("1758.00", page.obterSaldoConta("Conta do Teste alterada"));
    }
}
