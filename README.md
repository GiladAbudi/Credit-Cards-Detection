# Credit Cards Detection

Java Spring scalable application that uses HTTP Rest API to receive messages and scan them for credit card numbers,
in case of detection store the event containing details of the message and detection information in the database.

### Using: 
- Spring Framework 
- RabbitMQ
- NoSQL - MongoDB
- docker-compose.yml file for running RabbitMQ and MongoDB containers.

### RabbitMQ:
#### Producer:
contain Rest API to receive messages from users,
every message send to the Consumer by the credit card service, this service use
the Exchanger and binding key for send messages to Queue.

#### Consumer:
contain credit card detection service, this service listener to the Queue.
pull messages from the Queue and check the message body, if the message contain a credit card number.
the service save the message in the DB(MongoDB).



### How to run:
- Run the RabbitMQ & MongoDB containers.(RabbitMQ Management: http://localhost:15672/#/)
- Run the Application.










