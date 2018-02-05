def jsonBuilder = new groovy.json.JsonBuilder()
def myBook = new MyBook(isbn: '0321774094',
  title: 'Scala for the Impatient',
  author: 'Cay S. Horstmann',
  publisher: 'Addison-Wesley Professional')

def myBook2 = new MyBook(isbn: '0976694085',
  title: 'Pragmatic Ajax: A Web 2.0 Primer',
  author: 'Justin Gehtland, Ben Galbraith, Dion Almaer',
  publisher: 'Pragmatic Bookshelf')

def myBook3 = new MyBook(isbn: '1934356050',
  title: 'Pragmatic Thinking and Learning: Refactor Your Wetware',
  author: 'Andy Hunt',
  publisher: 'Pragmatic Bookshelf')

def myBookList = [myBook]
def tab1= [myBook2]
def tab2 = [myBook3]
jsonBuilder(books: myBookList, books1: tab1, book3: tab2)
println("Using list of objects")
println(jsonBuilder.toPrettyString())