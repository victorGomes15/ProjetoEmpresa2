package br.com.contmatic.testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EmpresaTeste.class, EnderecoTeste.class, TelefoneTeste.class, CidadeTeste.class,EmailTeste.class, BairroTeste.class,EstadoTeste.class })
public class AllTests {

}
