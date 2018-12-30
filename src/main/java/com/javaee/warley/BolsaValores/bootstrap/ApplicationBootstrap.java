package com.javaee.warley.BolsaValores.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.javaee.warley.BolsaValores.domain.Empresa;
import com.javaee.warley.BolsaValores.repositories.EmpresaRepository;

@Component
public class ApplicationBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private EmpresaRepository empresaRepository;
	
	public ApplicationBootstrap(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		if(empresaRepository.count() == 0L) {
			empresaRepository.deleteAll();
			carregarEmpresa();
		}
	}
	
	private void carregarEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setCnpj("04.522.587/0005-54");
		empresa.setEmpresa("Lima Coporation");
		empresaRepository.save(empresa);
		
		Empresa empresa1 = new Empresa();
		empresa1.setCnpj("05.557.987/0001-74");
		empresa1.setEmpresa("Silva Coporation");		
		empresaRepository.save(empresa1);
	}
}
