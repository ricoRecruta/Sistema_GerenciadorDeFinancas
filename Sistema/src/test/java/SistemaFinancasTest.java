
import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.DespesaJaCadastradaException;
import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.DespesaNaoExisteException;
import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.ReceitaNaoExistenteException;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaFinancasTest {


    @Test
    public void testRemoverDespesa() throws DespesaNaoExisteException {
        SistemaFinancas sistema = new SistemaFinancas();

        Despesa despesa1 = new Despesa("1", CategoriaDespesa.ALIMENTACAO, 100.0, "Feira de alimentos",LocalDate.now());
        try {
            sistema.cadastrarDespesa(despesa1);
        }catch (DespesaJaCadastradaException e){
            System.out.println(e.getMessage());
            fail();
        }
        sistema.removerDespesa(despesa1);

        assertFalse(sistema.getDespesas().containsKey(despesa1.getIdDespesa()));


    }

    @Test
    public void testaExibirTotalDoMes(){

        SistemaFinancas sistema = new SistemaFinancas();

        //Teste método exibirTotalGasto
        Despesa compraTeste = new Despesa("321", CategoriaDespesa.ALIMENTACAO, 53, "bananas",LocalDate.now());
        Despesa compraTeste2 = new Despesa("654", CategoriaDespesa.ALIMENTACAO, 53, "bananas", LocalDate.now());
        try {
            sistema.cadastrarDespesa(compraTeste);
            sistema.cadastrarDespesa(compraTeste2);
        } catch(DespesaJaCadastradaException e){
            System.out.println(e.getMessage());
        }
        assertFalse(sistema.exibirTotalGastoDoMes(LocalDate.now().withMonth(5)) == 63.1);

    }

    @Test
    public void testCadastrarEEditarValorReceita(){
        SistemaFinancas sistema = new SistemaFinancas();
        assertEquals(0, sistema.getReceitas().size());

        Receita receitaTeste = new Receita("123", 1500, LocalDate.now());
        sistema.cadastrarReceita(receitaTeste);

        try {
            sistema.editarValorReceita(receitaTeste.getIdReceita(), 2500);
        }catch (ReceitaNaoExistenteException e){
            System.out.println(e.getMessage());
        }
        assertTrue(sistema.getReceitas().get(receitaTeste.getIdReceita()).getValor() == 2500);

    }


    /*@Test
    public void testaCadatroDespesa(){
        SistemaGerenciadorFinancas sistema = new SistemaFinancas();
        try {
            sistema.cadastrarDespesa(new Despesa("321", CategoriaDespesa.OUTROS, 10.50, "nana", LocalDate.of(2024,10,3)));
            sistema.cadastrarDespesa(new Despesa("321", CategoriaDespesa.OUTROS, 10.50, "nana", LocalDate.of(2024,10,3)));
            fail("não é pra deixar cadastrar");
        }catch (DespesaJaCadastradaException e){
            //
        }
    }*/

}
