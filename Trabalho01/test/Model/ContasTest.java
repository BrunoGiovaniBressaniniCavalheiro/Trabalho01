package Model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Bruno Giovani Bressanini Cavalheiro
 */
public class ContasTest {

    public ContasTest() {
    }

    /**
     * IncluirReceita(Receita receita)
     *
     * Verificar a inserção de um valor invalido.
     */
    @Test
    public void testIncluirReceitaValor() {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {

            Contas contas = new Contas();

            Receita receita = new Receita(TiposReceitas.OutrasReceitas,
                    "11,A0",
                    "11/11/1111",
                    Tipo.Receita);

            contas.IncluirReceita(receita);

        });

        String esperado = "Valor invalido";

        assertEquals(esperado, ex.getMessage());

    }

    /**
     * IncluirReceita(Receita receita)
     *
     * Verificar a inserção de uma data invalido.
     */
    @Test
    public void testIncluirReceitaData() {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {

            Contas contas = new Contas();

            Receita receita = new Receita(TiposReceitas.OutrasReceitas,
                    "11,00",
                    "11/1A/1111",
                    Tipo.Receita);

            contas.IncluirReceita(receita);

        });

        String esperado = "Data ou formatação de data invalida.";

        assertEquals(esperado, ex.getMessage());

    }

    /**
     * public void IncluirDespesa(Despesa despesa)
     *
     * Verificar a inserção de um valor invalido.
     */
    @Test
    public void testIncluirDespesaValor() {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {

            Contas contas = new Contas();

            Despesa despesa = new Despesa(TiposDespesas.Alimentação,
                    "11,A0",
                    "11/11/1111",
                    Tipo.Despesa);

            contas.IncluirDespesa(despesa);

        });

        String esperado = "Valor invalido";

        assertEquals(esperado, ex.getMessage());

    }

    /**
     * public void IncluirDespesa(Despesa despesa)
     *
     * Verificar a inserção de uma data invalido.
     */
    @Test
    public void testIncluirDespesaData() {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {

            Contas contas = new Contas();

            Despesa despesa = new Despesa(TiposDespesas.Alimentação,
                    "11,00",
                    "11/1A/1111",
                    Tipo.Despesa);

            contas.IncluirDespesa(despesa);

        });

        String esperado = "Data ou formatação de data invalida.";

        assertEquals(esperado, ex.getMessage());

    }

    /**
     * public String ConsultarSaldo().
     *
     * Verificar valor da ConsultarSaldo().
     */
    @Test
    public void testConsultarSaldo() {

        Contas contas = new Contas();

        Receita receita = new Receita(TiposReceitas.OutrasReceitas,
                "11,00",
                "11/11/1111",
                Tipo.Receita);

        contas.IncluirReceita(receita);

        Receita receita1 = new Receita(TiposReceitas.OutrasReceitas,
                "11,00",
                "11/11/9999",
                Tipo.Receita);

        contas.IncluirReceita(receita1);

        assertEquals("R$ 11,00", contas.ConsultarSaldo());

    }

    /**
     * public String ConsultarSaldoTotal().
     *
     * Verificar valor da ConsultarSaldoTotal().
     */
    @Test
    public void testConsultarSaldoTotal() {

        Contas contas = new Contas();

        Receita receita = new Receita(TiposReceitas.OutrasReceitas,
                "11,00",
                "11/11/1111",
                Tipo.Receita);

        contas.IncluirReceita(receita);

        Receita receita1 = new Receita(TiposReceitas.OutrasReceitas,
                "11,00",
                "11/11/9999",
                Tipo.Receita);

        contas.IncluirReceita(receita1);

        assertEquals("R$ 22,00", contas.ConsultarSaldoTotal());

    }

    /**
     * public String ListarReceitas().
     *
     * Verificar se esta criando a listagem de receitas.
     */
    @Test
    public void testListarReceitas() {

        Contas contas = new Contas();

        Receita receita = new Receita(TiposReceitas.OutrasReceitas,
                "11,00",
                "11/11/1111",
                Tipo.Receita);

        contas.IncluirReceita(receita);

        assertNotNull(contas.ListarReceitas());

    }

    /**
     * public String ListarDespesas().
     *
     * Verificar se esta criando a listagem de despesas.
     */
    @Test
    public void testListarDespesas() {

        Contas contas = new Contas();

        Despesa despesa = new Despesa(TiposDespesas.Alimentação,
                "11,00",
                "11/11/1111",
                Tipo.Despesa);

        contas.IncluirDespesa(despesa);

        assertNotNull(contas.ListarDespesas());

    }

    /**
     * public String ListarExtrato().
     * 
     * Verificar se esta riado a listagem de todos os extratos.
     */
    @Test
    public void testListarExtrato() {

        Contas contas = new Contas();

        Receita receita = new Receita(TiposReceitas.OutrasReceitas,
                "11,00",
                "11/11/1111",
                Tipo.Receita);

        contas.IncluirReceita(receita);

        Despesa despesa = new Despesa(TiposDespesas.Alimentação,
                "11,00",
                "11/11/1111",
                Tipo.Despesa);

        contas.IncluirDespesa(despesa);

        assertNotNull(contas.ListarExtrato());

    }

}
