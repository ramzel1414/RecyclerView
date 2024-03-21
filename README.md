# Things to note:
- no landscape orientation support
In layout xml:
- there are two pages or activities (main.xml and main2.xml)
- the recycler_view_row.xml is just part of activity_main.xml

# Steps to Add string data(eg. stock: 78, category: smartphone) on MainActivity2
MainActivity2 (The page after you click the list of phone)
in any order:
- in MainActivity.java, fill in the SetUpPhoneModels and onItemClick functions 
- in MainActivity2.java, fill in the onCreate function 
- in activity_main2.xml, fill in or add the stock TextView
- in PhoneModel.java, declare your instance(stock) and add getters of it
- in strings.xml, add the string-array of phone_stock and its items
