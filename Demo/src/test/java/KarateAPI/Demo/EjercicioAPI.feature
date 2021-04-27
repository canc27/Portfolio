Feature: Test BackEnd

  Scenario: Obtener una lista de cervecerias
    Given url 'https://api.openbrewerydb.org/breweries/autocomplete?query=lagunitas'
    When method GET
    And print response
    #And match each $[*] contains {name: 'Lagunitas Brewing Co'}
    * def filt = function(x){ return x.name == 'Lagunitas Brewing Co' }
    * def items = get response[*]
    * def res = karate.filter(items, filt)
    * print res
    * def id1 = res[0].id
    * def id2 = res[1].id
    * print id1
    * print id2
    Given url 'https://api.openbrewerydb.org/breweries/' + id1
    When method GET
    And print response
  	
    Given url 'https://api.openbrewerydb.org/breweries/' + id2
    When method GET
    And print response
    And match response.state == "California"
    And match response.name == "Lagunitas Brewing Co"
    And match response.street == "1280 N McDowell Blvd"
    And match response.phone == "7077694495" 