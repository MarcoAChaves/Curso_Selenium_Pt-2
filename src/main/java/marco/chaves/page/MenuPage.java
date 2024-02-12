package marco.chaves.page;

import marco.chaves.core.BasePage;

public class MenuPage extends BasePage {

    public void acessarTelaInserirConta() {
        clicarLink("Contas");
        clicarLink("Adicionar");
    }

    public void acessarTelaListaConta() {
        clicarLink("Contas");
        clicarLink("Listar");
    }
}
