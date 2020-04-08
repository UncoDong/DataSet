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
	 * @param Filepath  midi文件路径
	 */
	public void AddPath(String Filepath)
	{
		Musiclist.add(Filepath);
	}
	
	/**
	 * 
	 * @param Directorypath  文件夹路径
	 */
	public void GetMidiFiles(String Directorypath)
	{
		
		File file = new File(Directorypath);		//获取其file对象
		File[] fs = file.listFiles();	//遍历path下的文件和目录，放在File数组中
		for(File f:fs){					//遍历File[]数组
			if(!f.isDirectory())		//若非目录(即文件)，则打印
			{
				//System.out.println(f.getName());
				String prefix = f.getName().substring(f.getName().lastIndexOf('.') + 1);
				if(prefix.equals("mid"))
					AddPath(Directorypath+"\\"+f.getName());
				//System.out.println(f.getName().substring(0,f.getName().lastIndexOf('.')+1));
			}	
		}
		
	}
	  
	//转换函数
	public void Convert(){ 
	    try{ 
	    	System.out.println("转换中...");
	    	for(String musicPath:Musiclist)
	    	{
	    		String Savepath = musicPath.substring(0,musicPath.lastIndexOf('.')+1)+"wav";
	    		//获取音频输入流 
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
			  System.out.println("请输入文件夹路径！");
		  else {
			  File file = new File(args[0]);
			  ConvertMidi2Wav Converter = new ConvertMidi2Wav();
		        if(file.isDirectory()){
		            Converter.GetMidiFiles(args[0]);
		            Converter.Convert();
		            System.out.println("转换完成！请在当前目录下查看");
		        }
		        else if(file.isFile()){
		        	String prefix = file.getName().substring(file.getName().lastIndexOf('.') + 1);
					if(prefix.equals("mid"))
					{
						Converter.AddPath(args[0]);
						Converter.Convert();
						System.out.println("转换完成！请在当前目录下查看");
					}
					else
						System.out.println("不是midi文件(至少尾缀不是)");	
		        }
		        else
		        	System.out.println("Error!路径输入错误");
		        	  
		  }
		  
	}
	
}
