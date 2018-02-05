import groovy.json.JsonBuilder
import groovy.json.JsonOutput
def json = new groovy.json.JsonBuilder()
File file = new File("D://json.text")
json.TAB_COMPONENT2_STG(
    Version:'StudentEnrollmentWithSpring-21.war',
    Environment:'STG',
    id:'21',
    Component:'COMPONENT2'
)
println(json.toPrettyString())
file.write json.toPrettyString()
json.TAB_COMPONENT2_DEV(
    Version:'StudentEnrollmentWithSpring-21.war',
    Environment:'DEV',
    id:'21',
    Component:'COMPONENT2'
)

println(json.toPrettyString())
file.write json.toPrettyString()
json.TAB_COMPONENT1_STG(
    Version:'StudentEnrollmentWithSpring-01.war',
    Environment:'STG',
    id:'20',
    Component:'COMPONENT1'
)

println(json.toPrettyString())
file.write json.toPrettyString()
json.TAB_COMPONENT1_DEV(
    Version:'StudentEnrollmentWithSpring-01.war',
    Environment:'DEV',
    id:'20',
    Component:'COMPONENT2'
)

println(json.toPrettyString())
file.write json.toPrettyString()
println("Using just named arguments")



