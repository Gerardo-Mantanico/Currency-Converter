
# Currency Converter

Este proyecto es un conversor de moneda desarrollado en Java, que permite a los usuarios convertir monedas entre diferentes países utilizando la API de ExchangeRate-API y la API de RestCountries.

## Descripción del Proyecto

El conversor de moneda es una herramienta que facilita la conversión de montos entre diversas monedas. Proporciona una interfaz interactiva para seleccionar pares de monedas y realizar conversiones, con soporte adicional para obtener monedas de países especificados por el usuario.

## Características principales

- **Conversión de monedas comunes**: Opciones predefinidas para convertir entre GTQ, USD y MXN.
- **Conversión de otras monedas**: Permite la entrada de cualquier par de países para obtener sus monedas y realizar la conversión.
- **Interfaz interactiva**: Solicita entradas del usuario y proporciona resultados en tiempo real.
- **Manejo de errores**: Muestra mensajes de error claros cuando no se puede realizar la conversión.

## APIs utilizadas

- **ExchangeRate-API**: Para obtener las tasas de conversión entre diferentes monedas.
- **RestCountries API**: Para obtener el código de moneda correspondiente a un país.

## Métodos de Conversión

El proyecto utiliza la API de ExchangeRate-API para obtener las tasas de conversión y la API de RestCountries para obtener el código de moneda correspondiente a un país.

## Cómo funciona

1. El usuario selecciona una opción de conversión predefinida o elige "Otros países" para especificar países personalizados.
2. Si se selecciona "Otros países", el usuario ingresa los nombres de los países de origen y destino.
3. El sistema obtiene el código de moneda correspondiente a los países ingresados.
4. El usuario ingresa la cantidad a convertir.
5. El sistema realiza la conversión y muestra el resultado.
6. El usuario puede ver el historial de conversiones realizadas

## Uso

### Ejecución del programa

Para ejecutar el programa, necesitas tener configurado el entorno de Java. El programa se ejecuta desde la línea de comandos:

```sh
java -jar currency_converter.jar
```

# Ejemplo

Este programa permite convertir entre diferentes monedas utilizando los tipos de cambio actuales. Puede seleccionar entre las siguientes opciones de conversión:

1. GTQ a USD
2. GTQ a MXN
3. USD a GTQ
4. USD a MXN
5. MXN a GTQ
6. MXN a USD
7. Otros países
8. Historial de conversiones
9. Salir

Opción: 1


## Ejemplo de uso

1. Ingrese la cantidad a convertir
   
```sh
 100
```

Resultado:
-------------------------------------
Moneda de origen =  GTQ
Moneda de destino = USD
Cantidad = 100.0
Tasa de conversion = 0.1287
Resultado  = 12.87

## Ejemplo de uso
Opción: 8

 Historial de conversiones
-------------------------------------
Moneda de origen =  GTQ
Moneda de destino = USD
Cantidad = 78.0
Tasa de conversion = 0.1287
Resultado  = 10.0386
-------------------------------------
Moneda de origen =  GTQ
Moneda de destino = USD
Cantidad = 45.0
Tasa de conversion = 0.1287
Resultado  = 5.7915
-------------------------------------
Moneda de origen =  MXN
Moneda de destino = USD
Cantidad = 78.0
Tasa de conversion = 0.05893
Resultado  = 4.59654
-------------------------------------
Moneda de origen =  GTQ
Moneda de destino = USD
Cantidad = 100.0
Tasa de conversion = 0.1287
Resultado  = 12.87
-------------------------------------
Moneda de origen =  GTQ
Moneda de destino = USD
Cantidad = 100.0
Tasa de conversion = 0.1287
Resultado  = 12.87
-------------------------------------
Moneda de origen =  GTQ
Moneda de destino = USD
Cantidad = 100.0
Tasa de conversion = 0.1287
Resultado  = 12.87



# Registro de Versiones

## Versión 1.0.0

- **Fecha**: 25/05/2024
- **Descripción**: Implementación inicial de la funcionalidad básica de conversión de monedas.

## Autor

Gerardo Tax

