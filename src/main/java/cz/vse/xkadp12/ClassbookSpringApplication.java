package cz.vse.xkadp12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.faces.webapp.FacesServlet;

@SpringBootApplication
@EnableJms
public class ClassbookSpringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ClassbookSpringApplication.class, args);

		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		System.out.println("Sending message...");
		jmsTemplate.convertAndSend("reciever","Hello world from JMS!!!");

	}

	@Bean
	public ServletRegistrationBean facesContext() {
		FacesServlet facesServlet = new FacesServlet();
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(facesServlet, "*.xhtml");
		servletRegistrationBean.setLoadOnStartup(1);
		return servletRegistrationBean;
	}

}
