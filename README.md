# ScraperApp
### ScraperApp to scrape a web URL

#####To compile and package the scraper application:

    mvn clean compile assembly:single

#####To execute the tests in the Scraper App:

    mvn clean test
  
#####To execute the Scraper App:

    java -jar target/ScraperApp-jar-with-dependencies.jar
    
#####Sample Output:
```json
  {
    "results" : [ {
      "title" : "Sainsbury's Apricot Ripe & Ready x5",
      "description" : "Apricots",
      "size" : "38.27kb",
      "unit_price" : 3.50
    }, {
      "title" : "Sainsbury's Avocado Ripe & Ready XL Loose 300g",
      "description" : "Avocados",
      "size" : "38.67kb",
      "unit_price" : 1.50
    }, {
      "title" : "Sainsbury's Avocado, Ripe & Ready x2",
      "description" : "Avocados",
      "size" : "43.44kb",
      "unit_price" : 1.80
    }, {
      "title" : "Sainsbury's Avocados, Ripe & Ready x4",
      "description" : "Avocados",
      "size" : "38.68kb",
      "unit_price" : 3.20
    }, {
      "title" : "Sainsbury's Conference Pears, Ripe & Ready x4 (minimum)",
      "description" : "Conference",
      "size" : "38.54kb",
      "unit_price" : 1.50
    }, {
      "title" : "Sainsbury's Golden Kiwi x4",
      "description" : "Gold Kiwi",
      "size" : "38.56kb",
      "unit_price" : 1.80
    }, {
      "title" : "Sainsbury's Kiwi Fruit, Ripe & Ready x4",
      "description" : "Kiwi",
      "size" : "38.98kb",
      "unit_price" : 1.80
    } ],
    "total" : 15.10
    }
```    

#####Default URL:
http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html

#####Classes:
1. ScraperApp - Main application class
2. IScraperService - Interface for Scraper service
3. ProductScraperService - Service class which acts as a main interface to the scraper implementation
4. BaseScraper - Base scraper class to parse the web page and convert into Document
5. ProductScraper - Child class of BaseScraper with additional functionality to get the product urls from main page
6. ProductDetailsScraper - Child class of BaseScraper with additional functionality to get the products data from product detailed pages
7. JsonUtils - Utils class to convert the object into JSON string
8. ScraperException - Exception class
9. IScraperConstant - Interface to maintain the constants
10. PageDocument - Data Object to hold document and length
11. ProductItem - Data Object to hold the product details
12) ProductsResult - Data Object to hold the list of product items and total

#####Technology Stack:
1. Java 8
2. Guice - Dependency Injection
3. Maven - Build
4. JUnit - Unit Testing
5. Hamcrest - Unit Testing
6. Jackson - JSON conversion
7. Guava - Google core library for PreCondition validations
8. JSoup - For parsing the web page

#####Future enhancements:
This solution can be implemented as a microservice using Spring Boot or DropWizard
