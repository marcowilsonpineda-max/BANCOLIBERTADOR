# banco-libertador
# Marco P


La configuración de comunicación asíncrona se validó mediante rabbit para que la misma funcione 
correctamente e debe validar que rabbit se encuentre operativo y levantado dentro el servidor.

Caso contrario para probar los APIS se puede comentar la línea 30 de ClienteService.

Validación Docker comandos:

docker build -t mic_cuentas .
docker build -t mic_movimientos .

docker run -d --name mic_cuentas -p 8080:8080 mic_cuentas
docker run -d --name mic_movimientos -p 8081:8081 mic_movimientos

docker ps