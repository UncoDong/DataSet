该脚本用来将midi转换成为wav文件，可以转换一个文件夹下所有文件，也可以转换单独文件，转换完的wav文件会保存在原midi文件的路径下。

This script is used to convert MIDI into WAV files. It can convert all files in a folder or single midi file. The converted WAV files will be saved in the same path with original MIDI file

1. 转换文件夹内所有midi文件(Convert midis in folder)

   指令：`java -jar midi2wav.jar FolderPath`，如下图所示：

   ` java -jar midi2wav.jar ..\Midi_Files  `

   ![image-20200408172614701](E:\数据仓库\pic\转换文件夹)

2. 转换单个文件(Convert single midi)

   指令：`java -jar midi2wav.jar FilePath`，如下图所示：

   java -jar midi2wav.jar ..\Midi_Files\jingle_bells.mid

   ![image-20200408172626250](E:\数据仓库\pic\转换文件)

   ​								
   
   ​																								UncleDong