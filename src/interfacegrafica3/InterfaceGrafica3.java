/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfacegrafica3;

import interfacegrafica3.model.Pessoa;
import interfacegrafica3.model.PessoaFisica;
import interfacegrafica3.model.PessoaJuridica;
import interfacegrafica3.view.JanelaPrincipal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Professor
 */
public class InterfaceGrafica3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
        janelaPrincipal.setVisible(true);
        janelaPrincipal.setTitle("Cadastro de clientes");
        
        /*
        // explicação do polimorfismo:
        Pessoa pessoa = new Pessoa("Maria",
                                  "maria@a.com",
                                "endereco",
                                "telefone");
        JOptionPane.showMessageDialog(
                null,
                pessoa.toString(),
                "Teste",
                JOptionPane.INFORMATION_MESSAGE
        );
        
        Pessoa pf = new PessoaFisica(
                "Jao",
                "jao@b.com",
                "endereco jao",
                "tel do jao",
                "111.111.111-11",
                "01/01/1990"
        );
        
        Pessoa pj = new PessoaJuridica(
                "22.222.222/0001-22",
                "Isento",
                "Loja do Ze",
                "Ze SA",
                "ze@b.com",
                "endereco do ze",
                "telefone do Ze"
        );
        
        List<Pessoa> lstPessoa = new ArrayList<>();
        lstPessoa.add(pf);
        lstPessoa.add(pj);
        lstPessoa.add(pj);
        lstPessoa.add(pj);
        lstPessoa.add(pf);
     
        for(int i = 0; i < lstPessoa.size(); i++){
            JOptionPane.showMessageDialog(
                    null,
                    lstPessoa.get(i).toString(),
                    "Teste",
                    JOptionPane.ERROR_MESSAGE
            );
        }//for
        
        for(Pessoa p : lstPessoa){
            JOptionPane.showMessageDialog(
                    null,
                    p.toString(),
                    "Teste",
                    JOptionPane.ERROR_MESSAGE
            );
        }//for
        */
        
    }//método main
    
}//classe
