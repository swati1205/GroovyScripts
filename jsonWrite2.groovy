def jsonBuilder = new groovy.json.JsonBuilder()
class T1{
def Version
def Environment
def id
def Component
}
class T2{
def Version
def Environment
def id
def Component
}
class T3{
def Version
def Environment
def id
def Component
}
class T4{
def Version
def Environment
def id
def Component
}
    def file = new File("D://json2.txt")
def T1 = new T1(Version:'StudentEnrollmentWithSpring-21.war',
    Environment:'STG',
    id:'21',
    Component:'COMPONENT2')

def T2= new T2(Version:'StudentEnrollmentWithSpring-21.war',
    Environment:'DEV',
    id:'21',
    Component:'COMPONENT2')
    
def T3= new T3(Version:'StudentEnrollmentWithSpring-01.war',
    Environment:'STG',
    id:'20',
    Component:'COMPONENT1')
    
def T4=new T4(Version:'StudentEnrollmentWithSpring-01.war',
    Environment:'DEV',
    id:'20',
    Component:'COMPONENT1')
def tab1 = T1
def tab2=  T2
def tab3=T3
def tab4=T4
jsonBuilder(TAB_COMPONENT2_STG: tab1, TAB_COMPONENT2_DEV: tab2, TAB_COMPONENT1_STG: tab3,TAB_COMPONENT1_DEV: tab4)
println("Using list of objects")
println(jsonBuilder.toPrettyString())
file.write(jsonBuilder.toPrettyString())