package chatbot;

import java.util.Date;

public class ChatbotDevin implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String facts;
	
	
	//
	
	public ChatbotDevin() {
		String[] temp = {"dates","events"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "time";
		facts = "facts";
	}

	public String getDates() 
	{
		Date date = new Date();
		return date.toString();
	}
	@Override
	public void talk(String response) {
		ChatbotMain.print("Events? What events do you want to know?");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("Here's the date: "+getDates()+" ");
				response = ChatbotMain.getInput();
				
			}else {
				ChatbotMain.print("?0");
				response = ChatbotMain.getInput();
			}
		}
		//access variables from other classes
		ChatbotMain.print("Well, it was nice talking to you, "+ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
	}
	@Override
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++)
		{
			//IMPORTANT (on the rubric)
			if(ChatbotMain.findKeyword(response, keywords[i],0) >= 0) {
				return true;
			}
			
		}
		return false;
		//
	}
}
