package com.hw4.bean;

public class UserNAnswerbean {
		private String question ;
		private String answer ;
		private int questionid;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		private String status;
		private String username;
		
		public String getQuestion() {
			return question;
		}
		public void setQuestion(String question) {
			this.question = question;
		}
		public String getAnswer() {
			return answer;
		}
		public void setAnswer(String answer) {
			this.answer = answer;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getStatus() {
			return status;
		}
		public int getQuestionid() {
			return questionid;
		}
		public void setQuestionid(int questionid) {
			this.questionid = questionid;
		}
	}

