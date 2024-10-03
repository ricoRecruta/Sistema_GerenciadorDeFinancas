
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.Despesa;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaFinancas;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.CategoriaCompra;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaFinancasTest {

    @Test
    public void testaEditarSalarioETotal(){

        SistemaFinancas sistema = new SistemaFinancas();

        //Teste método exibirTotalGasto
        Despesa compraTeste = new Despesa("",CategoriaCompra.ALIMENTACAO, 10.50, "bananas",LocalDate.now());
        Despesa compraTeste2 = new Despesa("",CategoriaCompra.LAZER, 53, "cinema", LocalDate.now());
        try {
            sistema.cadastrarCompra(compraTeste);
            sistema.cadastrarCompra(compraTeste2);
        } catch(Exception e){
            fail();
        }
        assertEquals(63.5,sistema.exibirTotalGasto());

        //Teste método editarSalario
        sistema.cadastrarSalario(1300);
        assertEquals(1300, sistema.getSalario());

        sistema.editarSalario(2300);
        assertEquals(2300, sistema.getSalario());


    }

}
