import groovy.json.*
import groovy.json.JsonSlurper

def proc = "D:\\curl-7.50.3-win64-mingw\\bin\\curl.exe -u admin:password -X GET http://35.164.106.34:8081/artifactory/api/storage/latest-repo"
def process = proc.execute()
//process.waitFor()
 def output = process.in.text 
 
//println output 
def data = new JsonSlurper().parseText(output)

//println(data)
println("the url is "+data.uri)