package br.ufpb.dcx.gerenciadorDeFinancas.login;

import br.ufpb.*;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaFinancas;

import java.util.Objects;

public class Conta {
    private String nomeDoUsuario;
    private String senhaDoUsuario;
    private double salario;
    private SistemaFinancas personalAdvisor;

    public Conta( String nomeDoUsuario, String senhaDoUsuario){
        this.nomeDoUsuario = nomeDoUsuario;
        this.senhaDoUsuario = senhaDoUsuario;
        this.salario = 0.0;
        personalAdvisor = new SistemaFinancas(this);
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

    public void setSalario( double salario){
        this.salario = salario;
    }
}
