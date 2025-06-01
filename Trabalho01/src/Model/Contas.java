package Model;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * @author Bruno Giovani Bressanini Cavalheiro
 */
public class Contas {

    /**
     * Parametros da classe contas onde:
     * 
     * extrato: é a listagem dos objetos do tipo Despesa ou Receita.
     * documento: objeo utilizado para administração do documento csv.
     */
    private ArrayList<Extrato> extrato;
    private Documento documento = new Documento();

    /**
     * Construtor da classe Contas, ao ser chamado cria uma nova listagem.
     */
    public Contas() {

        setExtrato(new ArrayList<Extrato>());

    }

    /**
     * adição de receita a lista, ordenação da lista e criação de arquivo com o
     * novo dado inserido.
     *
     * @param receita objeto do tipo Receita.
     */
    public void IncluirReceita(Receita receita) {

        extrato.add(receita);

        ordenar();

        documento.Salvar(getExtrato());

    }

    /**
     * adição de despesa a lista, ordenação da lista e criação de arquivo com o
     * novo dado inserido.
     *
     * @param despesa objeto do tipo Despesa
     */
    public void IncluirDespesa(Despesa despesa) {

        extrato.add(despesa);

        ordenar();

        documento.Salvar(getExtrato());

    }

    /**
     * Consultar o saldo que a pessoa tem disponível até a data atual.
     *
     * @return saldo até a data atual.
     */
    public String ConsultarSaldo() {

        double saldo = 0.00d;

        for (Extrato extrato1 : extrato) {

            if (!extrato1.pendente()) {

                if (extrato1.getTipoExtrato().equals(Tipo.Receita)) {

                    saldo = saldo + Double.parseDouble(extrato1.getValor());

                } else if (extrato1.getTipoExtrato().equals(Tipo.Despesa)) {

                    saldo = saldo - Double.parseDouble(extrato1.getValor());

                }
            }
        }

        return NumberFormat.getCurrencyInstance().format(saldo);

    }

    /**
     * Consultar o saldo que a pessoa tem disponível, independente do período.
     *
     * @return saldo total incluindo lansamentos futuros.
     */
    public String ConsultarSaldoTotal() {

        double saldo = 0.00d;

        for (Extrato extrato1 : extrato) {

            if (extrato1.getTipoExtrato().equals(Tipo.Receita)) {

                saldo = saldo + Double.parseDouble(extrato1.getValor());

            } else if (extrato1.getTipoExtrato().equals(Tipo.Despesa)) {

                saldo = saldo - Double.parseDouble(extrato1.getValor());

            }

        }

        return NumberFormat.getCurrencyInstance().format(saldo);

    }

    /**
     * Listar todas as receitas lançadas.
     *
     * @return Lista de todas as receitas lansadas até o momento.
     */
    public String ListarReceitas() {

        String relatorio = "";

        for (Extrato extrato1 : extrato) {

            if (extrato1.getTipoExtrato().equals(Tipo.Receita)) {

                Receita receita = (Receita) extrato1;

                relatorio = relatorio + String.format("Descrição: %s"
                        + "%nValor: %s"
                        + "%nData: %s"
                        + "%n---------------------------------------------------------------------------------------%n",
                        receita.getTipo(),
                        NumberFormat.getCurrencyInstance().format(Double.parseDouble(receita.getValor())),
                        receita.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            }
        }

        return relatorio;

    }

    /**
     * Listar todas as despesas lançadas.
     *
     * @return Lista de todas as despesas registradas até o momentos.
     */
    public String ListarDespesas() {

        String relatorio = "";

        for (Extrato extrato1 : extrato) {

            if (extrato1.getTipoExtrato().equals(Tipo.Despesa)) {

                Despesa despesa = (Despesa) extrato1;

                relatorio = relatorio + String.format("Descrição: %s"
                        + "%nValor: %s"
                        + "%nData: %s"
                        + "%n---------------------------------------------------------------------------------------%n",
                        despesa.getTipo(),
                        NumberFormat.getCurrencyInstance().format(Double.parseDouble(despesa.getValor())),
                        despesa.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            }
        }

        return relatorio;

    }

    /**
     * Listar todos os lançamentos (receitas e despesas) ordenados por data.
     *
     * @return Lista de todas as despesas e receitas.
     */
    public String ListarExtrato() {

        String relatorio = "";
        double saldo = 0.00d;

        for (Extrato extrato1 : extrato) {

            if (extrato1.getTipoExtrato().equals(Tipo.Receita)) {

                saldo = saldo + Double.parseDouble(extrato1.getValor());

            } else if (extrato1.getTipoExtrato().equals(Tipo.Despesa)) {

                saldo = saldo - Double.parseDouble(extrato1.getValor());

            }

            if (extrato1.getTipoExtrato().equals(Tipo.Receita)) {

                Receita receita = (Receita) extrato1;

                relatorio = relatorio + String.format("Tipo: %s "
                        + " %nDescrição: %s "
                        + "%nValor: %s "
                        + "%nSaldo: %s "
                        + "%nData: %s"
                        + "%n---------------------------------------------------------------------------------------%n",
                        receita.getTipoExtrato(),
                        receita.getTipo(),
                        NumberFormat.getCurrencyInstance().format(Double.parseDouble(receita.getValor())),
                        NumberFormat.getCurrencyInstance().format(saldo),
                        receita.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            } else {

                Despesa despesa = (Despesa) extrato1;

                relatorio = relatorio + String.format("Tipo: %s"
                        + "%nDescrição: %s "
                        + "%nValor: %s "
                        + "%nSaldo: %s "
                        + "%nData: %s"
                        + "%n---------------------------------------------------------------------------------------%n",
                        despesa.getTipoExtrato(),
                        despesa.getTipo(),
                        NumberFormat.getCurrencyInstance().format(Double.parseDouble(despesa.getValor())),
                        NumberFormat.getCurrencyInstance().format(saldo),
                        despesa.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            }
        }

        return relatorio;

    }

    /**
     * Getter extrato.
     *
     * @return Objeto com todos os registros das despeas e receitas.
     */
    public ArrayList<Extrato> getExtrato() {
        return extrato;
    }

    /**
     * Setter extrato.
     *
     * @param extrato, a listagem contendo objetos do tipo Despesa ou Receita.
     */
    public void setExtrato(ArrayList<Extrato> extrato) {
        this.extrato = extrato;
    }

    /**
     * Função para ordenar o extrato. pondo as mais recentes por ultimo.
     */
    private void ordenar() {

        int i, j;
        int n = extrato.size() - 1;
        boolean trocou;

        for (i = 0; i < n; i++) {

            trocou = false;

            for (j = n; j > i; j--) {

                if (extrato.get(j).getData().isBefore(extrato.get(j - 1).getData())) {

                    trocar(j, j - 1);
                    trocou = true;

                }

            }

            if (!trocou) {

                break;

            }

        }

    }

    /**
     * Usado para trocar entre os valores da listagem.
     */
    private void trocar(int a, int b) {

        Extrato pivo = extrato.get(a);

        extrato.set(a, extrato.get(b));

        extrato.set(b, pivo);

    }

}
