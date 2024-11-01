# Enterprise Application - Product Rental Platform

Dit project is een Spring Boot webapplicatie die een platform biedt voor studenten van een kunstopleiding om materiaal te reserveren en te huren voor projecten en eindwerken. Gebruikers kunnen inloggen, materialen doorzoeken, producten toevoegen aan hun winkelmandje en hun reserveringen bevestigen.

## Inhoudsopgave
- [Over het project](#over-het-project)
- [Projectstructuur](#projectstructuur)
- [Technologieën](#technologieën)
- [Installatie](#installatie)
- [Configuratie](#configuratie)

---

## Over het project

Dit project is ontwikkeld als een proof-of-concept platform voor studenten die materiaal willen huren. Het systeem biedt een catalogus, een winkelmandje, een beveiligd inlogsysteem, en een mogelijkheid om reserveringen te bevestigen. Spring Security zorgt voor de beveiliging van het platform.

## Projectstructuur

Het project is opgebouwd in een gestructureerde mappenindeling met de volgende kerncomponenten:

- `models`: Entiteiten zoals `Product`, `Order`, en `User`, die de database-tabellen representeren.
- `repositories`: Interfaces voor databasetoegang, zoals `ProductRepository`, `UserRepository`, en `OrderRepository`.
- `controllers`: Controllers die de endpoints van de applicatie beheren.
- `services`: Bevat businesslogica, bijvoorbeeld `ProductService`, `UserService`, enzovoort.
- `config`: Beveiligingsconfiguratie en andere instellingen.

## Technologieën

- **Spring Boot** - Framework voor snelle applicatieontwikkeling in Java.
- **Spring Data JPA** - Voor database-interactie met een PostgreSQL- of H2-database.
- **Spring Security** - Voor gebruikersauthenticatie en autorisatie.
- **PostgreSQL** - Database voor opslag van gegevens (kan worden vervangen door H2 voor eenvoudigere opzet).
- **Maven** - Voor projectbeheer en dependency-beheer.

## Installatie

1. **Clone de repository**:
   ```bash
   git clone https://github.com/jouw-gebruikersnaam/jouw-repository.git
   cd jouw-repository/backend
   ```

2. **Installeer de afhankelijkheden**:
   Zorg ervoor dat Maven en JDK 17 of hoger zijn geïnstalleerd.
   ```bash
   mvn clean install
   ```

3. **Stel de database in**:
   Configureer een PostgreSQL-database of gebruik de H2-database in de `application.properties` of `application.yml` zoals hieronder beschreven in de sectie Configuratie.
   ```bash
   docker compose up -d
   ```

4. **Start backend applicatie**:
   ```bash
   mvn spring-boot:run
   ```

5. **Start frontend application**
   ```bash
   cd ../frontend
   npm install
   npm run dev
   ```
   
## Configuratie

De basisinstellingen zijn te vinden in `src/main/resources/application.properties`. Hier kun je de database, poorten en beveiligingsopties instellen.

**Voorbeeld van `application.properties`**:
```properties
# Database configuratie
spring.datasource.url=jdbc:postgresql://localhost:5432/enterpriseapp
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password

# H2-database (voor testing)
# spring.datasource.url=jdbc:h2:mem:testdb

# JPA instellingen
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

# Spring Security instellingen
spring.security.user.name=admin
spring.security.user.password=admin
```

### Docker

Om een PostgreSQL-database te draaien in Docker, gebruik de volgende `docker-compose.yml`:
```yaml
version: '3.8'
services:
  db:
    image: postgres:latest
    environment:
      POSTGRES_USER: your_db_username
      POSTGRES_PASSWORD: your_db_password
      POSTGRES_DB: enterpriseapp
    ports:
      - "5432:5432"
```
Start de container:
```bash
docker-compose up -d
```




