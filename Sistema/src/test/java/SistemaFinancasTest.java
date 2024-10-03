
import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.DespesaJaCadastradaException;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.Despesa;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaFinancas;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.CategoriaDespesa;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaGerenciadorFinancas;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaFinancasTest {

    @Test
    public void testaEditarSalarioETotal(){

        SistemaFinancas sistema = new SistemaFinancas();

        //Teste método exibirTotalGasto
        Despesa compraTeste = new Despesa("", CategoriaDespesa.ALIMENTACAO, 10.50, "bananas",LocalDate.now());
        Despesa compraTeste2 = new Despesa("", CategoriaDespesa.LAZER, 53, "cinema", LocalDate.now());
        try {
            sistema.cadastrarDespesa(compraTeste);
            sistema.cadastrarDespesa(compraTeste2);
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
    @Test
    public void testaCadatroDespesa(){
        SistemaGerenciadorFinancas sistema = new SistemaFinancas();
        try {
            sistema.cadastrarDespesa(new Despesa("321", CategoriaDespesa.OUTROS, 10.50, "nana", LocalDate.of(2024,10,3)));
            sistema.cadastrarDespesa(new Despesa("321", CategoriaDespesa.OUTROS, 10.50, "nana", LocalDate.of(2024,10,3)));
            fail("não é pra deixar cadastrar");
        }catch (DespesaJaCadastradaException e){
            //
        }
    }

}
