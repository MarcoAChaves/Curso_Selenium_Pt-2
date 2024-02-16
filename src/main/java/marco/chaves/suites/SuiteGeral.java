package marco.chaves.suites;

import marco.chaves.core.DriverFactory;
import marco.chaves.page.LoginPage;
import marco.chaves.tests.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContaTest.class,
        MovimentacaoTest.class,
        RemoverMovimentacaoContaTest.class,
        SaldoTest.class,
        ResumoTest.class,
ExcluirContaFinalTest.class})

public class SuiteGeral {
    private static LoginPage page = new LoginPage();

    @BeforeClass
    public static void inicializa() {
        page.acessarTelaInicial();

        page.setEmail("macschaves@gmail.com");
        page.setSenha("250978");
        page.entrar();
    }
    @AfterClass
    public static void finaliza(){
        DriverFactory.killDriver();
    }
}
