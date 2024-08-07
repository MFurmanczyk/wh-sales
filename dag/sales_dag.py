import airflow

from datetime import timedelta, datetime
from airflow import DAG
from airflow.providers.apache.spark.operators.spark_submit import SparkSubmitOperator

application_path = "/Users/maciejfurmanczyk/Documents/spark/wh-sales/build/libs/wh-sales-1.0-all.jar"
properties_file_path = "/Users/maciejfurmanczyk/Documents/spark/wh-sales/src/main/resources/sales.properties"

default_args = {
    'owner': 'airflow',
    'start_date': airflow.utils.dates.days_ago(2),
    'end_date': datetime(
        year=2025,
        month=12,
        day=31
    ),
    'depends_on_past': False,
    'email': ['airflow@example.com'],
    'email_on_failure': False,
    'email_on_retry': False,
    'retries': 1,
    'retry_delay': timedelta(minutes=5),
}

sales_dag = DAG(
    dag_id="sales_dag",
    default_args=default_args,
    schedule="@monthly"
)

# Extraction jobs

category_extraction = SparkSubmitOperator(
    application=application_path,
    properties_file=properties_file_path,
    conn_id="spark_local",
    task_id="mysql_extraction_category",
    java_class="io.github.mfurmanczyk.jobs.extraction.CategoryExtractionKt",
    dag=sales_dag
)

customer_extraction = SparkSubmitOperator(
    application=application_path,
    properties_file=properties_file_path,
    conn_id="spark_local",
    task_id="mysql_extraction_customer",
    java_class="io.github.mfurmanczyk.jobs.extraction.CustomerExtractionKt",
    dag=sales_dag
)

order_extraction = SparkSubmitOperator(
    application=application_path,
    properties_file=properties_file_path,
    conn_id="spark_local",
    task_id="mysql_extraction_order",
    java_class="io.github.mfurmanczyk.jobs.extraction.OrderExtractionKt",
    dag=sales_dag
)

order_rel_extraction = SparkSubmitOperator(
    application=application_path,
    properties_file=properties_file_path,
    conn_id="spark_local",
    task_id="mysql_extraction_order_rel",
    java_class="io.github.mfurmanczyk.jobs.extraction.OrderRelExtractionKt",
    dag=sales_dag
)

product_extraction = SparkSubmitOperator(
    application=application_path,
    properties_file=properties_file_path,
    conn_id="spark_local",
    task_id="mysql_extraction_product",
    java_class="io.github.mfurmanczyk.jobs.extraction.ProductExtractionKt",
    dag=sales_dag
)

promo_extraction = SparkSubmitOperator(
    application=application_path,
    properties_file=properties_file_path,
    conn_id="spark_local",
    task_id="mysql_extraction_promo",
    java_class="io.github.mfurmanczyk.jobs.extraction.PromoExtractionKt",
    dag=sales_dag
)

promo_rel_extraction = SparkSubmitOperator(
    application=application_path,
    properties_file=properties_file_path,
    conn_id="spark_local",
    task_id="mysql_extraction_promo_rel",
    java_class="io.github.mfurmanczyk.jobs.extraction.PromoRelExtractionKt",
    dag=sales_dag
)

# Transformation jobs

address_dim_transformation = SparkSubmitOperator(
    application=application_path,
    properties_file=properties_file_path,
    conn_id="spark_local",
    task_id="transformation_dim_address",
    java_class="io.github.mfurmanczyk.jobs.transformation.AddressDimKt",
    dag=sales_dag
)

customer_dim_transformation = SparkSubmitOperator(
    application=application_path,
    properties_file=properties_file_path,
    conn_id="spark_local",
    task_id="transformation_dim_customer",
    java_class="io.github.mfurmanczyk.jobs.transformation.CustomerDimKt",
    dag=sales_dag
)

date_dim_transformation = SparkSubmitOperator(
    application=application_path,
    properties_file=properties_file_path,
    conn_id="spark_local",
    task_id="transformation_dim_date",
    java_class="io.github.mfurmanczyk.jobs.transformation.DateDimKt",
    dag=sales_dag
)

order_status_transformation = SparkSubmitOperator(
    application=application_path,
    properties_file=properties_file_path,
    conn_id="spark_local",
    task_id="transformation_dim_order_status",
    java_class="io.github.mfurmanczyk.jobs.transformation.OrderStatusDimKt",
    dag=sales_dag
)

payment_status_transformation = SparkSubmitOperator(
    application=application_path,
    properties_file=properties_file_path,
    conn_id="spark_local",
    task_id="transformation_dim_payment_status",
    java_class="io.github.mfurmanczyk.jobs.transformation.PaymentStatusDimKt",
    dag=sales_dag
)

product_dim_transformation = SparkSubmitOperator(
    application=application_path,
    properties_file=properties_file_path,
    conn_id="spark_local",
    task_id="transformation_dim_product",
    java_class="io.github.mfurmanczyk.jobs.transformation.ProductDimKt",
    dag=sales_dag
)

promo_dim_transformation = SparkSubmitOperator(
    application=application_path,
    properties_file=properties_file_path,
    conn_id="spark_local",
    task_id="transformation_dim_promo",
    java_class="io.github.mfurmanczyk.jobs.transformation.PromoDimKt",
    dag=sales_dag
)

sales_fact_transformation = SparkSubmitOperator(
    application=application_path,
    properties_file=properties_file_path,
    conn_id="spark_local",
    task_id="transformation_fact_sales",
    java_class="io.github.mfurmanczyk.jobs.transformation.SalesFactTransformationKt",
    dag=sales_dag
)

customer_extraction >> [address_dim_transformation, customer_dim_transformation, date_dim_transformation, sales_fact_transformation]
order_extraction >> [date_dim_transformation, order_status_transformation, payment_status_transformation, sales_fact_transformation]
order_rel_extraction >> sales_fact_transformation
promo_extraction >> [date_dim_transformation, promo_dim_transformation, sales_fact_transformation]
promo_rel_extraction >> [promo_dim_transformation, sales_fact_transformation]
product_extraction >> [product_dim_transformation, sales_fact_transformation]
category_extraction >> product_dim_transformation
address_dim_transformation >> sales_fact_transformation