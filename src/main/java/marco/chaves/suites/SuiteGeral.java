package marco.chaves.suites;

import marco.chaves.core.DriverFactory;
import marco.chaves.page.LoginPage;
import marco.chaves.tests.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static marco.chaves.core.DriverFactory.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContaTest.class,
        MovimentacaoTest.class,
        RemoverMovimentacaoContaTest.class,
        SaldoTest.class,
        ResumoTest.class})

public class SuiteGeral {
    private static LoginPage page = new LoginPage();

    @BeforeClass
    public static void reset(){
        page.acessarTelaInicial();

        page.setEmail("macschaves@gmail.com");
        page.setSenha("250978");
        page.entrar();

        page.resetar();

        killDriver();

    }
}
