package test.com;
import java.io.File;

public class Deletefile {
 
  public static boolean delete(String fileName) {
     System.out.println("delete");
 
     File file = new File(fileName);
     if (!file.exists()) {
       System.out.println("删除文件失败：" + fileName + "文件不存在");
       return false;
     } else {
       if (file.isFile()) {
 
         return deleteFile(fileName);
       } else {
         return deleteDirectory(fileName);
       }
     }
 
  }
 
 
 
  /**
   *  删除单个文件
   * @param fileName被删除文件的文件名
   * @return单个文件删除成功返回true,否则返回false
   */
  public static boolean deleteFile(String fileName) {
 
     System.out.println("deleteFile");
     File file = new File(fileName);
 
     if (file.exists() && file.isFile()) {
       file.delete();
       System.out.println("删除单个文件" + fileName + "成功！");
       return true;
     } else {
       System.out.println("删除单个文件" + fileName + "失败！");
       return false;
     }
 
  }
 
 
 
  /**
   * 删除目录（文件夹）以及目录下的文件
   * @param dir被删除目录的文件路径
   * @return目录删除成功返回true,否则返回false
   */
  public static boolean deleteDirectory(String dir) {
     System.out.println("deleteDirectory");
     //如果dir不以文件分隔符结尾，自动添加文件分隔符
 
     if (!dir.endsWith(File.separator)) {
       dir = dir + File.separator;
     }
     File dirFile = new File(dir);
     //如果dir对应的文件不存在，或者不是一个目录，则退出
     if (!dirFile.exists() || !dirFile.isDirectory()) {
       System.out.println("删除目录失败" + dir + "目录不存在！");
       return false;
     }
     boolean flag =true;
     //删除文件夹下的所有文件(包括子目录)
     File[] files = dirFile.listFiles();
     for (int i = 0; i < files.length; i++) {
 
       //删除子文件
       if (files[i].isFile()) {
         flag = deleteFile(files[i].getAbsolutePath());
 
         if (!flag) {
            break;
         }
       }
       //删除子目录
       else {
         flag = deleteDirectory(files[i].getAbsolutePath());
         if (!flag) {
            break;
         }
       }
 
     }
     if (!flag) {
       System.out.println("删除目录失败");
       return false;
     }
 
     //删除当前目录
 
     if (dirFile.delete()) {
       System.out.println("删除目录" + dir + "成功！");
       return true;
     } else {
 
       System.out.println("删除目录" + dir + "失败！");
       return false;
 
     }
  }
 
  public static void main(String[] args) {
 
 
      String fileDir = "E:/FILE";
     Deletefile.delete(fileDir);
    
 
  }
 
}
 

