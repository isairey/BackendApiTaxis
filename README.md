<div align="center">

<img width="220" src="https://cdn-icons-png.flaticon.com/512/3097/3097183.png" />

# 🚖 Taxi App Backend

### API Backend para Plataforma de Transporte y Solicitud de Taxis 🚀

<p align="center">
  <b>Taxi App Backend</b> es una plataforma backend desarrollada con Spring Boot para administrar conductores, pasajeros, viajes, pagos y servicios de transporte en tiempo real.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/SpringBoot-Backend-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
  <img src="https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white">
  <img src="https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
  <img src="https://img.shields.io/badge/JWT-Security-black?style=for-the-badge">
</p>

<p align="center">
  <a href="#-acerca-del-proyecto">Acerca</a> •
  <a href="#-módulos-del-sistema">Módulos</a> •
  <a href="#-tecnologías-utilizadas">Tecnologías</a> •
  <a href="#-instalación">Instalación</a> •
  <a href="#-api-rest">API</a>
</p>

</div>

---

# 🌌 Acerca del proyecto

**Taxi App Backend** es una API REST desarrollada para gestionar una plataforma de transporte tipo Uber, DiDi o InDrive.

El sistema permite administrar pasajeros, conductores, vehículos, solicitudes de viaje, pagos y autenticación mediante una arquitectura moderna basada en Spring Boot.

La API permite:

* 🚖 Solicitud de viajes
* 👨‍✈️ Gestión de conductores
* 👤 Administración de pasajeros
* 📍 Seguimiento de ubicaciones
* 💳 Gestión de pagos
* 📊 Historial de viajes
* 🔐 Seguridad JWT
* 🌐 Integración con aplicaciones móviles

---

# ✨ Características

## 🚖 Gestión de viajes

* Solicitud de viajes
* Asignación automática de conductores
* Estado del viaje en tiempo real
* Historial de recorridos
* Cancelación de servicios

---

## 👤 Gestión de usuarios

* Registro de pasajeros
* Registro de conductores
* Inicio de sesión
* Recuperación de acceso
* Administración de perfiles

---

## 🚘 Gestión de vehículos

* Registro de vehículos
* Validación de documentos
* Información de unidades
* Disponibilidad de servicio
* Control de estatus

---

## 💳 Sistema de pagos

* Cálculo automático de tarifas
* Historial de pagos
* Métodos de pago
* Facturación
* Reportes financieros

---

# 👨‍💼 Módulos del sistema

## 👤 User Module

Sistema encargado de la administración de usuarios.

### Funcionalidades

* Registro de usuarios
* Inicio de sesión
* Gestión de perfiles
* Roles y permisos
* Seguridad JWT

---

## 🚖 Trip Module

Módulo principal para la gestión de viajes.

### Funcionalidades

* Crear viaje
* Asignar conductor
* Finalizar recorrido
* Cancelar viaje
* Historial de servicios

---

## 👨‍✈️ Driver Module

Administración de conductores.

### Funcionalidades

* Registro de conductores
* Validación de documentos
* Disponibilidad en línea
* Historial de viajes
* Calificaciones

---

## 🚘 Vehicle Module

Administración de vehículos registrados.

### Funcionalidades

* Registro de unidades
* Actualización de información
* Verificación vehicular
* Disponibilidad

---

## 💳 Payment Module

Gestión financiera del sistema.

### Funcionalidades

* Procesamiento de pagos
* Historial de transacciones
* Tarifas dinámicas
* Reportes financieros

---

# 🛠️ Tecnologías utilizadas

## ☕ Backend

<p>
  <img src="https://skillicons.dev/icons?i=java,spring,maven" />
</p>

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA
* Maven

---

## 🗄️ Base de datos

<p>
  <img src="https://skillicons.dev/icons?i=mysql" />
</p>

* MySQL
* JPA / Hibernate
* Relaciones SQL
* Persistencia de datos

---

## 🔐 Seguridad

<p>
  <img src="https://skillicons.dev/icons?i=postman" />
</p>

* JWT Authentication
* Spring Security
* Role Based Access
* Protected Endpoints

---

## 🧰 Herramientas

<p>
  <img src="https://skillicons.dev/icons?i=git,github,vscode" />
</p>

* Git
* GitHub
* VS Code
* Postman

---

# 📂 Estructura del proyecto

```bash
TaxiBackend/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── repository/
│   │   │   ├── entity/
│   │   │   ├── security/
│   │   │   ├── dto/
│   │   │   └── config/
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │
├── pom.xml
├── mvnw
├── README.md
└── .gitignore
```

---

# 🗄️ Modelo de Base de Datos

## Entidades principales

### 👤 Usuario

* id
* nombre
* correo
* contraseña
* rol

---

### 👨‍✈️ Conductor

* id
* licencia
* disponibilidad
* calificación

---

### 🚘 Vehículo

* id
* marca
* modelo
* placas
* capacidad

---

### 🚖 Viaje

* id
* origen
* destino
* distancia
* tarifa
* estado

---

### 💳 Pago

* id
* monto
* métodoPago
* fechaPago

---

# ⚡ Instalación

## 📋 Requisitos

* Java 21
* Maven
* MySQL
* Postman
* VS Code

---

# 🚀 Configuración del proyecto

## 1️⃣ Clonar repositorio

```bash
git clone https://github.com/isairey/TaxiBackend.git
```

---

## 2️⃣ Entrar al proyecto

```bash
cd TaxiBackend
```

---

## 3️⃣ Configurar base de datos

Crear base de datos:

```sql
CREATE DATABASE taxi_app;
```

---

## 4️⃣ Configurar application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taxi_app
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=TaxiSecretKey2026
jwt.expiration=86400000
```

---

## 5️⃣ Ejecutar aplicación

```bash
mvn spring-boot:run
```

---

# 📡 API REST

## 🔐 Autenticación

### Endpoints

```http
POST /api/auth/register
POST /api/auth/login
```

Funciones:

* Registro
* Login
* JWT Token
* Seguridad

---

## 👤 Usuarios

```http
GET    /api/users
GET    /api/users/{id}
PUT    /api/users/{id}
DELETE /api/users/{id}
```

---

## 🚖 Viajes

```http
POST   /api/trips
GET    /api/trips
GET    /api/trips/{id}
PUT    /api/trips/{id}
DELETE /api/trips/{id}
```

---

## 👨‍✈️ Conductores

```http
POST   /api/drivers
GET    /api/drivers
PUT    /api/drivers/{id}
DELETE /api/drivers/{id}
```

---

## 🚘 Vehículos

```http
POST   /api/vehicles
GET    /api/vehicles
PUT    /api/vehicles/{id}
DELETE /api/vehicles/{id}
```

---

# 📊 Funcionalidades principales

## 🚖 Plataforma de transporte

* Solicitud de taxis
* Gestión de viajes
* Seguimiento de recorridos
* Historial de servicios

---

## 👨‍✈️ Administración de conductores

* Disponibilidad
* Calificaciones
* Información personal
* Historial de trabajo

---

## 💳 Gestión financiera

* Pagos
* Tarifas
* Reportes
* Historial de transacciones

---

# 🧠 Objetivos del proyecto

## 🎯 Aprendizaje y desarrollo

* Spring Boot
* Arquitectura REST
* JWT Authentication
* Bases de datos SQL
* APIs escalables
* Aplicaciones de transporte
* Integración móvil

---

# 🚧 Roadmap

## 🔮 Próximas mejoras

* 📍 Geolocalización en tiempo real
* 🗺️ Integración con Google Maps
* 💳 Stripe y PayPal
* 🔔 Notificaciones Push
* 📱 Aplicación Android
* 🍎 Aplicación iOS
* ☁️ Despliegue en AWS
* 📊 Dashboard administrativo

---

# 🤝 Contribuciones

Las contribuciones son bienvenidas ❤️

## Cómo contribuir

1. Fork del proyecto

```bash
git checkout -b feature/nueva-funcionalidad
```

2. Commit

```bash
git commit -m "✨ Nueva funcionalidad"
```

3. Push

```bash
git push origin feature/nueva-funcionalidad
```

4. Pull Request 🚀

---

# 👨‍💻 Desarrollador

<div align="center">

## Isai Reyes — Backend Developer

Desarrollador apasionado por la creación de APIs escalables, sistemas de transporte, plataformas empresariales y arquitecturas modernas con Spring Boot 🚀

</div>

---

# 🌟 Apoya el proyecto

⭐ Dale una estrella

🍴 Haz Fork

📢 Comparte el proyecto

🚖 Impulsa el desarrollo de soluciones de movilidad

---

# 📜 Licencia

Proyecto Open Source orientado al aprendizaje y desarrollo de plataformas de transporte, gestión de viajes y aplicaciones tipo Uber, DiDi o InDrive.

---

<div align="center">

### 🚖 Taxi App Backend — La infraestructura inteligente detrás de una plataforma moderna de transporte 🚀

</div>
