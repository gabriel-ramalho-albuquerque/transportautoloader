# transpotautoloader

A Spring Boot project to read data from csv files to the database using Spring Batch framework.

Java version 11.

The data stored in the database will be used as a source to the API project (https://github.com/gabriel-ramalho-albuquerque/dpttransportationapi)

The database used is MySQL and the schema name is "transportation" (localhost:3306/transportation)

The project has a migration file that will create the databases (src\main\resources\db\migration\V1__createTables.sql).

A job will be created and will have a scheduler to read and save the data from the csv files every month.

It has also an endpoint that can be used to start the job.

Has also a Postman collection in the "postman" folder.

### API docs

http://localhost:8181/v3/api-docs

### Swagger UI

http://localhost:8181/swagger-ui/index.html

## API Documentation

#### Start the job that will read and write the data from the csv files in the database

```http
  POST api/v1/dataLoader/importCSVData
```

### TODO

- Change the file path to external path
- Change the file name to be dynamic
- Try to refactor the trip type code (green and yellow) without affecting the job functionality
- Add performance tests
- Docker
