package model.exceptions;

public class DomainException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;		//declarando a versão de uma classe serializable
	
	//constructors	
	public DomainException(String msg) {		// permite instanciar um objeto dessa classe, passando uma msg pro construtor da superclasse
		super(msg);								//a msg vai ficar armazenada dentra da exceção
	}
	
	
	
}


/* Quando uma classe é exceção, por boa prática usa-se o sufixo Exception
 * Uma classe de exception extends ou a classe Exception (obrigado a tratar a exception) ou a classe RunnTimeExcepetion (não é obrigado a tratar a exception)
 * 
 * Exception é uma classe Serializable (conceito a ser visto mais para frente no curso),
 * Classes serializable precisam ter versões
 * 
 */