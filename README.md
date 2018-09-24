# OnlineStore
OnlineStore
--------------------
RESTful service that implments a check out counter for an online retail store that scans products and generates an itemized bill.
The bill should also total the cost of all the products and the applicable sales tax for each product.
The total cost and total sales tax should be printed
Sales tax varies based on the type of products
 category A products carry a levy of 10%
 category B products carry a levy of 20%
 category C products carry no levy

Swagger Url: http://localhost:8080/swagger-ui.html

Steps to build and run: 

1.Download or clone the repository and unzip.
2.Inside OnlineStore directory run : 
  mvn clean install
  mvn spring-boot:run
3.http://localhost:8080/swagger-ui.html to  test from swagger.
