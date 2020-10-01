Products test
- He añadido flyway como gestor de scripts de bbdd.
- Swagger que se ha requerido. http://localhost:8080/swagger-ui.html
- No he querido entrar en el manejo de exceptions con un ControllerAdvice ya que quizás
    me estaba saliendo del alcance de lo solitado.
- existe en los test integrados un populate que nutre la tabla prices.
- he normalizado un poco el modelo de bbdd dado.
-he creado la carpeta api, pero sería una librería para compartir dto entre micros.
- los 5 casos de test están en los integrados los cuales se ejecutan con el profile:
    mvn clean install -PintegrationTests
 - los test unitarios con :
    mvn verify
 -cuando no se encuentran datos en bbdd segun los requestParams la response es {} (son requeridos todos)
-para probar el micro levantando el servicio solo sería necesario copiar el fichero en test de populate
y crear una version nueva V3_0_xxxx_xxxx.sql.
-todo el código está documentado.

commandos:
los test unitarios con :
    mvn verify
 Integrados:
   mvn clean install -PintegrationTests
   
   Ejemplo URL:
   http://localhost:8080/products?dateAndTime=2020-06-14%2010%3A00%3A00&productId=3&brandId=3
   Params:
   dateAndTime= 2020-06-14 10:00:00
   productId=3
   brandId= 3