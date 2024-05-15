#!/bin/bash
echo "Start creating databases:"

POSTGRES_USER=${POSTGRES_USER:-job_hunter_admin}

DATABASES=(
"job_hunter_auth"
"job_hunter_comment" 
"job_hunter_company" 
"job_hunter_currency" 
"job_hunter_cv" 
"job_hunter_file" 
"job_hunter_geo"
"job_hunter_job"
"job_hunter_notification"
"job_hunter_user"
)

for DATABASE in ${DATABASES[@]}
do
  DB_EXISTS=$(psql -U $POSTGRES_USER -d postgres -tAc "SELECT 1 FROM pg_database WHERE datname='$DATABASE'" 2>/dev/null)
  if [ $? -eq 0 ] && [ "$DB_EXISTS" = "1" ]; then
      echo "Database [$DATABASE] already exists."
  else
      createdb -U $POSTGRES_USER $DATABASE
      psql -U $POSTGRES_USER -d $DATABASE -c "DROP SCHEMA IF EXISTS public CASCADE;"
      echo "Database [$DATABASE] has been created and dropped schema [public]"
  fi
done