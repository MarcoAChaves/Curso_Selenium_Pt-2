package marco.chaves.tests;

import marco.chaves.core.BaseTest;
import marco.chaves.page.MenuPage;
import marco.chaves.page.MovimentacaoPage;
import marco.chaves.utils.DataUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static marco.chaves.utils.DataUtils.obterDataFormatada;


public class MovimentacaoTest extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private MovimentacaoPage movPage = new MovimentacaoPage();

    @Test
    public void test1_InserirMovimentacao() {
        menuPage.acessarTelaInserirMovimentacao();

        movPage.setDataMovimentacao(obterDataFormatada(new Date()));
        movPage.setDataPagamento(obterDataFormatada(new Date()));
        movPage.setDescricao("Movimentação do Teste");
        movPage.setInteressado("Interessado");
        movPage.setValor("500");
        movPage.setConta("Conta para movimentacoes");
        movPage.setStatusPago();
        movPage.salvar();

        Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
    }

    @Test
    public void teste2_CamposObrigatorios() {
        menuPage.acessarTelaInserirMovimentacao();
        movPage.salvar();
        List<String> erros = movPage.obterErros();
        Assert.assertTrue(erros.containsAll(Arrays.asList(
                "Data da Movimentação é obrigatório", "Data do pagamento é obrigatório",
                "Descrição é obrigatório", "Interessado é obrigatório",
                "Valor é obrigatório", "Valor deve ser um número")));
        Assert.assertEquals(6, erros.size());
    }

    @Test
    public void test3_InserirMovimentacaoFutura() {
        menuPage.acessarTelaInserirMovimentacao();

        Date dataFutura = DataUtils.obterDataComDiferencaDias(5);

        movPage.setDataMovimentacao(obterDataFormatada(dataFutura));
        movPage.setDataPagamento(obterDataFormatada(dataFutura));
        movPage.setDescricao("Movimentação de Teste");
        movPage.setInteressado("Interessado");
        movPage.setValor("1758");
        movPage.setConta("Conta para movimentacoes");
        movPage.setStatusPago();
        movPage.salvar();

        List<String> erros = movPage.obterErros();
        Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
        Assert.assertEquals(1, erros.size());
    }
}
