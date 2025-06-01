package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Bruno Giovani Bressanini Cavalheiro
 */
public class Extrato {

    /**
     * parametros que gardarão os valores do objeto.
     *
     * valor: numero do extrato. data: data que foi preenchido. tipoExtrato:
     * Despesa ou Receita
     */
    private String valor;
    private LocalDate data;
    private Tipo tipoExtrato;

    /**
     * metodo construtor da classe Extrato.
     *
     * @param valor, string contendo o numero de valore e o "." que define os
     * decimais.
     * @param data, valor do campo data, que foi registrado na criação do
     * objeto.
     * @param tipoExtrato, valor salvo durante a criação do objeto, podendo ter
     * um dos seguintes valores Despesa ou Receita.
     */
    public Extrato(String valor, String data, Tipo tipoExtrato) {

        setValor(valor);
        setData(data);
        setTipoExtrato(tipoExtrato);

    }

    /**
     * setter do parametro valor, contendo a string do do numero que era somado
     * ou subtraido, alem de conter o "." que define os decimais.
     *
     * @return string contendo o numero de valore e o "." que define os
     * decimais.
     */
    public String getValor() {
        return valor;
    }

    /**
     * setter do parametro valor, contendo a string do do numero que era somado
     * ou subtraido, alem de conter o "." que define os decimais.
     *
     * @param valor, o valor que foi digitado durante a crição do objeto.
     */
    public void setValor(String valor) {

        Double testeValor = 0.00d;
        String valorDesformatado;

        if (valor.equals(null)) {

            throw new IllegalArgumentException("Valor invalido.");

        } else {

            try {

                valorDesformatado = valor.replace(".", "").replace(",", ".");

                testeValor = Double.valueOf(valorDesformatado);

                this.valor = valorDesformatado;

            } catch (Exception e) {

                throw new IllegalArgumentException("Valor invalido");

            }

        }

    }

    /**
     * getter do parametro data
     *
     * @return o valor do campo data, que foi registrado na criação do objeto.
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * setter do parametro data
     *
     * @param data data digitada pelo ususario na criação do objeto.
     */
    public void setData(String data) {

        if (data.equals(null)) {

            throw new IllegalArgumentException("Data invalida");

        } else {

            try {

                this.data = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            } catch (Exception e) {

                throw new IllegalArgumentException("Data ou formatação de data invalida.");

            }

        }

    }

    /**
     * getter do parametro tipoExtrato.
     *
     * @return um dos valore presentes no enum Tipo, sendo Despesa ou Receita.
     */
    public Tipo getTipoExtrato() {
        return tipoExtrato;
    }

    /**
     * setter que define o tipo de extrato, se é Despesa ou Receita.
     *
     * @param tipoExtrato, valor salvo durante a criação do objeto, podendo ter
     * um dos seguintes valores Despesa ou Receita.
     */
    public void setTipoExtrato(Tipo tipoExtrato) {

        String mensagem = "Tipo invalido de extrato.";

        if (tipoExtrato.equals(null)) {

            throw new IllegalArgumentException(mensagem);

        } else {

            try {

                this.tipoExtrato = tipoExtrato;

            } catch (Exception e) {

                throw new IllegalArgumentException(mensagem);

            }

        }

    }

    /**
     * Validar se a data de registro do extrato é futura ou não.
     *
     * @return true ou false, dependendo do retorno de isAfter.
     */
    public boolean pendente() {

        LocalDate dataAtual = LocalDate.now();

        return getData().isAfter(dataAtual);

    }
}
