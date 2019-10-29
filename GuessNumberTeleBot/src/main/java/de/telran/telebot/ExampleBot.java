package de.telran.telebot;

import de.telran.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import javax.annotation.PostConstruct;

@Component
public class ExampleBot extends TelegramLongPollingBot {
	
	private static final Logger logger = LoggerFactory.getLogger(ExampleBot.class);
	
	@Value("${bot.token}")
	private String token;
	
	@Value("${bot.username}")
	private String username;

	@Autowired
	GameService service;

	private Long chatId;
	
	@Override
	public String getBotToken() {
		return token;
	}
	
	@Override
	public String getBotUsername() {
		return username;
	}
	
	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage()) {
			Message message = update.getMessage();
			chatId = message.getChatId();
			String text = message.getText();
			try {
				service.processGameRequest(text);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@PostConstruct
	public void start() {
		logger.info("username: {}, token: {}", username, token);
	}

	@Scheduled(fixedDelay = 1000)
	public void readMessages() {
		String text = "";
		try {
			while(true) {
				text = service.readOutput();
				execute(createResponse(text));
				logger.info("Sent message \"{}\" to {}", text, chatId);
			}
		} catch (Exception e) {
			logger.error("Failed to send message \"{}\" to {} due to error: {}", text, chatId, e.getMessage());
		}
	}

	private SendMessage createResponse(String text) {
		SendMessage response = new SendMessage();
		response.setChatId(chatId);
		response.setText(text);
		return response;
	}
}
