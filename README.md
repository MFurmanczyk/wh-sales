# E-Commerce Data Warehouse ETL

This project implements an ETL (Extract, Transform, Load) process to migrate and transform data from an OLTP (Online Transaction Processing) system to a star schema in a data warehouse. The ETL process is written in Kotlin and Spark, and it is orchestrated using Apache Airflow.

## Features

- **ETL Processing**:
    - **T_CATEGORY**: Processes product categories.
    - **T_CUSTOMER**: Processes customer data and their addresses.
    - **T_ORDER**: Processes information about orders.
    - **T_ORDER_REL**: Processes information about products in orders.
    - **T_PRODUCT**: Processes product information.
    - **T_PROMO and T_PROMO_REL**: Processes information about promotions and the products affected by them.

- **Data Transformation**:
    - Transforms data from OLTP format to a star schema suitable for analytical queries.

- **Orchestration**:
    - Utilizes Apache Airflow for scheduling and managing the ETL workflows.

## Technologies Used

- **Programming Language**: Kotlin
- **Data Processing Framework**: Apache Spark v3.3.2
- **Workflow Orchestration**: Apache Airflow




## Getting Started

### Prerequisites

- **Kotlin**: Ensure you have Kotlin installed. [Install Kotlin](https://kotlinlang.org/docs/tutorials/command-line.html).
- **Apache Spark v3.3.2**: Ensure you have Apache Spark installed. [Install Spark](https://spark.apache.org/downloads.html).
- **Apache Airflow**: Ensure you have Apache Airflow installed. [Install Airflow](https://airflow.apache.org/docs/apache-airflow/stable/start.html).

### Installation

1. Clone the repository:
```bash
git clone https://github.com/MFurmanczyk/wh-sales.git
cd wh-sales
```

2. Build the project:
```bash
  ./gradlew shadowJar
```

3. Setup Apache Airflow:
```bash 
cd airflowdocker-compose up
```

4. Running the ETL
   Start the Apache Airflow web server and scheduler:
```bash
docker-compose up -d
```

5. Move `dag.py` to Airflow's DAGs folder.

Access the Airflow UI at http://localhost:8080 and trigger the ETL DAG (sales_dag).

## License
This project is licensed under the MIT License - see the LICENSE file for details.