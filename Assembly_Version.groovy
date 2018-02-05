import java.nio.file.*;
def AssemblyVersion=""
def AssemblyFileVersion=""

try {
    BufferedReader br = new BufferedReader(new FileReader(new File("D:\\TestProjects\\T_PAYMENT_SER\\CDTService\\CDT.PaymentServices.WCF\\Properties\\AssemblyInfo.cs")))
    String line;
    while ((line = br.readLine()) != null) {
       if (line.contains("assembly: AssemblyVersion")) {
          AssemblyVersion=line.split("\"")[1] 
        println AssemblyVersion         
       }
       if (line.contains("assembly: AssemblyFileVersion")) {
          AssemblyFileVersion=line.split("\"")[1]          
       }
    
    }
    String Assembly_Version=AssemblyVersion;
    println Assembly_Version
    firstIndex = Assembly_Version.substring(0,Assembly_Version.lastIndexOf("."))
    println firstIndex
  String  build_identifierNo = 1
build_identifierNo = (Integer.parseInt(build_identifierNo))+1
Build_Number = firstIndex + "." + build_identifierNo.toString()
println Build_Number
    }catch (Exception e) {e.printStackTrace()}