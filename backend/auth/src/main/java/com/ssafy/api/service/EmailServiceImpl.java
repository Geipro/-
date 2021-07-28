package com.ssafy.api.service;

import java.util.Random;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailServiceImpl implements EmailService {
	@Autowired
	JavaMailSender emailSender;
	
	public static final String ePw = createKey();

	@Override
	public MimeMessage createMessage(String to) throws Exception {
		System.out.println("������ ��� : " + to);
		System.out.println("������ȣ : " + ePw);
		MimeMessage message = emailSender.createMimeMessage();	
		message.addRecipients(RecipientType.TO, to);			//������ ���
		message.setSubject("[�츮���� ����] ������ȣ�� �����߽��ϴ�.");	//����
		String msg = "";
		/*
		 * msg += "<div style = 'margin:100px;'>";
		 * msg += "<h1>�ȳ��ϼ��� <bold>�츮���� ����</bold>�Դϴ�!</h1>";
		 * msg += "<br>";
		 * msg += "<p>�Ʒ� �ڵ带 �Է����ּ���!</p>";
		 * msg += "<br>";
		 * msg += "<p>�����մϴ�!</p>";
		 * msg += "<br>";
		 * msgg+= "<div align='center' style='border:1px solid black; font-family:verdana';>";
		 * msgg+= "<h3 style='color:blue;'>��й�ȣ ����Ȯ�� �ڵ��Դϴ�.</h3>";
		 * msgg+= "<div style='font-size:130%'>";
		 * msgg+= "CODE : <strong>";
		 * msgg+= ePw+"</strong><div><br/> ";
		 * msgg+= "</div>";
		 */
		message.setText(msg, "utf-8", "html");
		message.setFrom(new InternetAddress("properties�� �ۼ��� �̸���", "�츮��������"));	//������ ���
		
		return message;
	}

	public static String createKey() {
		StringBuffer key = new StringBuffer();
		Random rnd = new Random();
		//�����ڵ� 8�ڸ�
		for(int i = 0; i < 8; i++) {
			//0~2 ���� ����
			int index = rnd.nextInt(3);
			switch(index) {
				case 0:
					//a ~ z (1+ 97 = 98. => (char)98 = 'b'
					key.append((char) ((int)(rnd.nextInt(26)) + 97));
					break;
				case 1:
					//���� ����ϰ� A ~ Z
					key.append((char) ((int)(rnd.nextInt(26)) + 65));
					break;
				case 2:
					//0 ~ 9
					key.append((rnd.nextInt(10)));
					break;
			}
		}
		return key.toString();
	}

	@Override
	public void sendSimpleMessage(String to) throws Exception {
		MimeMessage message = createMessage(to);
		try {
			emailSender.send(message);
		}catch(MailException e){
			e.printStackTrace();
			throw new IllegalArgumentException();
		}
	}

}
