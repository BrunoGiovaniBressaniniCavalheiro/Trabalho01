package Model;

/**
 * @author Bruno Giovani Bressanini Cavalheiro
 */
/**
 * Extratos do tipo receitoa.
 */
public class Receita extends Extrato {

    /**
     * variavel que guarda o tipo da receita, sendo um dos tipos listados em
     * TiposReceitas
     */
    private TiposReceitas tipo;

    /**
     * construtor da classe, que pede os dados para a super casse.
     *
     * @param tiposReceita, um dos valores presentes no enum TiposReceitas.
     * @param valor, string com o valor a ser guardado, incluindo a posição do
     * decimal.
     * @param data, data que a receita foi registrada pelo usuario.
     * @param tipoExtrato, variavel para identificar se é Despesa ou Receita.
     */
    public Receita(TiposReceitas tiposReceita, String valor, String data, Tipo tipoExtrato) {

        super(valor, data, tipoExtrato);
        setTipo(tiposReceita);

    }

    /**
     * getter do tipo, para diferenciar entre os tipos presentes em enum
     * TiposReceitas.
     *
     * @return tipo, sendo o valor escolido durante a criação do objeto, tendo
     * um dos valores do enum TiposReceitas.
     */
    public TiposReceitas getTipo() {
        return tipo;
    }

    /**
     * setter do tipo, para diferenciar entre os tipos presentes em enum
     * TiposReceitas.
     *
     * @param tiposReceita, sendo o valor escolido durante a criação do objeto,
     * tendo um dos valores do enum TiposReceitas.
     */
    public void setTipo(TiposReceitas tiposReceita) {

        String mensagem = "Tipo invalido de receita.";

        if (tiposReceita.equals(null)) {

            throw new IllegalArgumentException(mensagem);

        } else {

            try {

                this.tipo = tiposReceita;

            } catch (Exception e) {

                throw new IllegalArgumentException(mensagem);

            }

        }

    }

}
