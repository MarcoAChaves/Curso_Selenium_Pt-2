package marco.chaves.core;

import marco.chaves.page.LoginPage;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static marco.chaves.core.DriverFactory.*;
import static marco.chaves.core.DriverFactory.getDriver;
import static marco.chaves.core.DriverFactory.killDriver;

public class BaseTest {
    @Rule
    public TestName testName = new TestName();

    private static LoginPage page = new LoginPage();

    @Before
    public void inicializa(){
        page.acessarTelaInicial();

        page.setEmail("macschaves@gmail.com");
        page.setSenha("250978");
        page.entrar();
    }

    @After
    public void finaliza() throws IOException {
        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + ".jpg"));

        if (Propriedades.FECHAR_BROWSER) {
            killDriver();
        }
    }
}

