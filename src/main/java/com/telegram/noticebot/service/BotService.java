package com.telegram.noticebot.service;


import com.telegram.noticebot.config.BotConfig;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Service
public class BotService extends TelegramLongPollingBot {




    private final BotConfig botConfig;

    public BotService(BotConfig botConfig) {

        this.botConfig = botConfig;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            String text = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            switch (text){
                case "/start":
                    String message = "roma chmo";
                    sendMessage(chatId, message);
                    break;

            }
        }
    }


    private void sendMessage(long chatId, String sendText){
        SendMessage sendMessage =  new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(sendText);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public String getBotToken(){
        return botConfig.getBotToken();
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }
}
