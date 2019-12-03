package com.lz.util;
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class MailSender {
    private static Properties properties = new Properties();
    static{
        try {
            //���������ļ�
            properties.load(MailSender.class.getResourceAsStream("/email.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param to    ���շ������ַ
     * @param title �ʼ�����
     * @param content   �ʼ�����
     */
    public static void send(String to,String title,String content)
    {

        System.out.println(to);

        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        properties.put("mail.smtp.ssl.socketFactory", sf);
        sf.setTrustAllHosts(true);

        // ������֤��
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(properties.getProperty("sourceEmail"), properties.getProperty("sourcePsw"));
            }
        };

        Session session = Session.getDefaultInstance(properties,auth);

        Message msg = new MimeMessage(session);

        try {
            msg.setSubject(title);
            msg.setSentDate(new Date());
            //������ʾ�ķ���ʱ��
            msg.setSentDate(new Date());
            //�����ʼ�����
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            String d = sdf.format(date);
            msg.setContent("<a href='http://139.155.2.182/luozhi_shopping'>LuoZhi</a>提示您: <p style='text-indent:2em'>您于"+d+" 注册luozhi账号，验证码是：<span style='color:red;font-size:20px'>"+content+"</span></p>" ,  "text/html;charset=UTF-8");
            msg.setFrom(new InternetAddress(properties.getProperty("sourceEmail"),title,"UTF-8"));

            msg.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress(to)); // ���÷��ͷ�ʽ�������

            msg.saveChanges();

            OutputStream out = new FileOutputStream("MyEmail.eml");
            msg.writeTo(out);
            out.flush();
            out.close();

            Transport.send(msg);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
