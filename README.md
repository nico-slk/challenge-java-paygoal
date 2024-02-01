
# PayGoal Java Jr Challenge - Nicolas Selicki

## Requisitos técnicos
- Utilizar Java 8 o superior. 
- Utilizar Spring Framework.
- Utilizar una base de datos en memoria(por ejemplo, HSQLDB, H2 Database, etc).
- La aplicación debe estar lista para ejecutar y hacer peticiones desde postman.

### Requeridas
- Crear un producto con los siguientes campos: nombre, descripción, precio, cantidad.
- Actualizar un producto existente.
- Consultar un producto por ID o por nombre.
- Eliminar un producto existente.

### Funcionalidades adicionales
- Consultar todos los productos ordenados por precio.




## Archivo - Application Properties

La configuración de la imagen en el archivo `application.propertes` debe verse como en la siguiente imagen. En caso de modificarse, debe coincidir la configuracion del puerto `server.port=XXXX`, username `spring.datasource.username=XXXX` y password `spring.datasource.password=XXXX`. Puede cambiar el nombre de la base de datos reemplazando la ultima palabra luego de los "dos puntos" ultimos `spring.datasource.url=jdbc:h2:mem:<NOMBRE-DB>`

![Logo](https://i.ibb.co/Sy5wmKr/application-properties.png)


## Body basico de un producto (entidad)

```bash
  ID: INTEGER
  NAME: STRING
  DESCRIPTION: STRING
  PRICE: DOUBLE
  STOCK: INTEGER
```

````
{
    "productId": 2,
    "name": "zapatilla",
    "description": "Zapatilla color azul talle 43",
    "price": 11.5,
    "stock": 11
}
````

Con el ejemplo dado previamente, tomandolo como referencia para hacer las pruebas en POSTMAN (o similar), será necesario para los métodos ```PUT``` y ```POST``` para proveer de un body valido para la modificacion de un producto o la creacion de uno nuevo (tener en cuenta que para la creación, no se debe pasar el parámetro ```productId```)
## Endpoints

- [GET - CONSULTAR POR ID](#-GET-CONSULTAR-POR-ID)
- [GET - CONSULTAR POR NOMBRE](#GET---CONSULTAR-POR-NOMBRE)
- [GET - CONSULTAR POR PRECIO](#GET---CONSULTAR-POR-PRECIO)
- [POST - CREAR PRODUCTO (extra)](#POST---CREAR-PRODUCTO)
- [PUT - ACTUALIZAR EXISTENTE](#PUT---ACTUALIZAR-EXISTENTE)
- [DELETE - ELIMINAR EXISTENTE](#DELETE---ELIMINAR-EXISTENTE)

## GET - CONSULTAR POR ID

Teniendo en cuenta la configuracion anterior donde se establece el puerto ```8090```

```http://localhost:8090/products/productId/3```

Y dado el endpoint, la respuesta se vería de la siguiente forma:


````
{
    "productId": 3,
    "name": "casa",
    "description": "grande",
    "price": 110.5,
    "stock": 1
}
````
## GET - CONSULTAR POR ID

Teniendo en cuenta la configuracion anterior donde se establece el puerto ```8090```

```http://localhost:8090/products/productId/3```

Y dado el endpoint, la respuesta se vería de la siguiente forma:


````
{
    "productId": 3,
    "name": "casa",
    "description": "grande",
    "price": 110.5,
    "stock": 1
}
````
## GET - CONSULTAR POR NOMBRE

Teniendo en cuenta la configuracion anterior donde se establece el puerto ```8090```

```http://localhost:8090/products/productName/auto```

Y dado el endpoint, la respuesta se vería de la siguiente forma:


````
{
    "productId": 2,
    "name": "auto",
    "description": "azul",
    "price": 11.5,
    "stock": 11
}
````


## GET - CONSULTAR POR PRECIO

Teniendo en cuenta la configuracion anterior donde se establece el puerto ```8090```

```http://localhost:8090/products/price```

Y dado el endpoint, la respuesta se vería de la siguiente forma, ene caso tambien cumple con el requisito de que la lista de productos debe estar ordenada según el precio.


````
[
    {
        "productId": 2,
        "name": "auto",
        "description": "azul",
        "price": 11.5,
        "stock": 20
    },
    {
        "productId": 1,
        "name": "bateria",
        "description": "Tama",
        "price": 22.0,
        "stock": 11
    },
    {
        "productId": 3,
        "name": "casa",
        "description": "grande",
        "price": 110.5,
        "stock": 1
    }
]
````

## POST - CREAR PRODUCTO (extra)

Teniendo en cuenta la configuracion anterior donde se establece el puerto ```8090```

```http://localhost:8090/products/```

El cuerpo que se debe enviar debe cumplir con la siguiente estructura:

````
{
    "name": "auto",
    "description": "azul",
    "price": 11.5,
    "stock": 11
}
````

Y dado el endpoint, la respuesta se vería de la siguiente forma:


````
{
    "productId": 2,
    "name": "auto",
    "description": "azul",
    "price": 11.5,
    "stock": 11
}
````

#### Este endpoint se creo para permitir crear productos para generar pruebas manuales
## PUT - ACTUALIZAR EXISTENTE

Teniendo en cuenta la configuracion anterior donde se establece el puerto ```8090```

```http://localhost:8090/products/1```

El cuerpo que se debe enviar debe cumplir con la siguiente estructura con cualquiera de los cambios modificados respetando el tipo de dato:

````
{
    "productId": 1,
    "name": "medias",
    "description": "naranjas",
    "price": 1.6,
    "stock": 10
}
````

Y dado el endpoint, la respuesta se vería de la siguiente forma:


````
{
    "productId": 1,
    "name": "medias",
    "description": "naranjas",
    "price": 1.6,
    "stock": 10
}
````
## DELETE - ELIMINAR EXISTENTE

Teniendo en cuenta la configuracion anterior donde se establece el puerto ```8090```

```http://localhost:8090/products/1```

Y dado el endpoint, la respuesta se vería de la siguiente forma:


````
{}
````
HttpStatus: 200 OK

