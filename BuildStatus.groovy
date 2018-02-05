import groovy.json.JsonSlurper
import groovy.json.StreamingJsonBuilder
import groovy.json.*
import groovy.json.JsonOutput;

def status;
def buildStatus;
def buildNO;
//start the build
def proc = "D:\\curl-7.50.3-win64-mingw\\bin\\curl.exe -u swati:swati -X POST http://localhost:8085/job/MultiGit_Checkout/build"
def process = proc.execute()
//check status
sleep(20000)
while (status == null)
{


String authString = "swati:swati".bytes.encodeBase64().toString()
 def url = "http://localhost:8085/job/MultiGit_Checkout/lastBuild/api/json";
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
//println json
//println("output of api is "+json.result)
buildNO=json.id
status= json.result
buildStatus =status

}
println buildNO
println buildStatus