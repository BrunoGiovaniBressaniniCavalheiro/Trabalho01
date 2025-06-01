package Model;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Bruno Giovani Bressanini Cavalheiro
 */
public class DocumentoTest {
    
    public DocumentoTest() {
    }

    /**
     * public ArrayList<Extrato> Carregar().
     * 
     * Validar o retorno da criação da listagem.
     */
    @Test
    public void testCarregar() {

        Documento documento = new Documento();

        assertNotNull(documento.Carregar());

    }

    /**
     * public void Salvar(ArrayList<Extrato> extrato).
     * 
     * Validar a criação do novo documento.
     */
    @Test
    public void testSalvar() {

        Documento documento = new Documento();

        documento.Salvar(documento.Carregar());

        assertTrue(new File("dados.csv").exists());

    }

}
