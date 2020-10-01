Feature: calling get product data by params
  Scenario Outline: calling product controller with params date <date> brandId <brandId> productId <productId>
    Given there is an spring context
    Given the database contains the data prepared for populate-prices
    When product controller call with params date <date> brandId <brandId> productId <productId>
    Then verify http status <statusCode>
    Then verify price <price> listPrice <listPrice> startDate <startDate> endDate <endDate>
    Scenarios:
   |Cases | date                | brandId| productId | statusCode | price | listPrice | startDate          | endDate          |
   |  1   |2020-06-14%2010:00:00|    1   |    35455  |    200     |  35.50|      1    | 2020-06-14T00:00   |2020-12-31T23:59:59|
   |  2   |2020-06-14%2016:00:00|    1   |    35455  |    200     |  25.45|      2    | 2020-06-14T15:00   |2020-06-14T18:30   |
   |  3   |2020-06-14%2021:00:00|    1   |    35455  |    200     |  35.50|      1    | 2020-06-14T00:00   |2020-12-31T23:59:59|
   |  4   |2020-06-15%2010:00:00|    1   |    35455  |    200     |  30.50|      3    | 2020-06-15T00:00   |2020-06-15T11:00   |
   |  5   |2020-06-16%2021:00:00|    1   |    35455  |    200     |  38.95|      4    | 2020-06-15T16:00   |2020-12-31T23:59:59   |