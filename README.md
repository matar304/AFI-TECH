# Projet AFI-TECH

Ce projet est une application web full-stack composée d'un backend en Java avec Spring Boot et d'un frontend en React utilisant Vite.

---

## Description

L'application AFI-TECH est conçue pour gérer des fonctionnalités liées à la gestion d'étudiants, notes, et utilisateurs avec authentification sécurisée via JWT. Le backend expose une API REST sécurisée, tandis que le frontend offre une interface utilisateur moderne et réactive.

---

## Structure du projet

- **AFI-TECH-backend** : Backend Java Spring Boot
- **AFI-TECH-frontend/frontend** : Frontend React avec Vite

---

## Prérequis

- Java 17
- Maven
- Node.js (version recommandée 16 ou supérieure)
- npm ou yarn

---

## Installation et exécution

### Backend

1. Se positionner dans le dossier `AFI-TECH-backend`
2. Construire le projet Maven :

```bash
mvn clean install
```

3. Lancer l'application Spring Boot :

```bash
mvn spring-boot:run
```

L'application backend sera accessible par défaut sur `http://localhost:8080`.

### Frontend

1. Se positionner dans le dossier `AFI-TECH-frontend/frontend`
2. Installer les dépendances :

```bash
npm install
# ou
yarn install
```

3. Lancer le serveur de développement Vite :

```bash
npm run dev
# ou
yarn dev
```

Le frontend sera accessible par défaut sur `http://localhost:5173` (ou autre port indiqué par Vite).

---

## Configuration

Le backend utilise un fichier de configuration `application.properties` situé dans `AFI-TECH-backend/src/main/resources/`. Un exemple est fourni dans `application.properties.example`. Vous pouvez configurer la connexion à la base de données, les paramètres de sécurité, etc.

---

## Tests

- Backend : Les tests unitaires peuvent être lancés avec Maven :

```bash
mvn test
```

- Frontend : Les tests ne sont pas explicitement configurés dans ce projet.

---

## Build pour production

### Backend

Construire le jar exécutable :

```bash
mvn clean package
```

Le fichier jar sera généré dans le dossier `target/`.

### Frontend

Construire les fichiers statiques optimisés :

```bash
npm run build
# ou
yarn build
```

Les fichiers de build seront générés dans le dossier `dist/`.

---

## Technologies utilisées

- Backend : Java 17, Spring Boot 3.4.2, Spring Security, JWT, Spring Data JPA, Hibernate Validator, MySQL/H2, Lombok, SpringDoc OpenAPI
- Frontend : React 18, Vite, React Router DOM, Material UI, Axios

