package Model;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Bruno Giovani Bressanini Cavalheiro
 */
public class ExtratoTest {

    public ExtratoTest() {
    }

    /**
     * Testar a verificação de um objeto comparado com a data atual.
     * 
     * Verificar se a data ainda não passou retorna verdadeiro.
     */
    @Test
    public void testPendenteVerdadeiro() {

        Extrato extrato = new Extrato("11.00", String.valueOf(LocalDate.MAX), Tipo.Receita);

        assertEquals(true, extrato.pendente());// ainda esta esperando a data chegar.

    }

    /**
     * Testar a verificação de um objeto comparado com a data atual.
     * 
     * Verifica de a data ja passou retorna falso.
     */
    @Test
    public void testPendenteFalso() {

        Extrato extrato1 = new Extrato("11.00", String.valueOf(LocalDate.MIN), Tipo.Receita);

        assertEquals(false, extrato1.pendente());// a data ja passou.

    }

}
