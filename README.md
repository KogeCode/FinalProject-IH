# FinalProject-IH

FinalProject-IH es un proyecto desarrollado en el lenguaje de programación Java el cual simula una API para una entidad bancaria. Dicho proyecto forma parte del bootcam JAVA-BACKEND de Ironhack©.


## DIAGRAMA DE CLASES

A continuación, se muestra el diagrama de clases utilizado en el proyecto en el cual se pueden observar dos clases principales (Account y User) de las cuales surgen el resto de sub-clases y que serán utilizadas durante el proyecto.
![diagrama de clases](https://github.com/KogeCode/FinalProject-IH/blob/main/assets/Diagrama.png)

## SWAGGER UI DOCUMENTATION

A continuación se mostrarán una serie de capturas tomadas al swagger-ui el cual mostrará los diferentes *end-points* que se encuentran en nuestra API.

*URL para ver los end-points desde el navegador con swagger: http://localhost:8080/swagger-ui/index.html*

[![Image from Gyazo](https://i.gyazo.com/6bf86fb559ce1803f89ef58b3d433c9c.png)](https://gyazo.com/6bf86fb559ce1803f89ef58b3d433c9c)
[![Image from Gyazo](https://i.gyazo.com/309a2784fe07df9f5286904729e1b8f6.png)](https://gyazo.com/309a2784fe07df9f5286904729e1b8f6)
[![Image from Gyazo](https://i.gyazo.com/948e753d3fbd1f5d8a5ea6176491d84f.png)](https://gyazo.com/948e753d3fbd1f5d8a5ea6176491d84f)
[![Image from Gyazo](https://i.gyazo.com/95ba33aa3fb354a02c415ab0f96eeb5a.png)](https://gyazo.com/95ba33aa3fb354a02c415ab0f96eeb5a)

## PACKAGE Y ARCHIVOS DEL PROYECTO

### Package MODELS
[![Image from Gyazo](https://i.gyazo.com/1abcc4fc639a60acd26ab0a8609ebc47.png)](https://gyazo.com/1abcc4fc639a60acd26ab0a8609ebc47)

En este package encontraremos los modelos (Clases) que usaremos en la API, podemos observar que las clases *User* y *Acount* son clases padre de las cuales heredarán propiedad las subclases como ejemplo AccountHolder o SavingAccount.

Existe la clase independiente Transaction la cual es utilizada para realizar transferencias entre distintas cuentas o con una cuenta Third Party.

La clase embedded Address es utilizada para añadirla a otras clases y asociarles una dirección

### Package ENUMS
[![Image from Gyazo](https://i.gyazo.com/7a5cf51bd3acbe48964d9f091e77537b.png)](https://gyazo.com/7a5cf51bd3acbe48964d9f091e77537b)

El ENUM de status será utilizado para definir el estado de la cuenta y este solo podrá tener dos valores, FROZEN o ACTIVA.

### Package Controllers
[![Image from Gyazo](https://i.gyazo.com/89311438656c8fc1369cf459c100eb0c.png)](https://gyazo.com/89311438656c8fc1369cf459c100eb0c)

Son los controladores donde definiremos los *end-points* de nuestras rutas para realizar ciertas funciones

### Package  Repositories
[![Image from Gyazo](https://i.gyazo.com/e65ded139bd5ae7a9de4134a6a3332c2.png)](https://gyazo.com/e65ded139bd5ae7a9de4134a6a3332c2)

Son los repositorios (interfaces) que usaremos para obtener ciertas funcionalidades como por ejemplo encontrar una SavingAccount por su ID.

### Package Services
[![Image from Gyazo](https://i.gyazo.com/e55f472a2751778bee0e081661fb8fa1.png)](https://gyazo.com/e55f472a2751778bee0e081661fb8fa1)

En estos archivos vamos a encontrar la lógica que será usada por los controladores cuando se usen.

## ANTES DE USAR
[![Image from Gyazo](https://i.gyazo.com/ef226892c43458ec6c8696307da72a84.png)](https://gyazo.com/ef226892c43458ec6c8696307da72a84)

Será de suma importancia tener en MySQL un schema creado con el nombre *finalproject* y modificar los apartados de usuario y contraseña para que la API pueda conectarse a nuestra base de datos.
