package Model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Bruno Giovani Bressanini Cavalheiro
 */
/**
 * Calsse utilizada apenas para lidar o o documnto csv.
 */
public class Documento {

    /**
     * construtor da calsse.
     */
    public Documento() {
    }

    /**
     * Utilizado para criar uma lista com os valores salvos no documento, caso o
     * documento não exista, apenas retorna uma lista vazia.
     *
     * @return lista de valores do tipo Extrato.
     */
    public ArrayList<Extrato> Carregar() {

        ArrayList<Extrato> novoExtrato = new ArrayList<>();

        if (new File("dados.csv").exists()) {

            try {

                Scanner csv = new Scanner(new File("dados.csv"));

                while (csv.hasNext()) {
                    String[] lista = csv.nextLine().split(";");

                    if ("Receita".equals(lista[0])) {

                        Receita receita = new Receita(TiposReceitas.valueOf(lista[1]),
                                lista[2],
                                lista[3],
                                Tipo.Receita);

                        novoExtrato.add(receita);

                    } else if ("Despesa".equals(lista[0])) {

                        Despesa despesa = new Despesa(TiposDespesas.valueOf(lista[1]),
                                lista[2],
                                lista[3],
                                Tipo.Despesa);

                        novoExtrato.add(despesa);

                    }
                }

                csv.close();

            } catch (Exception e) {

                throw new IllegalArgumentException("Erro inesperado na leitura dos dados.");

            }

        }

        return novoExtrato;

    }

    /**
     * utilizado para criar um novo documeto e apagar o anterior, caso exista.
     *
     * @param extrato a listagem que contem os objetos do tipo Despesa ou
     * Receita.
     */
    public void Salvar(ArrayList<Extrato> extrato) {

        try {

            if (new File("dados.csv").exists()) {

                if (new File("dados.csv").delete()) {

                    preenchDocumento(extrato);

                }

            } else {

                preenchDocumento(extrato);

            }

        } catch (Exception e) {

            throw new IllegalArgumentException("Erro inesperado na hora de finalizar o documento.");

        }

    }

    /**
     * Utilizado para criar um novo arquivo contendo os registros da listagem
     * atual.
     *
     * @param extrato a listagem que contem os objetos do tipo Despesa ou
     * Receita.
     */
    private void preenchDocumento(ArrayList<Extrato> extrato) {

        try {

            File csv = new File("dados.csv");

            FileOutputStream fos = new FileOutputStream(csv, true);
            PrintWriter arquivoTexto = new PrintWriter(fos);

            for (Extrato extrato1 : extrato) {

                if (extrato1.getTipoExtrato().equals(Tipo.Receita)) {

                    Receita receita = (Receita) extrato1;
                    arquivoTexto.println(receita.getTipoExtrato() + ";"
                            + receita.getTipo() + ";"
                            + receita.getValor() + ";"
                            + receita.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                } else {

                    Despesa despesa = (Despesa) extrato1;
                    arquivoTexto.println(despesa.getTipoExtrato() + ";"
                            + despesa.getTipo() + ";"
                            + despesa.getValor() + ";"
                            + despesa.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                }

            }

            arquivoTexto.flush();
            arquivoTexto.close();

        } catch (Exception e) {

            throw new IllegalArgumentException("Erro inesperado na hora de copiar registros.");

        }

    }

}
