import br.ufpb.dcx.gerenciadorDeFinancas.login.Conta;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.Compra;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaFinancas;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaGerenciadorFinancas;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.categoriaCompra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaFinancasTest {

    @Test
    public void testaEditarSalarioETotal(){
        Conta sistemaConta = new Conta("Gankyu", "4321");
        SistemaGerenciadorFinancas sistema = new SistemaFinancas(sistemaConta);

        //Teste método exibirTotalGasto
        Compra compraTeste = new Compra(categoriaCompra.ALIMENTACAO, 10.50, "bananas");
        Compra compraTeste2 = new Compra(categoriaCompra.LAZER, 53, "cinema");
        sistema.cadastrarCompra(compraTeste);
        sistema.cadastrarCompra(compraTeste2);
        assertEquals(63.5,sistema.exibirTotalGasto());

        //Teste método editarSalario
        sistema.cadastrarSalario(1300);
        assertEquals(1300, sistemaConta.getSalario());

        sistema.editarSalario(2300);
        assertEquals(2300, sistemaConta.getSalario());


    }

}
