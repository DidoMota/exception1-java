package model.exceptions;

public class DomainException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;		//declarando a vers�o de uma classe serializable
	
	//constructors	
	public DomainException(String msg) {		// permite instanciar um objeto dessa classe, passando uma msg pro construtor da superclasse
		super(msg);								//a msg vai ficar armazenada dentra da exce��o
	}
	
	
	
}


/* Quando uma classe � exce��o, por boa pr�tica usa-se o sufixo Exception
 * Uma classe de exception extends ou a classe Exception (obrigado a tratar a exception) ou a classe RunnTimeExcepetion (n�o � obrigado a tratar a exception)
 * 
 * Exception � uma classe Serializable (conceito a ser visto mais para frente no curso),
 * Classes serializable precisam ter vers�es
 * 
 */