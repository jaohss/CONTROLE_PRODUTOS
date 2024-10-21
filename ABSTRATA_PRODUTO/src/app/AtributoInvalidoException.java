package app;
//Classe para exception caso haja falhas
public class AtributoInvalidoException extends Exception {
    public AtributoInvalidoException(String mensagem) {
        super(mensagem);
    }
}