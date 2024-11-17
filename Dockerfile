# Utiliza la imagen base con el JDK
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copia el JAR generado al contenedor
COPY target/TrabajoFinal-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8080, ya que es el que tu aplicación usa
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
