package Pages;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class NoAttach extends SuperTestNG {

	public static void Sendmail() throws Exception {

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "465");

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("unicitytechindia@gmail.com",
						"wrureljwqawaeysu");
			}
		});

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("unicitytechindia@gmail.com"));
//		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("Manjunath.Shekhar@unicity.com"));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("Suman.CB@unicity.com"));
		message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("in-web-bangalore@unicity.com"));
//		message.addRecipients(Message.RecipientType.BCC,InternetAddress.parse("Manjunath.Shekhar@unicity.com"));

		message.setSubject("Enroll.ng Automation report");
		/*
		 * String msg =
		 * "<p>Hello Team,<br><br>please click on the below link to check the <strong>Enroll.ng</strong> Automation Suite <strong>Report.</strong></p>"
		 * + "<br>Failed TestCases : " + "<strong>" + failed.size() +
		 * "</strong>" + "<br><br>" + "Critical : " + "<strong>" +
		 * Critical.size() + "</strong>" + "<br>" + "<br>" + Critical +
		 * "<br><br>" + "<br><br>" + "Major : " + "<strong>" + Major.size() +
		 * "</strong>" + "<br>" + "<br>" + Major + "<br><br>" + "<br><br>" +
		 * "Minor : " + "<strong>" + Minor.size() + "</strong>" + "<br>" +
		 * "<br>" + Minor + "<br><br>" + "<br><br>" + "Low : " + "<strong>" +
		 * Low.size() + "</strong>" + "<br>" + "<br>" + Low +
		 * "<br><br>Thanks and Regards<br>QA Team";
		 * 
		 * String msg1 =
		 * "<p>Hello Team,<br><br>please click on the below link to check the <strong>Enroll.ng</strong> Automation Suite <strong>Report.</strong></p>"
		 * + "<br>Failed TestCases : " + "<strong>" + failed.size() +
		 * "<br><br>Thanks and Regards<br>QA Team";
		 * 
		 * String msg4 = "<table width='600' border='1' align='center'>" +
		 * "<tr align='center'>" + "<td><b>Critical<b></td>" +
		 * "<td><b>Major<b></td>" + "<td><b>Minor<b></td>" +
		 * "<td><b>Low<b></td>" + "</tr>" + "</table>";
		 */

		String msg3 = "<p>Hello Team,<br> <br>please click on the below link to check the <strong>Enroll.ng</strong> Automation Suite <strong>Report.</strong></p>http://10.2.0.23/EnrollReport/EnrollQA.html"
				+ "<br /><br />" + "<table width='600'border='1' cellpadding='5px'>" + "<tr><td><b>Critical:</b> </td>"
				+ "<td>" + Critical.size() + "<br></td>" + "<td>"
				+ Critical.toString().replace("[", "").replace("]", "") + "<br></td></tr>"
				+ "<tr><td><b>Major:</b> </td>" + "<td>" + Major.size() + "<br></td>" + "<td>"
				+ Major.toString().replace("[", "").replace("]", "") + "<br></td></tr>" + "<tr><td><b>Minor:</b> </td>"
				+ "<td>" + Minor.size() + "<br></td>" + "<td>" + Minor.toString().replace("[", "").replace("]", "")
				+ "<br></td></tr>" + "<tr><td><b>Low:</b> </td>" + "<td>" + Low.size() + "<br></td>" + "<td>"
				+ Low.toString().replace("[", "").replace("]", "") + "<br></td></tr>" + "<tr><td><b>Remarks:</b> </td>"
				+ "<td>" + failed.size() + "<br></td>" + "<td>Please Check Critical Bugs <br></td></tr>" + "</tr>"
				+ "</table>" + "<br />" + "Thanks<br />" + "Unicity QA Team";

		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(msg3, "text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);
		message.setContent(multipart);

		Transport.send(message);
		System.out.println("=====No Attachment Email Sent=====");
	}
}
