
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
        Despesa despesa2 = new Despesa("17823ghyfc", CategoriaDespesa.LAZER, 2900.0,"Console Video Game", LocalDate.now() );

        try {
            sistema.cadastrarDespesa(despesa1);
            sistema.cadastrarDespesa(despesa2);
        }catch (DespesaJaCadastradaException e){
            System.out.println(e.getMessage());
            fail();
        }
        sistema.removerDespesa(despesa1);

        assertFalse(sistema.getDespesas().containsKey(despesa1.getIdDespesa()));
        assertTrue(sistema.getDespesas().containsKey(despesa2.getIdDespesa())); // Verificando se a despesa2 existe.


    }



    @Test
    public void testExibirTotalDoMes(){

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


    @Test
    public  void testVerificarSaldoDoMes() {
        SistemaFinancas sistema = new SistemaFinancas();
        Receita receitaMaio = new Receita("123mesDeFernando", 1000.0, LocalDate.of(2024, 5, 13));
        Receita receitaJunho = new Receita("671829", 600.0, LocalDate.of(2024, 6, 20));
        Despesa despesaMaio = new Despesa("mesDeFernando546", CategoriaDespesa.GASTOS_PESSOAIS, 1100.0, "Festa de Anivérsario", LocalDate.of(2024, 5, 13));
        Despesa despesaJunho = new Despesa("87372", CategoriaDespesa.SAUDE, 50.0, "Mensalidade da Academia", LocalDate.of(2024, 6, 20));

        LocalDate data = LocalDate.of(2024, 5, 13);
        LocalDate data2 = LocalDate.of(2024, 5, 13);

        sistema.cadastrarReceita(receitaMaio);
        sistema.cadastrarReceita(receitaJunho);
        try {
            sistema.cadastrarDespesa(despesaMaio);
            sistema.cadastrarDespesa(despesaJunho);
        } catch (DespesaJaCadastradaException e) {
            System.out.println(e.getMessage());
        }

        String resultadoNegativo = sistema.verificarSaldoDoMes(data, 5);
        String resultadoPositivo = sistema.verificarSaldoDoMes(data2, 6);

        assertEquals("Atenção! Seu saldo do mês 5 foi negativo.\nSaldo = -100.0", resultadoNegativo);
        assertEquals("Parabéns! Seu saldo do mês 6 foi positivo.\nSaldo = 550.0", resultadoPositivo);
    }



    /*@Test
    public void testCadatroDespesa(){
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
