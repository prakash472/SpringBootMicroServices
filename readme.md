# Micorservices in Spring

This project is a microservices architecture implementation using Spring Boot, which enables seamless communication between services and integrated tracing with Jaeger and Micrometer to monitor API calls in real-time. The microservices are containerized using Docker and deployed as Kubernetes clusters. Resilience4j is incorporated for fault tolerance and Actuator endpoints to Prometheus for comprehensive monitoring of microservices performance.

The project contains three services: order service, customer service, and product service. The product service gets the result from the order service and customer service using the Rest template. All the services are registered using the Eureka server registry.

# Technologies Used:
- Spring Boot
- Docker
- Kubernetes
- Jaeger
- Micrometer
- Resilience4j
- Prometheus
- Eureka Server Registry


# Deployment

The microservices are containerized using Docker and deployed as Kubernetes clusters. The deployment process is as follows:

1. Clone the repository
2. Start the minikube cluster
3. Depoly the files in teh kubernetes clusters
4. Perform port-forwarding for the eureka-lb and api-gateway to perform the request.

```bash
git clone https://github.com/prakash472/SpringBootMicroServices.git
cd SpringBootMicroServices 
cd kubernetes
minikube start
kubectl apply -f ./
kubectl port-forward service/eureka-lb 8761:80
kubectl port-forward service/api-gateway-svc 8084:80
```

After clicking http://localhost:8761 in the link, we will see all the services of our microservices. This is the eureka server registry.
Some screenshots to verify them are:

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)
![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)
![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)

# Monitoring
The microservices are monitored using Jaeger and Micrometer for real-time API call tracing. The Actuator endpoints are configured to Prometheus for comprehensive monitoring of microservices performance.

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)
![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)