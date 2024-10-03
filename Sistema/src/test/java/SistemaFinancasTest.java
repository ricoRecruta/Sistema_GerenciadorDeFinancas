
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.Despesas;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaFinancas;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaGerenciadorFinancas;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.categoriaCompra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaFinancasTest {

    @Test
    public void testaEditarSalarioETotal(){

        SistemaFinancas sistema = new SistemaFinancas();

        //Teste método exibirTotalGasto
        Despesas compraTeste = new Despesas(CategoriaCompra.ALIMENTACAO, 10.50, "bananas");
        Despesas compraTeste2 = new Despesas(CategoriaCompra.LAZER, 53, "cinema");
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
