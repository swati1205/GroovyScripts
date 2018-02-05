import groovy.json.JsonSlurper
import groovy.json.StreamingJsonBuilder
import groovy.json.*

def count = 0;
def  connection = new URL("http://{url_of_artifactory}/artifactory/api/storage/{repo_name}").openConnection();
connection.setRequestProperty( 'User-Agent', 'groovy-2.4.4' )
connection.setRequestProperty( 'Accept', 'application/json' )
def json;
if ( connection.responseCode == 200 ) {
    // get the JSON response
     json = connection.inputStream.withCloseable { inStream ->
        new JsonSlurper().parse( inStream as InputStream )
    }
}
    println json
    println json.uri;