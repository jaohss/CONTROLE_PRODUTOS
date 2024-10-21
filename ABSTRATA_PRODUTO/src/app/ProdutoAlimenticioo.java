package app;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import DAO.ProdutoAlimenticiooDAO;//IMPORTA CLASSE DOS PRODUTOS ALIMENTICIOS QUE FAZ A CONEXÃO COM JDBC

public class ProdutoAlimenticioo extends Produto {
    //DEFINIÇÃO DOS ATRIBUTOS PRIVADOS
    private String data_val;
    private String info_nutri;
    private int id_alimento;

    //DEFINIÇÃO DOS CONSTRUTORES PÚBLICO
    public ProdutoAlimenticioo(){}

    public ProdutoAlimenticioo(String nome, double preco_custo, double preco_venda, String data_val, String info_nutri){
        super(nome, preco_custo, preco_venda);
        this.data_val=data_val;
        this.info_nutri=info_nutri;
    }

    //DEFINIÇÃO DOS GETTERS E SETTERS DOS ATRIBUTOS PRIVADOS
    public int getId_alimento() {
        return id_alimento;
    }

    public void setId_alimento(int id_alimento) {
        this.id_alimento = id_alimento;
    }

    //MÉTODO QUE CONVERTE A DATA DE STRING PARA DATE NO FORMATO(dd/MM/yyyy)
    private String converteData(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(this.data_val, formatter);
        return data.format(formatter);
    }

    public String getData_val() {
        return converteData();
    }

    public void setData_val(String data_val) {
        this.data_val = data_val;
    }

    public String getInfo_nutri() {
        return info_nutri;
    }

    public void setInfo_nutri(String info_nutri) {
        this.info_nutri = info_nutri;
    }

     //MÉTODO QUE CALCULA O LUCRO DOS PRODUTOS DE ALIMENTOS
    @Override
    public double calcularLucro() throws AtributoInvalidoException{
        if(getPreco_custo()> getPreco_venda()){
            double prejuizo = getPreco_custo() - getPreco_venda();
            throw new AtributoInvalidoException("Prejuízo de R$: "+prejuizo);
        }
        else{
            double lucro = getPreco_venda()-getPreco_custo();
            return lucro;
        }
    }
    //MÉTODO STRING QUE EXIBE OS DADOS DOS PRODUTOS ALIMENTICIOS
    public String descricao() throws AtributoInvalidoException{
        return "Nome do produto: "+getNome() +
        "\nData de validade: "+getData_val() +
        "\nInformações nutricionais: "+getInfo_nutri() +
        "\nPreço de custo: R$"+getPreco_custo()+
        "\nPreço de venda: R$"+getPreco_venda()+
        "\nLucro: R$"+ calcularLucro()+"\n";
    }

    //MÉTODO QUE DELETA REGISTROS DO BANCO DE DADOS
    public void deletarAlimento(int id_alimento){
        new ProdutoAlimenticiooDAO().deletarAlimento(id_alimento);
    }
    //MÉTODO QUE CADASTRA REGISTRO NO BANCO DE DADOS
    public void atualizarAlimento(ProdutoAlimenticioo pa){
        new ProdutoAlimenticiooDAO().atualizarAlimento(pa);
    }
    //MÉTODO QUE CADASTRA REGISTRO NO BANCO DE DADOS
    public void cadastrarAlimento(ProdutoAlimenticioo pa){
        new ProdutoAlimenticiooDAO().cadastrarAlimento(pa);
    }
    
}
