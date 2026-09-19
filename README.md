# Path Forge Backend

## Project Overview
Path Forge Backend is a Spring Boot application that processes candidate resumes, analyzes their skills and experience, and generates a personalized interview preparation roadmap based on the target role and number of days available.

The system integrates:
- MongoDB for data persistence
- Docker for local database setup
- LLM-based AI generation for roadmap creation
- Resume parsing using PDF extraction

## Features
- Upload candidate resume PDFs
- Extract text from uploaded resumes
- Accept target role and preparation days as input
- Generate a structured interview prep plan using AI
- Store/retrieve data in MongoDB

## Tech Stack
- Java 17+
- Spring Boot 3+
- Spring AI
- MongoDB
- Apache PDFBox
- Docker

## Docker MongoDB Setup
Run MongoDB locally using Docker:

```bash
docker run -d --name mongodb -p 27017:27017 mongo:latest
```

Verify the container is running:

```bash
docker ps
```

You can connect to MongoDB using:

- Host: localhost
- Port: 27017
- Database: default / your configured database

## MongoDB Configuration
Add the following in `application.properties` (or update as needed):

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/pathforge
```

If your project uses a different database name, replace `pathforge` with your preferred database name.

## LLM / AI Model Details
This project uses a Spring AI chat client to generate the interview roadmap. The AI model can be configured through your Spring AI setup and application properties.

Typical configuration pattern:

```properties
spring.ai.openai.api-key=YOUR_API_KEY
spring.ai.openai.chat.model=gpt-4o-mini
```

Update the exact keys based on the model provider and version used in your project.

## Running the Application
From the project root:

```bash
./mvnw spring-boot:run
```

On Windows PowerShell:

```powershell
./mvnw.cmd spring-boot:run
```

## API Example
Upload a resume with role and days:

```bash
curl -X POST "http://localhost:8080/api/upload" \
  -F "resume=@resume.pdf" \
  -F "role=Backend Developer" \
  -F "days=14"
```

## Notes
- Ensure Docker Desktop is running before starting MongoDB.
- For production environments, use secure credentials and managed MongoDB services.
- The AI prompt is personalized using the selected role and preparation duration.

## Useful Docker Commands
```bash
docker ps
docker stop mongodb
docker rm mongodb
```

## License
This project is for internal learning and development use unless otherwise specified.

