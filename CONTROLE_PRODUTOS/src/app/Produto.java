package app;
public abstract class Produto{
    //DEFINIÇÃO DOS ATRIBUTOS PRIVADOS DA CLASSE ABSTRATA
    private String nome;
    private double preco_custo;
    private double preco_venda;

    //DEFINIÇÃO DOS CONSTRUTORES PÚBLICOS
    public Produto(){}
    public Produto(String nome, double preco_custo, double preco_venda){
        this.nome=nome;
        this.preco_custo=preco_custo;
        this.preco_venda=preco_venda;
    }
    //GETTERS E SETTERS DOS ATRIBUTOS PRIVADOS DA CLASSE ABSTRATA
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco_custo() {
        return preco_custo;
    }
    public void setPreco_custo(double preco_custo) {
        this.preco_custo = preco_custo;
    }
    public double getPreco_venda() {
        return preco_venda;
    }
    public void setPreco_venda(double preco_venda) {
        this.preco_venda = preco_venda;
    }

    //DEFINIÇÃO DO MÉTODO ABSTRATO QUE CALCULA O LUCRO
    public abstract double calcularLucro() throws AtributoInvalidoException;
}