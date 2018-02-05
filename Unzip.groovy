import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
//import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;


public class Unzip {

    
    public static void main(String[] args) {
        String zipPath = "D:\\Docs.zip";
            String destDir = "D:\\Docs";
            unzip(zipPath, destDir);
}

    private static void unzip(String zipPath, String destDir) {
         FileInputStream fis;
           
            byte[] buffer = new byte[1024];
            try {
                fis = new FileInputStream(zipPath);
                ZipInputStream zis = new ZipInputStream(fis);
                ZipEntry ze = zis.getNextEntry();
                while(ze != null){
                    String fileName = ze.getName();
                    File newFile = new File(destDir + File.separator + fileName);
                    System.out.println("Unzipping to "+newFile.getAbsolutePath());
                   
                    new File(newFile.getParent()).mkdirs();
                    FileOutputStream fos = new FileOutputStream(newFile);
                    int len;
                   for(int i=1 ;i<=zis.read(buffer);++i)
                    {
                        fos.write(i);
                    }
                    fos.close();
                    zis.closeEntry();
                    ze = zis.getNextEntry();
                }
                
                zis.closeEntry();
                zis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
             
        }
        
        
    }