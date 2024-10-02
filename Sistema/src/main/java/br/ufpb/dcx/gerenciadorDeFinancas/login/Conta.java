package br.ufpb.dcx.gerenciadorDeFinancas.login;

import br.ufpb.*;
import java.util.Objects;

public class Conta {
    private String nomeDoUsuario;
    private String senhaDoUsuario;
    private double salario;
    private PersonalAdvisor personalAdvisor;

    public Conta( String nomeDoUsuario, String senhaDoUsuario, double salario){
        this.nomeDoUsuario = nomeDoUsuario;
        this.senhaDoUsuario = senhaDoUsuario;
        this.salario = salario;
        personalAdvisor = new SistemaPersonalAdvisor();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return Objects.equals(nomeDoUsuario, conta.nomeDoUsuario) && Objects.equals(senhaDoUsuario, conta.senhaDoUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeDoUsuario, senhaDoUsuario);
    }

    public boolean verificarConta(String nome, String senha){
        if(nome.equals(this.nomeDoUsuario) && senha.equals(senhaDoUsuario)){
            return true;
        }
        return false;
    }
}
