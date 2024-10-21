package app;
import DAO.ProdutoVestuarioDAO;//IMPORTA CLASSE DO VESTUARIO QUE FAZ A CONEXÃO COM JDBC

public class ProdutoVestuarioo extends Produto {
    //DEFINIÇÃO DOS ATRIBUTOS PRIVADO
    private String tamanho, cor, material;
    private int id_vestuario;

    //DEFINIÇÃO DOS CONSTRUTORES PÚBLICOS
    public ProdutoVestuarioo(){}
    public ProdutoVestuarioo(String nome, double preco_custo, double preco_venda, String tamanho, String cor, String material){
        super(nome, preco_custo, preco_venda);
        this.tamanho=tamanho;
        this.cor=cor;
        this.material=material;
    }

    //DEFINIÇÃO DOS GETTERS E SETTERS DOS ATRIBUTOS PRIVADOS
    public int getCodigo() {
        return id_vestuario;
    }
    public void setCodigo(int id_vestuario) {
        this.id_vestuario = id_vestuario;
    }

    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }

    //MÉTODO QUE CALCULA O LUCRO DOS PRODUTOS DE VESTUARIO
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

    //MÉTODO STRING QUE EXIBE OS DADOS DO VESTUÁRIO
    public String descricao() throws AtributoInvalidoException{
        return "Nome do produto: "+getNome() +
        "\nTamanho: "+getTamanho() +
        "\nMaterial: "+getMaterial() +
        "\nCor: "+getCor() +
        "\nPreço de custo: R$"+getPreco_custo()+
        "\nPreço de venda: R$"+getPreco_venda()+
        "\nLucro: R$"+ calcularLucro();
    }

    //MÉTODO QUE DELETA REGISTROS DO BANCO DE DADOS
    public void deletarVestuario(int id_vestuario){
        new ProdutoVestuarioDAO().deletarVestuario(id_vestuario);;
    }

    //MÉTODO QUE CADASTRA REGISTRO NO BANCO DE DADOS
    public void cadastrarVestuario(ProdutoVestuarioo pv ){
        new ProdutoVestuarioDAO().cadastrarVestuario(pv);
    }

    //MÉTODO QUE CADASTRA REGISTRO NO BANCO DE DADOS
    public void atualizarVestuario(ProdutoVestuarioo pv){
        new ProdutoVestuarioDAO().atualizarVestuario(pv);
    }
    
}
