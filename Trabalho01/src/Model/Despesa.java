package Model;

/**
 * @author Bruno Giovani Bressanini Cavalheiro
 */
/**
 * Extratos do tipo despesa.
 */
public class Despesa extends Extrato {

    /**
     * variavel que guarda o tipo da despesa, sendo um dos tipos listados em
     * TiposDespesas
     */
    private TiposDespesas tipo;

    /**
     * construtor da classe, que pede os dados para a super casse.
     *
     * @param tiposDespesa, um dos valores presentes no enum TiposDespesas.
     * @param valor, string com o valor a ser guardado, incluindo a posição do
     * decimal.
     * @param data, data que a receita foi registrada pelo usuario.
     * @param tipoExtrato, variavel para identificar se é Despesa ou Receita.
     */
    public Despesa(TiposDespesas tiposDespesa, String valor, String data, Tipo tipoExtrato) {

        super(valor, data, tipoExtrato);
        setTipo(tiposDespesa);

    }

    /**
     * getter do tipo, para diferenciar entre os tipos presentes em enum
     * TiposDespesas.
     *
     * @return tipo, sendo o valor escolido durante a criação do objeto, tendo
     * um dos valores do enum TiposDespesas.
     */
    public TiposDespesas getTipo() {
        return tipo;
    }

    /**
     * setter do tipo, para diferenciar entre os tipos presentes em enum
     * TiposDespesas.
     *
     * @param tiposDespesa, sendo o valor escolido durante a criação do objeto,
     * tendo um dos valores do enum TiposDespesas.
     */
    public void setTipo(TiposDespesas tiposDespesa) {

        String mensagem = "Tipo invalido de despesa.";

        if (tiposDespesa.equals(null)) {

            throw new IllegalArgumentException(mensagem);

        } else {

            try {

                this.tipo = tiposDespesa;

            } catch (Exception e) {

                throw new IllegalArgumentException(mensagem);

            }

        }

    }

}
