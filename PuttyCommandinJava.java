package grepputty;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class PuttyCommandinJava {
	
	public static void main(String args[])
	{
		JSch jsch = new JSch();
		Session session = null;
		try {
		  String command="comamnds";
		  session = jsch.getSession("username", "password", 22);
		  session.setPassword("Fequ9ma3weig");
		  session.setConfig("StrictHostKeyChecking", "no");
		  session.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password");
		  session.connect();

		  Channel channel = session.openChannel("exec");
		  ((ChannelExec)channel).setCommand(command);
		  channel.connect();

		  InputStream commandOutput = channel.getInputStream();
		  BufferedReader br = new BufferedReader(new      InputStreamReader(commandOutput)); 
		  String line ="";
		  while ((line = br.readLine()) != null)
		 {
			  
		        System.out.println(line);
		        
		 }
		  br.close();
		  channel.disconnect();
		  session.disconnect();
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}

}
