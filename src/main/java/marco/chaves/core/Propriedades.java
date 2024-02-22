package marco.chaves.core;

public class Propriedades {

    public static boolean FECHAR_BROWSER = true;
    // true - abre e fecha o browser a cada execução, almentando o tempo de teste.
    // false - abre o browser apenas uma vez, otimizando o tempo de execução

    public static Browsers BROWSER = Browsers.FIREFOX;

    public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.GRID;

    public enum Browsers {
        CHROME,
        FIREFOX
    }

    public enum TipoExecucao {
        LOCAL,
        GRID
    }
}
