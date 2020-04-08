package convert;
import javax.sound.sampled.*; 

import java.io.*;
import java.util.Vector;

public class ConvertMidi2Wav {
	
	private AudioInputStream audioStream; 
	private Vector<String>Musiclist = new Vector<String>();
	
	public ConvertMidi2Wav() {
	}
	
	/**
	 * 
	 * @param Filepath  midi�ļ�·��
	 */
	public void AddPath(String Filepath)
	{
		Musiclist.add(Filepath);
	}
	
	/**
	 * 
	 * @param Directorypath  �ļ���·��
	 */
	public void GetMidiFiles(String Directorypath)
	{
		
		File file = new File(Directorypath);		//��ȡ��file����
		File[] fs = file.listFiles();	//����path�µ��ļ���Ŀ¼������File������
		for(File f:fs){					//����File[]����
			if(!f.isDirectory())		//����Ŀ¼(���ļ�)�����ӡ
			{
				//System.out.println(f.getName());
				String prefix = f.getName().substring(f.getName().lastIndexOf('.') + 1);
				if(prefix.equals("mid"))
					AddPath(Directorypath+"\\"+f.getName());
				//System.out.println(f.getName().substring(0,f.getName().lastIndexOf('.')+1));
			}	
		}
		
	}
	  
	//ת������
	public void Convert(){ 
	    try{ 
	    	System.out.println("ת����...");
	    	for(String musicPath:Musiclist)
	    	{
	    		String Savepath = musicPath.substring(0,musicPath.lastIndexOf('.')+1)+"wav";
	    		//��ȡ��Ƶ������ 
			    audioStream = AudioSystem.getAudioInputStream(new File(musicPath)); 
			    try {
			        AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE, new File(Savepath));
			        audioStream.close();
			    }
			    catch(Exception e) {
			        e.printStackTrace();
			    }
	    	}
		    
	    }
	    catch(Exception ex){ 
	      ex.printStackTrace(); 
	    }
	    
	  } 
	  
	 
	  
	  public static void main(String[] args) {
		  if(args.length == 0)
			  System.out.println("�������ļ���·����");
		  else {
			  File file = new File(args[0]);
			  ConvertMidi2Wav Converter = new ConvertMidi2Wav();
		        if(file.isDirectory()){
		            Converter.GetMidiFiles(args[0]);
		            Converter.Convert();
		            System.out.println("ת����ɣ����ڵ�ǰĿ¼�²鿴");
		        }
		        else if(file.isFile()){
		        	String prefix = file.getName().substring(file.getName().lastIndexOf('.') + 1);
					if(prefix.equals("mid"))
					{
						Converter.AddPath(args[0]);
						Converter.Convert();
						System.out.println("ת����ɣ����ڵ�ǰĿ¼�²鿴");
					}
					else
						System.out.println("����midi�ļ�(����β׺����)");	
		        }
		        else
		        	System.out.println("Error!·���������");
		        	  
		  }
		  
	}
	
}
