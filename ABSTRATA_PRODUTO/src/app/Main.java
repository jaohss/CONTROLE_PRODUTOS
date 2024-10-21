package app;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        try{
            Scanner scn = new Scanner(System.in);
//=======================PRODUTO ALIMENTICIO============================
            //INSTANCIANDO OBJETO DO PRODUTO ALIMENTICIO
            ProdutoAlimenticioo pa = new ProdutoAlimenticioo();

            //CADASTRO DO PRODUTO ALIMENTICIO
            System.out.println("cadastrar alimento:");
            pa.setNome("Sucrilhos");
            pa.setPreco_custo(7);
            pa.setPreco_venda(16);
            pa.setData_val("25/12/2020");
            pa.setInfo_nutri("Muito açucar e gordura saturada");
            pa.cadastrarAlimento(pa);//CHAMA O MÉTODO QUE CADASTRA O ALIMENTO

            System.out.println("\n=========Produto Alimenticio=========");
            System.out.println(pa.descricao());//EXIBE OS DADOS DO ALIMENTO

            //OPÇÃO PARA O USUÁRIO DELETAR ALGUM ALIMENTO A PARTIR DE SEU ID
            System.out.println("Selecione o id do alimento que deseja deletar:");
            pa.deletarAlimento(scn.nextInt()); //CHAMA O MÉTODO PARA DELETAR O ALIMENTO

            //ATUALIZAÇÃO DO ALIMENTO
            System.out.println("Atualizar alimentos");
            pa.setNome("Leite integral");
            pa.setInfo_nutri("Muito proteina e gordura");
            pa.setPreco_custo(2);
            pa.setPreco_venda(10);
            System.out.println("Insira o ID do alimento que deseja atualizar");
            pa.setId_alimento(scn.nextInt());//PEDE PARA O USUÁRIO INSERIR O ID DO ALIMENTO QUE DESEJA ATUALIZAR
            pa.atualizarAlimento(pa);//CHAMA O MÉTODO QUE ATUALIZA O ALIMENTO

            System.out.println("PRODUTO ATUALIZADO");
            System.out.println(pa.descricao());//EXIBE OS DADOS DO ALIMENTO ATUALIZADO
//=========================PRODUTO ALIMENTICIO=======================================

//=========================PRODUTO DE VESTUÁRIO======================================
            ProdutoVestuarioo pv = new ProdutoVestuarioo();

            System.out.println("Cadastro de vestuário");
            pv.setNome("Camisa do Corinthians Nike 2024");
            pv.setCor("Preto");
            pv.setMaterial("Algodão");
            pv.setTamanho("GG");
            pv.setPreco_custo(50);
            pv.setPreco_venda(299);
            pv.cadastrarVestuario(pv);//CHAMA O MÉTODO QUE CADASTRA O VESTUÁRIO

            System.out.println("=======Produto de vestuário=======");
            System.out.println(pv.descricao());//EXIBE OS DADOS DO PRODUTO DO VESTUARIO
            System.out.println("Vestuário cadastrado!");

            System.out.println("INSIRA O ID DO VESTUÁRIO QUE DESEJA DELETAR: ");
            pv.deletarVestuario(scn.nextInt());//PEDE PARA O USUÁRIO INSERIR O ID DO VESTUARIO QUE DESEJA ATUALIZAR

            //Atualização do vestuário
            System.out.println("Atualizar vestuário");
            pv.setNome("Camisa Corinthians Topper 1977");
            pv.setCor("Preto-branco");
            pv.setMaterial("Algodão");
            pv.setTamanho("P");
            pv.setPreco_custo(40);
            pv.setPreco_venda(100);
            System.out.println("INSIRA O ID DO VESTUÁRIO QUE DESEJA ATUALIZAR:");
            pv.setCodigo(scn.nextInt());
            pv.atualizarVestuario(pv); //CHAMA O MÉTODO QUE ATUALIZA O VESTUARIO
            System.out.println("Produto atualizado");
            pa.descricao();//EXIBE OS DADOS DO ALIMENTO ATUALIZADO
//=========================PRODUTO DE VESTUÁRIO======================================
            scn.close();
        }
        catch(AtributoInvalidoException e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
}
