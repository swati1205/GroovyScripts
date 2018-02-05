import groovy.json.JsonSlurper
import groovy.json.StreamingJsonBuilder
import groovy.json.*
import groovy.json.JsonOutput;
    
/*class JiraMain {
    static void main(String[] args) {
  
    get()
    }
    }
  private static get()
   { */
  String authString = "jira:jira123".bytes.encodeBase64().toString()
 def url = "http://34.211.100.27:8080/rest/api/2/issue/tab-7";
 def json;
        def connection = url.toURL().openConnection()
        connection.addRequestProperty("Authorization", "Basic ${authString}")
      connection.setRequestMethod("GET")
      connection.setRequestProperty( 'User-Agent', 'groovy-2.4.4' )
      connection.setRequestProperty( 'Accept', 'application/json' )
       connection.doOutput = false
       connection.connect()
   // connection.content.text
    
if ( connection.responseCode == 200 ) {
    // get the JSON response
     json = connection.inputStream.withCloseable { inStream ->
        new JsonSlurper().parse( inStream as InputStream )
    }
}
//println("output of 1st api is "+json)
def id= json.id;

println  ("id is "+id);

  def field=json.fields;  
  //println field;  
 def enviornment = field.customfield_10104.value;
 println enviornment;
 def key=json.fields.project.key;
  println ("key is "+key);
 //call second method
getgridvalues(id,key,enviornment)
//}

private static getgridvalues(String Id,String key,def enviornment)
{
def json;
String authString = "jira:jira123".bytes.encodeBase64().toString()
def url = ("http://34.211.100.27:8080/rest/idalko-igrid/1.0/grid/10101/issue/"+Id);
 def connection = url.toURL().openConnection()
        connection.addRequestProperty("Authorization", "Basic ${authString}")
      connection.setRequestMethod("GET")
      connection.setRequestProperty( 'User-Agent', 'groovy-2.4.4' )
      connection.setRequestProperty( 'Accept', 'application/json' )
       connection.doOutput = false
       connection.connect()
   // connection.content.text
    
if ( connection.responseCode == 200 ) {
    // get the JSON response
     json = connection.inputStream.withCloseable { inStream ->
        new JsonSlurper().parse( inStream as InputStream )
    }
}
def comptype_value = json.values.componenttype.value
println comptype_value;
def ids=json.values.id;
println ids;
def version_value=json.values.version.value
println version_value

//create job_name
       
    StringBuilder final_jobname = new StringBuilder();
    ArrayList<String> jobName = new ArrayList<String>();
for (int i = 0; i < enviornment.size(); i++) {
           
            for (int j = 0; j < comptype_value.size(); j++) {
                final_jobname.append(key + "_");
                final_jobname.append(comptype_value.get(j) + "_");
                final_jobname.append(enviornment.get(i));
                jobName.add(final_jobname.toString());
                final_jobname.setLength(0);
            }

        }

        println jobName;
       def filename ="D://json.text"
//calling method to trigger jenkins job
//TriggerJob(comptype_value, enviornment, jobName, version_value);
def jsonBuilder = new groovy.json.JsonBuilder()
   
createJson(comptype_value, enviornment, jobName, version_value,ids,jsonBuilder)

}
class T1{
def Version
def Environment
def id
def Component
}

private static createJson(def comp_name, def  environment, def jobName,def  versions,def idvalue,def jsonBuilder)
{
 def file = new File("D://json.txt")
   def file2 = new File("D://jsonout.txt")
 PrintWriter writer = new PrintWriter(file);
writer.print("");
writer.close();
 PrintWriter writer1 = new PrintWriter(file2);
writer1.print("");
writer1.close();
      int i=0,k=0;
     while(k<jobName.size())
   {
    while(i<environment.size())
    {
    for(int j=0;j<comp_name.size();j++)
    {
    def T1 = new T1(Version:""+versions[j]+"",
    Environment:""+environment[i]+"",
    id:""+idvalue[j]+"",
    Component:""+comp_name[j]+"")
    def tab1 = T1
   
    def job=jobName[k];
    
    jsonBuilder("$job": tab1)
   // println(jsonBuilder.toPrettyString())  
    k++ 
    def result = (jsonBuilder.toPrettyString())  
   // println result;
   
    file.append(result)


    }
    i++
    }
    }


   def file1 = new File("D://json.txt")  
    def content = file1.text
    //def res= content.replaceAll("\\[" , "")
    // def res2= res.replaceAll("\\]" , "")
   def res1 =content.replaceAll("\\}\\{", ",")
    println res1;
   file2.append(res1)
 
   }