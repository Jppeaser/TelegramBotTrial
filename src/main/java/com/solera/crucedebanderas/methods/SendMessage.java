package com.solera.crucedebanderas.methods;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Configuration
@Validated
@ConfigurationProperties("custom")

public class SendMessage {
	@NotBlank
	private String telegramToken;
	@NotBlank
	private String telegramId;
	@NotBlank
	private String telegramMessageUpdatedRepo;
	@NotBlank
	private String telegramSendmessageUrl;
	
	@Bean    
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
	}
	
	public SendMessage() {
	}
	
	public void send(String message) {
		telegramSendmessageUrl = String.format(telegramSendmessageUrl, telegramToken, telegramId, message);
		try {
			URL urlSend = new URL(telegramSendmessageUrl);
			URLConnection urlConnection = urlSend.openConnection();
			InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String test() {
		return telegramToken;
	}
}
