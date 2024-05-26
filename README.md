# spring-cloud-config
Dockerized Configuration server with clients

![spring-cloud-config](https://github.com/abhisheksarkar30/spring-cloud-config/actions/workflows/actions-cicd.yml/badge.svg?branch=docker-compose)

This is a project to implement **_Spring Cloud Config_** in _**Dockerized**_ services secured by httpBasic 
**_Spring Security_** with **_CICD Pipeline_** setup via [GitHub Actions](https://docs.github.com/en/actions). <br>
By Docker, we plan to implement all 3 categories: **_standalone containers, docker-compose, kubernetes-cluster_**.

### Standalone Containers
Branch: standalone-container <br>

#### Prerequisites
Your host machine must be running RabbitMQ and be reachable @ http://localhost:5672 <br>
This will be used by each independently managed config-server/client containers for **_spring-cloud-bus_** based dynamic-refresh.

### Docker compose
Branch: docker-compose <br>
This feature has hybrid CICD setup, CI - Open Cloud Runner, CD - Self-hosted runners for each separate VM to deploy. <br>
This feature provides solution for a major issue we devs face: Cloud/On-Premise VM Rental Cost. <br>
_**Solution**_: GitHub provides Self-hosted runner integration which we have used to deploy in 
local machines under Private LAN. The same can be used for any Cloud/On-Premise VMs which
doesn't support direct deployment from Cloud GitHub. 

#### Prerequisites
For Windows Users:
1. Must have WSL2 installed on your machines
2. WSL integration must be active to communicate with the local Docker Daemon Engine.

### Kubernetes Cluster

Not yet implemented. Future plan.